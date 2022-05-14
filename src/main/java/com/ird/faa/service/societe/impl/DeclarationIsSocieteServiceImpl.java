package com.ird.faa.service.societe.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.DeclarationIs;
        import com.ird.faa.bean.Societe;
        import com.ird.faa.bean.TauxIs;
        import com.ird.faa.bean.TauxIsConfig;
        import com.ird.faa.bean.EtatDeclarationIs;
        import com.ird.faa.bean.PaiementDeclarationIs;
import com.ird.faa.dao.DeclarationIsDao;
import com.ird.faa.service.societe.facade.DeclarationIsSocieteService;
        import com.ird.faa.service.societe.facade.SocieteSocieteService;
        import com.ird.faa.service.societe.facade.EtatDeclarationIsSocieteService;
        import com.ird.faa.service.societe.facade.TauxIsConfigSocieteService;
        import com.ird.faa.service.societe.facade.TauxIsSocieteService;
        import com.ird.faa.service.societe.facade.PaiementDeclarationIsSocieteService;

import com.ird.faa.ws.rest.provided.vo.DeclarationIsVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class DeclarationIsSocieteServiceImpl extends AbstractServiceImpl<DeclarationIs> implements DeclarationIsSocieteService {

@Autowired
private DeclarationIsDao declarationIsDao;

    @Autowired
    private ArchivableService<DeclarationIs> archivableService;
        @Autowired
        private SocieteSocieteService societeService ;
        @Autowired
        private EtatDeclarationIsSocieteService etatDeclarationIsService ;
        @Autowired
        private TauxIsConfigSocieteService tauxIsConfigService ;
        @Autowired
        private TauxIsSocieteService tauxIsService ;
        @Autowired
        private PaiementDeclarationIsSocieteService paiementDeclarationIsService ;


@Autowired
private EntityManager entityManager;


@Override
public List<DeclarationIs> findAll(){
        return declarationIsDao.findAll();
}
        @Override
        public List<DeclarationIs> findBySocieteId(Long id){
        return declarationIsDao.findBySocieteId(id);
        }

        @Override
        @Transactional
        public int deleteBySocieteId(Long id){
        return declarationIsDao.deleteBySocieteId(id);
        }


        @Override
        public List<DeclarationIs> findByTauxIsReference(String reference){
        return declarationIsDao.findByTauxIsReference(reference);
        }

        @Override
        @Transactional
        public int deleteByTauxIsReference(String reference){
        return declarationIsDao.deleteByTauxIsReference(reference);
        }

        @Override
        public List<DeclarationIs> findByTauxIsId(Long id){
        return declarationIsDao.findByTauxIsId(id);
        }

        @Override
        @Transactional
        public int deleteByTauxIsId(Long id){
        return declarationIsDao.deleteByTauxIsId(id);
        }


        @Override
        public List<DeclarationIs> findByTauxIsConfigReference(String reference){
        return declarationIsDao.findByTauxIsConfigReference(reference);
        }

        @Override
        @Transactional
        public int deleteByTauxIsConfigReference(String reference){
        return declarationIsDao.deleteByTauxIsConfigReference(reference);
        }

        @Override
        public List<DeclarationIs> findByTauxIsConfigId(Long id){
        return declarationIsDao.findByTauxIsConfigId(id);
        }

        @Override
        @Transactional
        public int deleteByTauxIsConfigId(Long id){
        return declarationIsDao.deleteByTauxIsConfigId(id);
        }


        @Override
        public List<DeclarationIs> findByEtatDeclarationIsReference(String reference){
        return declarationIsDao.findByEtatDeclarationIsReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEtatDeclarationIsReference(String reference){
        return declarationIsDao.deleteByEtatDeclarationIsReference(reference);
        }

        @Override
        public List<DeclarationIs> findByEtatDeclarationIsId(Long id){
        return declarationIsDao.findByEtatDeclarationIsId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatDeclarationIsId(Long id){
        return declarationIsDao.deleteByEtatDeclarationIsId(id);
        }


        @Override
        public List<DeclarationIs> findByPaiementDeclarationIsReference(String reference){
        return declarationIsDao.findByPaiementDeclarationIsReference(reference);
        }

        @Override
        @Transactional
        public int deleteByPaiementDeclarationIsReference(String reference){
        return declarationIsDao.deleteByPaiementDeclarationIsReference(reference);
        }

        @Override
        public List<DeclarationIs> findByPaiementDeclarationIsId(Long id){
        return declarationIsDao.findByPaiementDeclarationIsId(id);
        }

        @Override
        @Transactional
        public int deleteByPaiementDeclarationIsId(Long id){
        return declarationIsDao.deleteByPaiementDeclarationIsId(id);
        }

    @Override
    public DeclarationIs findByReference(String reference){
    if( reference==null) return null;
    return declarationIsDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return declarationIsDao.deleteByReference(reference);
    }
    @Override
    public DeclarationIs findByIdOrReference(DeclarationIs declarationIs){
    DeclarationIs resultat=null;
    if(declarationIs != null){
    if(StringUtil.isNotEmpty(declarationIs.getId())){
    resultat= declarationIsDao.getOne(declarationIs.getId());
    }else if(StringUtil.isNotEmpty(declarationIs.getReference())) {
    resultat= declarationIsDao.findByReference(declarationIs.getReference());
    }
    }
    return resultat;
    }

@Override
public DeclarationIs findById(Long id){
if(id==null) return null;
return declarationIsDao.getOne(id);
}

@Override
public DeclarationIs findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public DeclarationIs archiver(DeclarationIs declarationIs) {
    if (declarationIs.getArchive() == null) {
    declarationIs.setArchive(false);
    }
    declarationIs.setArchive(true);
    declarationIs.setDateArchivage(new Date());
    declarationIsDao.save(declarationIs);
    return declarationIs;

    }

    @Override
    public DeclarationIs desarchiver(DeclarationIs declarationIs) {
    if (declarationIs.getArchive() == null) {
    declarationIs.setArchive(false);
    }
    declarationIs.setArchive(false);
    declarationIs.setDateArchivage(null);
    declarationIsDao.save(declarationIs);
    return declarationIs;
    }



@Transactional
public int deleteById(Long id){
int res=0;
if(declarationIsDao.findById(id).isPresent())  {
declarationIsDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public DeclarationIs update(DeclarationIs declarationIs){
DeclarationIs foundedDeclarationIs = findById(declarationIs.getId());
if(foundedDeclarationIs==null) return null;
else{
    archivableService.prepare(declarationIs);
return  declarationIsDao.save(declarationIs);
}
}
    private void prepareSave(DeclarationIs declarationIs){
        declarationIs.setDateCreation(new Date());
                    if(declarationIs.getArchive() == null)
                declarationIs.setArchive(false);
                    if(declarationIs.getAdmin() == null)
                declarationIs.setAdmin(false);
                    if(declarationIs.getVisible() == null)
                declarationIs.setVisible(false);



    }

@Override
public DeclarationIs save (DeclarationIs declarationIs){
    prepareSave(declarationIs);

    DeclarationIs result =null;
    DeclarationIs foundedDeclarationIs = findByReference(declarationIs.getReference());
    if(foundedDeclarationIs == null){


    findSociete(declarationIs);
    findTauxIs(declarationIs);
    findTauxIsConfig(declarationIs);
    findEtatDeclarationIs(declarationIs);
    findPaiementDeclarationIs(declarationIs);

    DeclarationIs savedDeclarationIs = declarationIsDao.save(declarationIs);

    result = savedDeclarationIs;
    }

    return result;
}

@Override
public List<DeclarationIs> save(List<DeclarationIs> declarationIss){
List<DeclarationIs> list = new ArrayList<>();
for(DeclarationIs declarationIs: declarationIss){
list.add(save(declarationIs));
}
return list;
}



@Override
@Transactional
public int delete(DeclarationIs declarationIs){
    if(declarationIs.getReference()==null) return -1;

    DeclarationIs foundedDeclarationIs = findByReference(declarationIs.getReference());
    if(foundedDeclarationIs==null) return -1;
declarationIsDao.delete(foundedDeclarationIs);
return 1;
}


public List<DeclarationIs> findByCriteria(DeclarationIsVo declarationIsVo){

String query = "SELECT o FROM DeclarationIs o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",declarationIsVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",declarationIsVo.getReference());
            query += SearchUtil.addConstraint( "o", "annee","=",declarationIsVo.getAnnee());
            query += SearchUtil.addConstraint( "o", "totalHtProduit","=",declarationIsVo.getTotalHtProduit());
            query += SearchUtil.addConstraint( "o", "totalHtCharge","=",declarationIsVo.getTotalHtCharge());
            query += SearchUtil.addConstraint( "o", "totalHtDifference","=",declarationIsVo.getTotalHtDifference());
            query += SearchUtil.addConstraint( "o", "montantIsCalcule","=",declarationIsVo.getMontantIsCalcule());
            query += SearchUtil.addConstraint( "o", "montantIsAPaye","=",declarationIsVo.getMontantIsAPaye());
            query += SearchUtil.addConstraint( "o", "totalAPaye","=",declarationIsVo.getTotalAPaye());
            query += SearchUtil.addConstraint( "o", "archive","=",declarationIsVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",declarationIsVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",declarationIsVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",declarationIsVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",declarationIsVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",declarationIsVo.getUsername());
            query += SearchUtil.addConstraintMinMax("o","annee",declarationIsVo.getAnneeMin(),declarationIsVo.getAnneeMax());
            query += SearchUtil.addConstraintMinMax("o","totalHtProduit",declarationIsVo.getTotalHtProduitMin(),declarationIsVo.getTotalHtProduitMax());
            query += SearchUtil.addConstraintMinMax("o","totalHtCharge",declarationIsVo.getTotalHtChargeMin(),declarationIsVo.getTotalHtChargeMax());
            query += SearchUtil.addConstraintMinMax("o","totalHtDifference",declarationIsVo.getTotalHtDifferenceMin(),declarationIsVo.getTotalHtDifferenceMax());
            query += SearchUtil.addConstraintMinMax("o","montantIsCalcule",declarationIsVo.getMontantIsCalculeMin(),declarationIsVo.getMontantIsCalculeMax());
            query += SearchUtil.addConstraintMinMax("o","montantIsAPaye",declarationIsVo.getMontantIsAPayeMin(),declarationIsVo.getMontantIsAPayeMax());
            query += SearchUtil.addConstraintMinMax("o","totalAPaye",declarationIsVo.getTotalAPayeMin(),declarationIsVo.getTotalAPayeMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",declarationIsVo.getDateArchivageMin(),declarationIsVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",declarationIsVo.getDateCreationMin(),declarationIsVo.getDateCreationMax());
    if(declarationIsVo.getSocieteVo()!=null){
        query += SearchUtil.addConstraint( "o", "societe.id","=",declarationIsVo.getSocieteVo().getId());
    }

    if(declarationIsVo.getTauxIsVo()!=null){
        query += SearchUtil.addConstraint( "o", "tauxIs.id","=",declarationIsVo.getTauxIsVo().getId());
            query += SearchUtil.addConstraint( "o", "tauxIs.reference","LIKE",declarationIsVo.getTauxIsVo().getReference());
    }

    if(declarationIsVo.getTauxIsConfigVo()!=null){
        query += SearchUtil.addConstraint( "o", "tauxIsConfig.id","=",declarationIsVo.getTauxIsConfigVo().getId());
            query += SearchUtil.addConstraint( "o", "tauxIsConfig.reference","LIKE",declarationIsVo.getTauxIsConfigVo().getReference());
    }

    if(declarationIsVo.getEtatDeclarationIsVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatDeclarationIs.id","=",declarationIsVo.getEtatDeclarationIsVo().getId());
            query += SearchUtil.addConstraint( "o", "etatDeclarationIs.reference","LIKE",declarationIsVo.getEtatDeclarationIsVo().getReference());
    }

    if(declarationIsVo.getPaiementDeclarationIsVo()!=null){
        query += SearchUtil.addConstraint( "o", "paiementDeclarationIs.id","=",declarationIsVo.getPaiementDeclarationIsVo().getId());
            query += SearchUtil.addConstraint( "o", "paiementDeclarationIs.reference","LIKE",declarationIsVo.getPaiementDeclarationIsVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findSociete(DeclarationIs declarationIs){
        Societe loadedSociete = null;
        if(declarationIs.getSociete() != null && declarationIs.getSociete().getId() !=null)
        loadedSociete =societeService.findById(declarationIs.getSociete().getId());

    if(loadedSociete==null ) {
    return;
    }
    declarationIs.setSociete(loadedSociete);
    }
    private void findTauxIs(DeclarationIs declarationIs){
        TauxIs loadedTauxIs =tauxIsService.findByIdOrReference(declarationIs.getTauxIs());

    if(loadedTauxIs==null ) {
    return;
    }
    declarationIs.setTauxIs(loadedTauxIs);
    }
    private void findTauxIsConfig(DeclarationIs declarationIs){
        TauxIsConfig loadedTauxIsConfig =tauxIsConfigService.findByIdOrReference(declarationIs.getTauxIsConfig());

    if(loadedTauxIsConfig==null ) {
    return;
    }
    declarationIs.setTauxIsConfig(loadedTauxIsConfig);
    }
    private void findEtatDeclarationIs(DeclarationIs declarationIs){
        EtatDeclarationIs loadedEtatDeclarationIs =etatDeclarationIsService.findByIdOrReference(declarationIs.getEtatDeclarationIs());

    if(loadedEtatDeclarationIs==null ) {
    return;
    }
    declarationIs.setEtatDeclarationIs(loadedEtatDeclarationIs);
    }
    private void findPaiementDeclarationIs(DeclarationIs declarationIs){
        PaiementDeclarationIs loadedPaiementDeclarationIs =paiementDeclarationIsService.findByIdOrReference(declarationIs.getPaiementDeclarationIs());

    if(loadedPaiementDeclarationIs==null ) {
    return;
    }
    declarationIs.setPaiementDeclarationIs(loadedPaiementDeclarationIs);
    }

@Override
@Transactional
public void delete(List<DeclarationIs> declarationIss){
if(ListUtil.isNotEmpty(declarationIss)){
declarationIss.forEach(e->declarationIsDao.delete(e));
}
}
@Override
public void update(List<DeclarationIs> declarationIss){
if(ListUtil.isNotEmpty(declarationIss)){
declarationIss.forEach(e->declarationIsDao.save(e));
}
}





    }
