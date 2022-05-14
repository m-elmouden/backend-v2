package com.ird.faa.service.societe.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.ClasseComptable;
        import com.ird.faa.bean.SousClasseComptable;
import com.ird.faa.dao.ClasseComptableDao;
import com.ird.faa.service.societe.facade.ClasseComptableSocieteService;
        import com.ird.faa.service.societe.facade.SousClasseComptableSocieteService;

import com.ird.faa.ws.rest.provided.vo.ClasseComptableVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.SousClasseComptable;
        import com.ird.faa.service.societe.facade.SousClasseComptableSocieteService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ClasseComptableSocieteServiceImpl extends AbstractServiceImpl<ClasseComptable> implements ClasseComptableSocieteService {

@Autowired
private ClasseComptableDao classeComptableDao;

    @Autowired
    private ArchivableService<ClasseComptable> archivableService;
        @Autowired
        private SousClasseComptableSocieteService sousClasseComptableService ;


@Autowired
private EntityManager entityManager;


@Override
public List<ClasseComptable> findAll(){
        return classeComptableDao.findAll();
}

@Override
public ClasseComptable findById(Long id){
if(id==null) return null;
return classeComptableDao.getOne(id);
}

@Override
public ClasseComptable findByIdWithAssociatedList(Long id){
    ClasseComptable classeComptable  = findById(id);
    findAssociatedLists(classeComptable);
    return classeComptable;
}
    @Override
    public ClasseComptable archiver(ClasseComptable classeComptable) {
    if (classeComptable.getArchive() == null) {
    classeComptable.setArchive(false);
    }
    classeComptable.setArchive(true);
    classeComptable.setDateArchivage(new Date());
    classeComptableDao.save(classeComptable);
    return classeComptable;

    }

    @Override
    public ClasseComptable desarchiver(ClasseComptable classeComptable) {
    if (classeComptable.getArchive() == null) {
    classeComptable.setArchive(false);
    }
    classeComptable.setArchive(false);
    classeComptable.setDateArchivage(null);
    classeComptableDao.save(classeComptable);
    return classeComptable;
    }

    private void findAssociatedLists(ClasseComptable classeComptable){
    if(classeComptable!=null && classeComptable.getId() != null) {
            List<SousClasseComptable> sousClasseComptables = sousClasseComptableService.findByClasseComptableId(classeComptable.getId());
            classeComptable.setSousClasseComptables(sousClasseComptables);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            sousClasseComptableService.deleteByClasseComptableId(id);
    }
    }

    private void updateAssociatedLists(ClasseComptable classeComptable){
    if(classeComptable !=null && classeComptable.getId() != null){
            List
            <List<SousClasseComptable>> resultSousClasseComptables= sousClasseComptableService.getToBeSavedAndToBeDeleted(sousClasseComptableService.findByClasseComptableId(classeComptable.getId()),classeComptable.getSousClasseComptables());
            sousClasseComptableService.delete(resultSousClasseComptables.get(1));
            associateSousClasseComptable(classeComptable,resultSousClasseComptables.get(0));
            sousClasseComptableService.update(resultSousClasseComptables.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(classeComptableDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
classeComptableDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public ClasseComptable update(ClasseComptable classeComptable){
ClasseComptable foundedClasseComptable = findById(classeComptable.getId());
if(foundedClasseComptable==null) return null;
else{
    archivableService.prepare(classeComptable);
    updateAssociatedLists(classeComptable);
return  classeComptableDao.save(classeComptable);
}
}
    private void prepareSave(ClasseComptable classeComptable){
        classeComptable.setDateCreation(new Date());
                    if(classeComptable.getArchive() == null)
                classeComptable.setArchive(false);
                    if(classeComptable.getAdmin() == null)
                classeComptable.setAdmin(false);
                    if(classeComptable.getVisible() == null)
                classeComptable.setVisible(false);



    }

@Override
public ClasseComptable save (ClasseComptable classeComptable){
    prepareSave(classeComptable);

    ClasseComptable result =null;



    ClasseComptable savedClasseComptable = classeComptableDao.save(classeComptable);

        saveSousClasseComptables(savedClasseComptable,classeComptable.getSousClasseComptables());
    result = savedClasseComptable;

    return result;
}

@Override
public List<ClasseComptable> save(List<ClasseComptable> classeComptables){
List<ClasseComptable> list = new ArrayList<>();
for(ClasseComptable classeComptable: classeComptables){
list.add(save(classeComptable));
}
return list;
}

        private List<SousClasseComptable> prepareSousClasseComptables(ClasseComptable classeComptable,List<SousClasseComptable> sousClasseComptables){
        for(SousClasseComptable sousClasseComptable:sousClasseComptables ){
        sousClasseComptable.setClasseComptable(classeComptable);
        }
        return sousClasseComptables;
        }


@Override
@Transactional
public int delete(ClasseComptable classeComptable){
    if(classeComptable.getId()==null) return -1;
    ClasseComptable foundedClasseComptable = findById(classeComptable.getId());
    if(foundedClasseComptable==null) return -1;
classeComptableDao.delete(foundedClasseComptable);
return 1;
}


public List<ClasseComptable> findByCriteria(ClasseComptableVo classeComptableVo){

String query = "SELECT o FROM ClasseComptable o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",classeComptableVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",classeComptableVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "numero","=",classeComptableVo.getNumero());
            query += SearchUtil.addConstraint( "o", "archive","=",classeComptableVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",classeComptableVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",classeComptableVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",classeComptableVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",classeComptableVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",classeComptableVo.getUsername());
            query += SearchUtil.addConstraintMinMax("o","numero",classeComptableVo.getNumeroMin(),classeComptableVo.getNumeroMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",classeComptableVo.getDateArchivageMin(),classeComptableVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",classeComptableVo.getDateCreationMin(),classeComptableVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}
        private  void saveSousClasseComptables(ClasseComptable classeComptable,List<SousClasseComptable> sousClasseComptables){

        if (ListUtil.isNotEmpty(classeComptable.getSousClasseComptables())) {
        List<SousClasseComptable> savedSousClasseComptables = new ArrayList<>();
        sousClasseComptables.forEach(element -> {
        element.setClasseComptable(classeComptable);
         sousClasseComptableService.save(element);
        });
        classeComptable.setSousClasseComptables(savedSousClasseComptables);
        }
        }


@Override
@Transactional
public void delete(List<ClasseComptable> classeComptables){
if(ListUtil.isNotEmpty(classeComptables)){
classeComptables.forEach(e->classeComptableDao.delete(e));
}
}
@Override
public void update(List<ClasseComptable> classeComptables){
if(ListUtil.isNotEmpty(classeComptables)){
classeComptables.forEach(e->classeComptableDao.save(e));
}
}

        private void associateSousClasseComptable(ClasseComptable classeComptable, List<SousClasseComptable> sousClasseComptable) {
        if (ListUtil.isNotEmpty(sousClasseComptable)) {
        sousClasseComptable.forEach(e -> e.setClasseComptable(classeComptable));
        }
        }




    }
