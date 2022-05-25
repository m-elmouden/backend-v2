package com.ird.faa.service.admin.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TauxIr;
import com.ird.faa.dao.TauxIrDao;
import com.ird.faa.service.admin.facade.TauxIrAdminService;

import com.ird.faa.ws.rest.provided.vo.TauxIrVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TauxIrAdminServiceImpl extends AbstractServiceImpl<TauxIr> implements TauxIrAdminService {

@Autowired
private TauxIrDao tauxIrDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TauxIr> findAll(){
        String query = "SELECT o FROM TauxIr o where 1=1 ";
        query+= " ORDER BY o.dateMin";
        return entityManager.createQuery(query).getResultList();
}

@Override
public TauxIr findById(Long id){
if(id==null) return null;
return tauxIrDao.getOne(id);
}

@Override
public TauxIr findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(tauxIrDao.findById(id).isPresent())  {
tauxIrDao.deleteById(id);
res = 1;
}
return res;
}

    @Override
    public TauxIr findDernierTaux() {
        return tauxIrDao.findDernierTaux();
    }


    @Override
public TauxIr update(TauxIr tauxIr){
TauxIr foundedTauxIr = findById(tauxIr.getId());
if(foundedTauxIr==null) return null;
else{
return  tauxIrDao.save(tauxIr);
}
}

@Override
public TauxIr save (TauxIr tauxIr){




    return tauxIrDao.save(tauxIr);


}

@Override
public List<TauxIr> save(List<TauxIr> tauxIrs){
List<TauxIr> list = new ArrayList<>();
for(TauxIr tauxIr: tauxIrs){
list.add(save(tauxIr));
}
return list;
}



@Override
@Transactional
public int delete(TauxIr tauxIr){
    if(tauxIr.getId()==null) return -1;
    TauxIr foundedTauxIr = findById(tauxIr.getId());
    if(foundedTauxIr==null) return -1;
tauxIrDao.delete(foundedTauxIr);
return 1;
}


public List<TauxIr> findByCriteria(TauxIrVo tauxIrVo){

String query = "SELECT o FROM TauxIr o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",tauxIrVo.getId());
        query += SearchUtil.addConstraintDate( "o", "dateMin","=",tauxIrVo.getDateMin());
        query += SearchUtil.addConstraintDate( "o", "dateMax","=",tauxIrVo.getDateMax());
            query += SearchUtil.addConstraint( "o", "salaireImpoMin","=",tauxIrVo.getSalaireImpoMin());
            query += SearchUtil.addConstraint( "o", "salaireImpoMax","=",tauxIrVo.getSalaireImpoMax());
            query += SearchUtil.addConstraint( "o", "forfaitDeduit","=",tauxIrVo.getForfaitDeduit());
            query += SearchUtil.addConstraint( "o", "pourcentage","=",tauxIrVo.getPourcentage());
            query += SearchUtil.addConstraintMinMaxDate("o","dateMin",tauxIrVo.getDateMinMin(),tauxIrVo.getDateMinMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateMax",tauxIrVo.getDateMaxMin(),tauxIrVo.getDateMaxMax());
            query += SearchUtil.addConstraintMinMax("o","salaireImpoMin",tauxIrVo.getSalaireImpoMinMin(),tauxIrVo.getSalaireImpoMinMax());
            query += SearchUtil.addConstraintMinMax("o","salaireImpoMax",tauxIrVo.getSalaireImpoMaxMin(),tauxIrVo.getSalaireImpoMaxMax());
            query += SearchUtil.addConstraintMinMax("o","forfaitDeduit",tauxIrVo.getForfaitDeduitMin(),tauxIrVo.getForfaitDeduitMax());
            query += SearchUtil.addConstraintMinMax("o","pourcentage",tauxIrVo.getPourcentageMin(),tauxIrVo.getPourcentageMax());
    query+= " ORDER BY o.dateMin";
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TauxIr> tauxIrs){
if(ListUtil.isNotEmpty(tauxIrs)){
tauxIrs.forEach(e->tauxIrDao.delete(e));
}
}
@Override
public void update(List<TauxIr> tauxIrs){
if(ListUtil.isNotEmpty(tauxIrs)){
tauxIrs.forEach(e->tauxIrDao.save(e));
}
}





    }
