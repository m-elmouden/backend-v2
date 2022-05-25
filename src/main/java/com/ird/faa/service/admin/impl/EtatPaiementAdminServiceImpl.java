package com.ird.faa.service.admin.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatPaiement;
import com.ird.faa.dao.EtatPaiementDao;
import com.ird.faa.service.admin.facade.EtatPaiementAdminService;

import com.ird.faa.ws.rest.provided.vo.EtatPaiementVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatPaiementAdminServiceImpl extends AbstractServiceImpl<EtatPaiement> implements EtatPaiementAdminService {

@Autowired
private EtatPaiementDao etatPaiementDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EtatPaiement> findAll(){
        return etatPaiementDao.findAll();
}

@Override
public EtatPaiement findById(Long id){
if(id==null) return null;
return etatPaiementDao.getOne(id);
}

@Override
public EtatPaiement findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(etatPaiementDao.findById(id).isPresent())  {
etatPaiementDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatPaiement update(EtatPaiement etatPaiement){
EtatPaiement foundedEtatPaiement = findById(etatPaiement.getId());
if(foundedEtatPaiement==null) return null;
else{
return  etatPaiementDao.save(etatPaiement);
}
}

@Override
public EtatPaiement save (EtatPaiement etatPaiement){




    return etatPaiementDao.save(etatPaiement);


}

@Override
public List<EtatPaiement> save(List<EtatPaiement> etatPaiements){
List<EtatPaiement> list = new ArrayList<>();
for(EtatPaiement etatPaiement: etatPaiements){
list.add(save(etatPaiement));
}
return list;
}



@Override
@Transactional
public int delete(EtatPaiement etatPaiement){
    if(etatPaiement.getId()==null) return -1;
    EtatPaiement foundedEtatPaiement = findById(etatPaiement.getId());
    if(foundedEtatPaiement==null) return -1;
etatPaiementDao.delete(foundedEtatPaiement);
return 1;
}


public List<EtatPaiement> findByCriteria(EtatPaiementVo etatPaiementVo){

String query = "SELECT o FROM EtatPaiement o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatPaiementVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatPaiementVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","=",etatPaiementVo.getCode());
            query += SearchUtil.addConstraintMinMax("o","code",etatPaiementVo.getCodeMin(),etatPaiementVo.getCodeMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatPaiement> etatPaiements){
if(ListUtil.isNotEmpty(etatPaiements)){
etatPaiements.forEach(e->etatPaiementDao.delete(e));
}
}
@Override
public void update(List<EtatPaiement> etatPaiements){
if(ListUtil.isNotEmpty(etatPaiements)){
etatPaiements.forEach(e->etatPaiementDao.save(e));
}
}





    }
