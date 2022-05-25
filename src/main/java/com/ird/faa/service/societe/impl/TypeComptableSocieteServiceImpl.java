package com.ird.faa.service.societe.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypeComptable;
import com.ird.faa.dao.TypeComptableDao;
import com.ird.faa.service.societe.facade.TypeComptableSocieteService;

import com.ird.faa.ws.rest.provided.vo.TypeComptableVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeComptableSocieteServiceImpl extends AbstractServiceImpl<TypeComptable> implements TypeComptableSocieteService {

@Autowired
private TypeComptableDao typeComptableDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeComptable> findAll(){
        return typeComptableDao.findAll();
}
    @Override
    public TypeComptable findByReference(String reference){
    if( reference==null) return null;
    return typeComptableDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return typeComptableDao.deleteByReference(reference);
    }
    @Override
    public TypeComptable findByIdOrReference(TypeComptable typeComptable){
    TypeComptable resultat=null;
    if(typeComptable != null){
    if(StringUtil.isNotEmpty(typeComptable.getId())){
    resultat= typeComptableDao.getOne(typeComptable.getId());
    }else if(StringUtil.isNotEmpty(typeComptable.getReference())) {
    resultat= typeComptableDao.findByReference(typeComptable.getReference());
    }
    }
    return resultat;
    }

@Override
public TypeComptable findById(Long id){
if(id==null) return null;
return typeComptableDao.getOne(id);
}

@Override
public TypeComptable findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(typeComptableDao.findById(id).isPresent())  {
typeComptableDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeComptable update(TypeComptable typeComptable){
TypeComptable foundedTypeComptable = findById(typeComptable.getId());
if(foundedTypeComptable==null) return null;
else{
return  typeComptableDao.save(typeComptable);
}
}

@Override
public TypeComptable save (TypeComptable typeComptable){

    TypeComptable result =null;
    TypeComptable foundedTypeComptable = findByReference(typeComptable.getReference());
    if(foundedTypeComptable == null){



    TypeComptable savedTypeComptable = typeComptableDao.save(typeComptable);

    result = savedTypeComptable;
    }

    return result;
}

@Override
public List<TypeComptable> save(List<TypeComptable> typeComptables){
List<TypeComptable> list = new ArrayList<>();
for(TypeComptable typeComptable: typeComptables){
list.add(save(typeComptable));
}
return list;
}



@Override
@Transactional
public int delete(TypeComptable typeComptable){
    if(typeComptable.getReference()==null) return -1;

    TypeComptable foundedTypeComptable = findByReference(typeComptable.getReference());
    if(foundedTypeComptable==null) return -1;
typeComptableDao.delete(foundedTypeComptable);
return 1;
}


public List<TypeComptable> findByCriteria(TypeComptableVo typeComptableVo){

String query = "SELECT o FROM TypeComptable o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeComptableVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeComptableVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",typeComptableVo.getReference());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeComptable> typeComptables){
if(ListUtil.isNotEmpty(typeComptables)){
typeComptables.forEach(e->typeComptableDao.delete(e));
}
}
@Override
public void update(List<TypeComptable> typeComptables){
if(ListUtil.isNotEmpty(typeComptables)){
typeComptables.forEach(e->typeComptableDao.save(e));
}
}





    }
