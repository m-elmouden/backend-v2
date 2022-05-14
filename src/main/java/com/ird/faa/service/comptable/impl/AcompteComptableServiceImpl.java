package com.ird.faa.service.comptable.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Acompte;
        import com.ird.faa.bean.Societe;
import com.ird.faa.dao.AcompteDao;
import com.ird.faa.service.comptable.facade.AcompteComptableService;
        import com.ird.faa.service.comptable.facade.SocieteComptableService;

import com.ird.faa.ws.rest.provided.vo.AcompteVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class AcompteComptableServiceImpl extends AbstractServiceImpl<Acompte> implements AcompteComptableService {

@Autowired
private AcompteDao acompteDao;

    @Autowired
    private ArchivableService<Acompte> archivableService;
        @Autowired
        private SocieteComptableService societeService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Acompte> findAll(){
        return acompteDao.findAll();
}
        @Override
        public List<Acompte> findBySocieteId(Long id){
        return acompteDao.findBySocieteId(id);
        }

        @Override
        @Transactional
        public int deleteBySocieteId(Long id){
        return acompteDao.deleteBySocieteId(id);
        }


@Override
public Acompte findById(Long id){
if(id==null) return null;
return acompteDao.getOne(id);
}

@Override
public Acompte findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public Acompte archiver(Acompte acompte) {
    if (acompte.getArchive() == null) {
    acompte.setArchive(false);
    }
    acompte.setArchive(true);
    acompte.setDateArchivage(new Date());
    acompteDao.save(acompte);
    return acompte;

    }

    @Override
    public Acompte desarchiver(Acompte acompte) {
    if (acompte.getArchive() == null) {
    acompte.setArchive(false);
    }
    acompte.setArchive(false);
    acompte.setDateArchivage(null);
    acompteDao.save(acompte);
    return acompte;
    }



@Transactional
public int deleteById(Long id){
int res=0;
if(acompteDao.findById(id).isPresent())  {
acompteDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Acompte update(Acompte acompte){
Acompte foundedAcompte = findById(acompte.getId());
if(foundedAcompte==null) return null;
else{
    archivableService.prepare(acompte);
return  acompteDao.save(acompte);
}
}
    private void prepareSave(Acompte acompte){
        acompte.setDateCreation(new Date());
                    if(acompte.getArchive() == null)
                acompte.setArchive(false);
                    if(acompte.getAdmin() == null)
                acompte.setAdmin(false);
                    if(acompte.getVisible() == null)
                acompte.setVisible(false);



    }

@Override
public Acompte save (Acompte acompte){
    prepareSave(acompte);



    findSociete(acompte);

    return acompteDao.save(acompte);


}

@Override
public List<Acompte> save(List<Acompte> acomptes){
List<Acompte> list = new ArrayList<>();
for(Acompte acompte: acomptes){
list.add(save(acompte));
}
return list;
}



@Override
@Transactional
public int delete(Acompte acompte){
    if(acompte.getId()==null) return -1;
    Acompte foundedAcompte = findById(acompte.getId());
    if(foundedAcompte==null) return -1;
acompteDao.delete(foundedAcompte);
return 1;
}


public List<Acompte> findByCriteria(AcompteVo acompteVo){

String query = "SELECT o FROM Acompte o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",acompteVo.getId());
            query += SearchUtil.addConstraint( "o", "numero","=",acompteVo.getNumero());
            query += SearchUtil.addConstraint( "o", "annee","=",acompteVo.getAnnee());
            query += SearchUtil.addConstraint( "o", "montant","=",acompteVo.getMontant());
            query += SearchUtil.addConstraint( "o", "archive","=",acompteVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",acompteVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",acompteVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",acompteVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",acompteVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",acompteVo.getUsername());
            query += SearchUtil.addConstraintMinMax("o","numero",acompteVo.getNumeroMin(),acompteVo.getNumeroMax());
            query += SearchUtil.addConstraintMinMax("o","annee",acompteVo.getAnneeMin(),acompteVo.getAnneeMax());
            query += SearchUtil.addConstraintMinMax("o","montant",acompteVo.getMontantMin(),acompteVo.getMontantMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",acompteVo.getDateArchivageMin(),acompteVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",acompteVo.getDateCreationMin(),acompteVo.getDateCreationMax());
    if(acompteVo.getSocieteVo()!=null){
        query += SearchUtil.addConstraint( "o", "societe.id","=",acompteVo.getSocieteVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findSociete(Acompte acompte){
        Societe loadedSociete = null;
        if(acompte.getSociete() != null && acompte.getSociete().getId() !=null)
        loadedSociete =societeService.findById(acompte.getSociete().getId());

    if(loadedSociete==null ) {
    return;
    }
    acompte.setSociete(loadedSociete);
    }

@Override
@Transactional
public void delete(List<Acompte> acomptes){
if(ListUtil.isNotEmpty(acomptes)){
acomptes.forEach(e->acompteDao.delete(e));
}
}
@Override
public void update(List<Acompte> acomptes){
if(ListUtil.isNotEmpty(acomptes)){
acomptes.forEach(e->acompteDao.save(e));
}
}





    }
