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
import com.ird.faa.bean.EtatDeclarationIr;
import com.ird.faa.dao.EtatDeclarationIrDao;
import com.ird.faa.service.chercheur.facade.EtatDeclarationIrChercheurService;

import com.ird.faa.ws.rest.provided.vo.EtatDeclarationIrVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatDeclarationIrChercheurServiceImpl extends AbstractServiceImpl<EtatDeclarationIr> implements EtatDeclarationIrChercheurService {

@Autowired
private EtatDeclarationIrDao etatDeclarationIrDao;

    @Autowired
    private ArchivableService<EtatDeclarationIr> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<EtatDeclarationIr> findAll(){
    List<EtatDeclarationIr> resultat= new ArrayList();
    resultat.addAll(findAllNonArchive());
    resultat.addAll(findAllByOwner());
    return resultat;
}
    @Override
    public EtatDeclarationIr findByReference(String reference){
    if( reference==null) return null;
    return etatDeclarationIrDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return etatDeclarationIrDao.deleteByReference(reference);
    }
    @Override
    public EtatDeclarationIr findByIdOrReference(EtatDeclarationIr etatDeclarationIr){
    EtatDeclarationIr resultat=null;
    if(etatDeclarationIr != null){
    if(StringUtil.isNotEmpty(etatDeclarationIr.getId())){
    resultat= etatDeclarationIrDao.getOne(etatDeclarationIr.getId());
    }else if(StringUtil.isNotEmpty(etatDeclarationIr.getReference())) {
    resultat= etatDeclarationIrDao.findByReference(etatDeclarationIr.getReference());
    }
    }
    return resultat;
    }

@Override
public EtatDeclarationIr findById(Long id){
if(id==null) return null;
return etatDeclarationIrDao.getOne(id);
}

@Override
public EtatDeclarationIr findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(etatDeclarationIrDao.findById(id).isPresent())  {
etatDeclarationIrDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatDeclarationIr update(EtatDeclarationIr etatDeclarationIr){
EtatDeclarationIr foundedEtatDeclarationIr = findById(etatDeclarationIr.getId());
if(foundedEtatDeclarationIr==null) return null;
else{
    archivableService.prepare(etatDeclarationIr);
return  etatDeclarationIrDao.save(etatDeclarationIr);
}
}
    private void prepareSave(EtatDeclarationIr etatDeclarationIr){
        etatDeclarationIr.setDateCreation(new Date());
                    if(etatDeclarationIr.getArchive() == null)
                etatDeclarationIr.setArchive(false);
                    if(etatDeclarationIr.getAdmin() == null)
                etatDeclarationIr.setAdmin(false);
                    if(etatDeclarationIr.getVisible() == null)
                etatDeclarationIr.setVisible(false);

            etatDeclarationIr.setAdmin(false);
            etatDeclarationIr.setVisible(false);
            User currentUser = SecurityUtil.getCurrentUser();
            if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
            etatDeclarationIr.setUsername(currentUser.getUsername());
            }


    }

@Override
public EtatDeclarationIr save (EtatDeclarationIr etatDeclarationIr){
    prepareSave(etatDeclarationIr);

    EtatDeclarationIr result =null;
    EtatDeclarationIr foundedEtatDeclarationIr = findByReference(etatDeclarationIr.getReference());
    if(foundedEtatDeclarationIr == null){



    EtatDeclarationIr savedEtatDeclarationIr = etatDeclarationIrDao.save(etatDeclarationIr);

    result = savedEtatDeclarationIr;
    }

    return result;
}

@Override
public List<EtatDeclarationIr> save(List<EtatDeclarationIr> etatDeclarationIrs){
List<EtatDeclarationIr> list = new ArrayList<>();
for(EtatDeclarationIr etatDeclarationIr: etatDeclarationIrs){
list.add(save(etatDeclarationIr));
}
return list;
}



@Override
@Transactional
public int delete(EtatDeclarationIr etatDeclarationIr){
    if(etatDeclarationIr.getReference()==null) return -1;

    EtatDeclarationIr foundedEtatDeclarationIr = findByReference(etatDeclarationIr.getReference());
    if(foundedEtatDeclarationIr==null) return -1;
etatDeclarationIrDao.delete(foundedEtatDeclarationIr);
return 1;
}


public List<EtatDeclarationIr> findByCriteria(EtatDeclarationIrVo etatDeclarationIrVo){

String query = "SELECT o FROM EtatDeclarationIr o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatDeclarationIrVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",etatDeclarationIrVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatDeclarationIrVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "archive","=",etatDeclarationIrVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",etatDeclarationIrVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",etatDeclarationIrVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",etatDeclarationIrVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",etatDeclarationIrVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",etatDeclarationIrVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",etatDeclarationIrVo.getDateArchivageMin(),etatDeclarationIrVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",etatDeclarationIrVo.getDateCreationMin(),etatDeclarationIrVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatDeclarationIr> etatDeclarationIrs){
if(ListUtil.isNotEmpty(etatDeclarationIrs)){
etatDeclarationIrs.forEach(e->etatDeclarationIrDao.delete(e));
}
}
@Override
public void update(List<EtatDeclarationIr> etatDeclarationIrs){
if(ListUtil.isNotEmpty(etatDeclarationIrs)){
etatDeclarationIrs.forEach(e->etatDeclarationIrDao.save(e));
}
}




        public List<EtatDeclarationIr> findAllNonArchive(){
        String query = "SELECT o FROM EtatDeclarationIr o  WHERE o.archive != true AND o.visible = true";
        return entityManager.createQuery(query).getResultList();
        }

        public List<EtatDeclarationIr> findAllByOwner(){
        List<EtatDeclarationIr> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM EtatDeclarationIr o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }
