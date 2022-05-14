package com.ird.faa.service.comptable.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Comptable;
        import com.ird.faa.bean.TypeComptable;
        import com.ird.faa.bean.Societe;
        import com.ird.faa.bean.Demande;
import com.ird.faa.dao.ComptableDao;
import com.ird.faa.service.comptable.facade.ComptableComptableService;
        import com.ird.faa.service.comptable.facade.SocieteComptableService;
        import com.ird.faa.service.comptable.facade.DemandeComptableService;
        import com.ird.faa.service.comptable.facade.TypeComptableComptableService;

import com.ird.faa.ws.rest.provided.vo.ComptableVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.Societe;
        import com.ird.faa.service.comptable.facade.SocieteComptableService;
        import com.ird.faa.bean.Demande;
        import com.ird.faa.service.comptable.facade.DemandeComptableService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ComptableComptableServiceImpl extends AbstractServiceImpl<Comptable> implements ComptableComptableService {

@Autowired
private ComptableDao comptableDao;

        @Autowired
        private SocieteComptableService societeService ;
        @Autowired
        private DemandeComptableService demandeService ;
        @Autowired
        private TypeComptableComptableService typeComptableService ;


@Autowired
private EntityManager entityManager;

    @Override
    public Comptable findByUsername(String username){
    return comptableDao.findByUsername(username);
    }

@Override
public List<Comptable> findAll(){
        return comptableDao.findAll();
}

        @Override
        public List<Comptable> findByTypeComptableReference(String reference){
        return comptableDao.findByTypeComptableReference(reference);
        }

        @Override
        @Transactional
        public int deleteByTypeComptableReference(String reference){
        return comptableDao.deleteByTypeComptableReference(reference);
        }

        @Override
        public List<Comptable> findByTypeComptableId(Long id){
        return comptableDao.findByTypeComptableId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeComptableId(Long id){
        return comptableDao.deleteByTypeComptableId(id);
        }

    @Override
    public Comptable findByCode(String code){
    if( code==null) return null;
    return comptableDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return comptableDao.deleteByCode(code);
    }
    @Override
    public Comptable findByIdOrCode(Comptable comptable){
    Comptable resultat=null;
    if(comptable != null){
    if(StringUtil.isNotEmpty(comptable.getId())){
    resultat= comptableDao.getOne(comptable.getId());
    }else if(StringUtil.isNotEmpty(comptable.getCode())) {
    resultat= comptableDao.findByCode(comptable.getCode());
    }else if(StringUtil.isNotEmpty(comptable.getUsername())) {
    resultat = comptableDao.findByUsername(comptable.getUsername());
    }
    }
    return resultat;
    }

@Override
public Comptable findById(Long id){
if(id==null) return null;
return comptableDao.getOne(id);
}

@Override
public Comptable findByIdWithAssociatedList(Long id){
    Comptable comptable  = findById(id);
    findAssociatedLists(comptable);
    return comptable;
}
    private void findAssociatedLists(Comptable comptable){
    if(comptable!=null && comptable.getId() != null) {
            List<Societe> societes = societeService.findByComptableId(comptable.getId());
            comptable.setSocietes(societes);
            List<Demande> demandes = demandeService.findByComptableId(comptable.getId());
            comptable.setDemandes(demandes);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            societeService.deleteByComptableId(id);
            demandeService.deleteByComptableId(id);
    }
    }

    private void updateAssociatedLists(Comptable comptable){
    if(comptable !=null && comptable.getId() != null){
            List
            <List<Societe>> resultSocietes= societeService.getToBeSavedAndToBeDeleted(societeService.findByComptableId(comptable.getId()),comptable.getSocietes());
            societeService.delete(resultSocietes.get(1));
            associateSociete(comptable,resultSocietes.get(0));
            societeService.update(resultSocietes.get(0));

            List
            <List<Demande>> resultDemandes= demandeService.getToBeSavedAndToBeDeleted(demandeService.findByComptableId(comptable.getId()),comptable.getDemandes());
            demandeService.delete(resultDemandes.get(1));
            associateDemande(comptable,resultDemandes.get(0));
            demandeService.update(resultDemandes.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(comptableDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
comptableDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Comptable update(Comptable comptable){
Comptable foundedComptable = findById(comptable.getId());
if(foundedComptable==null) return null;
else{
    updateAssociatedLists(comptable);
return  comptableDao.save(comptable);
}
}
    private void prepareSave(Comptable comptable){
                comptable.setCredentialsNonExpired(false);
                comptable.setEnabled(false);
                comptable.setAccountNonExpired(false);
                comptable.setAccountNonLocked(false);
                comptable.setPasswordChanged(false);



    }

@Override
public Comptable save (Comptable comptable){
    prepareSave(comptable);

    Comptable result =null;
    Comptable foundedComptable = findByCode(comptable.getCode());
    if(foundedComptable == null){


    findTypeComptable(comptable);

    Comptable savedComptable = comptableDao.save(comptable);

        saveSocietes(savedComptable,comptable.getSocietes());
        saveDemandes(savedComptable,comptable.getDemandes());
    result = savedComptable;
    }

    return result;
}

@Override
public List<Comptable> save(List<Comptable> comptables){
List<Comptable> list = new ArrayList<>();
for(Comptable comptable: comptables){
list.add(save(comptable));
}
return list;
}

        private List<Societe> prepareSocietes(Comptable comptable,List<Societe> societes){
        for(Societe societe:societes ){
        societe.setComptable(comptable);
        }
        return societes;
        }
        private List<Demande> prepareDemandes(Comptable comptable,List<Demande> demandes){
        for(Demande demande:demandes ){
        demande.setComptable(comptable);
        }
        return demandes;
        }


@Override
@Transactional
public int delete(Comptable comptable){
    if(comptable.getCode()==null) return -1;

    Comptable foundedComptable = findByCode(comptable.getCode());
    if(foundedComptable==null) return -1;
comptableDao.delete(foundedComptable);
return 1;
}


public List<Comptable> findByCriteria(ComptableVo comptableVo){

String query = "SELECT o FROM Comptable o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",comptableVo.getId());
            query += SearchUtil.addConstraint( "o", "code","LIKE",comptableVo.getCode());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",comptableVo.getNom());
            query += SearchUtil.addConstraint( "o", "telephone","LIKE",comptableVo.getTelephone());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",comptableVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "credentialsNonExpired","=",comptableVo.getCredentialsNonExpired());
            query += SearchUtil.addConstraint( "o", "enabled","=",comptableVo.getEnabled());
            query += SearchUtil.addConstraint( "o", "accountNonExpired","=",comptableVo.getAccountNonExpired());
            query += SearchUtil.addConstraint( "o", "accountNonLocked","=",comptableVo.getAccountNonLocked());
            query += SearchUtil.addConstraint( "o", "passwordChanged","=",comptableVo.getPasswordChanged());
        query += SearchUtil.addConstraintDate( "o", "createdAt","=",comptableVo.getCreatedAt());
        query += SearchUtil.addConstraintDate( "o", "updatedAt","=",comptableVo.getUpdatedAt());
            query += SearchUtil.addConstraint( "o", "username","LIKE",comptableVo.getUsername());
            query += SearchUtil.addConstraint( "o", "password","LIKE",comptableVo.getPassword());
            query += SearchUtil.addConstraint( "o", "equivalenceAvecPanelErc","LIKE",comptableVo.getEquivalenceAvecPanelErc());
            query += SearchUtil.addConstraint( "o", "baseHorizon","LIKE",comptableVo.getBaseHorizon());
            query += SearchUtil.addConstraint( "o", "role","LIKE",comptableVo.getRole());
            query += SearchUtil.addConstraintMinMaxDate("o","createdAt",comptableVo.getCreatedAtMin(),comptableVo.getCreatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","updatedAt",comptableVo.getUpdatedAtMin(),comptableVo.getUpdatedAtMax());
    if(comptableVo.getTypeComptableVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeComptable.id","=",comptableVo.getTypeComptableVo().getId());
            query += SearchUtil.addConstraint( "o", "typeComptable.reference","LIKE",comptableVo.getTypeComptableVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}
        private  void saveSocietes(Comptable comptable,List<Societe> societes){

        if (ListUtil.isNotEmpty(comptable.getSocietes())) {
        List<Societe> savedSocietes = new ArrayList<>();
        societes.forEach(element -> {
        element.setComptable(comptable);
         societeService.save(element);
        });
        comptable.setSocietes(savedSocietes);
        }
        }
        private  void saveDemandes(Comptable comptable,List<Demande> demandes){

        if (ListUtil.isNotEmpty(comptable.getDemandes())) {
        List<Demande> savedDemandes = new ArrayList<>();
        demandes.forEach(element -> {
        element.setComptable(comptable);
         demandeService.save(element);
        });
        comptable.setDemandes(savedDemandes);
        }
        }

    private void findTypeComptable(Comptable comptable){
        TypeComptable loadedTypeComptable =typeComptableService.findByIdOrReference(comptable.getTypeComptable());

    if(loadedTypeComptable==null ) {
    return;
    }
    comptable.setTypeComptable(loadedTypeComptable);
    }

@Override
@Transactional
public void delete(List<Comptable> comptables){
if(ListUtil.isNotEmpty(comptables)){
comptables.forEach(e->comptableDao.delete(e));
}
}
@Override
public void update(List<Comptable> comptables){
if(ListUtil.isNotEmpty(comptables)){
comptables.forEach(e->comptableDao.save(e));
}
}

        private void associateSociete(Comptable comptable, List<Societe> societe) {
        if (ListUtil.isNotEmpty(societe)) {
        societe.forEach(e -> e.setComptable(comptable));
        }
        }
        private void associateDemande(Comptable comptable, List<Demande> demande) {
        if (ListUtil.isNotEmpty(demande)) {
        demande.forEach(e -> e.setComptable(comptable));
        }
        }




    }
