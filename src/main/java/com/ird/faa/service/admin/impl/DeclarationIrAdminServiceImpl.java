package com.ird.faa.service.admin.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

import java.util.ArrayList;

import com.ird.faa.bean.*;
import com.ird.faa.ws.rest.provided.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import com.ird.faa.dao.DeclarationIrDao;
import com.ird.faa.service.admin.facade.DeclarationIrAdminService;
import com.ird.faa.service.admin.facade.SocieteAdminService;
import com.ird.faa.service.admin.facade.PaiementDeclarationIrAdminService;
import com.ird.faa.service.admin.facade.EtatDeclarationIrAdminService;
import com.ird.faa.service.admin.facade.DeclarationIrEmployeAdminService;
import com.ird.faa.service.admin.facade.PrelevementSocialEmployeAdminService;

import com.ird.faa.service.util.*;

import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DeclarationIrAdminServiceImpl extends AbstractServiceImpl<DeclarationIr> implements DeclarationIrAdminService {

    @Autowired
    private DeclarationIrDao declarationIrDao;
    @Autowired
    private ArchivableService<DeclarationIr> archivableService;
    @Autowired
    private SocieteAdminService societeService;
    @Autowired
    private PaiementDeclarationIrAdminService paiementDeclarationIrService;
    @Autowired
    private EtatDeclarationIrAdminService etatDeclarationIrService;
    @Autowired
    private DeclarationIrEmployeAdminService declarationIrEmployeService;
    @Autowired
    private PrelevementSocialEmployeAdminService prelevementSocialEmployeService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<DeclarationIr> findAll() {
        return declarationIrDao.findAll();
    }

    @Override
    public List<DeclarationIr> findBySocieteId(Long id) {
        return declarationIrDao.findBySocieteId(id);
    }

    @Override
    @Transactional
    public int deleteBySocieteId(Long id) {
        return declarationIrDao.deleteBySocieteId(id);
    }


    @Override
    public List<DeclarationIr> findByEtatDeclarationIrReference(String reference) {
        if(reference==null) return null;
        List<DeclarationIr> declarationIrLists= declarationIrDao.findByEtatDeclarationIrReference(reference);
        System.out.println("this is -->"+declarationIrLists.size());
        return declarationIrLists;
    }

    @Override
    @Transactional
    public int deleteByEtatDeclarationIrReference(String reference) {
        return declarationIrDao.deleteByEtatDeclarationIrReference(reference);
    }

    @Override
    public List<DeclarationIr> findByEtatDeclarationIrId(Long id) {
        return declarationIrDao.findByEtatDeclarationIrId(id);
    }

    @Override
    @Transactional
    public int deleteByEtatDeclarationIrId(Long id) {
        return declarationIrDao.deleteByEtatDeclarationIrId(id);
    }


    @Override
    public List<DeclarationIr> findByPaiementDeclarationIrReference(String reference) {
        return declarationIrDao.findByPaiementDeclarationIrReference(reference);
    }

    @Override
    @Transactional
    public int deleteByPaiementDeclarationIrReference(String reference) {
        return declarationIrDao.deleteByPaiementDeclarationIrReference(reference);
    }

    @Override
    public List<DeclarationIr> findByPaiementDeclarationIrId(Long id) {
        return declarationIrDao.findByPaiementDeclarationIrId(id);
    }

    @Override
    @Transactional
    public int deleteByPaiementDeclarationIrId(Long id) {
        return declarationIrDao.deleteByPaiementDeclarationIrId(id);
    }

    @Override
    public DeclarationIr findByRefrerence(String refrerence) {
        if (refrerence == null) return null;
        return declarationIrDao.findByRefrerence(refrerence);
    }

    @Override
    @Transactional
    public int deleteByRefrerence(String refrerence) {
        return declarationIrDao.deleteByRefrerence(refrerence);
    }

    @Override
    public DeclarationIr findByIdOrRefrerence(DeclarationIr declarationIr) {
        DeclarationIr resultat = null;
        if (declarationIr != null) {
            if (StringUtil.isNotEmpty(declarationIr.getId())) {
                resultat = declarationIrDao.getOne(declarationIr.getId());
            } else if (StringUtil.isNotEmpty(declarationIr.getRefrerence())) {
                resultat = declarationIrDao.findByRefrerence(declarationIr.getRefrerence());
            }
        }
        return resultat;
    }

    @Override
    public DeclarationIr findById(Long id) {
        if (id == null) return null;
        return declarationIrDao.getOne(id);
    }

    @Override
    public DeclarationIr findByIdWithAssociatedList(Long id) {
        DeclarationIr declarationIr = findById(id);
        findAssociatedLists(declarationIr);
        return declarationIr;
    }

    @Override
    public DeclarationIr archiver(DeclarationIr declarationIr) {
        if (declarationIr.getArchive() == null) {
            declarationIr.setArchive(false);
        }
        declarationIr.setArchive(true);
        declarationIr.setDateArchivage(new Date());
        declarationIrDao.save(declarationIr);
        return declarationIr;

    }

    @Override
    public DeclarationIr desarchiver(DeclarationIr declarationIr) {
        if (declarationIr.getArchive() == null) {
            declarationIr.setArchive(false);
        }
        declarationIr.setArchive(false);
        declarationIr.setDateArchivage(null);
        declarationIrDao.save(declarationIr);
        return declarationIr;
    }

    private void findAssociatedLists(DeclarationIr declarationIr) {
        if (declarationIr != null && declarationIr.getId() != null) {
            List<DeclarationIrEmploye> declarationIrEmployes = declarationIrEmployeService.findByDeclarationIrId(declarationIr.getId());
            declarationIr.setDeclarationIrEmployes(declarationIrEmployes);
            List<PrelevementSocialEmploye> prelevementSocialEmployes = prelevementSocialEmployeService.findByDeclarationIrId(declarationIr.getId());
            declarationIr.setPrelevementSocialEmployes(prelevementSocialEmployes);
        }
    }

    private void deleteAssociatedLists(Long id) {
        if (id != null) {
            declarationIrEmployeService.deleteByDeclarationIrId(id);
            prelevementSocialEmployeService.deleteByDeclarationIrId(id);
        }
    }

    private void updateAssociatedLists(DeclarationIr declarationIr) {
        if (declarationIr != null && declarationIr.getId() != null) {
            List
                    <List<DeclarationIrEmploye>> resultDeclarationIrEmployes = declarationIrEmployeService.getToBeSavedAndToBeDeleted(declarationIrEmployeService.findByDeclarationIrId(declarationIr.getId()), declarationIr.getDeclarationIrEmployes());
            declarationIrEmployeService.delete(resultDeclarationIrEmployes.get(1));
            associateDeclarationIrEmploye(declarationIr, resultDeclarationIrEmployes.get(0));
            declarationIrEmployeService.update(resultDeclarationIrEmployes.get(0));

            List
                    <List<PrelevementSocialEmploye>> resultPrelevementSocialEmployes = prelevementSocialEmployeService.getToBeSavedAndToBeDeleted(prelevementSocialEmployeService.findByDeclarationIrId(declarationIr.getId()), declarationIr.getPrelevementSocialEmployes());
            prelevementSocialEmployeService.delete(resultPrelevementSocialEmployes.get(1));
            associatePrelevementSocialEmploye(declarationIr, resultPrelevementSocialEmployes.get(0));
            prelevementSocialEmployeService.update(resultPrelevementSocialEmployes.get(0));

        }
    }

    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (declarationIrDao.findById(id).isPresent()) {
            deleteAssociatedLists(id);
            declarationIrDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public DeclarationIr update(DeclarationIr declarationIr) {
        DeclarationIr foundedDeclarationIr = findById(declarationIr.getId());
        if (foundedDeclarationIr == null) return null;
        else {
            archivableService.prepare(declarationIr);
            updateAssociatedLists(declarationIr);
            return declarationIrDao.save(declarationIr);
        }
    }

    private void prepareSave(DeclarationIr declarationIr) {
        declarationIr.setDateCreation(new Date());
        if (declarationIr.getArchive() == null)
            declarationIr.setArchive(false);
        if (declarationIr.getAdmin() == null)
            declarationIr.setAdmin(false);
        if (declarationIr.getVisible() == null)
            declarationIr.setVisible(false);


    }

    @Override
    public DeclarationIr save(DeclarationIr declarationIr) {
        prepareSave(declarationIr);

        DeclarationIr result = null;
        DeclarationIr foundedDeclarationIr = findByRefrerence(declarationIr.getRefrerence());
        if (foundedDeclarationIr == null) {


            findSociete(declarationIr);
            findEtatDeclarationIr(declarationIr);
            findPaiementDeclarationIr(declarationIr);

            DeclarationIr savedDeclarationIr = declarationIrDao.save(declarationIr);

            saveDeclarationIrEmployes(savedDeclarationIr, declarationIr.getDeclarationIrEmployes());
            savePrelevementSocialEmployes(savedDeclarationIr, declarationIr.getPrelevementSocialEmployes());
            result = savedDeclarationIr;
        }

        return result;
    }

    @Override
    public List<DeclarationIr> save(List<DeclarationIr> declarationIrs) {
        List<DeclarationIr> list = new ArrayList<>();
        for (DeclarationIr declarationIr : declarationIrs) {
            list.add(save(declarationIr));
        }
        return list;
    }

    private List<DeclarationIrEmploye> prepareDeclarationIrEmployes(DeclarationIr declarationIr, List<DeclarationIrEmploye> declarationIrEmployes) {
        for (DeclarationIrEmploye declarationIrEmploye : declarationIrEmployes) {
            declarationIrEmploye.setDeclarationIr(declarationIr);
        }
        return declarationIrEmployes;
    }

    private List<PrelevementSocialEmploye> preparePrelevementSocialEmployes(DeclarationIr declarationIr, List<PrelevementSocialEmploye> prelevementSocialEmployes) {
        for (PrelevementSocialEmploye prelevementSocialEmploye : prelevementSocialEmployes) {
            prelevementSocialEmploye.setDeclarationIr(declarationIr);
        }
        return prelevementSocialEmployes;
    }


    @Override
    @Transactional
    public int delete(DeclarationIr declarationIr) {
        if (declarationIr.getRefrerence() == null) return -1;

        DeclarationIr foundedDeclarationIr = findByRefrerence(declarationIr.getRefrerence());
        if (foundedDeclarationIr == null) return -1;
        declarationIrDao.delete(foundedDeclarationIr);
        return 1;
    }

    public void setTotalPaye(DeclarationIr declarationIr) {
        BigDecimal valeur1 = BigDecimal.ZERO;
        BigDecimal valeur2 = BigDecimal.ZERO;
        BigDecimal valeur3 = BigDecimal.ZERO;
        List<DeclarationIrEmploye> declarationIrEmployes = declarationIr.getDeclarationIrEmployes();
        for (DeclarationIrEmploye declarationIrEmploye : declarationIrEmployes) {
            valeur1 = valeur1.add(declarationIrEmploye.getSalaireBase());
            valeur2 = valeur2.add(declarationIrEmploye.getCotisation());
            valeur3 = valeur3.add(declarationIrEmploye.getSalaireNet());

        }
        declarationIr.setTotalSalaireBrut(valeur1);
        declarationIr.setMontantIrAPaye(valeur2);
        declarationIr.setTotalSalaireNet(valeur3);

    }

    @Override
    public int declarationIrToXML(DeclarationIr declarationIr) {
        DeclarationIrXml decXml = convertToDecIrXml(declarationIr);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DeclarationIrXml.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File fileDecIs = new File("C:\\Users\\admin\\Desktop\\DecIR_XML\\DecIR-" + declarationIr.getAnnee() +declarationIr.getMois()+ declarationIr.getRefrerence() + ".xml");
            marshaller.marshal(decXml, fileDecIs);
//            marshaller.marshal(decXml, System.out);

        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return 1;
    }

    public DeclarationIrXml convertToDecIrXml(DeclarationIr declarationIr) {
        DeclarationIr declarationIr1 = declarationIrDao.findByRefrerence(declarationIr.getRefrerence());
        DeclarationIrXml decIrXml = new DeclarationIrXml();
        List<DeclarationIrEmploye> declarationIrEmployes = new ArrayList<DeclarationIrEmploye>();
        List<DeclarationIrEmployeXml> declarationIrEmployeXmls = new ArrayList<DeclarationIrEmployeXml>();
        SocieteXml societeXml = new SocieteXml();
        DeclarationIrEmployeXml declarationIrEmployeXmlVo = new DeclarationIrEmployeXml();
        decIrXml.setId(declarationIr.getId());
        decIrXml.setRefrerence(declarationIr.getRefrerence());
        decIrXml.setAnnee(declarationIr.getAnnee());
        decIrXml.setMois(declarationIr.getMois());
        decIrXml.setMontantIrCalcule(declarationIr.getMontantIrCalcule());
        decIrXml.setMontantIrAPaye(declarationIr.getMontantIrAPaye());
        decIrXml.setTotalAPaye(declarationIr.getTotalAPaye());
        decIrXml.setTotalSalaireNet(declarationIr.getTotalSalaireNet());
        decIrXml.setTotalSalaireBrut(declarationIr.getTotalSalaireBrut());
        declarationIrEmployes = declarationIrEmployeService.findByDeclarationIrRefrerence(declarationIr1.getRefrerence());
        for (DeclarationIrEmploye dr : declarationIrEmployes) {
            declarationIrEmployeXmls.add(declarationIrEmployeXmlVo.convertToDeclartionEmlpXml(dr));
        }
        decIrXml.setDeclarationIrEmployes(declarationIrEmployeXmls);
        societeXml = societeXml.convertToSteXml(declarationIr1.getSociete());
        decIrXml.setSocieteXml(societeXml);
        return decIrXml;
    }


    public List<BigDecimal> findStatByDateDeclarationAndDemande(Date dateMin, Date dateMax, Demande demande) {
        String query = "SELECT SUM(d.totalAPaye) FROM DeclarationIr d WHERE 1=1";
        query += SearchUtil.addConstraintMinMaxDate("d", "totalAPaye", dateMin, dateMax);
        if (demande.getReference() != null) {
            query += SearchUtil.addConstraint("o", "demande.reference", "LIKE", demande.getReference());
        }
        return entityManager.createQuery(query).getResultList();

    }

    public List<com.ird.faa.ws.rest.provided.vo.DeclarationirStatVo> findStatByDateDeclarationAndEtatDeclaration(String dateMin,String dateMax) {
        String query = "SELECT NEW com.ird.faa.ws.rest.provided.vo.DeclarationirStatVo(d.etatDeclarationIr,SUM(d.totalSalaireBrut)) FROM DeclarationIr d WHERE 1=1";
        query += SearchUtil.addConstraintMinMaxDate("d", "dateCreation", dateMin, dateMax);
        query += " GROUP BY d.etatDeclarationIr";
        return entityManager.createQuery(query).getResultList();

    }


    public List<DeclarationIr> findByCriteria(DeclarationIrVo declarationIrVo) {

        String query = "SELECT o FROM DeclarationIr o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", declarationIrVo.getId());
        query += SearchUtil.addConstraint("o", "refrerence", "LIKE", declarationIrVo.getRefrerence());
        query += SearchUtil.addConstraint("o", "annee", "=", declarationIrVo.getAnnee());
        query += SearchUtil.addConstraint("o", "mois", "=", declarationIrVo.getMois());
        query += SearchUtil.addConstraint("o", "montantIrCalcule", "=", declarationIrVo.getMontantIrCalcule());
        query += SearchUtil.addConstraint("o", "montantIrAPaye", "=", declarationIrVo.getMontantIrAPaye());
        query += SearchUtil.addConstraint("o", "totalAPaye", "=", declarationIrVo.getTotalAPaye());
        query += SearchUtil.addConstraint("o", "totalSalaireNet", "=", declarationIrVo.getTotalSalaireNet());
        query += SearchUtil.addConstraint("o", "totalSalaireBrut", "=", declarationIrVo.getTotalSalaireBrut());
        query += SearchUtil.addConstraint("o", "archive", "=", declarationIrVo.getArchive());
        query += SearchUtil.addConstraintDate("o", "dateArchivage", "=", declarationIrVo.getDateArchivage());
        query += SearchUtil.addConstraintDate("o", "dateCreation", "=", declarationIrVo.getDateCreation());
        query += SearchUtil.addConstraint("o", "admin", "=", declarationIrVo.getAdmin());
        query += SearchUtil.addConstraint("o", "visible", "=", declarationIrVo.getVisible());
        query += SearchUtil.addConstraint("o", "username", "LIKE", declarationIrVo.getUsername());
        query += SearchUtil.addConstraintMinMax("o", "annee", declarationIrVo.getAnneeMin(), declarationIrVo.getAnneeMax());
        query += SearchUtil.addConstraintMinMax("o", "mois", declarationIrVo.getMoisMin(), declarationIrVo.getMoisMax());
        query += SearchUtil.addConstraintMinMax("o", "montantIrCalcule", declarationIrVo.getMontantIrCalculeMin(), declarationIrVo.getMontantIrCalculeMax());
        query += SearchUtil.addConstraintMinMax("o", "montantIrAPaye", declarationIrVo.getMontantIrAPayeMin(), declarationIrVo.getMontantIrAPayeMax());
        query += SearchUtil.addConstraintMinMax("o", "totalAPaye", declarationIrVo.getTotalAPayeMin(), declarationIrVo.getTotalAPayeMax());
        query += SearchUtil.addConstraintMinMax("o", "totalSalaireNet", declarationIrVo.getTotalSalaireNetMin(), declarationIrVo.getTotalSalaireNetMax());
        query += SearchUtil.addConstraintMinMax("o", "totalSalaireBrut", declarationIrVo.getTotalSalaireBrutMin(), declarationIrVo.getTotalSalaireBrutMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateArchivage", declarationIrVo.getDateArchivageMin(), declarationIrVo.getDateArchivageMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", declarationIrVo.getDateCreationMin(), declarationIrVo.getDateCreationMax());
        if (declarationIrVo.getSocieteVo() != null) {
            query += SearchUtil.addConstraint("o", "societe.id", "=", declarationIrVo.getSocieteVo().getId());
        }

        if (declarationIrVo.getEtatDeclarationIrVo() != null) {
            query += SearchUtil.addConstraint("o", "etatDeclarationIr.id", "=", declarationIrVo.getEtatDeclarationIrVo().getId());
            query += SearchUtil.addConstraint("o", "etatDeclarationIr.reference", "LIKE", declarationIrVo.getEtatDeclarationIrVo().getReference());
        }

        if (declarationIrVo.getPaiementDeclarationIrVo() != null) {
            query += SearchUtil.addConstraint("o", "paiementDeclarationIr.id", "=", declarationIrVo.getPaiementDeclarationIrVo().getId());
            query += SearchUtil.addConstraint("o", "paiementDeclarationIr.reference", "LIKE", declarationIrVo.getPaiementDeclarationIrVo().getReference());
        }

        return entityManager.createQuery(query).getResultList();
    }

    private void saveDeclarationIrEmployes(DeclarationIr declarationIr, List<DeclarationIrEmploye> declarationIrEmployes) {

        if (ListUtil.isNotEmpty(declarationIr.getDeclarationIrEmployes())) {
            List<DeclarationIrEmploye> savedDeclarationIrEmployes = new ArrayList<>();
            declarationIrEmployes.forEach(element -> {
                element.setDeclarationIr(declarationIr);
                declarationIrEmployeService.save(element);
            });
            declarationIr.setDeclarationIrEmployes(savedDeclarationIrEmployes);
        }
    }

    private void savePrelevementSocialEmployes(DeclarationIr declarationIr, List<PrelevementSocialEmploye> prelevementSocialEmployes) {

        if (ListUtil.isNotEmpty(declarationIr.getPrelevementSocialEmployes())) {
            List<PrelevementSocialEmploye> savedPrelevementSocialEmployes = new ArrayList<>();
            prelevementSocialEmployes.forEach(element -> {
                element.setDeclarationIr(declarationIr);
                prelevementSocialEmployeService.save(element);
            });
            declarationIr.setPrelevementSocialEmployes(savedPrelevementSocialEmployes);
        }
    }

    private void findSociete(DeclarationIr declarationIr) {
        Societe loadedSociete = null;
        if (declarationIr.getSociete() != null && declarationIr.getSociete().getId() != null)
            loadedSociete = societeService.findById(declarationIr.getSociete().getId());

        if (loadedSociete == null) {
            return;
        }
        declarationIr.setSociete(loadedSociete);
    }

    private void findEtatDeclarationIr(DeclarationIr declarationIr) {
        EtatDeclarationIr loadedEtatDeclarationIr = etatDeclarationIrService.findByIdOrReference(declarationIr.getEtatDeclarationIr());

        if (loadedEtatDeclarationIr == null) {
            return;
        }
        declarationIr.setEtatDeclarationIr(loadedEtatDeclarationIr);
    }

    private void findPaiementDeclarationIr(DeclarationIr declarationIr) {
        PaiementDeclarationIr loadedPaiementDeclarationIr = paiementDeclarationIrService.findByIdOrReference(declarationIr.getPaiementDeclarationIr());

        if (loadedPaiementDeclarationIr == null) {
            return;
        }
        declarationIr.setPaiementDeclarationIr(loadedPaiementDeclarationIr);
    }

    @Override
    @Transactional
    public void delete(List<DeclarationIr> declarationIrs) {
        if (ListUtil.isNotEmpty(declarationIrs)) {
            declarationIrs.forEach(e -> declarationIrDao.delete(e));
        }
    }

    @Override
    public void update(List<DeclarationIr> declarationIrs) {
        if (ListUtil.isNotEmpty(declarationIrs)) {
            declarationIrs.forEach(e -> declarationIrDao.save(e));
        }
    }

    private void associateDeclarationIrEmploye(DeclarationIr declarationIr, List<DeclarationIrEmploye> declarationIrEmploye) {
        if (ListUtil.isNotEmpty(declarationIrEmploye)) {
            declarationIrEmploye.forEach(e -> e.setDeclarationIr(declarationIr));
        }
    }

    private void associatePrelevementSocialEmploye(DeclarationIr declarationIr, List<PrelevementSocialEmploye> prelevementSocialEmploye) {
        if (ListUtil.isNotEmpty(prelevementSocialEmploye)) {
            prelevementSocialEmploye.forEach(e -> e.setDeclarationIr(declarationIr));
        }
    }


}
