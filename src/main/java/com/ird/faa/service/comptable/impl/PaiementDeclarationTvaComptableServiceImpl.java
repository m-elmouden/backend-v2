package com.ird.faa.service.comptable.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PaiementDeclarationTva;
        import com.ird.faa.bean.DeclarationTva;
import com.ird.faa.dao.PaiementDeclarationTvaDao;
import com.ird.faa.service.comptable.facade.PaiementDeclarationTvaComptableService;
        import com.ird.faa.service.comptable.facade.DeclarationTvaComptableService;

import com.ird.faa.ws.rest.provided.vo.PaiementDeclarationTvaVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PaiementDeclarationTvaComptableServiceImpl extends AbstractServiceImpl<PaiementDeclarationTva> implements PaiementDeclarationTvaComptableService {

@Autowired
private PaiementDeclarationTvaDao paiementDeclarationTvaDao;

        @Autowired
        private DeclarationTvaComptableService declarationTvaService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PaiementDeclarationTva> findAll(){
        String query = "SELECT o FROM PaiementDeclarationTva o where 1=1 ";
        query+= " ORDER BY o.datePaiement";
        return entityManager.createQuery(query).getResultList();
}

        @Override
        public List<PaiementDeclarationTva> findByDeclarationTvaReference(String reference){
        return paiementDeclarationTvaDao.findByDeclarationTvaReference(reference);
        }

        @Override
        @Transactional
        public int deleteByDeclarationTvaReference(String reference){
        return paiementDeclarationTvaDao.deleteByDeclarationTvaReference(reference);
        }

        @Override
        public List<PaiementDeclarationTva> findByDeclarationTvaId(Long id){
        return paiementDeclarationTvaDao.findByDeclarationTvaId(id);
        }

        @Override
        @Transactional
        public int deleteByDeclarationTvaId(Long id){
        return paiementDeclarationTvaDao.deleteByDeclarationTvaId(id);
        }

    @Override
    public PaiementDeclarationTva findByReference(String reference){
    if( reference==null) return null;
    return paiementDeclarationTvaDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return paiementDeclarationTvaDao.deleteByReference(reference);
    }
    @Override
    public PaiementDeclarationTva findByIdOrReference(PaiementDeclarationTva paiementDeclarationTva){
    PaiementDeclarationTva resultat=null;
    if(paiementDeclarationTva != null){
    if(StringUtil.isNotEmpty(paiementDeclarationTva.getId())){
    resultat= paiementDeclarationTvaDao.getOne(paiementDeclarationTva.getId());
    }else if(StringUtil.isNotEmpty(paiementDeclarationTva.getReference())) {
    resultat= paiementDeclarationTvaDao.findByReference(paiementDeclarationTva.getReference());
    }
    }
    return resultat;
    }

@Override
public PaiementDeclarationTva findById(Long id){
if(id==null) return null;
return paiementDeclarationTvaDao.getOne(id);
}

@Override
public PaiementDeclarationTva findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(paiementDeclarationTvaDao.findById(id).isPresent())  {
paiementDeclarationTvaDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PaiementDeclarationTva update(PaiementDeclarationTva paiementDeclarationTva){
PaiementDeclarationTva foundedPaiementDeclarationTva = findById(paiementDeclarationTva.getId());
if(foundedPaiementDeclarationTva==null) return null;
else{
return  paiementDeclarationTvaDao.save(paiementDeclarationTva);
}
}

@Override
public PaiementDeclarationTva save (PaiementDeclarationTva paiementDeclarationTva){

    PaiementDeclarationTva result =null;
    PaiementDeclarationTva foundedPaiementDeclarationTva = findByReference(paiementDeclarationTva.getReference());
    if(foundedPaiementDeclarationTva == null){


    findDeclarationTva(paiementDeclarationTva);

    PaiementDeclarationTva savedPaiementDeclarationTva = paiementDeclarationTvaDao.save(paiementDeclarationTva);

    result = savedPaiementDeclarationTva;
    }

    return result;
}

@Override
public List<PaiementDeclarationTva> save(List<PaiementDeclarationTva> paiementDeclarationTvas){
List<PaiementDeclarationTva> list = new ArrayList<>();
for(PaiementDeclarationTva paiementDeclarationTva: paiementDeclarationTvas){
list.add(save(paiementDeclarationTva));
}
return list;
}



@Override
@Transactional
public int delete(PaiementDeclarationTva paiementDeclarationTva){
    if(paiementDeclarationTva.getReference()==null) return -1;

    PaiementDeclarationTva foundedPaiementDeclarationTva = findByReference(paiementDeclarationTva.getReference());
    if(foundedPaiementDeclarationTva==null) return -1;
paiementDeclarationTvaDao.delete(foundedPaiementDeclarationTva);
return 1;
}


public List<PaiementDeclarationTva> findByCriteria(PaiementDeclarationTvaVo paiementDeclarationTvaVo){

String query = "SELECT o FROM PaiementDeclarationTva o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",paiementDeclarationTvaVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",paiementDeclarationTvaVo.getReference());
        query += SearchUtil.addConstraintDate( "o", "datePaiement","=",paiementDeclarationTvaVo.getDatePaiement());
            query += SearchUtil.addConstraint( "o", "total","=",paiementDeclarationTvaVo.getTotal());
            query += SearchUtil.addConstraint( "o", "montantCptTraiteur","=",paiementDeclarationTvaVo.getMontantCptTraiteur());
            query += SearchUtil.addConstraint( "o", "montantCptValidateur","=",paiementDeclarationTvaVo.getMontantCptValidateur());
            query += SearchUtil.addConstraint( "o", "reste","=",paiementDeclarationTvaVo.getReste());
            query += SearchUtil.addConstraintMinMaxDate("o","datePaiement",paiementDeclarationTvaVo.getDatePaiementMin(),paiementDeclarationTvaVo.getDatePaiementMax());
            query += SearchUtil.addConstraintMinMax("o","total",paiementDeclarationTvaVo.getTotalMin(),paiementDeclarationTvaVo.getTotalMax());
            query += SearchUtil.addConstraintMinMax("o","montantCptTraiteur",paiementDeclarationTvaVo.getMontantCptTraiteurMin(),paiementDeclarationTvaVo.getMontantCptTraiteurMax());
            query += SearchUtil.addConstraintMinMax("o","montantCptValidateur",paiementDeclarationTvaVo.getMontantCptValidateurMin(),paiementDeclarationTvaVo.getMontantCptValidateurMax());
            query += SearchUtil.addConstraintMinMax("o","reste",paiementDeclarationTvaVo.getResteMin(),paiementDeclarationTvaVo.getResteMax());
    if(paiementDeclarationTvaVo.getDeclarationTvaVo()!=null){
        query += SearchUtil.addConstraint( "o", "declarationTva.id","=",paiementDeclarationTvaVo.getDeclarationTvaVo().getId());
            query += SearchUtil.addConstraint( "o", "declarationTva.reference","LIKE",paiementDeclarationTvaVo.getDeclarationTvaVo().getReference());
    }

    query+= " ORDER BY o.datePaiement";
return entityManager.createQuery(query).getResultList();
}

    private void findDeclarationTva(PaiementDeclarationTva paiementDeclarationTva){
        DeclarationTva loadedDeclarationTva =declarationTvaService.findByIdOrReference(paiementDeclarationTva.getDeclarationTva());

    if(loadedDeclarationTva==null ) {
    return;
    }
    paiementDeclarationTva.setDeclarationTva(loadedDeclarationTva);
    }

@Override
@Transactional
public void delete(List<PaiementDeclarationTva> paiementDeclarationTvas){
if(ListUtil.isNotEmpty(paiementDeclarationTvas)){
paiementDeclarationTvas.forEach(e->paiementDeclarationTvaDao.delete(e));
}
}
@Override
public void update(List<PaiementDeclarationTva> paiementDeclarationTvas){
if(ListUtil.isNotEmpty(paiementDeclarationTvas)){
paiementDeclarationTvas.forEach(e->paiementDeclarationTvaDao.save(e));
}
}





    }
