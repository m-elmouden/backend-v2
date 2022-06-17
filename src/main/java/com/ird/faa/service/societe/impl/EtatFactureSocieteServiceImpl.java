package com.ird.faa.service.societe.impl;

import com.ird.faa.bean.EtatFacture;
import com.ird.faa.dao.EtatFactureDao;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.societe.facade.EtatFactureSocieteService;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.EtatFactureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class EtatFactureSocieteServiceImpl extends AbstractServiceImpl<EtatFacture> implements EtatFactureSocieteService {

    @Autowired
    private EtatFactureDao etatFactureDao;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<EtatFacture> findAll() {
        return etatFactureDao.findAll();
    }

    @Override
    public EtatFacture findById(Long id) {
        if (id == null) return null;
        return etatFactureDao.getOne(id);
    }

    @Override
    public EtatFacture findByIdWithAssociatedList(Long id) {
        return findById(id);
    }


    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (etatFactureDao.findById(id).isPresent()) {
            etatFactureDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public EtatFacture update(EtatFacture etatFacture) {
        EtatFacture foundedEtatFacture = findById(etatFacture.getId());
        if (foundedEtatFacture == null) return null;
        else {
            return etatFactureDao.save(etatFacture);
        }
    }

    @Override
    public EtatFacture save(EtatFacture etatFacture) {


        return etatFactureDao.save(etatFacture);


    }

    @Override
    public List<EtatFacture> save(List<EtatFacture> etatFactures) {
        List<EtatFacture> list = new ArrayList<>();
        for (EtatFacture etatFacture : etatFactures) {
            list.add(save(etatFacture));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(EtatFacture etatFacture) {
        if (etatFacture.getId() == null) return -1;
        EtatFacture foundedEtatFacture = findById(etatFacture.getId());
        if (foundedEtatFacture == null) return -1;
        etatFactureDao.delete(foundedEtatFacture);
        return 1;
    }


    public List<EtatFacture> findByCriteria(EtatFactureVo etatFactureVo) {

        String query = "SELECT o FROM EtatFacture o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", etatFactureVo.getId());
        query += SearchUtil.addConstraint("o", "libelle", "LIKE", etatFactureVo.getLibelle());
        query += SearchUtil.addConstraint("o", "code", "=", etatFactureVo.getCode());
        query += SearchUtil.addConstraintMinMax("o", "code", etatFactureVo.getCodeMin(), etatFactureVo.getCodeMax());
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    @Transactional
    public void delete(List<EtatFacture> etatFactures) {
        if (ListUtil.isNotEmpty(etatFactures)) {
            etatFactures.forEach(e -> etatFactureDao.delete(e));
        }
    }

    @Override
    public void update(List<EtatFacture> etatFactures) {
        if (ListUtil.isNotEmpty(etatFactures)) {
            etatFactures.forEach(e -> etatFactureDao.save(e));
        }
    }


}
