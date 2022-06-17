package com.ird.faa.service.admin.impl;

import com.ird.faa.bean.DeclarationIr;
import com.ird.faa.bean.PrelevementSocial;
import com.ird.faa.bean.PrelevementSocialEmploye;
import com.ird.faa.dao.PrelevementSocialEmployeDao;
import com.ird.faa.service.admin.facade.DeclarationIrAdminService;
import com.ird.faa.service.admin.facade.EmployeAdminService;
import com.ird.faa.service.admin.facade.PrelevementSocialAdminService;
import com.ird.faa.service.admin.facade.PrelevementSocialEmployeAdminService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.upload.employe.model.Employe;
import com.ird.faa.ws.rest.provided.vo.PrelevementSocialEmployeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrelevementSocialEmployeAdminServiceImpl extends AbstractServiceImpl<PrelevementSocialEmploye> implements PrelevementSocialEmployeAdminService {

    @Autowired
    private PrelevementSocialEmployeDao prelevementSocialEmployeDao;

    @Autowired
    private PrelevementSocialAdminService prelevementSocialService;
    @Autowired
    private EmployeAdminService employeService;
    @Autowired
    private DeclarationIrAdminService declarationIrService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<PrelevementSocialEmploye> findAll() {
        return prelevementSocialEmployeDao.findAll();
    }

    @Override
    public List<PrelevementSocialEmploye> findByPrelevementSocialId(Long id) {
        return prelevementSocialEmployeDao.findByPrelevementSocialId(id);
    }

    @Override
    @Transactional
    public int deleteByPrelevementSocialId(Long id) {
        return prelevementSocialEmployeDao.deleteByPrelevementSocialId(id);
    }


    @Override
    public List<PrelevementSocialEmploye> findByEmployeCin(String cin) {
        return prelevementSocialEmployeDao.findByEmployeCin(cin);
    }

    @Override
    @Transactional
    public int deleteByEmployeCin(String cin) {
        return prelevementSocialEmployeDao.deleteByEmployeCin(cin);
    }

    @Override
    public List<PrelevementSocialEmploye> findByEmployeId(Long id) {
        return prelevementSocialEmployeDao.findByEmployeId(id);
    }

    @Override
    public List<PrelevementSocialEmploye> findByEmployeCin(BigDecimal cin) {
        return null;
    }

    @Override
    @Transactional
    public int deleteByEmployeId(Long id) {
        return prelevementSocialEmployeDao.deleteByEmployeId(id);
    }


    @Override
    public List<PrelevementSocialEmploye> findByDeclarationIrRefrerence(String refrerence) {
        return prelevementSocialEmployeDao.findByDeclarationIrRefrerence(refrerence);
    }

    @Override
    @Transactional
    public int deleteByDeclarationIrRefrerence(String refrerence) {
        return prelevementSocialEmployeDao.deleteByDeclarationIrRefrerence(refrerence);
    }

    @Override
    public List<PrelevementSocialEmploye> findByDeclarationIrId(Long id) {
        return prelevementSocialEmployeDao.findByDeclarationIrId(id);
    }

    @Override
    @Transactional
    public int deleteByDeclarationIrId(Long id) {
        return prelevementSocialEmployeDao.deleteByDeclarationIrId(id);
    }


    @Override
    public BigDecimal calculDeduction(PrelevementSocialEmploye prelevementSocialEmploye) {
        BigDecimal valeur = BigDecimal.ZERO;
        prelevementSocialEmploye.setPrelevementSocial(prelevementSocialService.findByReference(prelevementSocialEmploye.getPrelevementSocial().getReference()));

        if (prelevementSocialEmploye.getPrelevementSocial().getLibelle().equalsIgnoreCase("cnss")) {
            if (prelevementSocialEmploye.getSalaireBrutImposable().compareTo(BigDecimal.valueOf(6000)) > 0) {
                valeur = prelevementSocialEmploye.getPrelevementSocial().getPourcentage().divide(BigDecimal.valueOf(100), 4, RoundingMode.DOWN).multiply(BigDecimal.valueOf(6000));

            } else {
                valeur = prelevementSocialEmploye.getPrelevementSocial().getPourcentage().divide(BigDecimal.valueOf(100), 4, RoundingMode.DOWN).multiply(prelevementSocialEmploye.getSalaireBrutImposable());
            }
        } else {
            valeur = prelevementSocialEmploye.getPrelevementSocial().getPourcentage().divide(BigDecimal.valueOf(100), 4, RoundingMode.DOWN).multiply(prelevementSocialEmploye.getSalaireBrutImposable());
        }
        return valeur;
    }


    @Override
    public PrelevementSocialEmploye findById(Long id) {
        if (id == null) return null;
        return prelevementSocialEmployeDao.getOne(id);
    }

    @Override
    public PrelevementSocialEmploye findByIdWithAssociatedList(Long id) {
        return findById(id);
    }


    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (prelevementSocialEmployeDao.findById(id).isPresent()) {
            prelevementSocialEmployeDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public PrelevementSocialEmploye update(PrelevementSocialEmploye prelevementSocialEmploye) {
        PrelevementSocialEmploye foundedPrelevementSocialEmploye = findById(prelevementSocialEmploye.getId());
        if (foundedPrelevementSocialEmploye == null) return null;
        else {
            prelevementSocialEmploye.setMontantCalculer(calculDeduction(prelevementSocialEmploye));
            return prelevementSocialEmployeDao.save(prelevementSocialEmploye);
        }
    }

    @Override
    public PrelevementSocialEmploye save(PrelevementSocialEmploye prelevementSocialEmploye) {


        findPrelevementSocial(prelevementSocialEmploye);
        findEmploye(prelevementSocialEmploye);
        findDeclarationIr(prelevementSocialEmploye);
        prelevementSocialEmploye.setMontantCalculer(calculDeduction(prelevementSocialEmploye));
        return prelevementSocialEmployeDao.save(prelevementSocialEmploye);


    }

    @Override
    public List<PrelevementSocialEmploye> save(List<PrelevementSocialEmploye> prelevementSocialEmployes) {
        List<PrelevementSocialEmploye> list = new ArrayList<>();
        for (PrelevementSocialEmploye prelevementSocialEmploye : prelevementSocialEmployes) {
            list.add(save(prelevementSocialEmploye));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(PrelevementSocialEmploye prelevementSocialEmploye) {
        if (prelevementSocialEmploye.getId() == null) return -1;
        PrelevementSocialEmploye foundedPrelevementSocialEmploye = findById(prelevementSocialEmploye.getId());
        if (foundedPrelevementSocialEmploye == null) return -1;
        prelevementSocialEmployeDao.delete(foundedPrelevementSocialEmploye);
        return 1;
    }


    public List<PrelevementSocialEmploye> findByCriteria(PrelevementSocialEmployeVo prelevementSocialEmployeVo) {

        String query = "SELECT o FROM PrelevementSocialEmploye o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", prelevementSocialEmployeVo.getId());
        query += SearchUtil.addConstraint("o", "salaireBrutImposable", "=", prelevementSocialEmployeVo.getSalaireBrutImposable());
        query += SearchUtil.addConstraint("o", "montantCalculer", "=", prelevementSocialEmployeVo.getMontantCalculer());
        query += SearchUtil.addConstraintMinMax("o", "salaireBrutImposable", prelevementSocialEmployeVo.getSalaireBrutImposableMin(), prelevementSocialEmployeVo.getSalaireBrutImposableMax());
        query += SearchUtil.addConstraintMinMax("o", "montantCalculer", prelevementSocialEmployeVo.getMontantCalculerMin(), prelevementSocialEmployeVo.getMontantCalculerMax());
        if (prelevementSocialEmployeVo.getPrelevementSocialVo() != null) {
            query += SearchUtil.addConstraint("o", "prelevementSocial.id", "=", prelevementSocialEmployeVo.getPrelevementSocialVo().getId());
        }

        if (prelevementSocialEmployeVo.getEmployeVo() != null) {
            query += SearchUtil.addConstraint("o", "employe.id", "=", prelevementSocialEmployeVo.getEmployeVo().getId());
            query += SearchUtil.addConstraint("o", "employe.cin", "LIKE", prelevementSocialEmployeVo.getEmployeVo().getCin());
        }

        if (prelevementSocialEmployeVo.getDeclarationIrVo() != null) {
            query += SearchUtil.addConstraint("o", "declarationIr.id", "=", prelevementSocialEmployeVo.getDeclarationIrVo().getId());
            query += SearchUtil.addConstraint("o", "declarationIr.refrerence", "LIKE", prelevementSocialEmployeVo.getDeclarationIrVo().getRefrerence());
        }

        return entityManager.createQuery(query).getResultList();
    }

    private void findPrelevementSocial(PrelevementSocialEmploye prelevementSocialEmploye) {
        PrelevementSocial loadedPrelevementSocial = null;
        if (prelevementSocialEmploye.getPrelevementSocial() != null && prelevementSocialEmploye.getPrelevementSocial().getId() != null)
            loadedPrelevementSocial = prelevementSocialService.findById(prelevementSocialEmploye.getPrelevementSocial().getId());

        if (loadedPrelevementSocial == null) {
            return;
        }
        prelevementSocialEmploye.setPrelevementSocial(loadedPrelevementSocial);
    }

    private void findEmploye(PrelevementSocialEmploye prelevementSocialEmploye) {
        Employe loadedEmploye = employeService.findByIdOrCin(prelevementSocialEmploye.getEmploye());

        if (loadedEmploye == null) {
            return;
        }
        prelevementSocialEmploye.setEmploye(loadedEmploye);
    }

    private void findDeclarationIr(PrelevementSocialEmploye prelevementSocialEmploye) {
        DeclarationIr loadedDeclarationIr = declarationIrService.findByIdOrRefrerence(prelevementSocialEmploye.getDeclarationIr());

        if (loadedDeclarationIr == null) {
            return;
        }
        prelevementSocialEmploye.setDeclarationIr(loadedDeclarationIr);
    }

    @Override
    @Transactional
    public void delete(List<PrelevementSocialEmploye> prelevementSocialEmployes) {
        if (ListUtil.isNotEmpty(prelevementSocialEmployes)) {
            prelevementSocialEmployes.forEach(e -> prelevementSocialEmployeDao.delete(e));
        }
    }

    @Override
    public void update(List<PrelevementSocialEmploye> prelevementSocialEmployes) {
        if (ListUtil.isNotEmpty(prelevementSocialEmployes)) {
            prelevementSocialEmployes.forEach(e -> prelevementSocialEmployeDao.save(e));
        }
    }


}
