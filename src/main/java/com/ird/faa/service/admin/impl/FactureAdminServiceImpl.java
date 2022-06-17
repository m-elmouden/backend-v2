package com.ird.faa.service.admin.impl;

import com.ird.faa.bean.*;
import com.ird.faa.dao.FactureDao;
import com.ird.faa.service.admin.facade.*;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.FactureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FactureAdminServiceImpl extends AbstractServiceImpl<Facture> implements FactureAdminService {

    @Autowired
    private FactureDao factureDao;

    @Autowired
    private ArchivableService<Facture> archivableService;
    @Autowired
    private SocieteAdminService societeService;
    @Autowired
    private DeclarationTvaAdminService declarationTvaService;
    @Autowired
    private CpcFactureAdminService cpcFactureService;
    @Autowired
    private DemandeAdminService demandeService;
    @Autowired
    private TypeOperationFactureAdminService typeOperationFactureService;
    @Autowired
    private ClasseComptableAdminService classeComptableService;
    @Autowired
    private CompteComptableAdminService compteComptableService;
    @Autowired
    private EtatFactureAdminService etatFactureService;
    @Autowired
    private DeclarationIsAdminService declarationIsService;
    @Autowired
    private EtatPaiementAdminService etatPaiementService;
    @Autowired
    private TvaAdminService tvaService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Facture> findAll() {
        String query = "SELECT o FROM Facture o where 1=1 ";
        query += " ORDER BY o.dateOperation";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Facture> findByTvaReference(String reference) {
        return factureDao.findByTvaReference(reference);
    }

    @Override
    @Transactional
    public int deleteByTvaReference(String reference) {
        return factureDao.deleteByTvaReference(reference);
    }

    @Override
    public List<Facture> findByTvaId(Long id) {
        return factureDao.findByTvaId(id);
    }

    @Override
    @Transactional
    public int deleteByTvaId(Long id) {
        return factureDao.deleteByTvaId(id);
    }

    @Override
    public List<Facture> findByTypeOperationFactureId(Long id) {
        return factureDao.findByTypeOperationFactureId(id);
    }

    @Override
    @Transactional
    public int deleteByTypeOperationFactureId(Long id) {
        return factureDao.deleteByTypeOperationFactureId(id);
    }

    @Override
    public List<Facture> findByEtatFactureId(Long id) {
        return factureDao.findByEtatFactureId(id);
    }

    @Override
    @Transactional
    public int deleteByEtatFactureId(Long id) {
        return factureDao.deleteByEtatFactureId(id);
    }

    @Override
    public List<Facture> findByEtatPaiementId(Long id) {
        return factureDao.findByEtatPaiementId(id);
    }

    @Override
    @Transactional
    public int deleteByEtatPaiementId(Long id) {
        return factureDao.deleteByEtatPaiementId(id);
    }

    @Override
    public List<Facture> findBySocieteId(Long id) {
        return factureDao.findBySocieteId(id);
    }

    @Override
    @Transactional
    public int deleteBySocieteId(Long id) {
        return factureDao.deleteBySocieteId(id);
    }


    @Override
    public List<Facture> findByCompteComptableNumero(BigDecimal numero) {
        return factureDao.findByCompteComptableNumero(numero);
    }

    @Override
    @Transactional
    public int deleteByCompteComptableNumero(BigDecimal numero) {
        return factureDao.deleteByCompteComptableNumero(numero);
    }

    @Override
    public List<Facture> findByCompteComptableId(Long id) {
        return factureDao.findByCompteComptableId(id);
    }

    @Override
    @Transactional
    public int deleteByCompteComptableId(Long id) {
        return factureDao.deleteByCompteComptableId(id);
    }


    @Override
    public List<Facture> findByDeclarationIsReference(String reference) {
        return factureDao.findByDeclarationIsReference(reference);
    }

    @Override
    @Transactional
    public int deleteByDeclarationIsReference(String reference) {
        return factureDao.deleteByDeclarationIsReference(reference);
    }

    @Override
    public List<Facture> findByDeclarationIsId(Long id) {
        return factureDao.findByDeclarationIsId(id);
    }

    @Override
    @Transactional
    public int deleteByDeclarationIsId(Long id) {
        return factureDao.deleteByDeclarationIsId(id);
    }


    @Override
    public List<Facture> findByDeclarationTvaReference(String reference) {
        return factureDao.findByDeclarationTvaReference(reference);
    }

    @Override
    @Transactional
    public int deleteByDeclarationTvaReference(String reference) {
        return factureDao.deleteByDeclarationTvaReference(reference);
    }

    @Override
    public List<Facture> findByDeclarationTvaId(Long id) {
        return factureDao.findByDeclarationTvaId(id);
    }

    @Override
    @Transactional
    public int deleteByDeclarationTvaId(Long id) {
        return factureDao.deleteByDeclarationTvaId(id);
    }


    @Override
    public List<Facture> findByDemandeReference(String reference) {
        return factureDao.findByDemandeReference(reference);
    }

    @Override
    @Transactional
    public int deleteByDemandeReference(String reference) {
        return factureDao.deleteByDemandeReference(reference);
    }

    @Override
    public List<Facture> findByDemandeId(Long id) {
        return factureDao.findByDemandeId(id);
    }

    @Override
    @Transactional
    public int deleteByDemandeId(Long id) {
        return factureDao.deleteByDemandeId(id);
    }

    @Override
    public List<Facture> findByClasseComptableId(Long id) {
        return factureDao.findByClasseComptableId(id);
    }

    @Override
    @Transactional
    public int deleteByClasseComptableId(Long id) {
        return factureDao.deleteByClasseComptableId(id);
    }

    @Override
    public List<Facture> findByCpcFactureId(Long id) {
        return factureDao.findByCpcFactureId(id);
    }

    @Override
    @Transactional
    public int deleteByCpcFactureId(Long id) {
        return factureDao.deleteByCpcFactureId(id);
    }

    @Override
    public Facture findByReference(String reference) {
        if (reference == null) return null;
        return factureDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return factureDao.deleteByReference(reference);
    }

    @Override
    public Facture findByIdOrReference(Facture facture) {
        Facture resultat = null;
        if (facture != null) {
            if (StringUtil.isNotEmpty(facture.getId())) {
                resultat = factureDao.getOne(facture.getId());
            } else if (StringUtil.isNotEmpty(facture.getReference())) {
                resultat = factureDao.findByReference(facture.getReference());
            }
        }
        return resultat;
    }

    @Override
    public Facture findById(Long id) {
        if (id == null) return null;
        return factureDao.getOne(id);
    }

    @Override
    public Facture findByIdWithAssociatedList(Long id) {
        return findById(id);
    }

    @Override
    public Facture archiver(Facture facture) {
        if (facture.getArchive() == null) {
            facture.setArchive(false);
        }
        facture.setArchive(true);
        facture.setDateArchivage(new Date());
        factureDao.save(facture);
        return facture;

    }

    @Override
    public Facture desarchiver(Facture facture) {
        if (facture.getArchive() == null) {
            facture.setArchive(false);
        }
        facture.setArchive(false);
        facture.setDateArchivage(null);
        factureDao.save(facture);
        return facture;
    }


    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (factureDao.findById(id).isPresent()) {
            factureDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public Facture update(Facture facture) {
        Facture foundedFacture = findById(facture.getId());
        if (foundedFacture == null) return null;
        else {
            archivableService.prepare(facture);
            return factureDao.save(facture);
        }
    }

    private void prepareSave(Facture facture) {
        facture.setDateCreation(new Date());
        if (facture.getArchive() == null)
            facture.setArchive(false);
        if (facture.getAdmin() == null)
            facture.setAdmin(false);
        if (facture.getVisible() == null)
            facture.setVisible(false);


    }

    @Override
    public Facture save(Facture facture) {
        prepareSave(facture);

        Facture result = null;
        Facture foundedFacture = findByReference(facture.getReference());
        if (foundedFacture == null) {


            findTva(facture);
            findTypeOperationFacture(facture);
            findEtatFacture(facture);
            findEtatPaiement(facture);
            findSociete(facture);
            findCompteComptable(facture);
            findDeclarationIs(facture);
            findDeclarationTva(facture);
            findDemande(facture);
            findClasseComptable(facture);
            findCpcFacture(facture);

            Facture savedFacture = factureDao.save(facture);

            result = savedFacture;
        }

        return result;
    }

    @Override
    public List<Facture> save(List<Facture> factures) {
        List<Facture> list = new ArrayList<>();
        for (Facture facture : factures) {
            list.add(save(facture));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(Facture facture) {
        if (facture.getReference() == null) return -1;

        Facture foundedFacture = findByReference(facture.getReference());
        if (foundedFacture == null) return -1;
        factureDao.delete(foundedFacture);
        return 1;
    }


    public List<Facture> findByCriteria(FactureVo factureVo) {

        String query = "SELECT o FROM Facture o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", factureVo.getId());
        query += SearchUtil.addConstraint("o", "reference", "LIKE", factureVo.getReference());
        query += SearchUtil.addConstraint("o", "libelle", "LIKE", factureVo.getLibelle());
        query += SearchUtil.addConstraint("o", "montantHorsTaxe", "=", factureVo.getMontantHorsTaxe());
        query += SearchUtil.addConstraintDate("o", "dateOperation", "=", factureVo.getDateOperation());
        query += SearchUtil.addConstraint("o", "annee", "=", factureVo.getAnnee());
        query += SearchUtil.addConstraint("o", "mois", "=", factureVo.getMois());
        query += SearchUtil.addConstraint("o", "trimestre", "=", factureVo.getTrimestre());
        query += SearchUtil.addConstraint("o", "montantTtc", "=", factureVo.getMontantTtc());
        query += SearchUtil.addConstraint("o", "montantTva", "=", factureVo.getMontantTva());
        query += SearchUtil.addConstraint("o", "credit", "LIKE", factureVo.getCredit());
        query += SearchUtil.addConstraint("o", "debit", "LIKE", factureVo.getDebit());
        query += SearchUtil.addConstraint("o", "facturePieceJointe", "=", factureVo.getFacturePieceJointeVo());
        query += SearchUtil.addConstraint("o", "archive", "=", factureVo.getArchive());
        query += SearchUtil.addConstraintDate("o", "dateArchivage", "=", factureVo.getDateArchivage());
        query += SearchUtil.addConstraintDate("o", "dateCreation", "=", factureVo.getDateCreation());
        query += SearchUtil.addConstraint("o", "admin", "=", factureVo.getAdmin());
        query += SearchUtil.addConstraint("o", "visible", "=", factureVo.getVisible());
        query += SearchUtil.addConstraint("o", "username", "LIKE", factureVo.getUsername());
        query += SearchUtil.addConstraintMinMax("o", "montantHorsTaxe", factureVo.getMontantHorsTaxeMin(), factureVo.getMontantHorsTaxeMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateOperation", factureVo.getDateOperationMin(), factureVo.getDateOperationMax());
        query += SearchUtil.addConstraintMinMax("o", "annee", factureVo.getAnneeMin(), factureVo.getAnneeMax());
        query += SearchUtil.addConstraintMinMax("o", "mois", factureVo.getMoisMin(), factureVo.getMoisMax());
        query += SearchUtil.addConstraintMinMax("o", "trimestre", factureVo.getTrimestreMin(), factureVo.getTrimestreMax());
        query += SearchUtil.addConstraintMinMax("o", "montantTtc", factureVo.getMontantTtcMin(), factureVo.getMontantTtcMax());
        query += SearchUtil.addConstraintMinMax("o", "montantTva", factureVo.getMontantTvaMin(), factureVo.getMontantTvaMax());
        query += SearchUtil.addConstraintMinMax("o", "facturePieceJointe", factureVo.getFacturePieceJointeMin(), factureVo.getFacturePieceJointeMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateArchivage", factureVo.getDateArchivageMin(), factureVo.getDateArchivageMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", factureVo.getDateCreationMin(), factureVo.getDateCreationMax());
        if (factureVo.getTvaVo() != null) {
            query += SearchUtil.addConstraint("o", "tva.id", "=", factureVo.getTvaVo().getId());
            query += SearchUtil.addConstraint("o", "tva.reference", "LIKE", factureVo.getTvaVo().getReference());
        }

        if (factureVo.getTypeOperationFactureVo() != null) {
            query += SearchUtil.addConstraint("o", "typeOperationFacture.id", "=", factureVo.getTypeOperationFactureVo().getId());
        }

        if (factureVo.getEtatFactureVo() != null) {
            query += SearchUtil.addConstraint("o", "etatFacture.id", "=", factureVo.getEtatFactureVo().getId());
        }

        if (factureVo.getEtatPaiementVo() != null) {
            query += SearchUtil.addConstraint("o", "etatPaiement.id", "=", factureVo.getEtatPaiementVo().getId());
        }

        if (factureVo.getSocieteVo() != null) {
            query += SearchUtil.addConstraint("o", "societe.id", "=", factureVo.getSocieteVo().getId());
        }

        if (factureVo.getCompteComptableVo() != null) {
            query += SearchUtil.addConstraint("o", "compteComptable.id", "=", factureVo.getCompteComptableVo().getId());
            query += SearchUtil.addConstraint("o", "compteComptable.numero", "=", factureVo.getCompteComptableVo().getNumero());
        }

        if (factureVo.getDeclarationIsVo() != null) {
            query += SearchUtil.addConstraint("o", "declarationIs.id", "=", factureVo.getDeclarationIsVo().getId());
            query += SearchUtil.addConstraint("o", "declarationIs.reference", "LIKE", factureVo.getDeclarationIsVo().getReference());
        }

        if (factureVo.getDeclarationTvaVo() != null) {
            query += SearchUtil.addConstraint("o", "declarationTva.id", "=", factureVo.getDeclarationTvaVo().getId());
            query += SearchUtil.addConstraint("o", "declarationTva.reference", "LIKE", factureVo.getDeclarationTvaVo().getReference());
        }

        if (factureVo.getDemandeVo() != null) {
            query += SearchUtil.addConstraint("o", "demande.id", "=", factureVo.getDemandeVo().getId());
            query += SearchUtil.addConstraint("o", "demande.reference", "LIKE", factureVo.getDemandeVo().getReference());
        }

        if (factureVo.getClasseComptableVo() != null) {
            query += SearchUtil.addConstraint("o", "classeComptable.id", "=", factureVo.getClasseComptableVo().getId());
        }

        if (factureVo.getCpcFactureVo() != null) {
            query += SearchUtil.addConstraint("o", "cpcFacture.id", "=", factureVo.getCpcFactureVo().getId());
        }

        query += " ORDER BY o.dateOperation";
        return entityManager.createQuery(query).getResultList();
    }

    private void findTva(Facture facture) {
        Tva loadedTva = tvaService.findByIdOrReference(facture.getTva());

        if (loadedTva == null) {
            return;
        }
        facture.setTva(loadedTva);
    }

    private void findTypeOperationFacture(Facture facture) {
        TypeOperationFacture loadedTypeOperationFacture = null;
        if (facture.getTypeOperationFacture() != null && facture.getTypeOperationFacture().getId() != null)
            loadedTypeOperationFacture = typeOperationFactureService.findById(facture.getTypeOperationFacture().getId());

        if (loadedTypeOperationFacture == null) {
            return;
        }
        facture.setTypeOperationFacture(loadedTypeOperationFacture);
    }

    private void findEtatFacture(Facture facture) {
        EtatFacture loadedEtatFacture = null;
        if (facture.getEtatFacture() != null && facture.getEtatFacture().getId() != null)
            loadedEtatFacture = etatFactureService.findById(facture.getEtatFacture().getId());

        if (loadedEtatFacture == null) {
            return;
        }
        facture.setEtatFacture(loadedEtatFacture);
    }

    private void findEtatPaiement(Facture facture) {
        EtatPaiement loadedEtatPaiement = null;
        if (facture.getEtatPaiement() != null && facture.getEtatPaiement().getId() != null)
            loadedEtatPaiement = etatPaiementService.findById(facture.getEtatPaiement().getId());

        if (loadedEtatPaiement == null) {
            return;
        }
        facture.setEtatPaiement(loadedEtatPaiement);
    }

    private void findSociete(Facture facture) {
        Societe loadedSociete = null;
        if (facture.getSociete() != null && facture.getSociete().getId() != null)
            loadedSociete = societeService.findById(facture.getSociete().getId());

        if (loadedSociete == null) {
            return;
        }
        facture.setSociete(loadedSociete);
    }

    private void findCompteComptable(Facture facture) {
        CompteComptable loadedCompteComptable = compteComptableService.findByIdOrNumero(facture.getCompteComptable());

        if (loadedCompteComptable == null) {
            return;
        }
        facture.setCompteComptable(loadedCompteComptable);
    }

    private void findDeclarationIs(Facture facture) {
        DeclarationIs loadedDeclarationIs = declarationIsService.findByIdOrReference(facture.getDeclarationIs());

        if (loadedDeclarationIs == null) {
            return;
        }
        facture.setDeclarationIs(loadedDeclarationIs);
    }

    private void findDeclarationTva(Facture facture) {
        DeclarationTva loadedDeclarationTva = declarationTvaService.findByIdOrReference(facture.getDeclarationTva());

        if (loadedDeclarationTva == null) {
            return;
        }
        facture.setDeclarationTva(loadedDeclarationTva);
    }

    private void findDemande(Facture facture) {
        Demande loadedDemande = demandeService.findByIdOrReference(facture.getDemande());

        if (loadedDemande == null) {
            return;
        }
        facture.setDemande(loadedDemande);
    }

    private void findClasseComptable(Facture facture) {
        ClasseComptable loadedClasseComptable = null;
        if (facture.getClasseComptable() != null && facture.getClasseComptable().getId() != null)
            loadedClasseComptable = classeComptableService.findById(facture.getClasseComptable().getId());

        if (loadedClasseComptable == null) {
            return;
        }
        facture.setClasseComptable(loadedClasseComptable);
    }

    private void findCpcFacture(Facture facture) {
        CpcFacture loadedCpcFacture = null;
        if (facture.getCpcFacture() != null && facture.getCpcFacture().getId() != null)
            loadedCpcFacture = cpcFactureService.findById(facture.getCpcFacture().getId());

        if (loadedCpcFacture == null) {
            return;
        }
        facture.setCpcFacture(loadedCpcFacture);
    }

    @Override
    @Transactional
    public void delete(List<Facture> factures) {
        if (ListUtil.isNotEmpty(factures)) {
            factures.forEach(e -> factureDao.delete(e));
        }
    }

    @Override
    public void update(List<Facture> factures) {
        if (ListUtil.isNotEmpty(factures)) {
            factures.forEach(e -> factureDao.save(e));
        }
    }


}
