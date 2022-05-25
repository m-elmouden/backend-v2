package com.ird.faa.service.societe.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypeEmploye;
import com.ird.faa.dao.TypeEmployeDao;
import com.ird.faa.service.societe.facade.TypeEmployeSocieteService;

import com.ird.faa.ws.rest.provided.vo.TypeEmployeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeEmployeSocieteServiceImpl extends AbstractServiceImpl<TypeEmploye> implements TypeEmployeSocieteService {

@Autowired
private TypeEmployeDao typeEmployeDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeEmploye> findAll(){
        return typeEmployeDao.findAll();
}
    @Override
    public TypeEmploye findByCode(String code){
    if( code==null) return null;
    return typeEmployeDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return typeEmployeDao.deleteByCode(code);
    }
    @Override
    public TypeEmploye findByIdOrCode(TypeEmploye typeEmploye){
    TypeEmploye resultat=null;
    if(typeEmploye != null){
    if(StringUtil.isNotEmpty(typeEmploye.getId())){
    resultat= typeEmployeDao.getOne(typeEmploye.getId());
    }else if(StringUtil.isNotEmpty(typeEmploye.getCode())) {
    resultat= typeEmployeDao.findByCode(typeEmploye.getCode());
    }
    }
    return resultat;
    }

@Override
public TypeEmploye findById(Long id){
if(id==null) return null;
return typeEmployeDao.getOne(id);
}

@Override
public TypeEmploye findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(typeEmployeDao.findById(id).isPresent())  {
typeEmployeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeEmploye update(TypeEmploye typeEmploye){
TypeEmploye foundedTypeEmploye = findById(typeEmploye.getId());
if(foundedTypeEmploye==null) return null;
else{
return  typeEmployeDao.save(typeEmploye);
}
}

@Override
public TypeEmploye save (TypeEmploye typeEmploye){

    TypeEmploye result =null;
    TypeEmploye foundedTypeEmploye = findByCode(typeEmploye.getCode());
    if(foundedTypeEmploye == null){



    TypeEmploye savedTypeEmploye = typeEmployeDao.save(typeEmploye);

    result = savedTypeEmploye;
    }

    return result;
}

@Override
public List<TypeEmploye> save(List<TypeEmploye> typeEmployes){
List<TypeEmploye> list = new ArrayList<>();
for(TypeEmploye typeEmploye: typeEmployes){
list.add(save(typeEmploye));
}
return list;
}



@Override
@Transactional
public int delete(TypeEmploye typeEmploye){
    if(typeEmploye.getCode()==null) return -1;

    TypeEmploye foundedTypeEmploye = findByCode(typeEmploye.getCode());
    if(foundedTypeEmploye==null) return -1;
typeEmployeDao.delete(foundedTypeEmploye);
return 1;
}


public List<TypeEmploye> findByCriteria(TypeEmployeVo typeEmployeVo){

String query = "SELECT o FROM TypeEmploye o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeEmployeVo.getId());
            query += SearchUtil.addConstraint( "o", "code","LIKE",typeEmployeVo.getCode());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeEmployeVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeEmploye> typeEmployes){
if(ListUtil.isNotEmpty(typeEmployes)){
typeEmployes.forEach(e->typeEmployeDao.delete(e));
}
}
@Override
public void update(List<TypeEmploye> typeEmployes){
if(ListUtil.isNotEmpty(typeEmployes)){
typeEmployes.forEach(e->typeEmployeDao.save(e));
}
}





    }
