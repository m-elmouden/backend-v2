package com.ird.faa.service.chercheur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
    import com.ird.faa.service.util.StringUtil;
    import com.ird.faa.security.common.SecurityUtil;
    import com.ird.faa.security.bean.User;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Cpc;
        import com.ird.faa.bean.CpcFacture;
import com.ird.faa.dao.CpcDao;
import com.ird.faa.service.chercheur.facade.CpcChercheurService;
        import com.ird.faa.service.chercheur.facade.CpcFactureChercheurService;

import com.ird.faa.ws.rest.provided.vo.CpcVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.CpcFacture;
        import com.ird.faa.service.chercheur.facade.CpcFactureChercheurService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CpcChercheurServiceImpl extends AbstractServiceImpl<Cpc> implements CpcChercheurService {

@Autowired
private CpcDao cpcDao;

    @Autowired
    private ArchivableService<Cpc> archivableService;
        @Autowired
        private CpcFactureChercheurService cpcFactureService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Cpc> findAll(){
    List<Cpc> resultat= new ArrayList();
    resultat.addAll(findAllNonArchive());
    resultat.addAll(findAllByOwner());
    return resultat;
}
    @Override
    public Cpc findByReference(String reference){
    if( reference==null) return null;
    return cpcDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return cpcDao.deleteByReference(reference);
    }
    @Override
    public Cpc findByIdOrReference(Cpc cpc){
    Cpc resultat=null;
    if(cpc != null){
    if(StringUtil.isNotEmpty(cpc.getId())){
    resultat= cpcDao.getOne(cpc.getId());
    }else if(StringUtil.isNotEmpty(cpc.getReference())) {
    resultat= cpcDao.findByReference(cpc.getReference());
    }
    }
    return resultat;
    }

@Override
public Cpc findById(Long id){
if(id==null) return null;
return cpcDao.getOne(id);
}

@Override
public Cpc findByIdWithAssociatedList(Long id){
    Cpc cpc  = findById(id);
    findAssociatedLists(cpc);
    return cpc;
}
    private void findAssociatedLists(Cpc cpc){
    if(cpc!=null && cpc.getId() != null) {
            List<CpcFacture> cpcFactures = cpcFactureService.findByCpcId(cpc.getId());
            cpc.setCpcFactures(cpcFactures);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            cpcFactureService.deleteByCpcId(id);
    }
    }

    private void updateAssociatedLists(Cpc cpc){
    if(cpc !=null && cpc.getId() != null){
            List
            <List<CpcFacture>> resultCpcFactures= cpcFactureService.getToBeSavedAndToBeDeleted(cpcFactureService.findByCpcId(cpc.getId()),cpc.getCpcFactures());
            cpcFactureService.delete(resultCpcFactures.get(1));
            associateCpcFacture(cpc,resultCpcFactures.get(0));
            cpcFactureService.update(resultCpcFactures.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(cpcDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
cpcDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Cpc update(Cpc cpc){
Cpc foundedCpc = findById(cpc.getId());
if(foundedCpc==null) return null;
else{
    archivableService.prepare(cpc);
    updateAssociatedLists(cpc);
return  cpcDao.save(cpc);
}
}
    private void prepareSave(Cpc cpc){
        cpc.setDateCreation(new Date());
                    if(cpc.getArchive() == null)
                cpc.setArchive(false);
                    if(cpc.getAdmin() == null)
                cpc.setAdmin(false);
                    if(cpc.getVisible() == null)
                cpc.setVisible(false);

            cpc.setAdmin(false);
            cpc.setVisible(false);
            User currentUser = SecurityUtil.getCurrentUser();
            if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
            cpc.setUsername(currentUser.getUsername());
            }


    }

@Override
public Cpc save (Cpc cpc){
    prepareSave(cpc);

    Cpc result =null;
    Cpc foundedCpc = findByReference(cpc.getReference());
    if(foundedCpc == null){



    Cpc savedCpc = cpcDao.save(cpc);

        saveCpcFactures(savedCpc,cpc.getCpcFactures());
    result = savedCpc;
    }

    return result;
}

@Override
public List<Cpc> save(List<Cpc> cpcs){
List<Cpc> list = new ArrayList<>();
for(Cpc cpc: cpcs){
list.add(save(cpc));
}
return list;
}

        private List<CpcFacture> prepareCpcFactures(Cpc cpc,List<CpcFacture> cpcFactures){
        for(CpcFacture cpcFacture:cpcFactures ){
        cpcFacture.setCpc(cpc);
        }
        return cpcFactures;
        }


@Override
@Transactional
public int delete(Cpc cpc){
    if(cpc.getReference()==null) return -1;

    Cpc foundedCpc = findByReference(cpc.getReference());
    if(foundedCpc==null) return -1;
cpcDao.delete(foundedCpc);
return 1;
}


public List<Cpc> findByCriteria(CpcVo cpcVo){

String query = "SELECT o FROM Cpc o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",cpcVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",cpcVo.getReference());
            query += SearchUtil.addConstraint( "o", "totalProdEx","=",cpcVo.getTotalProdEx());
            query += SearchUtil.addConstraint( "o", "totalChargEx","=",cpcVo.getTotalChargEx());
            query += SearchUtil.addConstraint( "o", "totalProdFin","=",cpcVo.getTotalProdFin());
            query += SearchUtil.addConstraint( "o", "totalChargFin","=",cpcVo.getTotalChargFin());
            query += SearchUtil.addConstraint( "o", "totalProdNCour","=",cpcVo.getTotalProdNCour());
            query += SearchUtil.addConstraint( "o", "totalChargNCour","=",cpcVo.getTotalChargNCour());
        query += SearchUtil.addConstraintDate( "o", "dateMinCpc","=",cpcVo.getDateMinCpc());
        query += SearchUtil.addConstraintDate( "o", "dateMaxCpc","=",cpcVo.getDateMaxCpc());
            query += SearchUtil.addConstraint( "o", "archive","=",cpcVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",cpcVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",cpcVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",cpcVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",cpcVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",cpcVo.getUsername());
            query += SearchUtil.addConstraintMinMax("o","totalProdEx",cpcVo.getTotalProdExMin(),cpcVo.getTotalProdExMax());
            query += SearchUtil.addConstraintMinMax("o","totalChargEx",cpcVo.getTotalChargExMin(),cpcVo.getTotalChargExMax());
            query += SearchUtil.addConstraintMinMax("o","totalProdFin",cpcVo.getTotalProdFinMin(),cpcVo.getTotalProdFinMax());
            query += SearchUtil.addConstraintMinMax("o","totalChargFin",cpcVo.getTotalChargFinMin(),cpcVo.getTotalChargFinMax());
            query += SearchUtil.addConstraintMinMax("o","totalProdNCour",cpcVo.getTotalProdNCourMin(),cpcVo.getTotalProdNCourMax());
            query += SearchUtil.addConstraintMinMax("o","totalChargNCour",cpcVo.getTotalChargNCourMin(),cpcVo.getTotalChargNCourMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateMinCpc",cpcVo.getDateMinCpcMin(),cpcVo.getDateMinCpcMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateMaxCpc",cpcVo.getDateMaxCpcMin(),cpcVo.getDateMaxCpcMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",cpcVo.getDateArchivageMin(),cpcVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",cpcVo.getDateCreationMin(),cpcVo.getDateCreationMax());
    query+= " ORDER BY o.dateMaxCpc";
return entityManager.createQuery(query).getResultList();
}
        private  void saveCpcFactures(Cpc cpc,List<CpcFacture> cpcFactures){

        if (ListUtil.isNotEmpty(cpc.getCpcFactures())) {
        List<CpcFacture> savedCpcFactures = new ArrayList<>();
        cpcFactures.forEach(element -> {
        element.setCpc(cpc);
         cpcFactureService.save(element);
        });
        cpc.setCpcFactures(savedCpcFactures);
        }
        }


@Override
@Transactional
public void delete(List<Cpc> cpcs){
if(ListUtil.isNotEmpty(cpcs)){
cpcs.forEach(e->cpcDao.delete(e));
}
}
@Override
public void update(List<Cpc> cpcs){
if(ListUtil.isNotEmpty(cpcs)){
cpcs.forEach(e->cpcDao.save(e));
}
}

        private void associateCpcFacture(Cpc cpc, List<CpcFacture> cpcFacture) {
        if (ListUtil.isNotEmpty(cpcFacture)) {
        cpcFacture.forEach(e -> e.setCpc(cpc));
        }
        }



        public List<Cpc> findAllNonArchive(){
        String query = "SELECT o FROM Cpc o  WHERE o.archive != true AND o.visible = true";
            query+= " ORDER BY o.dateMaxCpc";
        return entityManager.createQuery(query).getResultList();
        }

        public List<Cpc> findAllByOwner(){
        List<Cpc> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM Cpc o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
            query+= " ORDER BY o.dateMaxCpc";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }
