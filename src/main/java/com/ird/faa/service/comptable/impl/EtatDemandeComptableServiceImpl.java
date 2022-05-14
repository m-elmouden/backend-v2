package com.ird.faa.service.comptable.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatDemande;
import com.ird.faa.dao.EtatDemandeDao;
import com.ird.faa.service.comptable.facade.EtatDemandeComptableService;

import com.ird.faa.ws.rest.provided.vo.EtatDemandeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatDemandeComptableServiceImpl extends AbstractServiceImpl<EtatDemande> implements EtatDemandeComptableService {

@Autowired
private EtatDemandeDao etatDemandeDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EtatDemande> findAll(){
        return etatDemandeDao.findAll();
}
    @Override
    public EtatDemande findByReference(String reference){
    if( reference==null) return null;
    return etatDemandeDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return etatDemandeDao.deleteByReference(reference);
    }
    @Override
    public EtatDemande findByIdOrReference(EtatDemande etatDemande){
    EtatDemande resultat=null;
    if(etatDemande != null){
    if(StringUtil.isNotEmpty(etatDemande.getId())){
    resultat= etatDemandeDao.getOne(etatDemande.getId());
    }else if(StringUtil.isNotEmpty(etatDemande.getReference())) {
    resultat= etatDemandeDao.findByReference(etatDemande.getReference());
    }
    }
    return resultat;
    }

@Override
public EtatDemande findById(Long id){
if(id==null) return null;
return etatDemandeDao.getOne(id);
}

@Override
public EtatDemande findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(etatDemandeDao.findById(id).isPresent())  {
etatDemandeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatDemande update(EtatDemande etatDemande){
EtatDemande foundedEtatDemande = findById(etatDemande.getId());
if(foundedEtatDemande==null) return null;
else{
return  etatDemandeDao.save(etatDemande);
}
}

@Override
public EtatDemande save (EtatDemande etatDemande){

    EtatDemande result =null;
    EtatDemande foundedEtatDemande = findByReference(etatDemande.getReference());
    if(foundedEtatDemande == null){



    EtatDemande savedEtatDemande = etatDemandeDao.save(etatDemande);

    result = savedEtatDemande;
    }

    return result;
}

@Override
public List<EtatDemande> save(List<EtatDemande> etatDemandes){
List<EtatDemande> list = new ArrayList<>();
for(EtatDemande etatDemande: etatDemandes){
list.add(save(etatDemande));
}
return list;
}



@Override
@Transactional
public int delete(EtatDemande etatDemande){
    if(etatDemande.getReference()==null) return -1;

    EtatDemande foundedEtatDemande = findByReference(etatDemande.getReference());
    if(foundedEtatDemande==null) return -1;
etatDemandeDao.delete(foundedEtatDemande);
return 1;
}


public List<EtatDemande> findByCriteria(EtatDemandeVo etatDemandeVo){

String query = "SELECT o FROM EtatDemande o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatDemandeVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",etatDemandeVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatDemandeVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "couleur","LIKE",etatDemandeVo.getCouleur());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatDemande> etatDemandes){
if(ListUtil.isNotEmpty(etatDemandes)){
etatDemandes.forEach(e->etatDemandeDao.delete(e));
}
}
@Override
public void update(List<EtatDemande> etatDemandes){
if(ListUtil.isNotEmpty(etatDemandes)){
etatDemandes.forEach(e->etatDemandeDao.save(e));
}
}





    }
