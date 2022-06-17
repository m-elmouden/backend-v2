package com.ird.faa.service.societe.facade;

import com.ird.faa.bean.Demande;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.DemandeVo;

import java.util.List;

public interface DemandeSocieteService extends AbstractService<Demande, Long, DemandeVo> {


    /**
     * find Demande from database by reference (reference)
     *
     * @param reference - reference of Demande
     * @return the founded Demande , If no Demande were
     * found in database return  null.
     */
    Demande findByReference(String reference);

    /**
     * find Demande from database by id (PK) or reference (reference)
     *
     * @param id        - id of Demande
     * @param reference - reference of Demande
     * @return the founded Demande , If no Demande were
     * found in database return  null.
     */
    Demande findByIdOrReference(Demande demande);


    /**
     * delete Demande from database
     *
     * @param id - id of Demande to be deleted
     */
    int deleteById(Long id);


    List<Demande> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);

    List<Demande> findByComptableCode(String code);

    int deleteByComptableCode(String code);

    List<Demande> findByComptableId(Long id);

    int deleteByComptableId(Long id);

    List<Demande> findByEtatDemandeReference(String reference);

    int deleteByEtatDemandeReference(String reference);

    List<Demande> findByEtatDemandeId(Long id);

    int deleteByEtatDemandeId(Long id);


    /**
     * delete Demande from database by reference (reference)
     *
     * @param reference - reference of Demande to be deleted
     * @return 1 if Demande deleted successfully
     */
    int deleteByReference(String reference);


    Demande archiver(Demande demande);

    Demande desarchiver(Demande demande);

}
