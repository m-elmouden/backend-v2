package com.ird.faa.service.comptable.impl;

import com.ird.faa.bean.*;
import com.ird.faa.dao.SocieteDao;
import com.ird.faa.service.comptable.facade.*;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.upload.employe.model.Employe;
import com.ird.faa.ws.rest.provided.vo.SocieteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class SocieteComptableServiceImpl extends AbstractServiceImpl<Societe> implements SocieteComptableService {

    @Autowired
    private SocieteDao societeDao;

    @Autowired
    private TypeSocieteComptableService typeSocieteService;
    @Autowired
    private DeclarationTvaComptableService declarationTvaService;
    @Autowired
    private AcompteComptableService acompteService;
    @Autowired
    private PresidentSocieteComptableService presidentSocieteService;
    @Autowired
    private DemandeComptableService demandeService;
    @Autowired
    private FactureComptableService factureService;
    @Autowired
    private DeclarationCnssComptableService declarationCnssService;
    @Autowired
    private DeclarationIsComptableService declarationIsService;
    @Autowired
    private DeclarationIrComptableService declarationIrService;
    @Autowired
    private EmployeComptableService employeService;
    @Autowired
    private ComptableComptableService comptableService;


    @Autowired
    private EntityManager entityManager;

    @Override
    public Societe findByUsername(String username) {
        return societeDao.findByUsername(username);
    }

    @Override
    public List<Societe> findAll() {
        String query = "SELECT o FROM Societe o where 1=1 ";
        query += " ORDER BY o.dateCreation";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Societe> findByComptableCode(String code) {
        return societeDao.findByComptableCode(code);
    }

    @Override
    @Transactional
    public int deleteByComptableCode(String code) {
        return societeDao.deleteByComptableCode(code);
    }

    @Override
    public List<Societe> findByComptableId(Long id) {
        return societeDao.findByComptableId(id);
    }

    @Override
    @Transactional
    public int deleteByComptableId(Long id) {
        return societeDao.deleteByComptableId(id);
    }

    @Override
    public List<Societe> findByPresidentSocieteId(Long id) {
        return societeDao.findByPresidentSocieteId(id);
    }

    @Override
    @Transactional
    public int deleteByPresidentSocieteId(Long id) {
        return societeDao.deleteByPresidentSocieteId(id);
    }


    @Override
    public List<Societe> findByTypeSocieteCode(String code) {
        return societeDao.findByTypeSocieteCode(code);
    }

    @Override
    @Transactional
    public int deleteByTypeSocieteCode(String code) {
        return societeDao.deleteByTypeSocieteCode(code);
    }

    @Override
    public List<Societe> findByTypeSocieteId(Long id) {
        return societeDao.findByTypeSocieteId(id);
    }

    @Override
    @Transactional
    public int deleteByTypeSocieteId(Long id) {
        return societeDao.deleteByTypeSocieteId(id);
    }


    @Override
    public Societe findById(Long id) {
        if (id == null) return null;
        return societeDao.getOne(id);
    }

    @Override
    public Societe findByIdWithAssociatedList(Long id) {
        Societe societe = findById(id);
        findAssociatedLists(societe);
        return societe;
    }

    private void findAssociatedLists(Societe societe) {
        if (societe != null && societe.getId() != null) {
            List<Demande> demandes = demandeService.findBySocieteId(societe.getId());
            societe.setDemandes(demandes);
            List<Acompte> acomptes = acompteService.findBySocieteId(societe.getId());
            societe.setAcomptes(acomptes);
            List<Employe> employes = employeService.findBySocieteId(societe.getId());
            societe.setEmployes(employes);
            List<Facture> factures = factureService.findBySocieteId(societe.getId());
            societe.setFactures(factures);
        }
    }

    private void deleteAssociatedLists(Long id) {
        if (id != null) {
            demandeService.deleteBySocieteId(id);
            declarationIrService.deleteBySocieteId(id);
            declarationIsService.deleteBySocieteId(id);
            declarationTvaService.deleteBySocieteId(id);
            declarationCnssService.deleteBySocieteId(id);
            acompteService.deleteBySocieteId(id);
            employeService.deleteBySocieteId(id);
            factureService.deleteBySocieteId(id);
        }
    }

    private void updateAssociatedLists(Societe societe) {
        if (societe != null && societe.getId() != null) {
            List
                    <List<Demande>> resultDemandes = demandeService.getToBeSavedAndToBeDeleted(demandeService.findBySocieteId(societe.getId()), societe.getDemandes());
            demandeService.delete(resultDemandes.get(1));
            associateDemande(societe, resultDemandes.get(0));
            demandeService.update(resultDemandes.get(0));


            List
                    <List<Acompte>> resultAcomptes = acompteService.getToBeSavedAndToBeDeleted(acompteService.findBySocieteId(societe.getId()), societe.getAcomptes());
            acompteService.delete(resultAcomptes.get(1));
            associateAcompte(societe, resultAcomptes.get(0));
            acompteService.update(resultAcomptes.get(0));

            List
                    <List<Employe>> resultEmployes = employeService.getToBeSavedAndToBeDeleted(employeService.findBySocieteId(societe.getId()), societe.getEmployes());
            employeService.delete(resultEmployes.get(1));
            associateEmploye(societe, resultEmployes.get(0));
            employeService.update(resultEmployes.get(0));

            List
                    <List<Facture>> resultFactures = factureService.getToBeSavedAndToBeDeleted(factureService.findBySocieteId(societe.getId()), societe.getFactures());
            factureService.delete(resultFactures.get(1));
            associateFacture(societe, resultFactures.get(0));
            factureService.update(resultFactures.get(0));

        }
    }

    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (societeDao.findById(id).isPresent()) {
            deleteAssociatedLists(id);
            societeDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public Societe update(Societe societe) {
        Societe foundedSociete = findById(societe.getId());
        if (foundedSociete == null) return null;
        else {
            updateAssociatedLists(societe);
            return societeDao.save(societe);
        }
    }

    private void prepareSave(Societe societe) {
        societe.setCredentialsNonExpired(false);
        societe.setEnabled(false);
        societe.setAccountNonExpired(false);
        societe.setAccountNonLocked(false);
        societe.setPasswordChanged(false);


    }

    @Override
    public Societe save(Societe societe) {
        prepareSave(societe);

        Societe result = null;


        findComptable(societe);
        findPresidentSociete(societe);
        findTypeSociete(societe);

        Societe savedSociete = societeDao.save(societe);

        saveDemandes(savedSociete, societe.getDemandes());
        saveAcomptes(savedSociete, societe.getAcomptes());
        saveEmployes(savedSociete, societe.getEmployes());
        saveFactures(savedSociete, societe.getFactures());
        result = savedSociete;

        return result;
    }

    @Override
    public List<Societe> save(List<Societe> societes) {
        List<Societe> list = new ArrayList<>();
        for (Societe societe : societes) {
            list.add(save(societe));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(Societe societe) {
        if (societe.getId() == null) return -1;
        Societe foundedSociete = findById(societe.getId());
        if (foundedSociete == null) return -1;
        societeDao.delete(foundedSociete);
        return 1;
    }


    public List<Societe> findByCriteria(SocieteVo societeVo) {

        String query = "SELECT o FROM Societe o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", societeVo.getId());
        query += SearchUtil.addConstraint("o", "ice", "LIKE", societeVo.getIce());
        query += SearchUtil.addConstraint("o", "adresse", "LIKE", societeVo.getAdresse());
        query += SearchUtil.addConstraint("o", "fax", "LIKE", societeVo.getFax());
        query += SearchUtil.addConstraint("o", "telephone", "=", societeVo.getTelephone());
        query += SearchUtil.addConstraint("o", "raisonSociale", "LIKE", societeVo.getRaisonSociale());
        query += SearchUtil.addConstraintDate("o", "dateCreation", "=", societeVo.getDateCreation());
        query += SearchUtil.addConstraint("o", "anneeExploitation", "=", societeVo.getAnneeExploitation());
        query += SearchUtil.addConstraint("o", "capitalSocial", "=", societeVo.getCapitalSocial());
        query += SearchUtil.addConstraint("o", "description", "LIKE", societeVo.getDescription());
        query += SearchUtil.addConstraint("o", "age", "=", societeVo.getAge());
        query += SearchUtil.addConstraint("o", "credentialsNonExpired", "=", societeVo.getCredentialsNonExpired());
        query += SearchUtil.addConstraint("o", "enabled", "=", societeVo.getEnabled());
        query += SearchUtil.addConstraint("o", "accountNonExpired", "=", societeVo.getAccountNonExpired());
        query += SearchUtil.addConstraint("o", "accountNonLocked", "=", societeVo.getAccountNonLocked());
        query += SearchUtil.addConstraint("o", "passwordChanged", "=", societeVo.getPasswordChanged());
        query += SearchUtil.addConstraintDate("o", "createdAt", "=", societeVo.getCreatedAt());
        query += SearchUtil.addConstraintDate("o", "updatedAt", "=", societeVo.getUpdatedAt());
        query += SearchUtil.addConstraint("o", "username", "LIKE", societeVo.getUsername());
        query += SearchUtil.addConstraint("o", "password", "LIKE", societeVo.getPassword());
        query += SearchUtil.addConstraint("o", "equivalenceAvecPanelErc", "LIKE", societeVo.getEquivalenceAvecPanelErc());
        query += SearchUtil.addConstraint("o", "baseHorizon", "LIKE", societeVo.getBaseHorizon());
        query += SearchUtil.addConstraint("o", "role", "LIKE", societeVo.getRole());
        query += SearchUtil.addConstraintMinMax("o", "telephone", societeVo.getTelephoneMin(), societeVo.getTelephoneMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", societeVo.getDateCreationMin(), societeVo.getDateCreationMax());
        query += SearchUtil.addConstraintMinMax("o", "anneeExploitation", societeVo.getAnneeExploitationMin(), societeVo.getAnneeExploitationMax());
        query += SearchUtil.addConstraintMinMax("o", "capitalSocial", societeVo.getCapitalSocialMin(), societeVo.getCapitalSocialMax());
        query += SearchUtil.addConstraintMinMax("o", "age", societeVo.getAgeMin(), societeVo.getAgeMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "createdAt", societeVo.getCreatedAtMin(), societeVo.getCreatedAtMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "updatedAt", societeVo.getUpdatedAtMin(), societeVo.getUpdatedAtMax());
        if (societeVo.getComptableVo() != null) {
            query += SearchUtil.addConstraint("o", "comptable.id", "=", societeVo.getComptableVo().getId());
            query += SearchUtil.addConstraint("o", "comptable.code", "LIKE", societeVo.getComptableVo().getCode());
        }

        if (societeVo.getPresidentSocieteVo() != null) {
            query += SearchUtil.addConstraint("o", "presidentSociete.id", "=", societeVo.getPresidentSocieteVo().getId());
        }

        if (societeVo.getTypeSocieteVo() != null) {
            query += SearchUtil.addConstraint("o", "typeSociete.id", "=", societeVo.getTypeSocieteVo().getId());
            query += SearchUtil.addConstraint("o", "typeSociete.code", "LIKE", societeVo.getTypeSocieteVo().getCode());
        }

        query += " ORDER BY o.dateCreation";
        return entityManager.createQuery(query).getResultList();
    }

    private void saveDemandes(Societe societe, List<Demande> demandes) {

        if (ListUtil.isNotEmpty(societe.getDemandes())) {
            List<Demande> savedDemandes = new ArrayList<>();
            demandes.forEach(element -> {
                element.setSociete(societe);
                demandeService.save(element);
            });
            societe.setDemandes(savedDemandes);
        }
    }


    private void saveAcomptes(Societe societe, List<Acompte> acomptes) {

        if (ListUtil.isNotEmpty(societe.getAcomptes())) {
            List<Acompte> savedAcomptes = new ArrayList<>();
            acomptes.forEach(element -> {
                element.setSociete(societe);
                acompteService.save(element);
            });
            societe.setAcomptes(savedAcomptes);
        }
    }

    private void saveEmployes(Societe societe, List<Employe> employes) {

        if (ListUtil.isNotEmpty(societe.getEmployes())) {
            List<Employe> savedEmployes = new ArrayList<>();
            employes.forEach(element -> {
                element.setSociete(societe);
                employeService.save(element);
            });
            societe.setEmployes(savedEmployes);
        }
    }

    private void saveFactures(Societe societe, List<Facture> factures) {

        if (ListUtil.isNotEmpty(societe.getFactures())) {
            List<Facture> savedFactures = new ArrayList<>();
            factures.forEach(element -> {
                element.setSociete(societe);
                factureService.save(element);
            });
            societe.setFactures(savedFactures);
        }
    }

    private void findComptable(Societe societe) {
        Comptable loadedComptable = comptableService.findByIdOrCode(societe.getComptable());

        if (loadedComptable == null) {
            return;
        }
        societe.setComptable(loadedComptable);
    }

    private void findPresidentSociete(Societe societe) {
        PresidentSociete loadedPresidentSociete = null;
        if (societe.getPresidentSociete() != null && societe.getPresidentSociete().getId() != null)
            loadedPresidentSociete = presidentSocieteService.findById(societe.getPresidentSociete().getId());

        if (loadedPresidentSociete == null) {
            return;
        }
        societe.setPresidentSociete(loadedPresidentSociete);
    }

    private void findTypeSociete(Societe societe) {
        TypeSociete loadedTypeSociete = typeSocieteService.findByIdOrCode(societe.getTypeSociete());

        if (loadedTypeSociete == null) {
            return;
        }
        societe.setTypeSociete(loadedTypeSociete);
    }

    @Override
    @Transactional
    public void delete(List<Societe> societes) {
        if (ListUtil.isNotEmpty(societes)) {
            societes.forEach(e -> societeDao.delete(e));
        }
    }

    @Override
    public void update(List<Societe> societes) {
        if (ListUtil.isNotEmpty(societes)) {
            societes.forEach(e -> societeDao.save(e));
        }
    }

    private void associateDemande(Societe societe, List<Demande> demande) {
        if (ListUtil.isNotEmpty(demande)) {
            demande.forEach(e -> e.setSociete(societe));
        }
    }

    private void associateDeclarationIr(Societe societe, List<DeclarationIr> declarationIr) {
        if (ListUtil.isNotEmpty(declarationIr)) {
            declarationIr.forEach(e -> e.setSociete(societe));
        }
    }


    private void associateAcompte(Societe societe, List<Acompte> acompte) {
        if (ListUtil.isNotEmpty(acompte)) {
            acompte.forEach(e -> e.setSociete(societe));
        }
    }

    private void associateEmploye(Societe societe, List<Employe> employe) {
        if (ListUtil.isNotEmpty(employe)) {
            employe.forEach(e -> e.setSociete(societe));
        }
    }

    private void associateFacture(Societe societe, List<Facture> facture) {
        if (ListUtil.isNotEmpty(facture)) {
            facture.forEach(e -> e.setSociete(societe));
        }
    }


}
