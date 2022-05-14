package com.ird.faa.service.admin.facade;

import java.math.BigDecimal;
import java.util.List;
import com.ird.faa.bean.Facture;
import com.ird.faa.ws.rest.provided.vo.FactureVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface FactureAdminService extends AbstractService<Facture,Long,FactureVo>{


    /**
    * find Facture from database by reference (reference)
    * @param reference - reference of Facture
    * @return the founded Facture , If no Facture were
    *         found in database return  null.
    */
    Facture findByReference(String reference);

    /**
    * find Facture from database by id (PK) or reference (reference)
    * @param id - id of Facture
    * @param reference - reference of Facture
    * @return the founded Facture , If no Facture were
    *         found in database return  null.
    */
    Facture findByIdOrReference(Facture facture);


/**
    * delete Facture from database
    * @param id - id of Facture to be deleted
    *
    */
    int deleteById(Long id);


    List<Facture> findByTvaReference(String reference);

    int deleteByTvaReference(String reference);

    List<Facture> findByTvaId(Long id);

    int deleteByTvaId(Long id);

    List<Facture> findByTypeOperationFactureId(Long id);

    int deleteByTypeOperationFactureId(Long id);

    List<Facture> findByEtatFactureId(Long id);

    int deleteByEtatFactureId(Long id);

    List<Facture> findByEtatPaiementId(Long id);

    int deleteByEtatPaiementId(Long id);

    List<Facture> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);
    List<Facture> findByCompteComptableNumero(BigDecimal numero);

    int deleteByCompteComptableNumero(BigDecimal numero);

    List<Facture> findByCompteComptableId(Long id);

    int deleteByCompteComptableId(Long id);
    List<Facture> findByDeclarationIsReference(String reference);

    int deleteByDeclarationIsReference(String reference);

    List<Facture> findByDeclarationIsId(Long id);

    int deleteByDeclarationIsId(Long id);
    List<Facture> findByDeclarationTvaReference(String reference);

    int deleteByDeclarationTvaReference(String reference);

    List<Facture> findByDeclarationTvaId(Long id);

    int deleteByDeclarationTvaId(Long id);
    List<Facture> findByDemandeReference(String reference);

    int deleteByDemandeReference(String reference);

    List<Facture> findByDemandeId(Long id);

    int deleteByDemandeId(Long id);

    List<Facture> findByClasseComptableId(Long id);

    int deleteByClasseComptableId(Long id);

    List<Facture> findByCpcFactureId(Long id);

    int deleteByCpcFactureId(Long id);


    /**
    * delete Facture from database by reference (reference)
    *
    * @param reference - reference of Facture to be deleted
    * @return 1 if Facture deleted successfully
    */
    int deleteByReference(String reference);




    Facture archiver(Facture facture) ;
    Facture desarchiver(Facture facture);

}
