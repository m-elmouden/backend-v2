package com.ird.faa.service.comptable.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Employe;
        import com.ird.faa.bean.TypeEmploye;
        import com.ird.faa.bean.Societe;
        import com.ird.faa.bean.DeclarationCnss;
import com.ird.faa.dao.EmployeDao;
import com.ird.faa.service.comptable.facade.EmployeComptableService;
        import com.ird.faa.service.comptable.facade.SocieteComptableService;
        import com.ird.faa.service.comptable.facade.DeclarationCnssComptableService;
        import com.ird.faa.service.comptable.facade.TypeEmployeComptableService;

import com.ird.faa.ws.rest.provided.vo.EmployeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EmployeComptableServiceImpl extends AbstractServiceImpl<Employe> implements EmployeComptableService {

@Autowired
private EmployeDao employeDao;

        @Autowired
        private SocieteComptableService societeService ;
        @Autowired
        private DeclarationCnssComptableService declarationCnssService ;
        @Autowired
        private TypeEmployeComptableService typeEmployeService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Employe> findAll(){
        return employeDao.findAll();
}

        @Override
        public List<Employe> findByTypeEmployeCode(String code){
        return employeDao.findByTypeEmployeCode(code);
        }

        @Override
        @Transactional
        public int deleteByTypeEmployeCode(String code){
        return employeDao.deleteByTypeEmployeCode(code);
        }

        @Override
        public List<Employe> findByTypeEmployeId(Long id){
        return employeDao.findByTypeEmployeId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeEmployeId(Long id){
        return employeDao.deleteByTypeEmployeId(id);
        }

        @Override
        public List<Employe> findBySocieteId(Long id){
        return employeDao.findBySocieteId(id);
        }

        @Override
        @Transactional
        public int deleteBySocieteId(Long id){
        return employeDao.deleteBySocieteId(id);
        }


        @Override
        public List<Employe> findByDeclarationCnssRef(String ref){
        return employeDao.findByDeclarationCnssRef(ref);
        }

        @Override
        @Transactional
        public int deleteByDeclarationCnssRef(String ref){
        return employeDao.deleteByDeclarationCnssRef(ref);
        }

        @Override
        public List<Employe> findByDeclarationCnssId(Long id){
        return employeDao.findByDeclarationCnssId(id);
        }

        @Override
        @Transactional
        public int deleteByDeclarationCnssId(Long id){
        return employeDao.deleteByDeclarationCnssId(id);
        }

    @Override
    public Employe findByCin(String cin){
    if( cin==null) return null;
    return employeDao.findByCin(cin);
    }

    @Override
    @Transactional
    public int deleteByCin(String  cin) {
    return employeDao.deleteByCin(cin);
    }
    @Override
    public Employe findByIdOrCin(Employe employe){
    Employe resultat=null;
    if(employe != null){
    if(StringUtil.isNotEmpty(employe.getId())){
    resultat= employeDao.getOne(employe.getId());
    }else if(StringUtil.isNotEmpty(employe.getCin())) {
    resultat= employeDao.findByCin(employe.getCin());
    }
    }
    return resultat;
    }

@Override
public Employe findById(Long id){
if(id==null) return null;
return employeDao.getOne(id);
}

@Override
public Employe findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(employeDao.findById(id).isPresent())  {
employeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Employe update(Employe employe){
Employe foundedEmploye = findById(employe.getId());
if(foundedEmploye==null) return null;
else{
return  employeDao.save(employe);
}
}

@Override
public Employe save (Employe employe){

    Employe result =null;
    Employe foundedEmploye = findByCin(employe.getCin());
    if(foundedEmploye == null){


    findTypeEmploye(employe);
    findSociete(employe);
    findDeclarationCnss(employe);

    Employe savedEmploye = employeDao.save(employe);

    result = savedEmploye;
    }

    return result;
}

@Override
public List<Employe> save(List<Employe> employes){
List<Employe> list = new ArrayList<>();
for(Employe employe: employes){
list.add(save(employe));
}
return list;
}



@Override
@Transactional
public int delete(Employe employe){
    if(employe.getCin()==null) return -1;

    Employe foundedEmploye = findByCin(employe.getCin());
    if(foundedEmploye==null) return -1;
employeDao.delete(foundedEmploye);
return 1;
}


public List<Employe> findByCriteria(EmployeVo employeVo){

String query = "SELECT o FROM Employe o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",employeVo.getId());
            query += SearchUtil.addConstraint( "o", "cin","LIKE",employeVo.getCin());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",employeVo.getNom());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",employeVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "totalSalaireNet","=",employeVo.getTotalSalaireNet());
            query += SearchUtil.addConstraint( "o", "nombreFamille","=",employeVo.getNombreFamille());
            query += SearchUtil.addConstraintMinMax("o","totalSalaireNet",employeVo.getTotalSalaireNetMin(),employeVo.getTotalSalaireNetMax());
            query += SearchUtil.addConstraintMinMax("o","nombreFamille",employeVo.getNombreFamilleMin(),employeVo.getNombreFamilleMax());
    if(employeVo.getTypeEmployeVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeEmploye.id","=",employeVo.getTypeEmployeVo().getId());
            query += SearchUtil.addConstraint( "o", "typeEmploye.code","LIKE",employeVo.getTypeEmployeVo().getCode());
    }

    if(employeVo.getSocieteVo()!=null){
        query += SearchUtil.addConstraint( "o", "societe.id","=",employeVo.getSocieteVo().getId());
    }

    if(employeVo.getDeclarationCnssVo()!=null){
        query += SearchUtil.addConstraint( "o", "declarationCnss.id","=",employeVo.getDeclarationCnssVo().getId());
            query += SearchUtil.addConstraint( "o", "declarationCnss.ref","LIKE",employeVo.getDeclarationCnssVo().getRef());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findTypeEmploye(Employe employe){
        TypeEmploye loadedTypeEmploye =typeEmployeService.findByIdOrCode(employe.getTypeEmploye());

    if(loadedTypeEmploye==null ) {
    return;
    }
    employe.setTypeEmploye(loadedTypeEmploye);
    }
    private void findSociete(Employe employe){
        Societe loadedSociete = null;
        if(employe.getSociete() != null && employe.getSociete().getId() !=null)
        loadedSociete =societeService.findById(employe.getSociete().getId());

    if(loadedSociete==null ) {
    return;
    }
    employe.setSociete(loadedSociete);
    }
    private void findDeclarationCnss(Employe employe){
        DeclarationCnss loadedDeclarationCnss =declarationCnssService.findByIdOrRef(employe.getDeclarationCnss());

    if(loadedDeclarationCnss==null ) {
    return;
    }
    employe.setDeclarationCnss(loadedDeclarationCnss);
    }

@Override
@Transactional
public void delete(List<Employe> employes){
if(ListUtil.isNotEmpty(employes)){
employes.forEach(e->employeDao.delete(e));
}
}
@Override
public void update(List<Employe> employes){
if(ListUtil.isNotEmpty(employes)){
employes.forEach(e->employeDao.save(e));
}
}





    }
