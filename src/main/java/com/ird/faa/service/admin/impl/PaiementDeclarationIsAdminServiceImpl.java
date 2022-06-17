package com.ird.faa.service.admin.impl;

import com.ird.faa.bean.DeclarationIs;
import com.ird.faa.bean.PaiementDeclarationIs;
import com.ird.faa.dao.PaiementDeclarationIsDao;
import com.ird.faa.service.admin.facade.DeclarationIsAdminService;
import com.ird.faa.service.admin.facade.PaiementDeclarationIsAdminService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.PaiementDeclarationIsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaiementDeclarationIsAdminServiceImpl extends AbstractServiceImpl<PaiementDeclarationIs> implements PaiementDeclarationIsAdminService {

    @Autowired
    private PaiementDeclarationIsDao paiementDeclarationIsDao;

    @Autowired
    private DeclarationIsAdminService declarationIsService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<PaiementDeclarationIs> findAll() {
        String query = "SELECT o FROM PaiementDeclarationIs o where 1=1 ";
        query += " ORDER BY o.datePaiement";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<PaiementDeclarationIs> findByDeclarationIsReference(String reference) {
        return paiementDeclarationIsDao.findByDeclarationIsReference(reference);
    }

    @Override
    @Transactional
    public int deleteByDeclarationIsReference(String reference) {
        return paiementDeclarationIsDao.deleteByDeclarationIsReference(reference);
    }

    @Override
    public List<PaiementDeclarationIs> findByDeclarationIsId(Long id) {
        return paiementDeclarationIsDao.findByDeclarationIsId(id);
    }

    @Override
    @Transactional
    public int deleteByDeclarationIsId(Long id) {
        return paiementDeclarationIsDao.deleteByDeclarationIsId(id);
    }

    @Override
    public PaiementDeclarationIs findByReference(String reference) {
        if (reference == null) return null;
        return paiementDeclarationIsDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return paiementDeclarationIsDao.deleteByReference(reference);
    }

    @Override
    public PaiementDeclarationIs findByIdOrReference(PaiementDeclarationIs paiementDeclarationIs) {
        PaiementDeclarationIs resultat = null;
        if (paiementDeclarationIs != null) {
            if (StringUtil.isNotEmpty(paiementDeclarationIs.getId())) {
                resultat = paiementDeclarationIsDao.getOne(paiementDeclarationIs.getId());
            } else if (StringUtil.isNotEmpty(paiementDeclarationIs.getReference())) {
                resultat = paiementDeclarationIsDao.findByReference(paiementDeclarationIs.getReference());
            }
        }
        return resultat;
    }

    @Override
    public PaiementDeclarationIs findById(Long id) {
        if (id == null) return null;
        return paiementDeclarationIsDao.getOne(id);
    }

    @Override
    public PaiementDeclarationIs findByIdWithAssociatedList(Long id) {
        return findById(id);
    }


    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (paiementDeclarationIsDao.findById(id).isPresent()) {
            paiementDeclarationIsDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public PaiementDeclarationIs update(PaiementDeclarationIs paiementDeclarationIs) {
        PaiementDeclarationIs foundedPaiementDeclarationIs = findById(paiementDeclarationIs.getId());
        if (foundedPaiementDeclarationIs == null) return null;
        else {
            return paiementDeclarationIsDao.save(paiementDeclarationIs);
        }
    }

    @Override
    public PaiementDeclarationIs save(PaiementDeclarationIs paiementDeclarationIs) {

        PaiementDeclarationIs result = null;
        PaiementDeclarationIs foundedPaiementDeclarationIs = findByReference(paiementDeclarationIs.getReference());
        if (foundedPaiementDeclarationIs == null) {


            findDeclarationIs(paiementDeclarationIs);

            PaiementDeclarationIs savedPaiementDeclarationIs = paiementDeclarationIsDao.save(paiementDeclarationIs);

            result = savedPaiementDeclarationIs;
        }

        return result;
    }

    @Override
    public List<PaiementDeclarationIs> save(List<PaiementDeclarationIs> paiementDeclarationIss) {
        List<PaiementDeclarationIs> list = new ArrayList<>();
        for (PaiementDeclarationIs paiementDeclarationIs : paiementDeclarationIss) {
            list.add(save(paiementDeclarationIs));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(PaiementDeclarationIs paiementDeclarationIs) {
        if (paiementDeclarationIs.getReference() == null) return -1;

        PaiementDeclarationIs foundedPaiementDeclarationIs = findByReference(paiementDeclarationIs.getReference());
        if (foundedPaiementDeclarationIs == null) return -1;
        paiementDeclarationIsDao.delete(foundedPaiementDeclarationIs);
        return 1;
    }


    public List<PaiementDeclarationIs> findByCriteria(PaiementDeclarationIsVo paiementDeclarationIsVo) {

        String query = "SELECT o FROM PaiementDeclarationIs o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", paiementDeclarationIsVo.getId());
        query += SearchUtil.addConstraint("o", "reference", "LIKE", paiementDeclarationIsVo.getReference());
        query += SearchUtil.addConstraintDate("o", "datePaiement", "=", paiementDeclarationIsVo.getDatePaiement());
        query += SearchUtil.addConstraint("o", "total", "=", paiementDeclarationIsVo.getTotal());
        query += SearchUtil.addConstraint("o", "montantCptTraiteur", "=", paiementDeclarationIsVo.getMontantCptTraiteur());
        query += SearchUtil.addConstraint("o", "montantCptValidateur", "=", paiementDeclarationIsVo.getMontantCptValidateur());
        query += SearchUtil.addConstraint("o", "reste", "=", paiementDeclarationIsVo.getReste());
        query += SearchUtil.addConstraintMinMaxDate("o", "datePaiement", paiementDeclarationIsVo.getDatePaiementMin(), paiementDeclarationIsVo.getDatePaiementMax());
        query += SearchUtil.addConstraintMinMax("o", "total", paiementDeclarationIsVo.getTotalMin(), paiementDeclarationIsVo.getTotalMax());
        query += SearchUtil.addConstraintMinMax("o", "montantCptTraiteur", paiementDeclarationIsVo.getMontantCptTraiteurMin(), paiementDeclarationIsVo.getMontantCptTraiteurMax());
        query += SearchUtil.addConstraintMinMax("o", "montantCptValidateur", paiementDeclarationIsVo.getMontantCptValidateurMin(), paiementDeclarationIsVo.getMontantCptValidateurMax());
        query += SearchUtil.addConstraintMinMax("o", "reste", paiementDeclarationIsVo.getResteMin(), paiementDeclarationIsVo.getResteMax());
        if (paiementDeclarationIsVo.getDeclarationIsVo() != null) {
            query += SearchUtil.addConstraint("o", "declarationIs.id", "=", paiementDeclarationIsVo.getDeclarationIsVo().getId());
            query += SearchUtil.addConstraint("o", "declarationIs.reference", "LIKE", paiementDeclarationIsVo.getDeclarationIsVo().getReference());
        }

        query += " ORDER BY o.datePaiement";
        return entityManager.createQuery(query).getResultList();
    }

    private void findDeclarationIs(PaiementDeclarationIs paiementDeclarationIs) {
        DeclarationIs loadedDeclarationIs = declarationIsService.findByIdOrReference(paiementDeclarationIs.getDeclarationIs());

        if (loadedDeclarationIs == null) {
            return;
        }
        paiementDeclarationIs.setDeclarationIs(loadedDeclarationIs);
    }

    @Override
    @Transactional
    public void delete(List<PaiementDeclarationIs> paiementDeclarationIss) {
        if (ListUtil.isNotEmpty(paiementDeclarationIss)) {
            paiementDeclarationIss.forEach(e -> paiementDeclarationIsDao.delete(e));
        }
    }

    @Override
    public void update(List<PaiementDeclarationIs> paiementDeclarationIss) {
        if (ListUtil.isNotEmpty(paiementDeclarationIss)) {
            paiementDeclarationIss.forEach(e -> paiementDeclarationIsDao.save(e));
        }
    }


}
