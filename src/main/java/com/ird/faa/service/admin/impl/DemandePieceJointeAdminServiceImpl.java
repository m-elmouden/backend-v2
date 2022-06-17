package com.ird.faa.service.admin.impl;

import com.ird.faa.bean.Demande;
import com.ird.faa.bean.DemandePieceJointe;
import com.ird.faa.dao.DemandePieceJointeDao;
import com.ird.faa.service.admin.facade.DemandeAdminService;
import com.ird.faa.service.admin.facade.DemandePieceJointeAdminService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.DemandePieceJointeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemandePieceJointeAdminServiceImpl extends AbstractServiceImpl<DemandePieceJointe> implements DemandePieceJointeAdminService {

    @Autowired
    private DemandePieceJointeDao demandePieceJointeDao;

    @Autowired
    private DemandeAdminService demandeService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<DemandePieceJointe> findAll() {
        return demandePieceJointeDao.findAll();
    }

    @Override
    public List<DemandePieceJointe> findByDemandeReference(String reference) {
        return demandePieceJointeDao.findByDemandeReference(reference);
    }

    @Override
    @Transactional
    public int deleteByDemandeReference(String reference) {
        return demandePieceJointeDao.deleteByDemandeReference(reference);
    }

    @Override
    public List<DemandePieceJointe> findByDemandeId(Long id) {
        return demandePieceJointeDao.findByDemandeId(id);
    }

    @Override
    @Transactional
    public int deleteByDemandeId(Long id) {
        return demandePieceJointeDao.deleteByDemandeId(id);
    }


    @Override
    public DemandePieceJointe findById(Long id) {
        if (id == null) return null;
        return demandePieceJointeDao.getOne(id);
    }

    @Override
    public DemandePieceJointe findByIdWithAssociatedList(Long id) {
        return findById(id);
    }


    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (demandePieceJointeDao.findById(id).isPresent()) {
            demandePieceJointeDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public DemandePieceJointe update(DemandePieceJointe demandePieceJointe) {
        DemandePieceJointe foundedDemandePieceJointe = findById(demandePieceJointe.getId());
        if (foundedDemandePieceJointe == null) return null;
        else {
            return demandePieceJointeDao.save(demandePieceJointe);
        }
    }

    @Override
    public DemandePieceJointe save(DemandePieceJointe demandePieceJointe) {


        findDemande(demandePieceJointe);

        return demandePieceJointeDao.save(demandePieceJointe);


    }

    @Override
    public List<DemandePieceJointe> save(List<DemandePieceJointe> demandePieceJointes) {
        List<DemandePieceJointe> list = new ArrayList<>();
        for (DemandePieceJointe demandePieceJointe : demandePieceJointes) {
            list.add(save(demandePieceJointe));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(DemandePieceJointe demandePieceJointe) {
        if (demandePieceJointe.getId() == null) return -1;
        DemandePieceJointe foundedDemandePieceJointe = findById(demandePieceJointe.getId());
        if (foundedDemandePieceJointe == null) return -1;
        demandePieceJointeDao.delete(foundedDemandePieceJointe);
        return 1;
    }


    public List<DemandePieceJointe> findByCriteria(DemandePieceJointeVo demandePieceJointeVo) {

        String query = "SELECT o FROM DemandePieceJointe o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", demandePieceJointeVo.getId());
        query += SearchUtil.addConstraint("o", "name", "LIKE", demandePieceJointeVo.getName());
        query += SearchUtil.addConstraint("o", "path", "LIKE", demandePieceJointeVo.getPath());
        if (demandePieceJointeVo.getDemandeVo() != null) {
            query += SearchUtil.addConstraint("o", "demande.id", "=", demandePieceJointeVo.getDemandeVo().getId());
            query += SearchUtil.addConstraint("o", "demande.reference", "LIKE", demandePieceJointeVo.getDemandeVo().getReference());
        }

        return entityManager.createQuery(query).getResultList();
    }

    private void findDemande(DemandePieceJointe demandePieceJointe) {
        Demande loadedDemande = demandeService.findByIdOrReference(demandePieceJointe.getDemande());

        if (loadedDemande == null) {
            return;
        }
        demandePieceJointe.setDemande(loadedDemande);
    }

    @Override
    @Transactional
    public void delete(List<DemandePieceJointe> demandePieceJointes) {
        if (ListUtil.isNotEmpty(demandePieceJointes)) {
            demandePieceJointes.forEach(e -> demandePieceJointeDao.delete(e));
        }
    }

    @Override
    public void update(List<DemandePieceJointe> demandePieceJointes) {
        if (ListUtil.isNotEmpty(demandePieceJointes)) {
            demandePieceJointes.forEach(e -> demandePieceJointeDao.save(e));
        }
    }


}
