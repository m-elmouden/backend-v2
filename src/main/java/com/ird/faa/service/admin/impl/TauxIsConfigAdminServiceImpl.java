package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TauxIsConfig;
        import com.ird.faa.bean.TauxIs;
import com.ird.faa.dao.TauxIsConfigDao;
import com.ird.faa.service.admin.facade.TauxIsConfigAdminService;
        import com.ird.faa.service.admin.facade.TauxIsAdminService;

import com.ird.faa.ws.rest.provided.vo.TauxIsConfigVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.TauxIs;
        import com.ird.faa.service.admin.facade.TauxIsAdminService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TauxIsConfigAdminServiceImpl extends AbstractServiceImpl<TauxIsConfig> implements TauxIsConfigAdminService {

@Autowired
private TauxIsConfigDao tauxIsConfigDao;

        @Autowired
        private TauxIsAdminService tauxIsService ;


@Autowired
private EntityManager entityManager;


@Override
public List<TauxIsConfig> findAll(){
        String query = "SELECT o FROM TauxIsConfig o where 1=1 ";
        query+= " ORDER BY o.dateMax";
        return entityManager.createQuery(query).getResultList();
}
    @Override
    public TauxIsConfig findByReference(String reference){
    if( reference==null) return null;
    return tauxIsConfigDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return tauxIsConfigDao.deleteByReference(reference);
    }
    @Override
    public TauxIsConfig findByIdOrReference(TauxIsConfig tauxIsConfig){
    TauxIsConfig resultat=null;
    if(tauxIsConfig != null){
    if(StringUtil.isNotEmpty(tauxIsConfig.getId())){
    resultat= tauxIsConfigDao.getOne(tauxIsConfig.getId());
    }else if(StringUtil.isNotEmpty(tauxIsConfig.getReference())) {
    resultat= tauxIsConfigDao.findByReference(tauxIsConfig.getReference());
    }
    }
    return resultat;
    }

@Override
public TauxIsConfig findById(Long id){
if(id==null) return null;
return tauxIsConfigDao.getOne(id);
}

@Override
public TauxIsConfig findByIdWithAssociatedList(Long id){
    TauxIsConfig tauxIsConfig  = findById(id);
    findAssociatedLists(tauxIsConfig);
    return tauxIsConfig;
}
    private void findAssociatedLists(TauxIsConfig tauxIsConfig){
    if(tauxIsConfig!=null && tauxIsConfig.getId() != null) {
            List<TauxIs> tauxIss = tauxIsService.findByTauxIsConfigId(tauxIsConfig.getId());
            tauxIsConfig.setTauxIss(tauxIss);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            tauxIsService.deleteByTauxIsConfigId(id);
    }
    }

    private void updateAssociatedLists(TauxIsConfig tauxIsConfig){
    if(tauxIsConfig !=null && tauxIsConfig.getId() != null){
            List
            <List<TauxIs>> resultTauxIss= tauxIsService.getToBeSavedAndToBeDeleted(tauxIsService.findByTauxIsConfigId(tauxIsConfig.getId()),tauxIsConfig.getTauxIss());
            tauxIsService.delete(resultTauxIss.get(1));
            associateTauxIs(tauxIsConfig,resultTauxIss.get(0));
            tauxIsService.update(resultTauxIss.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(tauxIsConfigDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
tauxIsConfigDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TauxIsConfig update(TauxIsConfig tauxIsConfig){
TauxIsConfig foundedTauxIsConfig = findById(tauxIsConfig.getId());
if(foundedTauxIsConfig==null) return null;
else{
    updateAssociatedLists(tauxIsConfig);
return  tauxIsConfigDao.save(tauxIsConfig);
}
}

@Override
public TauxIsConfig save (TauxIsConfig tauxIsConfig){

    TauxIsConfig result =null;
    TauxIsConfig foundedTauxIsConfig = findByReference(tauxIsConfig.getReference());
    if(foundedTauxIsConfig == null){



    TauxIsConfig savedTauxIsConfig = tauxIsConfigDao.save(tauxIsConfig);

        saveTauxIss(savedTauxIsConfig,tauxIsConfig.getTauxIss());
    result = savedTauxIsConfig;
    }

    return result;
}

@Override
public List<TauxIsConfig> save(List<TauxIsConfig> tauxIsConfigs){
List<TauxIsConfig> list = new ArrayList<>();
for(TauxIsConfig tauxIsConfig: tauxIsConfigs){
list.add(save(tauxIsConfig));
}
return list;
}

        private List<TauxIs> prepareTauxIss(TauxIsConfig tauxIsConfig,List<TauxIs> tauxIss){
        for(TauxIs tauxIs:tauxIss ){
        tauxIs.setTauxIsConfig(tauxIsConfig);
        }
        return tauxIss;
        }


@Override
@Transactional
public int delete(TauxIsConfig tauxIsConfig){
    if(tauxIsConfig.getReference()==null) return -1;

    TauxIsConfig foundedTauxIsConfig = findByReference(tauxIsConfig.getReference());
    if(foundedTauxIsConfig==null) return -1;
tauxIsConfigDao.delete(foundedTauxIsConfig);
return 1;
}


public List<TauxIsConfig> findByCriteria(TauxIsConfigVo tauxIsConfigVo){

String query = "SELECT o FROM TauxIsConfig o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",tauxIsConfigVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",tauxIsConfigVo.getReference());
            query += SearchUtil.addConstraint( "o", "cotisationMinimale","=",tauxIsConfigVo.getCotisationMinimale());
        query += SearchUtil.addConstraintDate( "o", "dateMin","=",tauxIsConfigVo.getDateMin());
        query += SearchUtil.addConstraintDate( "o", "dateMax","=",tauxIsConfigVo.getDateMax());
            query += SearchUtil.addConstraintMinMax("o","cotisationMinimale",tauxIsConfigVo.getCotisationMinimaleMin(),tauxIsConfigVo.getCotisationMinimaleMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateMin",tauxIsConfigVo.getDateMinMin(),tauxIsConfigVo.getDateMinMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateMax",tauxIsConfigVo.getDateMaxMin(),tauxIsConfigVo.getDateMaxMax());
    query+= " ORDER BY o.dateMax";
return entityManager.createQuery(query).getResultList();
}
        private  void saveTauxIss(TauxIsConfig tauxIsConfig,List<TauxIs> tauxIss){

        if (ListUtil.isNotEmpty(tauxIsConfig.getTauxIss())) {
        List<TauxIs> savedTauxIss = new ArrayList<>();
        tauxIss.forEach(element -> {
        element.setTauxIsConfig(tauxIsConfig);
         tauxIsService.save(element);
        });
        tauxIsConfig.setTauxIss(savedTauxIss);
        }
        }


@Override
@Transactional
public void delete(List<TauxIsConfig> tauxIsConfigs){
if(ListUtil.isNotEmpty(tauxIsConfigs)){
tauxIsConfigs.forEach(e->tauxIsConfigDao.delete(e));
}
}
@Override
public void update(List<TauxIsConfig> tauxIsConfigs){
if(ListUtil.isNotEmpty(tauxIsConfigs)){
tauxIsConfigs.forEach(e->tauxIsConfigDao.save(e));
}
}

        private void associateTauxIs(TauxIsConfig tauxIsConfig, List<TauxIs> tauxIs) {
        if (ListUtil.isNotEmpty(tauxIs)) {
        tauxIs.forEach(e -> e.setTauxIsConfig(tauxIsConfig));
        }
        }




    }
