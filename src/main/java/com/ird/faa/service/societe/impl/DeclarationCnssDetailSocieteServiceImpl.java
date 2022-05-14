package com.ird.faa.service.societe.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.DeclarationCnssDetail;
        import com.ird.faa.bean.TypeTauxCnss;
        import com.ird.faa.bean.DeclarationCnss;
import com.ird.faa.dao.DeclarationCnssDetailDao;
import com.ird.faa.service.societe.facade.DeclarationCnssDetailSocieteService;
        import com.ird.faa.service.societe.facade.TypeTauxCnssSocieteService;
        import com.ird.faa.service.societe.facade.DeclarationCnssSocieteService;

import com.ird.faa.ws.rest.provided.vo.DeclarationCnssDetailVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class DeclarationCnssDetailSocieteServiceImpl extends AbstractServiceImpl<DeclarationCnssDetail> implements DeclarationCnssDetailSocieteService {

@Autowired
private DeclarationCnssDetailDao declarationCnssDetailDao;

    @Autowired
    private ArchivableService<DeclarationCnssDetail> archivableService;
        @Autowired
        private TypeTauxCnssSocieteService typeTauxCnssService ;
        @Autowired
        private DeclarationCnssSocieteService declarationCnssService ;


@Autowired
private EntityManager entityManager;


@Override
public List<DeclarationCnssDetail> findAll(){
        return declarationCnssDetailDao.findAll();
}
        @Override
        public List<DeclarationCnssDetail> findByTypeTauxCnssId(Long id){
        return declarationCnssDetailDao.findByTypeTauxCnssId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeTauxCnssId(Long id){
        return declarationCnssDetailDao.deleteByTypeTauxCnssId(id);
        }


        @Override
        public List<DeclarationCnssDetail> findByDeclarationCnssRef(String ref){
        return declarationCnssDetailDao.findByDeclarationCnssRef(ref);
        }

        @Override
        @Transactional
        public int deleteByDeclarationCnssRef(String ref){
        return declarationCnssDetailDao.deleteByDeclarationCnssRef(ref);
        }

        @Override
        public List<DeclarationCnssDetail> findByDeclarationCnssId(Long id){
        return declarationCnssDetailDao.findByDeclarationCnssId(id);
        }

        @Override
        @Transactional
        public int deleteByDeclarationCnssId(Long id){
        return declarationCnssDetailDao.deleteByDeclarationCnssId(id);
        }

    @Override
    public DeclarationCnssDetail findByRef(String ref){
    if( ref==null) return null;
    return declarationCnssDetailDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String  ref) {
    return declarationCnssDetailDao.deleteByRef(ref);
    }
    @Override
    public DeclarationCnssDetail findByIdOrRef(DeclarationCnssDetail declarationCnssDetail){
    DeclarationCnssDetail resultat=null;
    if(declarationCnssDetail != null){
    if(StringUtil.isNotEmpty(declarationCnssDetail.getId())){
    resultat= declarationCnssDetailDao.getOne(declarationCnssDetail.getId());
    }else if(StringUtil.isNotEmpty(declarationCnssDetail.getRef())) {
    resultat= declarationCnssDetailDao.findByRef(declarationCnssDetail.getRef());
    }
    }
    return resultat;
    }

@Override
public DeclarationCnssDetail findById(Long id){
if(id==null) return null;
return declarationCnssDetailDao.getOne(id);
}

@Override
public DeclarationCnssDetail findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public DeclarationCnssDetail archiver(DeclarationCnssDetail declarationCnssDetail) {
    if (declarationCnssDetail.getArchive() == null) {
    declarationCnssDetail.setArchive(false);
    }
    declarationCnssDetail.setArchive(true);
    declarationCnssDetail.setDateArchivage(new Date());
    declarationCnssDetailDao.save(declarationCnssDetail);
    return declarationCnssDetail;

    }

    @Override
    public DeclarationCnssDetail desarchiver(DeclarationCnssDetail declarationCnssDetail) {
    if (declarationCnssDetail.getArchive() == null) {
    declarationCnssDetail.setArchive(false);
    }
    declarationCnssDetail.setArchive(false);
    declarationCnssDetail.setDateArchivage(null);
    declarationCnssDetailDao.save(declarationCnssDetail);
    return declarationCnssDetail;
    }



@Transactional
public int deleteById(Long id){
int res=0;
if(declarationCnssDetailDao.findById(id).isPresent())  {
declarationCnssDetailDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public DeclarationCnssDetail update(DeclarationCnssDetail declarationCnssDetail){
DeclarationCnssDetail foundedDeclarationCnssDetail = findById(declarationCnssDetail.getId());
if(foundedDeclarationCnssDetail==null) return null;
else{
    archivableService.prepare(declarationCnssDetail);
return  declarationCnssDetailDao.save(declarationCnssDetail);
}
}
    private void prepareSave(DeclarationCnssDetail declarationCnssDetail){
        declarationCnssDetail.setDateCreation(new Date());
                    if(declarationCnssDetail.getArchive() == null)
                declarationCnssDetail.setArchive(false);
                    if(declarationCnssDetail.getAdmin() == null)
                declarationCnssDetail.setAdmin(false);
                    if(declarationCnssDetail.getVisible() == null)
                declarationCnssDetail.setVisible(false);



    }

@Override
public DeclarationCnssDetail save (DeclarationCnssDetail declarationCnssDetail){
    prepareSave(declarationCnssDetail);

    DeclarationCnssDetail result =null;
    DeclarationCnssDetail foundedDeclarationCnssDetail = findByRef(declarationCnssDetail.getRef());
    if(foundedDeclarationCnssDetail == null){


    findTypeTauxCnss(declarationCnssDetail);
    findDeclarationCnss(declarationCnssDetail);

    DeclarationCnssDetail savedDeclarationCnssDetail = declarationCnssDetailDao.save(declarationCnssDetail);

    result = savedDeclarationCnssDetail;
    }

    return result;
}

@Override
public List<DeclarationCnssDetail> save(List<DeclarationCnssDetail> declarationCnssDetails){
List<DeclarationCnssDetail> list = new ArrayList<>();
for(DeclarationCnssDetail declarationCnssDetail: declarationCnssDetails){
list.add(save(declarationCnssDetail));
}
return list;
}



@Override
@Transactional
public int delete(DeclarationCnssDetail declarationCnssDetail){
    if(declarationCnssDetail.getRef()==null) return -1;

    DeclarationCnssDetail foundedDeclarationCnssDetail = findByRef(declarationCnssDetail.getRef());
    if(foundedDeclarationCnssDetail==null) return -1;
declarationCnssDetailDao.delete(foundedDeclarationCnssDetail);
return 1;
}


public List<DeclarationCnssDetail> findByCriteria(DeclarationCnssDetailVo declarationCnssDetailVo){

String query = "SELECT o FROM DeclarationCnssDetail o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",declarationCnssDetailVo.getId());
            query += SearchUtil.addConstraint( "o", "ref","LIKE",declarationCnssDetailVo.getRef());
            query += SearchUtil.addConstraint( "o", "montantCalcule","=",declarationCnssDetailVo.getMontantCalcule());
            query += SearchUtil.addConstraint( "o", "montantTotal","=",declarationCnssDetailVo.getMontantTotal());
            query += SearchUtil.addConstraint( "o", "archive","=",declarationCnssDetailVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",declarationCnssDetailVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",declarationCnssDetailVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",declarationCnssDetailVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",declarationCnssDetailVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",declarationCnssDetailVo.getUsername());
            query += SearchUtil.addConstraintMinMax("o","montantCalcule",declarationCnssDetailVo.getMontantCalculeMin(),declarationCnssDetailVo.getMontantCalculeMax());
            query += SearchUtil.addConstraintMinMax("o","montantTotal",declarationCnssDetailVo.getMontantTotalMin(),declarationCnssDetailVo.getMontantTotalMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",declarationCnssDetailVo.getDateArchivageMin(),declarationCnssDetailVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",declarationCnssDetailVo.getDateCreationMin(),declarationCnssDetailVo.getDateCreationMax());
    if(declarationCnssDetailVo.getTypeTauxCnssVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeTauxCnss.id","=",declarationCnssDetailVo.getTypeTauxCnssVo().getId());
    }

    if(declarationCnssDetailVo.getDeclarationCnssVo()!=null){
        query += SearchUtil.addConstraint( "o", "declarationCnss.id","=",declarationCnssDetailVo.getDeclarationCnssVo().getId());
            query += SearchUtil.addConstraint( "o", "declarationCnss.ref","LIKE",declarationCnssDetailVo.getDeclarationCnssVo().getRef());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findTypeTauxCnss(DeclarationCnssDetail declarationCnssDetail){
        TypeTauxCnss loadedTypeTauxCnss = null;
        if(declarationCnssDetail.getTypeTauxCnss() != null && declarationCnssDetail.getTypeTauxCnss().getId() !=null)
        loadedTypeTauxCnss =typeTauxCnssService.findById(declarationCnssDetail.getTypeTauxCnss().getId());

    if(loadedTypeTauxCnss==null ) {
    return;
    }
    declarationCnssDetail.setTypeTauxCnss(loadedTypeTauxCnss);
    }
    private void findDeclarationCnss(DeclarationCnssDetail declarationCnssDetail){
        DeclarationCnss loadedDeclarationCnss =declarationCnssService.findByIdOrRef(declarationCnssDetail.getDeclarationCnss());

    if(loadedDeclarationCnss==null ) {
    return;
    }
    declarationCnssDetail.setDeclarationCnss(loadedDeclarationCnss);
    }

@Override
@Transactional
public void delete(List<DeclarationCnssDetail> declarationCnssDetails){
if(ListUtil.isNotEmpty(declarationCnssDetails)){
declarationCnssDetails.forEach(e->declarationCnssDetailDao.delete(e));
}
}
@Override
public void update(List<DeclarationCnssDetail> declarationCnssDetails){
if(ListUtil.isNotEmpty(declarationCnssDetails)){
declarationCnssDetails.forEach(e->declarationCnssDetailDao.save(e));
}
}





    }
