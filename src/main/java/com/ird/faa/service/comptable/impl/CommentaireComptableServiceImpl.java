package com.ird.faa.service.comptable.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Commentaire;
        import com.ird.faa.bean.Demande;
import com.ird.faa.dao.CommentaireDao;
import com.ird.faa.service.comptable.facade.CommentaireComptableService;
        import com.ird.faa.service.comptable.facade.DemandeComptableService;

import com.ird.faa.ws.rest.provided.vo.CommentaireVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CommentaireComptableServiceImpl extends AbstractServiceImpl<Commentaire> implements CommentaireComptableService {

@Autowired
private CommentaireDao commentaireDao;

        @Autowired
        private DemandeComptableService demandeService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Commentaire> findAll(){
        String query = "SELECT o FROM Commentaire o where 1=1 ";
        query+= " ORDER BY o.dateCommentaire";
        return entityManager.createQuery(query).getResultList();
}

        @Override
        public List<Commentaire> findByDemandeReference(String reference){
        return commentaireDao.findByDemandeReference(reference);
        }

        @Override
        @Transactional
        public int deleteByDemandeReference(String reference){
        return commentaireDao.deleteByDemandeReference(reference);
        }

        @Override
        public List<Commentaire> findByDemandeId(Long id){
        return commentaireDao.findByDemandeId(id);
        }

        @Override
        @Transactional
        public int deleteByDemandeId(Long id){
        return commentaireDao.deleteByDemandeId(id);
        }


@Override
public Commentaire findById(Long id){
if(id==null) return null;
return commentaireDao.getOne(id);
}

@Override
public Commentaire findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(commentaireDao.findById(id).isPresent())  {
commentaireDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Commentaire update(Commentaire commentaire){
Commentaire foundedCommentaire = findById(commentaire.getId());
if(foundedCommentaire==null) return null;
else{
return  commentaireDao.save(commentaire);
}
}

@Override
public Commentaire save (Commentaire commentaire){



    findDemande(commentaire);

    return commentaireDao.save(commentaire);


}

@Override
public List<Commentaire> save(List<Commentaire> commentaires){
List<Commentaire> list = new ArrayList<>();
for(Commentaire commentaire: commentaires){
list.add(save(commentaire));
}
return list;
}



@Override
@Transactional
public int delete(Commentaire commentaire){
    if(commentaire.getId()==null) return -1;
    Commentaire foundedCommentaire = findById(commentaire.getId());
    if(foundedCommentaire==null) return -1;
commentaireDao.delete(foundedCommentaire);
return 1;
}


public List<Commentaire> findByCriteria(CommentaireVo commentaireVo){

String query = "SELECT o FROM Commentaire o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",commentaireVo.getId());
            query += SearchUtil.addConstraint( "o", "description","LIKE",commentaireVo.getDescription());
        query += SearchUtil.addConstraintDate( "o", "dateCommentaire","=",commentaireVo.getDateCommentaire());
            query += SearchUtil.addConstraint( "o", "auteur","LIKE",commentaireVo.getAuteur());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCommentaire",commentaireVo.getDateCommentaireMin(),commentaireVo.getDateCommentaireMax());
    if(commentaireVo.getDemandeVo()!=null){
        query += SearchUtil.addConstraint( "o", "demande.id","=",commentaireVo.getDemandeVo().getId());
            query += SearchUtil.addConstraint( "o", "demande.reference","LIKE",commentaireVo.getDemandeVo().getReference());
    }

    query+= " ORDER BY o.dateCommentaire";
return entityManager.createQuery(query).getResultList();
}

    private void findDemande(Commentaire commentaire){
        Demande loadedDemande =demandeService.findByIdOrReference(commentaire.getDemande());

    if(loadedDemande==null ) {
    return;
    }
    commentaire.setDemande(loadedDemande);
    }

@Override
@Transactional
public void delete(List<Commentaire> commentaires){
if(ListUtil.isNotEmpty(commentaires)){
commentaires.forEach(e->commentaireDao.delete(e));
}
}
@Override
public void update(List<Commentaire> commentaires){
if(ListUtil.isNotEmpty(commentaires)){
commentaires.forEach(e->commentaireDao.save(e));
}
}





    }
