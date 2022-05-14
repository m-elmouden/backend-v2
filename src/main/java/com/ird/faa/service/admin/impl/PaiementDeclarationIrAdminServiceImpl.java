package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PaiementDeclarationIr;
        import com.ird.faa.bean.DeclarationIr;
import com.ird.faa.dao.PaiementDeclarationIrDao;
import com.ird.faa.service.admin.facade.PaiementDeclarationIrAdminService;
        import com.ird.faa.service.admin.facade.DeclarationIrAdminService;

import com.ird.faa.ws.rest.provided.vo.PaiementDeclarationIrVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PaiementDeclarationIrAdminServiceImpl extends AbstractServiceImpl<PaiementDeclarationIr> implements PaiementDeclarationIrAdminService {

@Autowired
private PaiementDeclarationIrDao paiementDeclarationIrDao;

        @Autowired
        private DeclarationIrAdminService declarationIrService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PaiementDeclarationIr> findAll(){
        String query = "SELECT o FROM PaiementDeclarationIr o where 1=1 ";
        query+= " ORDER BY o.datePaiement";
        return entityManager.createQuery(query).getResultList();
}

        @Override
        public List<PaiementDeclarationIr> findByDeclarationIrRefrerence(String refrerence){
        return paiementDeclarationIrDao.findByDeclarationIrRefrerence(refrerence);
        }

        @Override
        @Transactional
        public int deleteByDeclarationIrRefrerence(String refrerence){
        return paiementDeclarationIrDao.deleteByDeclarationIrRefrerence(refrerence);
        }

        @Override
        public List<PaiementDeclarationIr> findByDeclarationIrId(Long id){
        return paiementDeclarationIrDao.findByDeclarationIrId(id);
        }

        @Override
        @Transactional
        public int deleteByDeclarationIrId(Long id){
        return paiementDeclarationIrDao.deleteByDeclarationIrId(id);
        }

    @Override
    public PaiementDeclarationIr findByReference(String reference){
    if( reference==null) return null;
    return paiementDeclarationIrDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return paiementDeclarationIrDao.deleteByReference(reference);
    }
    @Override
    public PaiementDeclarationIr findByIdOrReference(PaiementDeclarationIr paiementDeclarationIr){
    PaiementDeclarationIr resultat=null;
    if(paiementDeclarationIr != null){
    if(StringUtil.isNotEmpty(paiementDeclarationIr.getId())){
    resultat= paiementDeclarationIrDao.getOne(paiementDeclarationIr.getId());
    }else if(StringUtil.isNotEmpty(paiementDeclarationIr.getReference())) {
    resultat= paiementDeclarationIrDao.findByReference(paiementDeclarationIr.getReference());
    }
    }
    return resultat;
    }

@Override
public PaiementDeclarationIr findById(Long id){
if(id==null) return null;
return paiementDeclarationIrDao.getOne(id);
}

@Override
public PaiementDeclarationIr findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(paiementDeclarationIrDao.findById(id).isPresent())  {
paiementDeclarationIrDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PaiementDeclarationIr update(PaiementDeclarationIr paiementDeclarationIr){
PaiementDeclarationIr foundedPaiementDeclarationIr = findById(paiementDeclarationIr.getId());
if(foundedPaiementDeclarationIr==null) return null;
else{
return  paiementDeclarationIrDao.save(paiementDeclarationIr);
}
}

@Override
public PaiementDeclarationIr save (PaiementDeclarationIr paiementDeclarationIr){

    PaiementDeclarationIr result =null;
    PaiementDeclarationIr foundedPaiementDeclarationIr = findByReference(paiementDeclarationIr.getReference());
    if(foundedPaiementDeclarationIr == null){


    findDeclarationIr(paiementDeclarationIr);

    PaiementDeclarationIr savedPaiementDeclarationIr = paiementDeclarationIrDao.save(paiementDeclarationIr);

    result = savedPaiementDeclarationIr;
    }

    return result;
}

@Override
public List<PaiementDeclarationIr> save(List<PaiementDeclarationIr> paiementDeclarationIrs){
List<PaiementDeclarationIr> list = new ArrayList<>();
for(PaiementDeclarationIr paiementDeclarationIr: paiementDeclarationIrs){
list.add(save(paiementDeclarationIr));
}
return list;
}



@Override
@Transactional
public int delete(PaiementDeclarationIr paiementDeclarationIr){
    if(paiementDeclarationIr.getReference()==null) return -1;

    PaiementDeclarationIr foundedPaiementDeclarationIr = findByReference(paiementDeclarationIr.getReference());
    if(foundedPaiementDeclarationIr==null) return -1;
paiementDeclarationIrDao.delete(foundedPaiementDeclarationIr);
return 1;
}


public List<PaiementDeclarationIr> findByCriteria(PaiementDeclarationIrVo paiementDeclarationIrVo){

String query = "SELECT o FROM PaiementDeclarationIr o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",paiementDeclarationIrVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",paiementDeclarationIrVo.getReference());
        query += SearchUtil.addConstraintDate( "o", "datePaiement","=",paiementDeclarationIrVo.getDatePaiement());
            query += SearchUtil.addConstraint( "o", "total","=",paiementDeclarationIrVo.getTotal());
            query += SearchUtil.addConstraint( "o", "montantCptTraiteur","=",paiementDeclarationIrVo.getMontantCptTraiteur());
            query += SearchUtil.addConstraint( "o", "montantCptValidateur","=",paiementDeclarationIrVo.getMontantCptValidateur());
            query += SearchUtil.addConstraint( "o", "reste","=",paiementDeclarationIrVo.getReste());
            query += SearchUtil.addConstraintMinMaxDate("o","datePaiement",paiementDeclarationIrVo.getDatePaiementMin(),paiementDeclarationIrVo.getDatePaiementMax());
            query += SearchUtil.addConstraintMinMax("o","total",paiementDeclarationIrVo.getTotalMin(),paiementDeclarationIrVo.getTotalMax());
            query += SearchUtil.addConstraintMinMax("o","montantCptTraiteur",paiementDeclarationIrVo.getMontantCptTraiteurMin(),paiementDeclarationIrVo.getMontantCptTraiteurMax());
            query += SearchUtil.addConstraintMinMax("o","montantCptValidateur",paiementDeclarationIrVo.getMontantCptValidateurMin(),paiementDeclarationIrVo.getMontantCptValidateurMax());
            query += SearchUtil.addConstraintMinMax("o","reste",paiementDeclarationIrVo.getResteMin(),paiementDeclarationIrVo.getResteMax());
    if(paiementDeclarationIrVo.getDeclarationIrVo()!=null){
        query += SearchUtil.addConstraint( "o", "declarationIr.id","=",paiementDeclarationIrVo.getDeclarationIrVo().getId());
            query += SearchUtil.addConstraint( "o", "declarationIr.refrerence","LIKE",paiementDeclarationIrVo.getDeclarationIrVo().getRefrerence());
    }

    query+= " ORDER BY o.datePaiement";
return entityManager.createQuery(query).getResultList();
}

    private void findDeclarationIr(PaiementDeclarationIr paiementDeclarationIr){
        DeclarationIr loadedDeclarationIr =declarationIrService.findByIdOrRefrerence(paiementDeclarationIr.getDeclarationIr());

    if(loadedDeclarationIr==null ) {
    return;
    }
    paiementDeclarationIr.setDeclarationIr(loadedDeclarationIr);
    }

@Override
@Transactional
public void delete(List<PaiementDeclarationIr> paiementDeclarationIrs){
if(ListUtil.isNotEmpty(paiementDeclarationIrs)){
paiementDeclarationIrs.forEach(e->paiementDeclarationIrDao.delete(e));
}
}
@Override
public void update(List<PaiementDeclarationIr> paiementDeclarationIrs){
if(ListUtil.isNotEmpty(paiementDeclarationIrs)){
paiementDeclarationIrs.forEach(e->paiementDeclarationIrDao.save(e));
}
}





    }
