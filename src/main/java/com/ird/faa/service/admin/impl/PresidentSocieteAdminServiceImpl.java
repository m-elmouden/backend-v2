package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PresidentSociete;
        import com.ird.faa.bean.Societe;
import com.ird.faa.dao.PresidentSocieteDao;
import com.ird.faa.service.admin.facade.PresidentSocieteAdminService;
        import com.ird.faa.service.admin.facade.SocieteAdminService;

import com.ird.faa.ws.rest.provided.vo.PresidentSocieteVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PresidentSocieteAdminServiceImpl extends AbstractServiceImpl<PresidentSociete> implements PresidentSocieteAdminService {

@Autowired
private PresidentSocieteDao presidentSocieteDao;

        @Autowired
        private SocieteAdminService societeService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PresidentSociete> findAll(){
        return presidentSocieteDao.findAll();
}
        @Override
        public List<PresidentSociete> findBySocieteId(Long id){
        return presidentSocieteDao.findBySocieteId(id);
        }

        @Override
        @Transactional
        public int deleteBySocieteId(Long id){
        return presidentSocieteDao.deleteBySocieteId(id);
        }


@Override
public PresidentSociete findById(Long id){
if(id==null) return null;
return presidentSocieteDao.getOne(id);
}

@Override
public PresidentSociete findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(presidentSocieteDao.findById(id).isPresent())  {
presidentSocieteDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PresidentSociete update(PresidentSociete presidentSociete){
PresidentSociete foundedPresidentSociete = findById(presidentSociete.getId());
if(foundedPresidentSociete==null) return null;
else{
return  presidentSocieteDao.save(presidentSociete);
}
}

@Override
public PresidentSociete save (PresidentSociete presidentSociete){



    findSociete(presidentSociete);

    return presidentSocieteDao.save(presidentSociete);


}

@Override
public List<PresidentSociete> save(List<PresidentSociete> presidentSocietes){
List<PresidentSociete> list = new ArrayList<>();
for(PresidentSociete presidentSociete: presidentSocietes){
list.add(save(presidentSociete));
}
return list;
}



@Override
@Transactional
public int delete(PresidentSociete presidentSociete){
    if(presidentSociete.getId()==null) return -1;
    PresidentSociete foundedPresidentSociete = findById(presidentSociete.getId());
    if(foundedPresidentSociete==null) return -1;
presidentSocieteDao.delete(foundedPresidentSociete);
return 1;
}


public List<PresidentSociete> findByCriteria(PresidentSocieteVo presidentSocieteVo){

String query = "SELECT o FROM PresidentSociete o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",presidentSocieteVo.getId());
            query += SearchUtil.addConstraint( "o", "cin","LIKE",presidentSocieteVo.getCin());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",presidentSocieteVo.getNom());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",presidentSocieteVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "email","LIKE",presidentSocieteVo.getEmail());
            query += SearchUtil.addConstraint( "o", "telephone","LIKE",presidentSocieteVo.getTelephone());
    if(presidentSocieteVo.getSocieteVo()!=null){
        query += SearchUtil.addConstraint( "o", "societe.id","=",presidentSocieteVo.getSocieteVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findSociete(PresidentSociete presidentSociete){
        Societe loadedSociete = null;
        if(presidentSociete.getSociete() != null && presidentSociete.getSociete().getId() !=null)
        loadedSociete =societeService.findById(presidentSociete.getSociete().getId());

    if(loadedSociete==null ) {
    return;
    }
    presidentSociete.setSociete(loadedSociete);
    }

@Override
@Transactional
public void delete(List<PresidentSociete> presidentSocietes){
if(ListUtil.isNotEmpty(presidentSocietes)){
presidentSocietes.forEach(e->presidentSocieteDao.delete(e));
}
}
@Override
public void update(List<PresidentSociete> presidentSocietes){
if(ListUtil.isNotEmpty(presidentSocietes)){
presidentSocietes.forEach(e->presidentSocieteDao.save(e));
}
}





    }
