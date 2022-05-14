package com.ird.faa.service.societe.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypeTauxCnss;
import com.ird.faa.dao.TypeTauxCnssDao;
import com.ird.faa.service.societe.facade.TypeTauxCnssSocieteService;

import com.ird.faa.ws.rest.provided.vo.TypeTauxCnssVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeTauxCnssSocieteServiceImpl extends AbstractServiceImpl<TypeTauxCnss> implements TypeTauxCnssSocieteService {

@Autowired
private TypeTauxCnssDao typeTauxCnssDao;

    @Autowired
    private ArchivableService<TypeTauxCnss> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<TypeTauxCnss> findAll(){
        return typeTauxCnssDao.findAll();
}

@Override
public TypeTauxCnss findById(Long id){
if(id==null) return null;
return typeTauxCnssDao.getOne(id);
}

@Override
public TypeTauxCnss findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public TypeTauxCnss archiver(TypeTauxCnss typeTauxCnss) {
    if (typeTauxCnss.getArchive() == null) {
    typeTauxCnss.setArchive(false);
    }
    typeTauxCnss.setArchive(true);
    typeTauxCnss.setDateArchivage(new Date());
    typeTauxCnssDao.save(typeTauxCnss);
    return typeTauxCnss;

    }

    @Override
    public TypeTauxCnss desarchiver(TypeTauxCnss typeTauxCnss) {
    if (typeTauxCnss.getArchive() == null) {
    typeTauxCnss.setArchive(false);
    }
    typeTauxCnss.setArchive(false);
    typeTauxCnss.setDateArchivage(null);
    typeTauxCnssDao.save(typeTauxCnss);
    return typeTauxCnss;
    }



@Transactional
public int deleteById(Long id){
int res=0;
if(typeTauxCnssDao.findById(id).isPresent())  {
typeTauxCnssDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeTauxCnss update(TypeTauxCnss typeTauxCnss){
TypeTauxCnss foundedTypeTauxCnss = findById(typeTauxCnss.getId());
if(foundedTypeTauxCnss==null) return null;
else{
    archivableService.prepare(typeTauxCnss);
return  typeTauxCnssDao.save(typeTauxCnss);
}
}
    private void prepareSave(TypeTauxCnss typeTauxCnss){
        typeTauxCnss.setDateCreation(new Date());
                    if(typeTauxCnss.getArchive() == null)
                typeTauxCnss.setArchive(false);
                    if(typeTauxCnss.getAdmin() == null)
                typeTauxCnss.setAdmin(false);
                    if(typeTauxCnss.getVisible() == null)
                typeTauxCnss.setVisible(false);



    }

@Override
public TypeTauxCnss save (TypeTauxCnss typeTauxCnss){
    prepareSave(typeTauxCnss);




    return typeTauxCnssDao.save(typeTauxCnss);


}

@Override
public List<TypeTauxCnss> save(List<TypeTauxCnss> typeTauxCnsss){
List<TypeTauxCnss> list = new ArrayList<>();
for(TypeTauxCnss typeTauxCnss: typeTauxCnsss){
list.add(save(typeTauxCnss));
}
return list;
}



@Override
@Transactional
public int delete(TypeTauxCnss typeTauxCnss){
    if(typeTauxCnss.getId()==null) return -1;
    TypeTauxCnss foundedTypeTauxCnss = findById(typeTauxCnss.getId());
    if(foundedTypeTauxCnss==null) return -1;
typeTauxCnssDao.delete(foundedTypeTauxCnss);
return 1;
}


public List<TypeTauxCnss> findByCriteria(TypeTauxCnssVo typeTauxCnssVo){

String query = "SELECT o FROM TypeTauxCnss o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeTauxCnssVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeTauxCnssVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",typeTauxCnssVo.getCode());
            query += SearchUtil.addConstraint( "o", "archive","=",typeTauxCnssVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",typeTauxCnssVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",typeTauxCnssVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",typeTauxCnssVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",typeTauxCnssVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",typeTauxCnssVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",typeTauxCnssVo.getDateArchivageMin(),typeTauxCnssVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",typeTauxCnssVo.getDateCreationMin(),typeTauxCnssVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeTauxCnss> typeTauxCnsss){
if(ListUtil.isNotEmpty(typeTauxCnsss)){
typeTauxCnsss.forEach(e->typeTauxCnssDao.delete(e));
}
}
@Override
public void update(List<TypeTauxCnss> typeTauxCnsss){
if(ListUtil.isNotEmpty(typeTauxCnsss)){
typeTauxCnsss.forEach(e->typeTauxCnssDao.save(e));
}
}





    }
