package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypeDeclarationTva;
import com.ird.faa.dao.TypeDeclarationTvaDao;
import com.ird.faa.service.admin.facade.TypeDeclarationTvaAdminService;

import com.ird.faa.ws.rest.provided.vo.TypeDeclarationTvaVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeDeclarationTvaAdminServiceImpl extends AbstractServiceImpl<TypeDeclarationTva> implements TypeDeclarationTvaAdminService {

@Autowired
private TypeDeclarationTvaDao typeDeclarationTvaDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeDeclarationTva> findAll(){
        return typeDeclarationTvaDao.findAll();
}
    @Override
    public TypeDeclarationTva findByReference(String reference){
    if( reference==null) return null;
    return typeDeclarationTvaDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return typeDeclarationTvaDao.deleteByReference(reference);
    }
    @Override
    public TypeDeclarationTva findByIdOrReference(TypeDeclarationTva typeDeclarationTva){
    TypeDeclarationTva resultat=null;
    if(typeDeclarationTva != null){
    if(StringUtil.isNotEmpty(typeDeclarationTva.getId())){
    resultat= typeDeclarationTvaDao.getOne(typeDeclarationTva.getId());
    }else if(StringUtil.isNotEmpty(typeDeclarationTva.getReference())) {
    resultat= typeDeclarationTvaDao.findByReference(typeDeclarationTva.getReference());
    }
    }
    return resultat;
    }

@Override
public TypeDeclarationTva findById(Long id){
if(id==null) return null;
return typeDeclarationTvaDao.getOne(id);
}

@Override
public TypeDeclarationTva findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(typeDeclarationTvaDao.findById(id).isPresent())  {
typeDeclarationTvaDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeDeclarationTva update(TypeDeclarationTva typeDeclarationTva){
TypeDeclarationTva foundedTypeDeclarationTva = findById(typeDeclarationTva.getId());
if(foundedTypeDeclarationTva==null) return null;
else{
return  typeDeclarationTvaDao.save(typeDeclarationTva);
}
}

@Override
public TypeDeclarationTva save (TypeDeclarationTva typeDeclarationTva){

    TypeDeclarationTva result =null;
    TypeDeclarationTva foundedTypeDeclarationTva = findByReference(typeDeclarationTva.getReference());
    if(foundedTypeDeclarationTva == null){



    TypeDeclarationTva savedTypeDeclarationTva = typeDeclarationTvaDao.save(typeDeclarationTva);

    result = savedTypeDeclarationTva;
    }

    return result;
}

@Override
public List<TypeDeclarationTva> save(List<TypeDeclarationTva> typeDeclarationTvas){
List<TypeDeclarationTva> list = new ArrayList<>();
for(TypeDeclarationTva typeDeclarationTva: typeDeclarationTvas){
list.add(save(typeDeclarationTva));
}
return list;
}



@Override
@Transactional
public int delete(TypeDeclarationTva typeDeclarationTva){
    if(typeDeclarationTva.getReference()==null) return -1;

    TypeDeclarationTva foundedTypeDeclarationTva = findByReference(typeDeclarationTva.getReference());
    if(foundedTypeDeclarationTva==null) return -1;
typeDeclarationTvaDao.delete(foundedTypeDeclarationTva);
return 1;
}


public List<TypeDeclarationTva> findByCriteria(TypeDeclarationTvaVo typeDeclarationTvaVo){

String query = "SELECT o FROM TypeDeclarationTva o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeDeclarationTvaVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",typeDeclarationTvaVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeDeclarationTvaVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeDeclarationTva> typeDeclarationTvas){
if(ListUtil.isNotEmpty(typeDeclarationTvas)){
typeDeclarationTvas.forEach(e->typeDeclarationTvaDao.delete(e));
}
}
@Override
public void update(List<TypeDeclarationTva> typeDeclarationTvas){
if(ListUtil.isNotEmpty(typeDeclarationTvas)){
typeDeclarationTvas.forEach(e->typeDeclarationTvaDao.save(e));
}
}





    }
