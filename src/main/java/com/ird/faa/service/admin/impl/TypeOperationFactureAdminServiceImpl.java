package com.ird.faa.service.admin.impl;

import com.ird.faa.bean.TypeOperationFacture;
import com.ird.faa.dao.TypeOperationFactureDao;
import com.ird.faa.service.admin.facade.TypeOperationFactureAdminService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.TypeOperationFactureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeOperationFactureAdminServiceImpl extends AbstractServiceImpl<TypeOperationFacture> implements TypeOperationFactureAdminService {

    @Autowired
    private TypeOperationFactureDao typeOperationFactureDao;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<TypeOperationFacture> findAll() {
        return typeOperationFactureDao.findAll();
    }

    @Override
    public TypeOperationFacture findById(Long id) {
        if (id == null) return null;
        return typeOperationFactureDao.getOne(id);
    }

    @Override
    public TypeOperationFacture findByIdWithAssociatedList(Long id) {
        return findById(id);
    }


    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (typeOperationFactureDao.findById(id).isPresent()) {
            typeOperationFactureDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public TypeOperationFacture update(TypeOperationFacture typeOperationFacture) {
        TypeOperationFacture foundedTypeOperationFacture = findById(typeOperationFacture.getId());
        if (foundedTypeOperationFacture == null) return null;
        else {
            return typeOperationFactureDao.save(typeOperationFacture);
        }
    }

    @Override
    public TypeOperationFacture save(TypeOperationFacture typeOperationFacture) {


        return typeOperationFactureDao.save(typeOperationFacture);


    }

    @Override
    public List<TypeOperationFacture> save(List<TypeOperationFacture> typeOperationFactures) {
        List<TypeOperationFacture> list = new ArrayList<>();
        for (TypeOperationFacture typeOperationFacture : typeOperationFactures) {
            list.add(save(typeOperationFacture));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(TypeOperationFacture typeOperationFacture) {
        if (typeOperationFacture.getId() == null) return -1;
        TypeOperationFacture foundedTypeOperationFacture = findById(typeOperationFacture.getId());
        if (foundedTypeOperationFacture == null) return -1;
        typeOperationFactureDao.delete(foundedTypeOperationFacture);
        return 1;
    }


    public List<TypeOperationFacture> findByCriteria(TypeOperationFactureVo typeOperationFactureVo) {

        String query = "SELECT o FROM TypeOperationFacture o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", typeOperationFactureVo.getId());
        query += SearchUtil.addConstraint("o", "libelle", "LIKE", typeOperationFactureVo.getLibelle());
        query += SearchUtil.addConstraint("o", "typeOperationSociete", "LIKE", typeOperationFactureVo.getTypeOperationSociete());
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    @Transactional
    public void delete(List<TypeOperationFacture> typeOperationFactures) {
        if (ListUtil.isNotEmpty(typeOperationFactures)) {
            typeOperationFactures.forEach(e -> typeOperationFactureDao.delete(e));
        }
    }

    @Override
    public void update(List<TypeOperationFacture> typeOperationFactures) {
        if (ListUtil.isNotEmpty(typeOperationFactures)) {
            typeOperationFactures.forEach(e -> typeOperationFactureDao.save(e));
        }
    }


}
