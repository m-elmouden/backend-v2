package com.ird.faa.service.admin.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import com.ird.faa.bean.DeclarationIrEmploye;
import com.ird.faa.bean.DeclarationIr;
import com.ird.faa.bean.Employe;
import com.ird.faa.bean.TauxIr;
import com.ird.faa.dao.DeclarationIrEmployeDao;
import com.ird.faa.service.admin.facade.DeclarationIrEmployeAdminService;
import com.ird.faa.service.admin.facade.TauxIrAdminService;
import com.ird.faa.service.admin.facade.DeclarationIrAdminService;
import com.ird.faa.service.admin.facade.EmployeAdminService;

import com.ird.faa.ws.rest.provided.vo.DeclarationIrEmployeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class DeclarationIrEmployeAdminServiceImpl extends AbstractServiceImpl<DeclarationIrEmploye> implements DeclarationIrEmployeAdminService {

    @Autowired
    private DeclarationIrEmployeDao declarationIrEmployeDao;

    @Autowired
    private TauxIrAdminService tauxIrService;
    @Autowired
    private DeclarationIrAdminService declarationIrService;
    @Autowired
    private EmployeAdminService employeService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<DeclarationIrEmploye> findAll() {
        return declarationIrEmployeDao.findAll();
    }

    @Override
    public List<DeclarationIrEmploye> findByDeclarationIrRefrerence(String refrerence) {
        return declarationIrEmployeDao.findByDeclarationIrRefrerence(refrerence);
    }

    @Override
    @Transactional
    public int deleteByDeclarationIrRefrerence(String refrerence) {
        return declarationIrEmployeDao.deleteByDeclarationIrRefrerence(refrerence);
    }

    @Override
    public List<DeclarationIrEmploye> findByDeclarationIrId(Long id) {
        return declarationIrEmployeDao.findByDeclarationIrId(id);
    }

    @Override
    @Transactional
    public int deleteByDeclarationIrId(Long id) {
        return declarationIrEmployeDao.deleteByDeclarationIrId(id);
    }


    @Override
    public List<DeclarationIrEmploye> findByEmployeCin(String cin) {
        return declarationIrEmployeDao.findByEmployeCin(cin);
    }

    @Override
    @Transactional
    public int deleteByEmployeCin(String cin) {
        return declarationIrEmployeDao.deleteByEmployeCin(cin);
    }

    @Override
    public List<DeclarationIrEmploye> findByEmployeId(Long id) {
        return declarationIrEmployeDao.findByEmployeId(id);
    }

    @Override
    @Transactional
    public int deleteByEmployeId(Long id) {
        return declarationIrEmployeDao.deleteByEmployeId(id);
    }

    @Override
    public List<DeclarationIrEmploye> findByTauxIrId(Long id) {
        return declarationIrEmployeDao.findByTauxIrId(id);
    }

    @Override
    @Transactional
    public int deleteByTauxIrId(Long id) {
        return declarationIrEmployeDao.deleteByTauxIrId(id);
    }

    @Override
    public void CalculIr(DeclarationIrEmploye declarationIrEmploye) {

    }


    @Override
    public DeclarationIrEmploye findById(Long id) {
        if (id == null) return null;
        return declarationIrEmployeDao.getOne(id);
    }

    @Override
    public DeclarationIrEmploye findByIdWithAssociatedList(Long id) {
        return findById(id);
    }


    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (declarationIrEmployeDao.findById(id).isPresent()) {
            declarationIrEmployeDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    private BigDecimal calculHoraireSuplamentaire(DeclarationIrEmploye declarationIrEmploye) {
        if (declarationIrEmploye.getSalaireBase() != null)
            return declarationIrEmploye.getSalaireBase().divide(BigDecimal.valueOf(176), 2, RoundingMode.HALF_UP);
        return BigDecimal.ZERO;
    }

    private BigDecimal calculSalaireBrutGlobale(DeclarationIrEmploye declarationIrEmploye) {
        BigDecimal salaireBrutGlobale;
        BigDecimal HS = calculHoraireSuplamentaire(declarationIrEmploye);
        salaireBrutGlobale = declarationIrEmploye.getSalaireBase().add(declarationIrEmploye.getSalaireBase().multiply((declarationIrEmploye.getPourcentageAnciennete()).divide(BigDecimal.valueOf(100)))).add(declarationIrEmploye.getPrimes()).add(HS.multiply(declarationIrEmploye.getHeuresSupplementaires()));//.add(declarationIrEmploye.getAvantage());
        return salaireBrutGlobale;
    }

    private BigDecimal calculSalaireBrutImposable(DeclarationIrEmploye declarationIrEmploye) {
        BigDecimal salaireBrutImposable;
        salaireBrutImposable = calculSalaireBrutGlobale(declarationIrEmploye).subtract(declarationIrEmploye.getIndemniteJustifie());
        return salaireBrutImposable;
    }


    @Override
    public DeclarationIrEmploye update(DeclarationIrEmploye declarationIrEmploye) {
        DeclarationIrEmploye foundedDeclarationIrEmploye = findById(declarationIrEmploye.getId());
        if (foundedDeclarationIrEmploye == null) return null;
        else {
            declarationIrEmploye.setSalaireBrut(calculSalaireBrutGlobale(declarationIrEmploye));
            declarationIrEmploye.setSalaireBrutImposable(calculSalaireBrutImposable(declarationIrEmploye));
            return declarationIrEmployeDao.save(declarationIrEmploye);
        }
    }

    @Override
    public DeclarationIrEmploye save(DeclarationIrEmploye declarationIrEmploye) {


        findDeclarationIr(declarationIrEmploye);
        findEmploye(declarationIrEmploye);
        findTauxIr(declarationIrEmploye);
        declarationIrEmploye.setSalaireBrut(calculSalaireBrutGlobale(declarationIrEmploye));
        declarationIrEmploye.setSalaireBrutImposable(calculSalaireBrutImposable(declarationIrEmploye));
        declarationIrEmployeDao.save(declarationIrEmploye);
        return declarationIrEmployeDao.save(declarationIrEmploye);


    }


    @Override
    public List<DeclarationIrEmploye> save(List<DeclarationIrEmploye> declarationIrEmployes) {
        List<DeclarationIrEmploye> list = new ArrayList<>();
        for (DeclarationIrEmploye declarationIrEmploye : declarationIrEmployes) {
            list.add(save(declarationIrEmploye));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(DeclarationIrEmploye declarationIrEmploye) {
        if (declarationIrEmploye.getId() == null) return -1;
        DeclarationIrEmploye foundedDeclarationIrEmploye = findById(declarationIrEmploye.getId());
        if (foundedDeclarationIrEmploye == null) return -1;
        declarationIrEmployeDao.delete(foundedDeclarationIrEmploye);
        return 1;
    }


    public List<DeclarationIrEmploye> findByCriteria(DeclarationIrEmployeVo declarationIrEmployeVo) {

        String query = "SELECT o FROM DeclarationIrEmploye o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", declarationIrEmployeVo.getId());
        query += SearchUtil.addConstraint("o", "salaireNet", "=", declarationIrEmployeVo.getSalaireNet());
        query += SearchUtil.addConstraint("o", "salaireBrut", "=", declarationIrEmployeVo.getSalaireBrut());
        query += SearchUtil.addConstraint("o", "salaireNetImposable", "=", declarationIrEmployeVo.getSalaireNetImposable());
        query += SearchUtil.addConstraint("o", "salaireBrutImposable", "=", declarationIrEmployeVo.getSalaireBrutImposable());
        query += SearchUtil.addConstraint("o", "salaireBase", "=", declarationIrEmployeVo.getSalaireBase());
        query += SearchUtil.addConstraint("o", "indemnite", "=", declarationIrEmployeVo.getIndemnite());
        query += SearchUtil.addConstraint("o", "primes", "=", declarationIrEmployeVo.getPrimes());
        query += SearchUtil.addConstraint("o", "pourcentageAnciennete", "=", declarationIrEmployeVo.getPourcentageAnciennete());
        query += SearchUtil.addConstraint("o", "cotisation", "=", declarationIrEmployeVo.getCotisation());
        query += SearchUtil.addConstraintMinMax("o", "salaireNet", declarationIrEmployeVo.getSalaireNetMin(), declarationIrEmployeVo.getSalaireNetMax());
        query += SearchUtil.addConstraintMinMax("o", "salaireBrut", declarationIrEmployeVo.getSalaireBrutMin(), declarationIrEmployeVo.getSalaireBrutMax());
        query += SearchUtil.addConstraintMinMax("o", "salaireNetImposable", declarationIrEmployeVo.getSalaireNetImposableMin(), declarationIrEmployeVo.getSalaireNetImposableMax());
        query += SearchUtil.addConstraintMinMax("o", "salaireBrutImposable", declarationIrEmployeVo.getSalaireBrutImposableMin(), declarationIrEmployeVo.getSalaireBrutImposableMax());
        query += SearchUtil.addConstraintMinMax("o", "salaireBase", declarationIrEmployeVo.getSalaireBaseMin(), declarationIrEmployeVo.getSalaireBaseMax());
        query += SearchUtil.addConstraintMinMax("o", "indemnite", declarationIrEmployeVo.getIndemniteMin(), declarationIrEmployeVo.getIndemniteMax());
        query += SearchUtil.addConstraintMinMax("o", "primes", declarationIrEmployeVo.getPrimesMin(), declarationIrEmployeVo.getPrimesMax());
        query += SearchUtil.addConstraintMinMax("o", "pourcentageAnciennete", declarationIrEmployeVo.getPourcentageAncienneteMin(), declarationIrEmployeVo.getPourcentageAncienneteMax());
        query += SearchUtil.addConstraintMinMax("o", "cotisation", declarationIrEmployeVo.getCotisationMin(), declarationIrEmployeVo.getCotisationMax());
        if (declarationIrEmployeVo.getDeclarationIrVo() != null) {
            query += SearchUtil.addConstraint("o", "declarationIr.id", "=", declarationIrEmployeVo.getDeclarationIrVo().getId());
            query += SearchUtil.addConstraint("o", "declarationIr.refrerence", "LIKE", declarationIrEmployeVo.getDeclarationIrVo().getRefrerence());
        }

        if (declarationIrEmployeVo.getEmployeVo() != null) {
            query += SearchUtil.addConstraint("o", "employe.id", "=", declarationIrEmployeVo.getEmployeVo().getId());
            query += SearchUtil.addConstraint("o", "employe.cin", "LIKE", declarationIrEmployeVo.getEmployeVo().getCin());
        }

        if (declarationIrEmployeVo.getTauxIrVo() != null) {
            query += SearchUtil.addConstraint("o", "tauxIr.id", "=", declarationIrEmployeVo.getTauxIrVo().getId());
        }

        return entityManager.createQuery(query).getResultList();
    }

    private void findDeclarationIr(DeclarationIrEmploye declarationIrEmploye) {
        DeclarationIr loadedDeclarationIr = declarationIrService.findByIdOrRefrerence(declarationIrEmploye.getDeclarationIr());

        if (loadedDeclarationIr == null) {
            return;
        }
        declarationIrEmploye.setDeclarationIr(loadedDeclarationIr);
    }

    private void findEmploye(DeclarationIrEmploye declarationIrEmploye) {
        Employe loadedEmploye = employeService.findByIdOrCin(declarationIrEmploye.getEmploye());

        if (loadedEmploye == null) {
            return;
        }
        declarationIrEmploye.setEmploye(loadedEmploye);
    }

    private void findTauxIr(DeclarationIrEmploye declarationIrEmploye) {
        TauxIr loadedTauxIr = null;
        if (declarationIrEmploye.getTauxIr() != null && declarationIrEmploye.getTauxIr().getId() != null)
            loadedTauxIr = tauxIrService.findById(declarationIrEmploye.getTauxIr().getId());

        if (loadedTauxIr == null) {
            return;
        }
        declarationIrEmploye.setTauxIr(loadedTauxIr);
    }

    @Override
    @Transactional
    public void delete(List<DeclarationIrEmploye> declarationIrEmployes) {
        if (ListUtil.isNotEmpty(declarationIrEmployes)) {
            declarationIrEmployes.forEach(e -> declarationIrEmployeDao.delete(e));
        }
    }

    @Override
    public void update(List<DeclarationIrEmploye> declarationIrEmployes) {
        if (ListUtil.isNotEmpty(declarationIrEmployes)) {
            declarationIrEmployes.forEach(e -> declarationIrEmployeDao.save(e));
        }
    }


}
