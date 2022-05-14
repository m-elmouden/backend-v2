package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Demande;
        import com.ird.faa.bean.Societe;
        import com.ird.faa.bean.Comptable;
        import com.ird.faa.bean.EtatDemande;
        import com.ird.faa.bean.Facture;
        import com.ird.faa.bean.DemandePieceJointe;
        import com.ird.faa.bean.Commentaire;
import com.ird.faa.dao.DemandeDao;
import com.ird.faa.service.admin.facade.DemandeAdminService;
        import com.ird.faa.service.admin.facade.SocieteAdminService;
        import com.ird.faa.service.admin.facade.EtatDemandeAdminService;
        import com.ird.faa.service.admin.facade.DemandePieceJointeAdminService;
        import com.ird.faa.service.admin.facade.FactureAdminService;
        import com.ird.faa.service.admin.facade.CommentaireAdminService;
        import com.ird.faa.service.admin.facade.ComptableAdminService;

import com.ird.faa.ws.rest.provided.vo.DemandeVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.Facture;
        import com.ird.faa.service.admin.facade.FactureAdminService;
        import com.ird.faa.bean.DemandePieceJointe;
        import com.ird.faa.service.admin.facade.DemandePieceJointeAdminService;
        import com.ird.faa.bean.Commentaire;
        import com.ird.faa.service.admin.facade.CommentaireAdminService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class DemandeAdminServiceImpl extends AbstractServiceImpl<Demande> implements DemandeAdminService {

@Autowired
private DemandeDao demandeDao;

    @Autowired
    private ArchivableService<Demande> archivableService;
        @Autowired
        private SocieteAdminService societeService ;
        @Autowired
        private EtatDemandeAdminService etatDemandeService ;
        @Autowired
        private DemandePieceJointeAdminService demandePieceJointeService ;
        @Autowired
        private FactureAdminService factureService ;
        @Autowired
        private CommentaireAdminService commentaireService ;
        @Autowired
        private ComptableAdminService comptableService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Demande> findAll(){
        String query = "SELECT o FROM Demande o where 1=1 ";
        query+= " ORDER BY o.dateDemande";
        return entityManager.createQuery(query).getResultList();
}
        @Override
        public List<Demande> findBySocieteId(Long id){
        return demandeDao.findBySocieteId(id);
        }

        @Override
        @Transactional
        public int deleteBySocieteId(Long id){
        return demandeDao.deleteBySocieteId(id);
        }


        @Override
        public List<Demande> findByComptableCode(String code){
        return demandeDao.findByComptableCode(code);
        }

        @Override
        @Transactional
        public int deleteByComptableCode(String code){
        return demandeDao.deleteByComptableCode(code);
        }

        @Override
        public List<Demande> findByComptableId(Long id){
        return demandeDao.findByComptableId(id);
        }

        @Override
        @Transactional
        public int deleteByComptableId(Long id){
        return demandeDao.deleteByComptableId(id);
        }


        @Override
        public List<Demande> findByEtatDemandeReference(String reference){
        return demandeDao.findByEtatDemandeReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEtatDemandeReference(String reference){
        return demandeDao.deleteByEtatDemandeReference(reference);
        }

        @Override
        public List<Demande> findByEtatDemandeId(Long id){
        return demandeDao.findByEtatDemandeId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatDemandeId(Long id){
        return demandeDao.deleteByEtatDemandeId(id);
        }

    @Override
    public Demande findByReference(String reference){
    if( reference==null) return null;
    return demandeDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return demandeDao.deleteByReference(reference);
    }
    @Override
    public Demande findByIdOrReference(Demande demande){
    Demande resultat=null;
    if(demande != null){
    if(StringUtil.isNotEmpty(demande.getId())){
    resultat= demandeDao.getOne(demande.getId());
    }else if(StringUtil.isNotEmpty(demande.getReference())) {
    resultat= demandeDao.findByReference(demande.getReference());
    }
    }
    return resultat;
    }

@Override
public Demande findById(Long id){
if(id==null) return null;
return demandeDao.getOne(id);
}

@Override
public Demande findByIdWithAssociatedList(Long id){
    Demande demande  = findById(id);
    findAssociatedLists(demande);
    return demande;
}
    @Override
    public Demande archiver(Demande demande) {
    if (demande.getArchive() == null) {
    demande.setArchive(false);
    }
    demande.setArchive(true);
    demande.setDateArchivage(new Date());
    demandeDao.save(demande);
    return demande;

    }

    @Override
    public Demande desarchiver(Demande demande) {
    if (demande.getArchive() == null) {
    demande.setArchive(false);
    }
    demande.setArchive(false);
    demande.setDateArchivage(null);
    demandeDao.save(demande);
    return demande;
    }

    private void findAssociatedLists(Demande demande){
    if(demande!=null && demande.getId() != null) {
            List<Facture> factures = factureService.findByDemandeId(demande.getId());
            demande.setFactures(factures);
            List<DemandePieceJointe> demandePieceJointes = demandePieceJointeService.findByDemandeId(demande.getId());
            demande.setDemandePieceJointes(demandePieceJointes);
            List<Commentaire> commentaires = commentaireService.findByDemandeId(demande.getId());
            demande.setCommentaires(commentaires);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            factureService.deleteByDemandeId(id);
            demandePieceJointeService.deleteByDemandeId(id);
            commentaireService.deleteByDemandeId(id);
    }
    }

    private void updateAssociatedLists(Demande demande){
    if(demande !=null && demande.getId() != null){
            List
            <List<Facture>> resultFactures= factureService.getToBeSavedAndToBeDeleted(factureService.findByDemandeId(demande.getId()),demande.getFactures());
            factureService.delete(resultFactures.get(1));
            associateFacture(demande,resultFactures.get(0));
            factureService.update(resultFactures.get(0));

            List
            <List<DemandePieceJointe>> resultDemandePieceJointes= demandePieceJointeService.getToBeSavedAndToBeDeleted(demandePieceJointeService.findByDemandeId(demande.getId()),demande.getDemandePieceJointes());
            demandePieceJointeService.delete(resultDemandePieceJointes.get(1));
            associateDemandePieceJointe(demande,resultDemandePieceJointes.get(0));
            demandePieceJointeService.update(resultDemandePieceJointes.get(0));

            List
            <List<Commentaire>> resultCommentaires= commentaireService.getToBeSavedAndToBeDeleted(commentaireService.findByDemandeId(demande.getId()),demande.getCommentaires());
            commentaireService.delete(resultCommentaires.get(1));
            associateCommentaire(demande,resultCommentaires.get(0));
            commentaireService.update(resultCommentaires.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(demandeDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
demandeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Demande update(Demande demande){
Demande foundedDemande = findById(demande.getId());
if(foundedDemande==null) return null;
else{
    archivableService.prepare(demande);
    updateAssociatedLists(demande);
return  demandeDao.save(demande);
}
}
    private void prepareSave(Demande demande){
        demande.setDateCreation(new Date());
                    if(demande.getArchive() == null)
                demande.setArchive(false);
                    if(demande.getAdmin() == null)
                demande.setAdmin(false);
                    if(demande.getVisible() == null)
                demande.setVisible(false);



    }

@Override
public Demande save (Demande demande){
    prepareSave(demande);

    Demande result =null;
    Demande foundedDemande = findByReference(demande.getReference());
    if(foundedDemande == null){


    findSociete(demande);
    findComptable(demande);
    findEtatDemande(demande);

    Demande savedDemande = demandeDao.save(demande);

        saveFactures(savedDemande,demande.getFactures());
        saveDemandePieceJointes(savedDemande,demande.getDemandePieceJointes());
        saveCommentaires(savedDemande,demande.getCommentaires());
    result = savedDemande;
    }

    return result;
}

@Override
public List<Demande> save(List<Demande> demandes){
List<Demande> list = new ArrayList<>();
for(Demande demande: demandes){
list.add(save(demande));
}
return list;
}

        private List<Facture> prepareFactures(Demande demande,List<Facture> factures){
        for(Facture facture:factures ){
        facture.setDemande(demande);
        }
        return factures;
        }
        private List<DemandePieceJointe> prepareDemandePieceJointes(Demande demande,List<DemandePieceJointe> demandePieceJointes){
        for(DemandePieceJointe demandePieceJointe:demandePieceJointes ){
        demandePieceJointe.setDemande(demande);
        }
        return demandePieceJointes;
        }
        private List<Commentaire> prepareCommentaires(Demande demande,List<Commentaire> commentaires){
        for(Commentaire commentaire:commentaires ){
        commentaire.setDemande(demande);
        }
        return commentaires;
        }


@Override
@Transactional
public int delete(Demande demande){
    if(demande.getReference()==null) return -1;

    Demande foundedDemande = findByReference(demande.getReference());
    if(foundedDemande==null) return -1;
demandeDao.delete(foundedDemande);
return 1;
}


public List<Demande> findByCriteria(DemandeVo demandeVo){

String query = "SELECT o FROM Demande o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",demandeVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",demandeVo.getReference());
            query += SearchUtil.addConstraint( "o", "operation","LIKE",demandeVo.getOperation());
        query += SearchUtil.addConstraintDate( "o", "dateDemande","=",demandeVo.getDateDemande());
            query += SearchUtil.addConstraint( "o", "annee","=",demandeVo.getAnnee());
            query += SearchUtil.addConstraint( "o", "mois","=",demandeVo.getMois());
            query += SearchUtil.addConstraint( "o", "trimestre","=",demandeVo.getTrimestre());
            query += SearchUtil.addConstraint( "o", "demandePieceJointes","=",demandeVo.getDemandePieceJointesVo());
            query += SearchUtil.addConstraint( "o", "archive","=",demandeVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",demandeVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",demandeVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",demandeVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",demandeVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",demandeVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateDemande",demandeVo.getDateDemandeMin(),demandeVo.getDateDemandeMax());
            query += SearchUtil.addConstraintMinMax("o","annee",demandeVo.getAnneeMin(),demandeVo.getAnneeMax());
            query += SearchUtil.addConstraintMinMax("o","mois",demandeVo.getMoisMin(),demandeVo.getMoisMax());
            query += SearchUtil.addConstraintMinMax("o","trimestre",demandeVo.getTrimestreMin(),demandeVo.getTrimestreMax());
            query += SearchUtil.addConstraintMinMax("o","demandePieceJointes",demandeVo.getDemandePieceJointesMin(),demandeVo.getDemandePieceJointesMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",demandeVo.getDateArchivageMin(),demandeVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",demandeVo.getDateCreationMin(),demandeVo.getDateCreationMax());
    if(demandeVo.getSocieteVo()!=null){
        query += SearchUtil.addConstraint( "o", "societe.id","=",demandeVo.getSocieteVo().getId());
    }

    if(demandeVo.getComptableVo()!=null){
        query += SearchUtil.addConstraint( "o", "comptable.id","=",demandeVo.getComptableVo().getId());
            query += SearchUtil.addConstraint( "o", "comptable.code","LIKE",demandeVo.getComptableVo().getCode());
    }

    if(demandeVo.getEtatDemandeVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatDemande.id","=",demandeVo.getEtatDemandeVo().getId());
            query += SearchUtil.addConstraint( "o", "etatDemande.reference","LIKE",demandeVo.getEtatDemandeVo().getReference());
    }

    query+= " ORDER BY o.dateDemande";
return entityManager.createQuery(query).getResultList();
}
        private  void saveFactures(Demande demande,List<Facture> factures){

        if (ListUtil.isNotEmpty(demande.getFactures())) {
        List<Facture> savedFactures = new ArrayList<>();
        factures.forEach(element -> {
        element.setDemande(demande);
         factureService.save(element);
        });
        demande.setFactures(savedFactures);
        }
        }
        private  void saveDemandePieceJointes(Demande demande,List<DemandePieceJointe> demandePieceJointes){

        if (ListUtil.isNotEmpty(demande.getDemandePieceJointes())) {
        List<DemandePieceJointe> savedDemandePieceJointes = new ArrayList<>();
        demandePieceJointes.forEach(element -> {
        element.setDemande(demande);
         demandePieceJointeService.save(element);
        });
        demande.setDemandePieceJointes(savedDemandePieceJointes);
        }
        }
        private  void saveCommentaires(Demande demande,List<Commentaire> commentaires){

        if (ListUtil.isNotEmpty(demande.getCommentaires())) {
        List<Commentaire> savedCommentaires = new ArrayList<>();
        commentaires.forEach(element -> {
        element.setDemande(demande);
         commentaireService.save(element);
        });
        demande.setCommentaires(savedCommentaires);
        }
        }

    private void findSociete(Demande demande){
        Societe loadedSociete = null;
        if(demande.getSociete() != null && demande.getSociete().getId() !=null)
        loadedSociete =societeService.findById(demande.getSociete().getId());

    if(loadedSociete==null ) {
    return;
    }
    demande.setSociete(loadedSociete);
    }
    private void findComptable(Demande demande){
        Comptable loadedComptable =comptableService.findByIdOrCode(demande.getComptable());

    if(loadedComptable==null ) {
    return;
    }
    demande.setComptable(loadedComptable);
    }
    private void findEtatDemande(Demande demande){
        EtatDemande loadedEtatDemande =etatDemandeService.findByIdOrReference(demande.getEtatDemande());

    if(loadedEtatDemande==null ) {
    return;
    }
    demande.setEtatDemande(loadedEtatDemande);
    }

@Override
@Transactional
public void delete(List<Demande> demandes){
if(ListUtil.isNotEmpty(demandes)){
demandes.forEach(e->demandeDao.delete(e));
}
}
@Override
public void update(List<Demande> demandes){
if(ListUtil.isNotEmpty(demandes)){
demandes.forEach(e->demandeDao.save(e));
}
}

        private void associateFacture(Demande demande, List<Facture> facture) {
        if (ListUtil.isNotEmpty(facture)) {
        facture.forEach(e -> e.setDemande(demande));
        }
        }
        private void associateDemandePieceJointe(Demande demande, List<DemandePieceJointe> demandePieceJointe) {
        if (ListUtil.isNotEmpty(demandePieceJointe)) {
        demandePieceJointe.forEach(e -> e.setDemande(demande));
        }
        }
        private void associateCommentaire(Demande demande, List<Commentaire> commentaire) {
        if (ListUtil.isNotEmpty(commentaire)) {
        commentaire.forEach(e -> e.setDemande(demande));
        }
        }




    }
