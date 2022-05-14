package com.ird.faa.service.societe.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatDeclarationTva;
import com.ird.faa.dao.EtatDeclarationTvaDao;
import com.ird.faa.service.societe.facade.EtatDeclarationTvaSocieteService;

import com.ird.faa.ws.rest.provided.vo.EtatDeclarationTvaVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatDeclarationTvaSocieteServiceImpl extends AbstractServiceImpl<EtatDeclarationTva> implements EtatDeclarationTvaSocieteService {

@Autowired
private EtatDeclarationTvaDao etatDeclarationTvaDao;

    @Autowired
    private ArchivableService<EtatDeclarationTva> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<EtatDeclarationTva> findAll(){
        return etatDeclarationTvaDao.findAll();
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
    @Override
    public EtatDeclarationTva archiver(EtatDeclarationTva etatDeclarationTva) {
    if (etatDeclarationTva.getArchive() == null) {
    etatDeclarationTva.setArchive(false);
    }
    etatDeclarationTva.setArchive(true);
    etatDeclarationTva.setDateArchivage(new Date());
    etatDeclarationTvaDao.save(etatDeclarationTva);
    return etatDeclarationTva;

    }

    @Override
    public EtatDeclarationTva desarchiver(EtatDeclarationTva etatDeclarationTva) {
    if (etatDeclarationTva.getArchive() == null) {
    etatDeclarationTva.setArchive(false);
    }
    etatDeclarationTva.setArchive(false);
    etatDeclarationTva.setDateArchivage(null);
    etatDeclarationTvaDao.save(etatDeclarationTva);
    return etatDeclarationTva;
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





    }
