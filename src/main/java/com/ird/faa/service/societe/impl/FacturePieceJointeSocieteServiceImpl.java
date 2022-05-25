package com.ird.faa.service.societe.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.FacturePieceJointe;
        import com.ird.faa.bean.Facture;
import com.ird.faa.dao.FacturePieceJointeDao;
import com.ird.faa.service.societe.facade.FacturePieceJointeSocieteService;
        import com.ird.faa.service.societe.facade.FactureSocieteService;

import com.ird.faa.ws.rest.provided.vo.FacturePieceJointeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class FacturePieceJointeSocieteServiceImpl extends AbstractServiceImpl<FacturePieceJointe> implements FacturePieceJointeSocieteService {

@Autowired
private FacturePieceJointeDao facturePieceJointeDao;

        @Autowired
        private FactureSocieteService factureService ;


@Autowired
private EntityManager entityManager;


@Override
public List<FacturePieceJointe> findAll(){
        return facturePieceJointeDao.findAll();
}

        @Override
        public List<FacturePieceJointe> findByFactureReference(String reference){
        return facturePieceJointeDao.findByFactureReference(reference);
        }

        @Override
        @Transactional
        public int deleteByFactureReference(String reference){
        return facturePieceJointeDao.deleteByFactureReference(reference);
        }

        @Override
        public List<FacturePieceJointe> findByFactureId(Long id){
        return facturePieceJointeDao.findByFactureId(id);
        }

        @Override
        @Transactional
        public int deleteByFactureId(Long id){
        return facturePieceJointeDao.deleteByFactureId(id);
        }


@Override
public FacturePieceJointe findById(Long id){
if(id==null) return null;
return facturePieceJointeDao.getOne(id);
}

@Override
public FacturePieceJointe findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(facturePieceJointeDao.findById(id).isPresent())  {
facturePieceJointeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public FacturePieceJointe update(FacturePieceJointe facturePieceJointe){
FacturePieceJointe foundedFacturePieceJointe = findById(facturePieceJointe.getId());
if(foundedFacturePieceJointe==null) return null;
else{
return  facturePieceJointeDao.save(facturePieceJointe);
}
}

@Override
public FacturePieceJointe save (FacturePieceJointe facturePieceJointe){



    findFacture(facturePieceJointe);

    return facturePieceJointeDao.save(facturePieceJointe);


}

@Override
public List<FacturePieceJointe> save(List<FacturePieceJointe> facturePieceJointes){
List<FacturePieceJointe> list = new ArrayList<>();
for(FacturePieceJointe facturePieceJointe: facturePieceJointes){
list.add(save(facturePieceJointe));
}
return list;
}



@Override
@Transactional
public int delete(FacturePieceJointe facturePieceJointe){
    if(facturePieceJointe.getId()==null) return -1;
    FacturePieceJointe foundedFacturePieceJointe = findById(facturePieceJointe.getId());
    if(foundedFacturePieceJointe==null) return -1;
facturePieceJointeDao.delete(foundedFacturePieceJointe);
return 1;
}


public List<FacturePieceJointe> findByCriteria(FacturePieceJointeVo facturePieceJointeVo){

String query = "SELECT o FROM FacturePieceJointe o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",facturePieceJointeVo.getId());
            query += SearchUtil.addConstraint( "o", "name","LIKE",facturePieceJointeVo.getName());
            query += SearchUtil.addConstraint( "o", "path","LIKE",facturePieceJointeVo.getPath());
    if(facturePieceJointeVo.getFactureVo()!=null){
        query += SearchUtil.addConstraint( "o", "facture.id","=",facturePieceJointeVo.getFactureVo().getId());
            query += SearchUtil.addConstraint( "o", "facture.reference","LIKE",facturePieceJointeVo.getFactureVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findFacture(FacturePieceJointe facturePieceJointe){
        Facture loadedFacture =factureService.findByIdOrReference(facturePieceJointe.getFacture());

    if(loadedFacture==null ) {
    return;
    }
    facturePieceJointe.setFacture(loadedFacture);
    }

@Override
@Transactional
public void delete(List<FacturePieceJointe> facturePieceJointes){
if(ListUtil.isNotEmpty(facturePieceJointes)){
facturePieceJointes.forEach(e->facturePieceJointeDao.delete(e));
}
}
@Override
public void update(List<FacturePieceJointe> facturePieceJointes){
if(ListUtil.isNotEmpty(facturePieceJointes)){
facturePieceJointes.forEach(e->facturePieceJointeDao.save(e));
}
}





    }
