package com.ird.faa.service.societe.facade;

import java.util.List;
import com.ird.faa.bean.Employe;
import com.ird.faa.ws.rest.provided.vo.EmployeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EmployeSocieteService extends AbstractService<Employe,Long,EmployeVo>{


    /**
    * find Employe from database by cin (reference)
    * @param cin - reference of Employe
    * @return the founded Employe , If no Employe were
    *         found in database return  null.
    */
    Employe findByCin(String cin);

    /**
    * find Employe from database by id (PK) or cin (reference)
    * @param id - id of Employe
    * @param cin - reference of Employe
    * @return the founded Employe , If no Employe were
    *         found in database return  null.
    */
    Employe findByIdOrCin(Employe employe);


/**
    * delete Employe from database
    * @param id - id of Employe to be deleted
    *
    */
    int deleteById(Long id);


    List<Employe> findByTypeEmployeCode(String code);

    int deleteByTypeEmployeCode(String code);

    List<Employe> findByTypeEmployeId(Long id);

    int deleteByTypeEmployeId(Long id);

    List<Employe> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);
    List<Employe> findByDeclarationCnssRef(String ref);

    int deleteByDeclarationCnssRef(String ref);

    List<Employe> findByDeclarationCnssId(Long id);

    int deleteByDeclarationCnssId(Long id);


    /**
    * delete Employe from database by cin (reference)
    *
    * @param cin - reference of Employe to be deleted
    * @return 1 if Employe deleted successfully
    */
    int deleteByCin(String cin);





}
