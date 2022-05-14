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
import com.ird.faa.bean.EtatDeclarationIs;
import com.ird.faa.dao.EtatDeclarationIsDao;
import com.ird.faa.service.chercheur.facade.EtatDeclarationIsChercheurService;

import com.ird.faa.ws.rest.provided.vo.EtatDeclarationIsVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatDeclarationIsChercheurServiceImpl extends AbstractServiceImpl<EtatDeclarationIs> implements EtatDeclarationIsChercheurService {

@Autowired
private EtatDeclarationIsDao etatDeclarationIsDao;

    @Autowired
    private ArchivableService<EtatDeclarationIs> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<EtatDeclarationIs> findAll(){
    List<EtatDeclarationIs> resultat= new ArrayList();
    resultat.addAll(findAllNonArchive());
    resultat.addAll(findAllByOwner());
    return resultat;
}
    @Override
    public EtatDeclarationIs findByReference(String reference){
    if( reference==null) return null;
    return etatDeclarationIsDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return etatDeclarationIsDao.deleteByReference(reference);
    }
    @Override
    public EtatDeclarationIs findByIdOrReference(EtatDeclarationIs etatDeclarationIs){
    EtatDeclarationIs resultat=null;
    if(etatDeclarationIs != null){
    if(StringUtil.isNotEmpty(etatDeclarationIs.getId())){
    resultat= etatDeclarationIsDao.getOne(etatDeclarationIs.getId());
    }else if(StringUtil.isNotEmpty(etatDeclarationIs.getReference())) {
    resultat= etatDeclarationIsDao.findByReference(etatDeclarationIs.getReference());
    }
    }
    return resultat;
    }

@Override
public EtatDeclarationIs findById(Long id){
if(id==null) return null;
return etatDeclarationIsDao.getOne(id);
}

@Override
public EtatDeclarationIs findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(etatDeclarationIsDao.findById(id).isPresent())  {
etatDeclarationIsDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatDeclarationIs update(EtatDeclarationIs etatDeclarationIs){
EtatDeclarationIs foundedEtatDeclarationIs = findById(etatDeclarationIs.getId());
if(foundedEtatDeclarationIs==null) return null;
else{
    archivableService.prepare(etatDeclarationIs);
return  etatDeclarationIsDao.save(etatDeclarationIs);
}
}
    private void prepareSave(EtatDeclarationIs etatDeclarationIs){
        etatDeclarationIs.setDateCreation(new Date());
                    if(etatDeclarationIs.getArchive() == null)
                etatDeclarationIs.setArchive(false);
                    if(etatDeclarationIs.getAdmin() == null)
                etatDeclarationIs.setAdmin(false);
                    if(etatDeclarationIs.getVisible() == null)
                etatDeclarationIs.setVisible(false);

            etatDeclarationIs.setAdmin(false);
            etatDeclarationIs.setVisible(false);
            User currentUser = SecurityUtil.getCurrentUser();
            if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
            etatDeclarationIs.setUsername(currentUser.getUsername());
            }


    }

@Override
public EtatDeclarationIs save (EtatDeclarationIs etatDeclarationIs){
    prepareSave(etatDeclarationIs);

    EtatDeclarationIs result =null;
    EtatDeclarationIs foundedEtatDeclarationIs = findByReference(etatDeclarationIs.getReference());
    if(foundedEtatDeclarationIs == null){



    EtatDeclarationIs savedEtatDeclarationIs = etatDeclarationIsDao.save(etatDeclarationIs);

    result = savedEtatDeclarationIs;
    }

    return result;
}

@Override
public List<EtatDeclarationIs> save(List<EtatDeclarationIs> etatDeclarationIss){
List<EtatDeclarationIs> list = new ArrayList<>();
for(EtatDeclarationIs etatDeclarationIs: etatDeclarationIss){
list.add(save(etatDeclarationIs));
}
return list;
}



@Override
@Transactional
public int delete(EtatDeclarationIs etatDeclarationIs){
    if(etatDeclarationIs.getReference()==null) return -1;

    EtatDeclarationIs foundedEtatDeclarationIs = findByReference(etatDeclarationIs.getReference());
    if(foundedEtatDeclarationIs==null) return -1;
etatDeclarationIsDao.delete(foundedEtatDeclarationIs);
return 1;
}


public List<EtatDeclarationIs> findByCriteria(EtatDeclarationIsVo etatDeclarationIsVo){

String query = "SELECT o FROM EtatDeclarationIs o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatDeclarationIsVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",etatDeclarationIsVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatDeclarationIsVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "archive","=",etatDeclarationIsVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",etatDeclarationIsVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",etatDeclarationIsVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",etatDeclarationIsVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",etatDeclarationIsVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",etatDeclarationIsVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",etatDeclarationIsVo.getDateArchivageMin(),etatDeclarationIsVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",etatDeclarationIsVo.getDateCreationMin(),etatDeclarationIsVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatDeclarationIs> etatDeclarationIss){
if(ListUtil.isNotEmpty(etatDeclarationIss)){
etatDeclarationIss.forEach(e->etatDeclarationIsDao.delete(e));
}
}
@Override
public void update(List<EtatDeclarationIs> etatDeclarationIss){
if(ListUtil.isNotEmpty(etatDeclarationIss)){
etatDeclarationIss.forEach(e->etatDeclarationIsDao.save(e));
}
}




        public List<EtatDeclarationIs> findAllNonArchive(){
        String query = "SELECT o FROM EtatDeclarationIs o  WHERE o.archive != true AND o.visible = true";
        return entityManager.createQuery(query).getResultList();
        }

        public List<EtatDeclarationIs> findAllByOwner(){
        List<EtatDeclarationIs> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM EtatDeclarationIs o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }
