package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.DeclarationTva;
        import com.ird.faa.bean.Societe;
        import com.ird.faa.bean.TypeDeclarationTva;
        import com.ird.faa.bean.EtatDeclarationTva;
        import com.ird.faa.bean.PaiementDeclarationTva;
import com.ird.faa.dao.DeclarationTvaDao;
import com.ird.faa.service.admin.facade.DeclarationTvaAdminService;
        import com.ird.faa.service.admin.facade.SocieteAdminService;
        import com.ird.faa.service.admin.facade.PaiementDeclarationTvaAdminService;
        import com.ird.faa.service.admin.facade.EtatDeclarationTvaAdminService;
        import com.ird.faa.service.admin.facade.TypeDeclarationTvaAdminService;

import com.ird.faa.ws.rest.provided.vo.DeclarationTvaVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class DeclarationTvaAdminServiceImpl extends AbstractServiceImpl<DeclarationTva> implements DeclarationTvaAdminService {

@Autowired
private DeclarationTvaDao declarationTvaDao;

    @Autowired
    private ArchivableService<DeclarationTva> archivableService;
        @Autowired
        private SocieteAdminService societeService ;
        @Autowired
        private PaiementDeclarationTvaAdminService paiementDeclarationTvaService ;
        @Autowired
        private EtatDeclarationTvaAdminService etatDeclarationTvaService ;
        @Autowired
        private TypeDeclarationTvaAdminService typeDeclarationTvaService ;


@Autowired
private EntityManager entityManager;


@Override
public List<DeclarationTva> findAll(){
        return declarationTvaDao.findAll();
}
        @Override
        public List<DeclarationTva> findBySocieteId(Long id){
        return declarationTvaDao.findBySocieteId(id);
        }

        @Override
        @Transactional
        public int deleteBySocieteId(Long id){
        return declarationTvaDao.deleteBySocieteId(id);
        }


        @Override
        public List<DeclarationTva> findByTypeDeclarationTvaReference(String reference){
        return declarationTvaDao.findByTypeDeclarationTvaReference(reference);
        }

        @Override
        @Transactional
        public int deleteByTypeDeclarationTvaReference(String reference){
        return declarationTvaDao.deleteByTypeDeclarationTvaReference(reference);
        }

        @Override
        public List<DeclarationTva> findByTypeDeclarationTvaId(Long id){
        return declarationTvaDao.findByTypeDeclarationTvaId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeDeclarationTvaId(Long id){
        return declarationTvaDao.deleteByTypeDeclarationTvaId(id);
        }


        @Override
        public List<DeclarationTva> findByEtatDeclarationTvaReference(String reference){
        return declarationTvaDao.findByEtatDeclarationTvaReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEtatDeclarationTvaReference(String reference){
        return declarationTvaDao.deleteByEtatDeclarationTvaReference(reference);
        }

        @Override
        public List<DeclarationTva> findByEtatDeclarationTvaId(Long id){
        return declarationTvaDao.findByEtatDeclarationTvaId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatDeclarationTvaId(Long id){
        return declarationTvaDao.deleteByEtatDeclarationTvaId(id);
        }


        @Override
        public List<DeclarationTva> findByPaiementDeclarationTvaReference(String reference){
        return declarationTvaDao.findByPaiementDeclarationTvaReference(reference);
        }

        @Override
        @Transactional
        public int deleteByPaiementDeclarationTvaReference(String reference){
        return declarationTvaDao.deleteByPaiementDeclarationTvaReference(reference);
        }

        @Override
        public List<DeclarationTva> findByPaiementDeclarationTvaId(Long id){
        return declarationTvaDao.findByPaiementDeclarationTvaId(id);
        }

        @Override
        @Transactional
        public int deleteByPaiementDeclarationTvaId(Long id){
        return declarationTvaDao.deleteByPaiementDeclarationTvaId(id);
        }

    @Override
    public DeclarationTva findByReference(String reference){
    if( reference==null) return null;
    return declarationTvaDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return declarationTvaDao.deleteByReference(reference);
    }
    @Override
    public DeclarationTva findByIdOrReference(DeclarationTva declarationTva){
    DeclarationTva resultat=null;
    if(declarationTva != null){
    if(StringUtil.isNotEmpty(declarationTva.getId())){
    resultat= declarationTvaDao.getOne(declarationTva.getId());
    }else if(StringUtil.isNotEmpty(declarationTva.getReference())) {
    resultat= declarationTvaDao.findByReference(declarationTva.getReference());
    }
    }
    return resultat;
    }

@Override
public DeclarationTva findById(Long id){
if(id==null) return null;
return declarationTvaDao.getOne(id);
}

@Override
public DeclarationTva findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public DeclarationTva archiver(DeclarationTva declarationTva) {
    if (declarationTva.getArchive() == null) {
    declarationTva.setArchive(false);
    }
    declarationTva.setArchive(true);
    declarationTva.setDateArchivage(new Date());
    declarationTvaDao.save(declarationTva);
    return declarationTva;

    }

    @Override
    public DeclarationTva desarchiver(DeclarationTva declarationTva) {
    if (declarationTva.getArchive() == null) {
    declarationTva.setArchive(false);
    }
    declarationTva.setArchive(false);
    declarationTva.setDateArchivage(null);
    declarationTvaDao.save(declarationTva);
    return declarationTva;
    }



@Transactional
public int deleteById(Long id){
int res=0;
if(declarationTvaDao.findById(id).isPresent())  {
declarationTvaDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public DeclarationTva update(DeclarationTva declarationTva){
DeclarationTva foundedDeclarationTva = findById(declarationTva.getId());
if(foundedDeclarationTva==null) return null;
else{
    archivableService.prepare(declarationTva);
return  declarationTvaDao.save(declarationTva);
}
}
    private void prepareSave(DeclarationTva declarationTva){
        declarationTva.setDateCreation(new Date());
                    if(declarationTva.getArchive() == null)
                declarationTva.setArchive(false);
                    if(declarationTva.getAdmin() == null)
                declarationTva.setAdmin(false);
                    if(declarationTva.getVisible() == null)
                declarationTva.setVisible(false);



    }

@Override
public DeclarationTva save (DeclarationTva declarationTva){
    prepareSave(declarationTva);

    DeclarationTva result =null;
    DeclarationTva foundedDeclarationTva = findByReference(declarationTva.getReference());
    if(foundedDeclarationTva == null){


    findSociete(declarationTva);
    findTypeDeclarationTva(declarationTva);
    findEtatDeclarationTva(declarationTva);
    findPaiementDeclarationTva(declarationTva);

    DeclarationTva savedDeclarationTva = declarationTvaDao.save(declarationTva);

    result = savedDeclarationTva;
    }

    return result;
}

@Override
public List<DeclarationTva> save(List<DeclarationTva> declarationTvas){
List<DeclarationTva> list = new ArrayList<>();
for(DeclarationTva declarationTva: declarationTvas){
list.add(save(declarationTva));
}
return list;
}



@Override
@Transactional
public int delete(DeclarationTva declarationTva){
    if(declarationTva.getReference()==null) return -1;

    DeclarationTva foundedDeclarationTva = findByReference(declarationTva.getReference());
    if(foundedDeclarationTva==null) return -1;
declarationTvaDao.delete(foundedDeclarationTva);
return 1;
}


public List<DeclarationTva> findByCriteria(DeclarationTvaVo declarationTvaVo){

String query = "SELECT o FROM DeclarationTva o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",declarationTvaVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",declarationTvaVo.getReference());
            query += SearchUtil.addConstraint( "o", "tvacollecter","=",declarationTvaVo.getTvacollecter());
            query += SearchUtil.addConstraint( "o", "tvaperdue","=",declarationTvaVo.getTvaperdue());
            query += SearchUtil.addConstraint( "o", "differenceTva","=",declarationTvaVo.getDifferenceTva());
            query += SearchUtil.addConstraint( "o", "montantTvaCalcule","=",declarationTvaVo.getMontantTvaCalcule());
            query += SearchUtil.addConstraint( "o", "montantTvaAPaye","=",declarationTvaVo.getMontantTvaAPaye());
            query += SearchUtil.addConstraint( "o", "annee","=",declarationTvaVo.getAnnee());
            query += SearchUtil.addConstraint( "o", "mois","=",declarationTvaVo.getMois());
            query += SearchUtil.addConstraint( "o", "trimestre","=",declarationTvaVo.getTrimestre());
            query += SearchUtil.addConstraint( "o", "archive","=",declarationTvaVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",declarationTvaVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",declarationTvaVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",declarationTvaVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",declarationTvaVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",declarationTvaVo.getUsername());
            query += SearchUtil.addConstraintMinMax("o","tvacollecter",declarationTvaVo.getTvacollecterMin(),declarationTvaVo.getTvacollecterMax());
            query += SearchUtil.addConstraintMinMax("o","tvaperdue",declarationTvaVo.getTvaperdueMin(),declarationTvaVo.getTvaperdueMax());
            query += SearchUtil.addConstraintMinMax("o","differenceTva",declarationTvaVo.getDifferenceTvaMin(),declarationTvaVo.getDifferenceTvaMax());
            query += SearchUtil.addConstraintMinMax("o","montantTvaCalcule",declarationTvaVo.getMontantTvaCalculeMin(),declarationTvaVo.getMontantTvaCalculeMax());
            query += SearchUtil.addConstraintMinMax("o","montantTvaAPaye",declarationTvaVo.getMontantTvaAPayeMin(),declarationTvaVo.getMontantTvaAPayeMax());
            query += SearchUtil.addConstraintMinMax("o","annee",declarationTvaVo.getAnneeMin(),declarationTvaVo.getAnneeMax());
            query += SearchUtil.addConstraintMinMax("o","mois",declarationTvaVo.getMoisMin(),declarationTvaVo.getMoisMax());
            query += SearchUtil.addConstraintMinMax("o","trimestre",declarationTvaVo.getTrimestreMin(),declarationTvaVo.getTrimestreMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",declarationTvaVo.getDateArchivageMin(),declarationTvaVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",declarationTvaVo.getDateCreationMin(),declarationTvaVo.getDateCreationMax());
    if(declarationTvaVo.getSocieteVo()!=null){
        query += SearchUtil.addConstraint( "o", "societe.id","=",declarationTvaVo.getSocieteVo().getId());
    }

    if(declarationTvaVo.getTypeDeclarationTvaVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeDeclarationTva.id","=",declarationTvaVo.getTypeDeclarationTvaVo().getId());
            query += SearchUtil.addConstraint( "o", "typeDeclarationTva.reference","LIKE",declarationTvaVo.getTypeDeclarationTvaVo().getReference());
    }

    if(declarationTvaVo.getEtatDeclarationTvaVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatDeclarationTva.id","=",declarationTvaVo.getEtatDeclarationTvaVo().getId());
            query += SearchUtil.addConstraint( "o", "etatDeclarationTva.reference","LIKE",declarationTvaVo.getEtatDeclarationTvaVo().getReference());
    }

    if(declarationTvaVo.getPaiementDeclarationTvaVo()!=null){
        query += SearchUtil.addConstraint( "o", "paiementDeclarationTva.id","=",declarationTvaVo.getPaiementDeclarationTvaVo().getId());
            query += SearchUtil.addConstraint( "o", "paiementDeclarationTva.reference","LIKE",declarationTvaVo.getPaiementDeclarationTvaVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findSociete(DeclarationTva declarationTva){
        Societe loadedSociete = null;
        if(declarationTva.getSociete() != null && declarationTva.getSociete().getId() !=null)
        loadedSociete =societeService.findById(declarationTva.getSociete().getId());

    if(loadedSociete==null ) {
    return;
    }
    declarationTva.setSociete(loadedSociete);
    }
    private void findTypeDeclarationTva(DeclarationTva declarationTva){
        TypeDeclarationTva loadedTypeDeclarationTva =typeDeclarationTvaService.findByIdOrReference(declarationTva.getTypeDeclarationTva());

    if(loadedTypeDeclarationTva==null ) {
    return;
    }
    declarationTva.setTypeDeclarationTva(loadedTypeDeclarationTva);
    }
    private void findEtatDeclarationTva(DeclarationTva declarationTva){
        EtatDeclarationTva loadedEtatDeclarationTva =etatDeclarationTvaService.findByIdOrReference(declarationTva.getEtatDeclarationTva());

    if(loadedEtatDeclarationTva==null ) {
    return;
    }
    declarationTva.setEtatDeclarationTva(loadedEtatDeclarationTva);
    }
    private void findPaiementDeclarationTva(DeclarationTva declarationTva){
        PaiementDeclarationTva loadedPaiementDeclarationTva =paiementDeclarationTvaService.findByIdOrReference(declarationTva.getPaiementDeclarationTva());

    if(loadedPaiementDeclarationTva==null ) {
    return;
    }
    declarationTva.setPaiementDeclarationTva(loadedPaiementDeclarationTva);
    }

@Override
@Transactional
public void delete(List<DeclarationTva> declarationTvas){
if(ListUtil.isNotEmpty(declarationTvas)){
declarationTvas.forEach(e->declarationTvaDao.delete(e));
}
}
@Override
public void update(List<DeclarationTva> declarationTvas){
if(ListUtil.isNotEmpty(declarationTvas)){
declarationTvas.forEach(e->declarationTvaDao.save(e));
}
}





    }
