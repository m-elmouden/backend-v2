package com.ird.faa.service.comptable.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypeSociete;
import com.ird.faa.dao.TypeSocieteDao;
import com.ird.faa.service.comptable.facade.TypeSocieteComptableService;

import com.ird.faa.ws.rest.provided.vo.TypeSocieteVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeSocieteComptableServiceImpl extends AbstractServiceImpl<TypeSociete> implements TypeSocieteComptableService {

@Autowired
private TypeSocieteDao typeSocieteDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeSociete> findAll(){
        return typeSocieteDao.findAll();
}
    @Override
    public TypeSociete findByCode(String code){
    if( code==null) return null;
    return typeSocieteDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return typeSocieteDao.deleteByCode(code);
    }
    @Override
    public TypeSociete findByIdOrCode(TypeSociete typeSociete){
    TypeSociete resultat=null;
    if(typeSociete != null){
    if(StringUtil.isNotEmpty(typeSociete.getId())){
    resultat= typeSocieteDao.getOne(typeSociete.getId());
    }else if(StringUtil.isNotEmpty(typeSociete.getCode())) {
    resultat= typeSocieteDao.findByCode(typeSociete.getCode());
    }
    }
    return resultat;
    }

@Override
public TypeSociete findById(Long id){
if(id==null) return null;
return typeSocieteDao.getOne(id);
}

@Override
public TypeSociete findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(typeSocieteDao.findById(id).isPresent())  {
typeSocieteDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeSociete update(TypeSociete typeSociete){
TypeSociete foundedTypeSociete = findById(typeSociete.getId());
if(foundedTypeSociete==null) return null;
else{
return  typeSocieteDao.save(typeSociete);
}
}

@Override
public TypeSociete save (TypeSociete typeSociete){

    TypeSociete result =null;
    TypeSociete foundedTypeSociete = findByCode(typeSociete.getCode());
    if(foundedTypeSociete == null){



    TypeSociete savedTypeSociete = typeSocieteDao.save(typeSociete);

    result = savedTypeSociete;
    }

    return result;
}

@Override
public List<TypeSociete> save(List<TypeSociete> typeSocietes){
List<TypeSociete> list = new ArrayList<>();
for(TypeSociete typeSociete: typeSocietes){
list.add(save(typeSociete));
}
return list;
}



@Override
@Transactional
public int delete(TypeSociete typeSociete){
    if(typeSociete.getCode()==null) return -1;

    TypeSociete foundedTypeSociete = findByCode(typeSociete.getCode());
    if(foundedTypeSociete==null) return -1;
typeSocieteDao.delete(foundedTypeSociete);
return 1;
}


public List<TypeSociete> findByCriteria(TypeSocieteVo typeSocieteVo){

String query = "SELECT o FROM TypeSociete o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeSocieteVo.getId());
            query += SearchUtil.addConstraint( "o", "code","LIKE",typeSocieteVo.getCode());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeSocieteVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeSociete> typeSocietes){
if(ListUtil.isNotEmpty(typeSocietes)){
typeSocietes.forEach(e->typeSocieteDao.delete(e));
}
}
@Override
public void update(List<TypeSociete> typeSocietes){
if(ListUtil.isNotEmpty(typeSocietes)){
typeSocietes.forEach(e->typeSocieteDao.save(e));
}
}





    }
