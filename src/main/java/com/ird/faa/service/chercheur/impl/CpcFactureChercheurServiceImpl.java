package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.CpcFacture;
        import com.ird.faa.bean.Cpc;
        import com.ird.faa.bean.Facture;
import com.ird.faa.dao.CpcFactureDao;
import com.ird.faa.service.chercheur.facade.CpcFactureChercheurService;
        import com.ird.faa.service.chercheur.facade.CpcChercheurService;
        import com.ird.faa.service.chercheur.facade.FactureChercheurService;

import com.ird.faa.ws.rest.provided.vo.CpcFactureVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CpcFactureChercheurServiceImpl extends AbstractServiceImpl<CpcFacture> implements CpcFactureChercheurService {

@Autowired
private CpcFactureDao cpcFactureDao;

        @Autowired
        private CpcChercheurService cpcService ;
        @Autowired
        private FactureChercheurService factureService ;


@Autowired
private EntityManager entityManager;


@Override
public List<CpcFacture> findAll(){
        return cpcFactureDao.findAll();
}

        @Override
        public List<CpcFacture> findByCpcReference(String reference){
        return cpcFactureDao.findByCpcReference(reference);
        }

        @Override
        @Transactional
        public int deleteByCpcReference(String reference){
        return cpcFactureDao.deleteByCpcReference(reference);
        }

        @Override
        public List<CpcFacture> findByCpcId(Long id){
        return cpcFactureDao.findByCpcId(id);
        }

        @Override
        @Transactional
        public int deleteByCpcId(Long id){
        return cpcFactureDao.deleteByCpcId(id);
        }


        @Override
        public List<CpcFacture> findByFactureReference(String reference){
        return cpcFactureDao.findByFactureReference(reference);
        }

        @Override
        @Transactional
        public int deleteByFactureReference(String reference){
        return cpcFactureDao.deleteByFactureReference(reference);
        }

        @Override
        public List<CpcFacture> findByFactureId(Long id){
        return cpcFactureDao.findByFactureId(id);
        }

        @Override
        @Transactional
        public int deleteByFactureId(Long id){
        return cpcFactureDao.deleteByFactureId(id);
        }


@Override
public CpcFacture findById(Long id){
if(id==null) return null;
return cpcFactureDao.getOne(id);
}

@Override
public CpcFacture findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(cpcFactureDao.findById(id).isPresent())  {
cpcFactureDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public CpcFacture update(CpcFacture cpcFacture){
CpcFacture foundedCpcFacture = findById(cpcFacture.getId());
if(foundedCpcFacture==null) return null;
else{
return  cpcFactureDao.save(cpcFacture);
}
}

@Override
public CpcFacture save (CpcFacture cpcFacture){



    findCpc(cpcFacture);
    findFacture(cpcFacture);

    return cpcFactureDao.save(cpcFacture);


}

@Override
public List<CpcFacture> save(List<CpcFacture> cpcFactures){
List<CpcFacture> list = new ArrayList<>();
for(CpcFacture cpcFacture: cpcFactures){
list.add(save(cpcFacture));
}
return list;
}



@Override
@Transactional
public int delete(CpcFacture cpcFacture){
    if(cpcFacture.getId()==null) return -1;
    CpcFacture foundedCpcFacture = findById(cpcFacture.getId());
    if(foundedCpcFacture==null) return -1;
cpcFactureDao.delete(foundedCpcFacture);
return 1;
}


public List<CpcFacture> findByCriteria(CpcFactureVo cpcFactureVo){

String query = "SELECT o FROM CpcFacture o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",cpcFactureVo.getId());
    if(cpcFactureVo.getCpcVo()!=null){
        query += SearchUtil.addConstraint( "o", "cpc.id","=",cpcFactureVo.getCpcVo().getId());
            query += SearchUtil.addConstraint( "o", "cpc.reference","LIKE",cpcFactureVo.getCpcVo().getReference());
    }

    if(cpcFactureVo.getFactureVo()!=null){
        query += SearchUtil.addConstraint( "o", "facture.id","=",cpcFactureVo.getFactureVo().getId());
            query += SearchUtil.addConstraint( "o", "facture.reference","LIKE",cpcFactureVo.getFactureVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findCpc(CpcFacture cpcFacture){
        Cpc loadedCpc =cpcService.findByIdOrReference(cpcFacture.getCpc());

    if(loadedCpc==null ) {
    return;
    }
    cpcFacture.setCpc(loadedCpc);
    }
    private void findFacture(CpcFacture cpcFacture){
        Facture loadedFacture =factureService.findByIdOrReference(cpcFacture.getFacture());

    if(loadedFacture==null ) {
    return;
    }
    cpcFacture.setFacture(loadedFacture);
    }

@Override
@Transactional
public void delete(List<CpcFacture> cpcFactures){
if(ListUtil.isNotEmpty(cpcFactures)){
cpcFactures.forEach(e->cpcFactureDao.delete(e));
}
}
@Override
public void update(List<CpcFacture> cpcFactures){
if(ListUtil.isNotEmpty(cpcFactures)){
cpcFactures.forEach(e->cpcFactureDao.save(e));
}
}





    }
