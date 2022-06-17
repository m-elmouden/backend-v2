package com.ird.faa.service.societe.impl;

import com.ird.faa.bean.EtatDeclarationIr;
import com.ird.faa.dao.EtatDeclarationIrDao;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.societe.facade.EtatDeclarationIrSocieteService;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.EtatDeclarationIrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EtatDeclarationIrSocieteServiceImpl extends AbstractServiceImpl<EtatDeclarationIr> implements EtatDeclarationIrSocieteService {

    @Autowired
    private EtatDeclarationIrDao etatDeclarationIrDao;

    @Autowired
    private ArchivableService<EtatDeclarationIr> archivableService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<EtatDeclarationIr> findAll() {
        return etatDeclarationIrDao.findAll();
    }

    @Override
    public EtatDeclarationIr findByReference(String reference) {
        if (reference == null) return null;
        return etatDeclarationIrDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return etatDeclarationIrDao.deleteByReference(reference);
    }

    @Override
    public EtatDeclarationIr findByIdOrReference(EtatDeclarationIr etatDeclarationIr) {
        EtatDeclarationIr resultat = null;
        if (etatDeclarationIr != null) {
            if (StringUtil.isNotEmpty(etatDeclarationIr.getId())) {
                resultat = etatDeclarationIrDao.getOne(etatDeclarationIr.getId());
            } else if (StringUtil.isNotEmpty(etatDeclarationIr.getReference())) {
                resultat = etatDeclarationIrDao.findByReference(etatDeclarationIr.getReference());
            }
        }
        return resultat;
    }

    @Override
    public EtatDeclarationIr findById(Long id) {
        if (id == null) return null;
        return etatDeclarationIrDao.getOne(id);
    }

    @Override
    public EtatDeclarationIr findByIdWithAssociatedList(Long id) {
        return findById(id);
    }

    @Override
    public EtatDeclarationIr archiver(EtatDeclarationIr etatDeclarationIr) {
        if (etatDeclarationIr.getArchive() == null) {
            etatDeclarationIr.setArchive(false);
        }
        etatDeclarationIr.setArchive(true);
        etatDeclarationIr.setDateArchivage(new Date());
        etatDeclarationIrDao.save(etatDeclarationIr);
        return etatDeclarationIr;

    }

    @Override
    public EtatDeclarationIr desarchiver(EtatDeclarationIr etatDeclarationIr) {
        if (etatDeclarationIr.getArchive() == null) {
            etatDeclarationIr.setArchive(false);
        }
        etatDeclarationIr.setArchive(false);
        etatDeclarationIr.setDateArchivage(null);
        etatDeclarationIrDao.save(etatDeclarationIr);
        return etatDeclarationIr;
    }


    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (etatDeclarationIrDao.findById(id).isPresent()) {
            etatDeclarationIrDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public EtatDeclarationIr update(EtatDeclarationIr etatDeclarationIr) {
        EtatDeclarationIr foundedEtatDeclarationIr = findById(etatDeclarationIr.getId());
        if (foundedEtatDeclarationIr == null) return null;
        else {
            archivableService.prepare(etatDeclarationIr);
            return etatDeclarationIrDao.save(etatDeclarationIr);
        }
    }

    private void prepareSave(EtatDeclarationIr etatDeclarationIr) {
        etatDeclarationIr.setDateCreation(new Date());
        if (etatDeclarationIr.getArchive() == null)
            etatDeclarationIr.setArchive(false);
        if (etatDeclarationIr.getAdmin() == null)
            etatDeclarationIr.setAdmin(false);
        if (etatDeclarationIr.getVisible() == null)
            etatDeclarationIr.setVisible(false);


    }

    @Override
    public EtatDeclarationIr save(EtatDeclarationIr etatDeclarationIr) {
        prepareSave(etatDeclarationIr);

        EtatDeclarationIr result = null;
        EtatDeclarationIr foundedEtatDeclarationIr = findByReference(etatDeclarationIr.getReference());
        if (foundedEtatDeclarationIr == null) {


            EtatDeclarationIr savedEtatDeclarationIr = etatDeclarationIrDao.save(etatDeclarationIr);

            result = savedEtatDeclarationIr;
        }

        return result;
    }

    @Override
    public List<EtatDeclarationIr> save(List<EtatDeclarationIr> etatDeclarationIrs) {
        List<EtatDeclarationIr> list = new ArrayList<>();
        for (EtatDeclarationIr etatDeclarationIr : etatDeclarationIrs) {
            list.add(save(etatDeclarationIr));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(EtatDeclarationIr etatDeclarationIr) {
        if (etatDeclarationIr.getReference() == null) return -1;

        EtatDeclarationIr foundedEtatDeclarationIr = findByReference(etatDeclarationIr.getReference());
        if (foundedEtatDeclarationIr == null) return -1;
        etatDeclarationIrDao.delete(foundedEtatDeclarationIr);
        return 1;
    }


    public List<EtatDeclarationIr> findByCriteria(EtatDeclarationIrVo etatDeclarationIrVo) {

        String query = "SELECT o FROM EtatDeclarationIr o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", etatDeclarationIrVo.getId());
        query += SearchUtil.addConstraint("o", "reference", "LIKE", etatDeclarationIrVo.getReference());
        query += SearchUtil.addConstraint("o", "libelle", "LIKE", etatDeclarationIrVo.getLibelle());
        query += SearchUtil.addConstraint("o", "archive", "=", etatDeclarationIrVo.getArchive());
        query += SearchUtil.addConstraintDate("o", "dateArchivage", "=", etatDeclarationIrVo.getDateArchivage());
        query += SearchUtil.addConstraintDate("o", "dateCreation", "=", etatDeclarationIrVo.getDateCreation());
        query += SearchUtil.addConstraint("o", "admin", "=", etatDeclarationIrVo.getAdmin());
        query += SearchUtil.addConstraint("o", "visible", "=", etatDeclarationIrVo.getVisible());
        query += SearchUtil.addConstraint("o", "username", "LIKE", etatDeclarationIrVo.getUsername());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateArchivage", etatDeclarationIrVo.getDateArchivageMin(), etatDeclarationIrVo.getDateArchivageMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", etatDeclarationIrVo.getDateCreationMin(), etatDeclarationIrVo.getDateCreationMax());
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    @Transactional
    public void delete(List<EtatDeclarationIr> etatDeclarationIrs) {
        if (ListUtil.isNotEmpty(etatDeclarationIrs)) {
            etatDeclarationIrs.forEach(e -> etatDeclarationIrDao.delete(e));
        }
    }

    @Override
    public void update(List<EtatDeclarationIr> etatDeclarationIrs) {
        if (ListUtil.isNotEmpty(etatDeclarationIrs)) {
            etatDeclarationIrs.forEach(e -> etatDeclarationIrDao.save(e));
        }
    }


}
