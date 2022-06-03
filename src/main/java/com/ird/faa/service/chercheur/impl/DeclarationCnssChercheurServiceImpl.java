package com.ird.faa.service.chercheur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
    import com.ird.faa.service.util.StringUtil;
    import com.ird.faa.security.common.SecurityUtil;
    import com.ird.faa.security.bean.User;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.DeclarationCnss;
        import com.ird.faa.upload.employe.model.Employe;
        import com.ird.faa.bean.Societe;
        import com.ird.faa.bean.DeclarationCnssDetail;
import com.ird.faa.dao.DeclarationCnssDao;
import com.ird.faa.service.chercheur.facade.DeclarationCnssChercheurService;
        import com.ird.faa.service.chercheur.facade.SocieteChercheurService;
        import com.ird.faa.service.chercheur.facade.EmployeChercheurService;
        import com.ird.faa.service.chercheur.facade.DeclarationCnssDetailChercheurService;

import com.ird.faa.ws.rest.provided.vo.DeclarationCnssVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class DeclarationCnssChercheurServiceImpl extends AbstractServiceImpl<DeclarationCnss> implements DeclarationCnssChercheurService {

@Autowired
private DeclarationCnssDao declarationCnssDao;

    @Autowired
    private ArchivableService<DeclarationCnss> archivableService;
        @Autowired
        private SocieteChercheurService societeService ;
        @Autowired
        private EmployeChercheurService employeService ;
        @Autowired
        private DeclarationCnssDetailChercheurService declarationCnssDetailService ;


@Autowired
private EntityManager entityManager;


@Override
public List<DeclarationCnss> findAll(){
    List<DeclarationCnss> resultat= new ArrayList();
    resultat.addAll(findAllNonArchive());
    resultat.addAll(findAllByOwner());
    return resultat;
}

        @Override
        public List<DeclarationCnss> findByEmployeCin(String cin){
        return declarationCnssDao.findByEmployeCin(cin);
        }

        @Override
        @Transactional
        public int deleteByEmployeCin(String cin){
        return declarationCnssDao.deleteByEmployeCin(cin);
        }

        @Override
        public List<DeclarationCnss> findByEmployeId(Long id){
        return declarationCnssDao.findByEmployeId(id);
        }

        @Override
        @Transactional
        public int deleteByEmployeId(Long id){
        return declarationCnssDao.deleteByEmployeId(id);
        }

        @Override
        public List<DeclarationCnss> findBySocieteId(Long id){
        return declarationCnssDao.findBySocieteId(id);
        }

        @Override
        @Transactional
        public int deleteBySocieteId(Long id){
        return declarationCnssDao.deleteBySocieteId(id);
        }

    @Override
    public DeclarationCnss findByRef(String ref){
    if( ref==null) return null;
    return declarationCnssDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String  ref) {
    return declarationCnssDao.deleteByRef(ref);
    }
    @Override
    public DeclarationCnss findByIdOrRef(DeclarationCnss declarationCnss){
    DeclarationCnss resultat=null;
    if(declarationCnss != null){
    if(StringUtil.isNotEmpty(declarationCnss.getId())){
    resultat= declarationCnssDao.getOne(declarationCnss.getId());
    }else if(StringUtil.isNotEmpty(declarationCnss.getRef())) {
    resultat= declarationCnssDao.findByRef(declarationCnss.getRef());
    }
    }
    return resultat;
    }

@Override
public DeclarationCnss findById(Long id){
if(id==null) return null;
return declarationCnssDao.getOne(id);
}

@Override
public DeclarationCnss findByIdWithAssociatedList(Long id){
    DeclarationCnss declarationCnss  = findById(id);
    findAssociatedLists(declarationCnss);
    return declarationCnss;
}
    private void findAssociatedLists(DeclarationCnss declarationCnss){
    if(declarationCnss!=null && declarationCnss.getId() != null) {
            List<DeclarationCnssDetail> declarationCnssDetails = declarationCnssDetailService.findByDeclarationCnssId(declarationCnss.getId());
            declarationCnss.setDeclarationCnssDetails(declarationCnssDetails);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            declarationCnssDetailService.deleteByDeclarationCnssId(id);
    }
    }

    private void updateAssociatedLists(DeclarationCnss declarationCnss){
    if(declarationCnss !=null && declarationCnss.getId() != null){
            List
            <List<DeclarationCnssDetail>> resultDeclarationCnssDetails= declarationCnssDetailService.getToBeSavedAndToBeDeleted(declarationCnssDetailService.findByDeclarationCnssId(declarationCnss.getId()),declarationCnss.getDeclarationCnssDetails());
            declarationCnssDetailService.delete(resultDeclarationCnssDetails.get(1));
            associateDeclarationCnssDetail(declarationCnss,resultDeclarationCnssDetails.get(0));
            declarationCnssDetailService.update(resultDeclarationCnssDetails.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(declarationCnssDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
declarationCnssDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public DeclarationCnss update(DeclarationCnss declarationCnss){
DeclarationCnss foundedDeclarationCnss = findById(declarationCnss.getId());
if(foundedDeclarationCnss==null) return null;
else{
    archivableService.prepare(declarationCnss);
    updateAssociatedLists(declarationCnss);
return  declarationCnssDao.save(declarationCnss);
}
}
    private void prepareSave(DeclarationCnss declarationCnss){
        declarationCnss.setDateCreation(new Date());
                    if(declarationCnss.getArchive() == null)
                declarationCnss.setArchive(false);
                    if(declarationCnss.getAdmin() == null)
                declarationCnss.setAdmin(false);
                    if(declarationCnss.getVisible() == null)
                declarationCnss.setVisible(false);

            declarationCnss.setAdmin(false);
            declarationCnss.setVisible(false);
            User currentUser = SecurityUtil.getCurrentUser();
            if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
            declarationCnss.setUsername(currentUser.getUsername());
            }


    }

@Override
public DeclarationCnss save (DeclarationCnss declarationCnss){
    prepareSave(declarationCnss);

    DeclarationCnss result =null;
    DeclarationCnss foundedDeclarationCnss = findByRef(declarationCnss.getRef());
    if(foundedDeclarationCnss == null){


    findEmploye(declarationCnss);
    findSociete(declarationCnss);

    DeclarationCnss savedDeclarationCnss = declarationCnssDao.save(declarationCnss);

        saveDeclarationCnssDetails(savedDeclarationCnss,declarationCnss.getDeclarationCnssDetails());
    result = savedDeclarationCnss;
    }

    return result;
}

@Override
public List<DeclarationCnss> save(List<DeclarationCnss> declarationCnsss){
List<DeclarationCnss> list = new ArrayList<>();
for(DeclarationCnss declarationCnss: declarationCnsss){
list.add(save(declarationCnss));
}
return list;
}

        private List<DeclarationCnssDetail> prepareDeclarationCnssDetails(DeclarationCnss declarationCnss,List<DeclarationCnssDetail> declarationCnssDetails){
        for(DeclarationCnssDetail declarationCnssDetail:declarationCnssDetails ){
        declarationCnssDetail.setDeclarationCnss(declarationCnss);
        }
        return declarationCnssDetails;
        }


@Override
@Transactional
public int delete(DeclarationCnss declarationCnss){
    if(declarationCnss.getRef()==null) return -1;

    DeclarationCnss foundedDeclarationCnss = findByRef(declarationCnss.getRef());
    if(foundedDeclarationCnss==null) return -1;
declarationCnssDao.delete(foundedDeclarationCnss);
return 1;
}


public List<DeclarationCnss> findByCriteria(DeclarationCnssVo declarationCnssVo){

String query = "SELECT o FROM DeclarationCnss o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",declarationCnssVo.getId());
            query += SearchUtil.addConstraint( "o", "ref","LIKE",declarationCnssVo.getRef());
            query += SearchUtil.addConstraint( "o", "salaireNet","=",declarationCnssVo.getSalaireNet());
            query += SearchUtil.addConstraint( "o", "salaireBrut","=",declarationCnssVo.getSalaireBrut());
            query += SearchUtil.addConstraint( "o", "salaireImposable","=",declarationCnssVo.getSalaireImposable());
            query += SearchUtil.addConstraint( "o", "montantTotal","=",declarationCnssVo.getMontantTotal());
            query += SearchUtil.addConstraint( "o", "mois","=",declarationCnssVo.getMois());
            query += SearchUtil.addConstraint( "o", "annee","=",declarationCnssVo.getAnnee());
            query += SearchUtil.addConstraint( "o", "archive","=",declarationCnssVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",declarationCnssVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",declarationCnssVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",declarationCnssVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",declarationCnssVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",declarationCnssVo.getUsername());
            query += SearchUtil.addConstraintMinMax("o","salaireNet",declarationCnssVo.getSalaireNetMin(),declarationCnssVo.getSalaireNetMax());
            query += SearchUtil.addConstraintMinMax("o","salaireBrut",declarationCnssVo.getSalaireBrutMin(),declarationCnssVo.getSalaireBrutMax());
            query += SearchUtil.addConstraintMinMax("o","salaireImposable",declarationCnssVo.getSalaireImposableMin(),declarationCnssVo.getSalaireImposableMax());
            query += SearchUtil.addConstraintMinMax("o","montantTotal",declarationCnssVo.getMontantTotalMin(),declarationCnssVo.getMontantTotalMax());
            query += SearchUtil.addConstraintMinMax("o","mois",declarationCnssVo.getMoisMin(),declarationCnssVo.getMoisMax());
            query += SearchUtil.addConstraintMinMax("o","annee",declarationCnssVo.getAnneeMin(),declarationCnssVo.getAnneeMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",declarationCnssVo.getDateArchivageMin(),declarationCnssVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",declarationCnssVo.getDateCreationMin(),declarationCnssVo.getDateCreationMax());
    if(declarationCnssVo.getEmployeVo()!=null){
        query += SearchUtil.addConstraint( "o", "employe.id","=",declarationCnssVo.getEmployeVo().getId());
            query += SearchUtil.addConstraint( "o", "employe.cin","LIKE",declarationCnssVo.getEmployeVo().getCin());
    }

    if(declarationCnssVo.getSocieteVo()!=null){
        query += SearchUtil.addConstraint( "o", "societe.id","=",declarationCnssVo.getSocieteVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}
        private  void saveDeclarationCnssDetails(DeclarationCnss declarationCnss,List<DeclarationCnssDetail> declarationCnssDetails){

        if (ListUtil.isNotEmpty(declarationCnss.getDeclarationCnssDetails())) {
        List<DeclarationCnssDetail> savedDeclarationCnssDetails = new ArrayList<>();
        declarationCnssDetails.forEach(element -> {
        element.setDeclarationCnss(declarationCnss);
         declarationCnssDetailService.save(element);
        });
        declarationCnss.setDeclarationCnssDetails(savedDeclarationCnssDetails);
        }
        }

    private void findEmploye(DeclarationCnss declarationCnss){
        Employe loadedEmploye =employeService.findByIdOrCin(declarationCnss.getEmploye());

    if(loadedEmploye==null ) {
    return;
    }
    declarationCnss.setEmploye(loadedEmploye);
    }
    private void findSociete(DeclarationCnss declarationCnss){
        Societe loadedSociete = null;
        if(declarationCnss.getSociete() != null && declarationCnss.getSociete().getId() !=null)
        loadedSociete =societeService.findById(declarationCnss.getSociete().getId());

    if(loadedSociete==null ) {
    return;
    }
    declarationCnss.setSociete(loadedSociete);
    }

@Override
@Transactional
public void delete(List<DeclarationCnss> declarationCnsss){
if(ListUtil.isNotEmpty(declarationCnsss)){
declarationCnsss.forEach(e->declarationCnssDao.delete(e));
}
}
@Override
public void update(List<DeclarationCnss> declarationCnsss){
if(ListUtil.isNotEmpty(declarationCnsss)){
declarationCnsss.forEach(e->declarationCnssDao.save(e));
}
}

        private void associateDeclarationCnssDetail(DeclarationCnss declarationCnss, List<DeclarationCnssDetail> declarationCnssDetail) {
        if (ListUtil.isNotEmpty(declarationCnssDetail)) {
        declarationCnssDetail.forEach(e -> e.setDeclarationCnss(declarationCnss));
        }
        }



        public List<DeclarationCnss> findAllNonArchive(){
        String query = "SELECT o FROM DeclarationCnss o  WHERE o.archive != true AND o.visible = true";
        return entityManager.createQuery(query).getResultList();
        }

        public List<DeclarationCnss> findAllByOwner(){
        List<DeclarationCnss> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM DeclarationCnss o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }
