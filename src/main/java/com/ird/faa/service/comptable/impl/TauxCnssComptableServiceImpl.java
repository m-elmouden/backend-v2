package com.ird.faa.service.comptable.impl;

import com.ird.faa.bean.TauxCnss;
import com.ird.faa.bean.TypeTauxCnss;
import com.ird.faa.dao.TauxCnssDao;
import com.ird.faa.service.comptable.facade.TauxCnssComptableService;
import com.ird.faa.service.comptable.facade.TypeTauxCnssComptableService;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.TauxCnssVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TauxCnssComptableServiceImpl extends AbstractServiceImpl<TauxCnss> implements TauxCnssComptableService {

    @Autowired
    private TauxCnssDao tauxCnssDao;

    @Autowired
    private ArchivableService<TauxCnss> archivableService;
    @Autowired
    private TypeTauxCnssComptableService typeTauxCnssService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<TauxCnss> findAll() {
        String query = "SELECT o FROM TauxCnss o where 1=1 ";
        query += " ORDER BY o.dateApplicationMax";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<TauxCnss> findByTypeTauxCnssId(Long id) {
        return tauxCnssDao.findByTypeTauxCnssId(id);
    }

    @Override
    @Transactional
    public int deleteByTypeTauxCnssId(Long id) {
        return tauxCnssDao.deleteByTypeTauxCnssId(id);
    }

    @Override
    public TauxCnss findByRef(String ref) {
        if (ref == null) return null;
        return tauxCnssDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return tauxCnssDao.deleteByRef(ref);
    }

    @Override
    public TauxCnss findByIdOrRef(TauxCnss tauxCnss) {
        TauxCnss resultat = null;
        if (tauxCnss != null) {
            if (StringUtil.isNotEmpty(tauxCnss.getId())) {
                resultat = tauxCnssDao.getOne(tauxCnss.getId());
            } else if (StringUtil.isNotEmpty(tauxCnss.getRef())) {
                resultat = tauxCnssDao.findByRef(tauxCnss.getRef());
            }
        }
        return resultat;
    }

    @Override
    public TauxCnss findById(Long id) {
        if (id == null) return null;
        return tauxCnssDao.getOne(id);
    }

    @Override
    public TauxCnss findByIdWithAssociatedList(Long id) {
        return findById(id);
    }

    @Override
    public TauxCnss archiver(TauxCnss tauxCnss) {
        if (tauxCnss.getArchive() == null) {
            tauxCnss.setArchive(false);
        }
        tauxCnss.setArchive(true);
        tauxCnss.setDateArchivage(new Date());
        tauxCnssDao.save(tauxCnss);
        return tauxCnss;

    }

    @Override
    public TauxCnss desarchiver(TauxCnss tauxCnss) {
        if (tauxCnss.getArchive() == null) {
            tauxCnss.setArchive(false);
        }
        tauxCnss.setArchive(false);
        tauxCnss.setDateArchivage(null);
        tauxCnssDao.save(tauxCnss);
        return tauxCnss;
    }


    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (tauxCnssDao.findById(id).isPresent()) {
            tauxCnssDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public TauxCnss update(TauxCnss tauxCnss) {
        TauxCnss foundedTauxCnss = findById(tauxCnss.getId());
        if (foundedTauxCnss == null) return null;
        else {
            archivableService.prepare(tauxCnss);
            return tauxCnssDao.save(tauxCnss);
        }
    }

    private void prepareSave(TauxCnss tauxCnss) {
        tauxCnss.setDateCreation(new Date());
        if (tauxCnss.getArchive() == null)
            tauxCnss.setArchive(false);
        if (tauxCnss.getAdmin() == null)
            tauxCnss.setAdmin(false);
        if (tauxCnss.getVisible() == null)
            tauxCnss.setVisible(false);


    }

    @Override
    public TauxCnss save(TauxCnss tauxCnss) {
        prepareSave(tauxCnss);

        TauxCnss result = null;
        TauxCnss foundedTauxCnss = findByRef(tauxCnss.getRef());
        if (foundedTauxCnss == null) {


            findTypeTauxCnss(tauxCnss);

            TauxCnss savedTauxCnss = tauxCnssDao.save(tauxCnss);

            result = savedTauxCnss;
        }

        return result;
    }

    @Override
    public List<TauxCnss> save(List<TauxCnss> tauxCnsss) {
        List<TauxCnss> list = new ArrayList<>();
        for (TauxCnss tauxCnss : tauxCnsss) {
            list.add(save(tauxCnss));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(TauxCnss tauxCnss) {
        if (tauxCnss.getRef() == null) return -1;

        TauxCnss foundedTauxCnss = findByRef(tauxCnss.getRef());
        if (foundedTauxCnss == null) return -1;
        tauxCnssDao.delete(foundedTauxCnss);
        return 1;
    }


    public List<TauxCnss> findByCriteria(TauxCnssVo tauxCnssVo) {

        String query = "SELECT o FROM TauxCnss o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", tauxCnssVo.getId());
        query += SearchUtil.addConstraint("o", "ref", "LIKE", tauxCnssVo.getRef());
        query += SearchUtil.addConstraintDate("o", "dateApplicationMin", "=", tauxCnssVo.getDateApplicationMin());
        query += SearchUtil.addConstraintDate("o", "dateApplicationMax", "=", tauxCnssVo.getDateApplicationMax());
        query += SearchUtil.addConstraint("o", "plafond", "=", tauxCnssVo.getPlafond());
        query += SearchUtil.addConstraint("o", "pourcentage", "=", tauxCnssVo.getPourcentage());
        query += SearchUtil.addConstraint("o", "archive", "=", tauxCnssVo.getArchive());
        query += SearchUtil.addConstraintDate("o", "dateArchivage", "=", tauxCnssVo.getDateArchivage());
        query += SearchUtil.addConstraintDate("o", "dateCreation", "=", tauxCnssVo.getDateCreation());
        query += SearchUtil.addConstraint("o", "admin", "=", tauxCnssVo.getAdmin());
        query += SearchUtil.addConstraint("o", "visible", "=", tauxCnssVo.getVisible());
        query += SearchUtil.addConstraint("o", "username", "LIKE", tauxCnssVo.getUsername());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateApplicationMin", tauxCnssVo.getDateApplicationMinMin(), tauxCnssVo.getDateApplicationMinMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateApplicationMax", tauxCnssVo.getDateApplicationMaxMin(), tauxCnssVo.getDateApplicationMaxMax());
        query += SearchUtil.addConstraintMinMax("o", "plafond", tauxCnssVo.getPlafondMin(), tauxCnssVo.getPlafondMax());
        query += SearchUtil.addConstraintMinMax("o", "pourcentage", tauxCnssVo.getPourcentageMin(), tauxCnssVo.getPourcentageMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateArchivage", tauxCnssVo.getDateArchivageMin(), tauxCnssVo.getDateArchivageMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", tauxCnssVo.getDateCreationMin(), tauxCnssVo.getDateCreationMax());
        if (tauxCnssVo.getTypeTauxCnssVo() != null) {
            query += SearchUtil.addConstraint("o", "typeTauxCnss.id", "=", tauxCnssVo.getTypeTauxCnssVo().getId());
        }

        query += " ORDER BY o.dateApplicationMax";
        return entityManager.createQuery(query).getResultList();
    }

    private void findTypeTauxCnss(TauxCnss tauxCnss) {
        TypeTauxCnss loadedTypeTauxCnss = null;
        if (tauxCnss.getTypeTauxCnss() != null && tauxCnss.getTypeTauxCnss().getId() != null)
            loadedTypeTauxCnss = typeTauxCnssService.findById(tauxCnss.getTypeTauxCnss().getId());

        if (loadedTypeTauxCnss == null) {
            return;
        }
        tauxCnss.setTypeTauxCnss(loadedTypeTauxCnss);
    }

    @Override
    @Transactional
    public void delete(List<TauxCnss> tauxCnsss) {
        if (ListUtil.isNotEmpty(tauxCnsss)) {
            tauxCnsss.forEach(e -> tauxCnssDao.delete(e));
        }
    }

    @Override
    public void update(List<TauxCnss> tauxCnsss) {
        if (ListUtil.isNotEmpty(tauxCnsss)) {
            tauxCnsss.forEach(e -> tauxCnssDao.save(e));
        }
    }


}
