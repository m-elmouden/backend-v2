package com.ird.faa.service.comptable.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Tva;
import com.ird.faa.dao.TvaDao;
import com.ird.faa.service.comptable.facade.TvaComptableService;

import com.ird.faa.ws.rest.provided.vo.TvaVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TvaComptableServiceImpl extends AbstractServiceImpl<Tva> implements TvaComptableService {

@Autowired
private TvaDao tvaDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Tva> findAll(){
        return tvaDao.findAll();
}
    @Override
    public Tva findByReference(String reference){
    if( reference==null) return null;
    return tvaDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return tvaDao.deleteByReference(reference);
    }
    @Override
    public Tva findByIdOrReference(Tva tva){
    Tva resultat=null;
    if(tva != null){
    if(StringUtil.isNotEmpty(tva.getId())){
    resultat= tvaDao.getOne(tva.getId());
    }else if(StringUtil.isNotEmpty(tva.getReference())) {
    resultat= tvaDao.findByReference(tva.getReference());
    }
    }
    return resultat;
    }

@Override
public Tva findById(Long id){
if(id==null) return null;
return tvaDao.getOne(id);
}

@Override
public Tva findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(tvaDao.findById(id).isPresent())  {
tvaDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Tva update(Tva tva){
Tva foundedTva = findById(tva.getId());
if(foundedTva==null) return null;
else{
return  tvaDao.save(tva);
}
}

@Override
public Tva save (Tva tva){

    Tva result =null;
    Tva foundedTva = findByReference(tva.getReference());
    if(foundedTva == null){



    Tva savedTva = tvaDao.save(tva);

    result = savedTva;
    }

    return result;
}

@Override
public List<Tva> save(List<Tva> tvas){
List<Tva> list = new ArrayList<>();
for(Tva tva: tvas){
list.add(save(tva));
}
return list;
}



@Override
@Transactional
public int delete(Tva tva){
    if(tva.getReference()==null) return -1;

    Tva foundedTva = findByReference(tva.getReference());
    if(foundedTva==null) return -1;
tvaDao.delete(foundedTva);
return 1;
}


public List<Tva> findByCriteria(TvaVo tvaVo){

String query = "SELECT o FROM Tva o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",tvaVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",tvaVo.getReference());
            query += SearchUtil.addConstraint( "o", "pourcentage","=",tvaVo.getPourcentage());
            query += SearchUtil.addConstraintMinMax("o","pourcentage",tvaVo.getPourcentageMin(),tvaVo.getPourcentageMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Tva> tvas){
if(ListUtil.isNotEmpty(tvas)){
tvas.forEach(e->tvaDao.delete(e));
}
}
@Override
public void update(List<Tva> tvas){
if(ListUtil.isNotEmpty(tvas)){
tvas.forEach(e->tvaDao.save(e));
}
}





    }
