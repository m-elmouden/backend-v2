package com.ird.faa.service.comptable.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TauxIs;
        import com.ird.faa.bean.TauxIsConfig;
import com.ird.faa.dao.TauxIsDao;
import com.ird.faa.service.comptable.facade.TauxIsComptableService;
        import com.ird.faa.service.comptable.facade.TauxIsConfigComptableService;

import com.ird.faa.ws.rest.provided.vo.TauxIsVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TauxIsComptableServiceImpl extends AbstractServiceImpl<TauxIs> implements TauxIsComptableService {

@Autowired
private TauxIsDao tauxIsDao;

        @Autowired
        private TauxIsConfigComptableService tauxIsConfigService ;


@Autowired
private EntityManager entityManager;


@Override
public List<TauxIs> findAll(){
        return tauxIsDao.findAll();
}

        @Override
        public List<TauxIs> findByTauxIsConfigReference(String reference){
        return tauxIsDao.findByTauxIsConfigReference(reference);
        }

        @Override
        @Transactional
        public int deleteByTauxIsConfigReference(String reference){
        return tauxIsDao.deleteByTauxIsConfigReference(reference);
        }

        @Override
        public List<TauxIs> findByTauxIsConfigId(Long id){
        return tauxIsDao.findByTauxIsConfigId(id);
        }

        @Override
        @Transactional
        public int deleteByTauxIsConfigId(Long id){
        return tauxIsDao.deleteByTauxIsConfigId(id);
        }

    @Override
    public TauxIs findByReference(String reference){
    if( reference==null) return null;
    return tauxIsDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return tauxIsDao.deleteByReference(reference);
    }
    @Override
    public TauxIs findByIdOrReference(TauxIs tauxIs){
    TauxIs resultat=null;
    if(tauxIs != null){
    if(StringUtil.isNotEmpty(tauxIs.getId())){
    resultat= tauxIsDao.getOne(tauxIs.getId());
    }else if(StringUtil.isNotEmpty(tauxIs.getReference())) {
    resultat= tauxIsDao.findByReference(tauxIs.getReference());
    }
    }
    return resultat;
    }

@Override
public TauxIs findById(Long id){
if(id==null) return null;
return tauxIsDao.getOne(id);
}

@Override
public TauxIs findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(tauxIsDao.findById(id).isPresent())  {
tauxIsDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TauxIs update(TauxIs tauxIs){
TauxIs foundedTauxIs = findById(tauxIs.getId());
if(foundedTauxIs==null) return null;
else{
return  tauxIsDao.save(tauxIs);
}
}

@Override
public TauxIs save (TauxIs tauxIs){

    TauxIs result =null;
    TauxIs foundedTauxIs = findByReference(tauxIs.getReference());
    if(foundedTauxIs == null){


    findTauxIsConfig(tauxIs);

    TauxIs savedTauxIs = tauxIsDao.save(tauxIs);

    result = savedTauxIs;
    }

    return result;
}

@Override
public List<TauxIs> save(List<TauxIs> tauxIss){
List<TauxIs> list = new ArrayList<>();
for(TauxIs tauxIs: tauxIss){
list.add(save(tauxIs));
}
return list;
}



@Override
@Transactional
public int delete(TauxIs tauxIs){
    if(tauxIs.getReference()==null) return -1;

    TauxIs foundedTauxIs = findByReference(tauxIs.getReference());
    if(foundedTauxIs==null) return -1;
tauxIsDao.delete(foundedTauxIs);
return 1;
}


public List<TauxIs> findByCriteria(TauxIsVo tauxIsVo){

String query = "SELECT o FROM TauxIs o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",tauxIsVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",tauxIsVo.getReference());
            query += SearchUtil.addConstraint( "o", "resultatFiscalMin","=",tauxIsVo.getResultatFiscalMin());
            query += SearchUtil.addConstraint( "o", "resultatFiscalMax","=",tauxIsVo.getResultatFiscalMax());
            query += SearchUtil.addConstraint( "o", "pourcentage","=",tauxIsVo.getPourcentage());
            query += SearchUtil.addConstraint( "o", "penalite","=",tauxIsVo.getPenalite());
            query += SearchUtil.addConstraintMinMax("o","resultatFiscalMin",tauxIsVo.getResultatFiscalMinMin(),tauxIsVo.getResultatFiscalMinMax());
            query += SearchUtil.addConstraintMinMax("o","resultatFiscalMax",tauxIsVo.getResultatFiscalMaxMin(),tauxIsVo.getResultatFiscalMaxMax());
            query += SearchUtil.addConstraintMinMax("o","pourcentage",tauxIsVo.getPourcentageMin(),tauxIsVo.getPourcentageMax());
            query += SearchUtil.addConstraintMinMax("o","penalite",tauxIsVo.getPenaliteMin(),tauxIsVo.getPenaliteMax());
    if(tauxIsVo.getTauxIsConfigVo()!=null){
        query += SearchUtil.addConstraint( "o", "tauxIsConfig.id","=",tauxIsVo.getTauxIsConfigVo().getId());
            query += SearchUtil.addConstraint( "o", "tauxIsConfig.reference","LIKE",tauxIsVo.getTauxIsConfigVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findTauxIsConfig(TauxIs tauxIs){
        TauxIsConfig loadedTauxIsConfig =tauxIsConfigService.findByIdOrReference(tauxIs.getTauxIsConfig());

    if(loadedTauxIsConfig==null ) {
    return;
    }
    tauxIs.setTauxIsConfig(loadedTauxIsConfig);
    }

@Override
@Transactional
public void delete(List<TauxIs> tauxIss){
if(ListUtil.isNotEmpty(tauxIss)){
tauxIss.forEach(e->tauxIsDao.delete(e));
}
}
@Override
public void update(List<TauxIs> tauxIss){
if(ListUtil.isNotEmpty(tauxIss)){
tauxIss.forEach(e->tauxIsDao.save(e));
}
}





    }
