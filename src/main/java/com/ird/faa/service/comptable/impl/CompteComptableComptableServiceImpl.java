package com.ird.faa.service.comptable.impl;

import com.ird.faa.bean.CompteComptable;
import com.ird.faa.bean.SousClasseComptable;
import com.ird.faa.dao.CompteComptableDao;
import com.ird.faa.service.comptable.facade.CompteComptableComptableService;
import com.ird.faa.service.comptable.facade.SousClasseComptableComptableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.CompteComptableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompteComptableComptableServiceImpl extends AbstractServiceImpl<CompteComptable> implements CompteComptableComptableService {

    @Autowired
    private CompteComptableDao compteComptableDao;

    @Autowired
    private SousClasseComptableComptableService sousClasseComptableService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<CompteComptable> findAll() {
        return compteComptableDao.findAll();
    }

    @Override
    public List<CompteComptable> findBySousClasseComptableId(Long id) {
        return compteComptableDao.findBySousClasseComptableId(id);
    }

    @Override
    @Transactional
    public int deleteBySousClasseComptableId(Long id) {
        return compteComptableDao.deleteBySousClasseComptableId(id);
    }

    @Override
    public CompteComptable findByNumero(BigDecimal numero) {
        if (numero == null) return null;
        return compteComptableDao.findByNumero(numero);
    }

    @Override
    @Transactional
    public int deleteByNumero(BigDecimal numero) {
        return compteComptableDao.deleteByNumero(numero);
    }

    @Override
    public CompteComptable findByIdOrNumero(CompteComptable compteComptable) {
        CompteComptable resultat = null;
        if (compteComptable != null) {
            if (StringUtil.isNotEmpty(compteComptable.getId())) {
                resultat = compteComptableDao.getOne(compteComptable.getId());
            } else if (StringUtil.isNotEmpty(compteComptable.getNumero())) {
                resultat = compteComptableDao.findByNumero(compteComptable.getNumero());
            }
        }
        return resultat;
    }

    @Override
    public CompteComptable findById(Long id) {
        if (id == null) return null;
        return compteComptableDao.getOne(id);
    }

    @Override
    public CompteComptable findByIdWithAssociatedList(Long id) {
        return findById(id);
    }


    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (compteComptableDao.findById(id).isPresent()) {
            compteComptableDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public CompteComptable update(CompteComptable compteComptable) {
        CompteComptable foundedCompteComptable = findById(compteComptable.getId());
        if (foundedCompteComptable == null) return null;
        else {
            return compteComptableDao.save(compteComptable);
        }
    }

    @Override
    public CompteComptable save(CompteComptable compteComptable) {

        CompteComptable result = null;
        CompteComptable foundedCompteComptable = findByNumero(compteComptable.getNumero());
        if (foundedCompteComptable == null) {


            findSousClasseComptable(compteComptable);

            CompteComptable savedCompteComptable = compteComptableDao.save(compteComptable);

            result = savedCompteComptable;
        }

        return result;
    }

    @Override
    public List<CompteComptable> save(List<CompteComptable> compteComptables) {
        List<CompteComptable> list = new ArrayList<>();
        for (CompteComptable compteComptable : compteComptables) {
            list.add(save(compteComptable));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(CompteComptable compteComptable) {
        if (compteComptable.getNumero() == null) return -1;

        CompteComptable foundedCompteComptable = findByNumero(compteComptable.getNumero());
        if (foundedCompteComptable == null) return -1;
        compteComptableDao.delete(foundedCompteComptable);
        return 1;
    }


    public List<CompteComptable> findByCriteria(CompteComptableVo compteComptableVo) {

        String query = "SELECT o FROM CompteComptable o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", compteComptableVo.getId());
        query += SearchUtil.addConstraint("o", "libelle", "LIKE", compteComptableVo.getLibelle());
        query += SearchUtil.addConstraint("o", "numero", "=", compteComptableVo.getNumero());
        query += SearchUtil.addConstraintMinMax("o", "numero", compteComptableVo.getNumeroMin(), compteComptableVo.getNumeroMax());
        if (compteComptableVo.getSousClasseComptableVo() != null) {
            query += SearchUtil.addConstraint("o", "sousClasseComptable.id", "=", compteComptableVo.getSousClasseComptableVo().getId());
        }

        return entityManager.createQuery(query).getResultList();
    }

    private void findSousClasseComptable(CompteComptable compteComptable) {
        SousClasseComptable loadedSousClasseComptable = null;
        if (compteComptable.getSousClasseComptable() != null && compteComptable.getSousClasseComptable().getId() != null)
            loadedSousClasseComptable = sousClasseComptableService.findById(compteComptable.getSousClasseComptable().getId());

        if (loadedSousClasseComptable == null) {
            return;
        }
        compteComptable.setSousClasseComptable(loadedSousClasseComptable);
    }

    @Override
    @Transactional
    public void delete(List<CompteComptable> compteComptables) {
        if (ListUtil.isNotEmpty(compteComptables)) {
            compteComptables.forEach(e -> compteComptableDao.delete(e));
        }
    }

    @Override
    public void update(List<CompteComptable> compteComptables) {
        if (ListUtil.isNotEmpty(compteComptables)) {
            compteComptables.forEach(e -> compteComptableDao.save(e));
        }
    }


}
