package com.ird.faa.service.chercheur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
    import com.ird.faa.service.util.StringUtil;
    import com.ird.faa.security.common.SecurityUtil;
    import com.ird.faa.security.bean.User;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatDeclarationTva;
import com.ird.faa.dao.EtatDeclarationTvaDao;
import com.ird.faa.service.chercheur.facade.EtatDeclarationTvaChercheurService;

import com.ird.faa.ws.rest.provided.vo.EtatDeclarationTvaVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatDeclarationTvaChercheurServiceImpl extends AbstractServiceImpl<EtatDeclarationTva> implements EtatDeclarationTvaChercheurService {

@Autowired
private EtatDeclarationTvaDao etatDeclarationTvaDao;

    @Autowired
    private ArchivableService<EtatDeclarationTva> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<EtatDeclarationTva> findAll(){
    List<EtatDeclarationTva> resultat= new ArrayList();
    resultat.addAll(findAllNonArchive());
    resultat.addAll(findAllByOwner());
    return resultat;
}
    @Override
    public EtatDeclarationTva findByReference(String reference){
    if( reference==null) return null;
    return etatDeclarationTvaDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return etatDeclarationTvaDao.deleteByReference(reference);
    }
    @Override
    public EtatDeclarationTva findByIdOrReference(EtatDeclarationTva etatDeclarationTva){
    EtatDeclarationTva resultat=null;
    if(etatDeclarationTva != null){
    if(StringUtil.isNotEmpty(etatDeclarationTva.getId())){
    resultat= etatDeclarationTvaDao.getOne(etatDeclarationTva.getId());
    }else if(StringUtil.isNotEmpty(etatDeclarationTva.getReference())) {
    resultat= etatDeclarationTvaDao.findByReference(etatDeclarationTva.getReference());
    }
    }
    return resultat;
    }

@Override
public EtatDeclarationTva findById(Long id){
if(id==null) return null;
return etatDeclarationTvaDao.getOne(id);
}

@Override
public EtatDeclarationTva findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(etatDeclarationTvaDao.findById(id).isPresent())  {
etatDeclarationTvaDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatDeclarationTva update(EtatDeclarationTva etatDeclarationTva){
EtatDeclarationTva foundedEtatDeclarationTva = findById(etatDeclarationTva.getId());
if(foundedEtatDeclarationTva==null) return null;
else{
    archivableService.prepare(etatDeclarationTva);
return  etatDeclarationTvaDao.save(etatDeclarationTva);
}
}
    private void prepareSave(EtatDeclarationTva etatDeclarationTva){
        etatDeclarationTva.setDateCreation(new Date());
                    if(etatDeclarationTva.getArchive() == null)
                etatDeclarationTva.setArchive(false);
                    if(etatDeclarationTva.getAdmin() == null)
                etatDeclarationTva.setAdmin(false);
                    if(etatDeclarationTva.getVisible() == null)
                etatDeclarationTva.setVisible(false);

            etatDeclarationTva.setAdmin(false);
            etatDeclarationTva.setVisible(false);
            User currentUser = SecurityUtil.getCurrentUser();
            if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
            etatDeclarationTva.setUsername(currentUser.getUsername());
            }


    }

@Override
public EtatDeclarationTva save (EtatDeclarationTva etatDeclarationTva){
    prepareSave(etatDeclarationTva);

    EtatDeclarationTva result =null;
    EtatDeclarationTva foundedEtatDeclarationTva = findByReference(etatDeclarationTva.getReference());
    if(foundedEtatDeclarationTva == null){



    EtatDeclarationTva savedEtatDeclarationTva = etatDeclarationTvaDao.save(etatDeclarationTva);

    result = savedEtatDeclarationTva;
    }

    return result;
}

@Override
public List<EtatDeclarationTva> save(List<EtatDeclarationTva> etatDeclarationTvas){
List<EtatDeclarationTva> list = new ArrayList<>();
for(EtatDeclarationTva etatDeclarationTva: etatDeclarationTvas){
list.add(save(etatDeclarationTva));
}
return list;
}



@Override
@Transactional
public int delete(EtatDeclarationTva etatDeclarationTva){
    if(etatDeclarationTva.getReference()==null) return -1;

    EtatDeclarationTva foundedEtatDeclarationTva = findByReference(etatDeclarationTva.getReference());
    if(foundedEtatDeclarationTva==null) return -1;
etatDeclarationTvaDao.delete(foundedEtatDeclarationTva);
return 1;
}


public List<EtatDeclarationTva> findByCriteria(EtatDeclarationTvaVo etatDeclarationTvaVo){

String query = "SELECT o FROM EtatDeclarationTva o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatDeclarationTvaVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",etatDeclarationTvaVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatDeclarationTvaVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "archive","=",etatDeclarationTvaVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",etatDeclarationTvaVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",etatDeclarationTvaVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",etatDeclarationTvaVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",etatDeclarationTvaVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",etatDeclarationTvaVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",etatDeclarationTvaVo.getDateArchivageMin(),etatDeclarationTvaVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",etatDeclarationTvaVo.getDateCreationMin(),etatDeclarationTvaVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatDeclarationTva> etatDeclarationTvas){
if(ListUtil.isNotEmpty(etatDeclarationTvas)){
etatDeclarationTvas.forEach(e->etatDeclarationTvaDao.delete(e));
}
}
@Override
public void update(List<EtatDeclarationTva> etatDeclarationTvas){
if(ListUtil.isNotEmpty(etatDeclarationTvas)){
etatDeclarationTvas.forEach(e->etatDeclarationTvaDao.save(e));
}
}




        public List<EtatDeclarationTva> findAllNonArchive(){
        String query = "SELECT o FROM EtatDeclarationTva o  WHERE o.archive != true AND o.visible = true";
        return entityManager.createQuery(query).getResultList();
        }

        public List<EtatDeclarationTva> findAllByOwner(){
        List<EtatDeclarationTva> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM EtatDeclarationTva o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }
