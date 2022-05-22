package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PrelevementSocial;
import com.ird.faa.dao.PrelevementSocialDao;
import com.ird.faa.service.admin.facade.PrelevementSocialAdminService;

import com.ird.faa.ws.rest.provided.vo.PrelevementSocialVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PrelevementSocialAdminServiceImpl extends AbstractServiceImpl<PrelevementSocial> implements PrelevementSocialAdminService {

@Autowired
private PrelevementSocialDao prelevementSocialDao;


@Autowired
private EntityManager entityManager;


@Override
public List<PrelevementSocial> findAll(){
        String query = "SELECT o FROM PrelevementSocial o where 1=1 ";
        query+= " ORDER BY o.dateMin";
        return entityManager.createQuery(query).getResultList();
}

@Override
public PrelevementSocial findById(Long id){
if(id==null) return null;
return prelevementSocialDao.getOne(id);
}

@Override
public PrelevementSocial findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(prelevementSocialDao.findById(id).isPresent())  {
prelevementSocialDao.deleteById(id);
res = 1;
}
return res;
}

    @Override
    public PrelevementSocial findByLibelle(String libelle) {
        return prelevementSocialDao.findByLibelle(libelle);
    }


    @Override
public PrelevementSocial update(PrelevementSocial prelevementSocial){
PrelevementSocial foundedPrelevementSocial = findById(prelevementSocial.getId());
if(foundedPrelevementSocial==null) return null;
else{
return  prelevementSocialDao.save(prelevementSocial);
}
}

@Override
public PrelevementSocial save (PrelevementSocial prelevementSocial){




    return prelevementSocialDao.save(prelevementSocial);


}

@Override
public List<PrelevementSocial> save(List<PrelevementSocial> prelevementSocials){
List<PrelevementSocial> list = new ArrayList<>();
for(PrelevementSocial prelevementSocial: prelevementSocials){
list.add(save(prelevementSocial));
}
return list;
}



@Override
@Transactional
public int delete(PrelevementSocial prelevementSocial){
    if(prelevementSocial.getId()==null) return -1;
    PrelevementSocial foundedPrelevementSocial = findById(prelevementSocial.getId());
    if(foundedPrelevementSocial==null) return -1;
prelevementSocialDao.delete(foundedPrelevementSocial);
return 1;
}


public List<PrelevementSocial> findByCriteria(PrelevementSocialVo prelevementSocialVo){

String query = "SELECT o FROM PrelevementSocial o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",prelevementSocialVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",prelevementSocialVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "pourcentage","=",prelevementSocialVo.getPourcentage());
        query += SearchUtil.addConstraintDate( "o", "dateMax","=",prelevementSocialVo.getDateMax());
        query += SearchUtil.addConstraintDate( "o", "dateMin","=",prelevementSocialVo.getDateMin());
            query += SearchUtil.addConstraintMinMax("o","pourcentage",prelevementSocialVo.getPourcentageMin(),prelevementSocialVo.getPourcentageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateMax",prelevementSocialVo.getDateMaxMin(),prelevementSocialVo.getDateMaxMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateMin",prelevementSocialVo.getDateMinMin(),prelevementSocialVo.getDateMinMax());
    query+= " ORDER BY o.dateMin";
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<PrelevementSocial> prelevementSocials){
if(ListUtil.isNotEmpty(prelevementSocials)){
prelevementSocials.forEach(e->prelevementSocialDao.delete(e));
}
}
@Override
public void update(List<PrelevementSocial> prelevementSocials){
if(ListUtil.isNotEmpty(prelevementSocials)){
prelevementSocials.forEach(e->prelevementSocialDao.save(e));
}
}





    }
