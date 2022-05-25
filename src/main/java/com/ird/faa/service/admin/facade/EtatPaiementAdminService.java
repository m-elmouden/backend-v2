package com.ird.faa.service.admin.facade;

import com.ird.faa.bean.EtatPaiement;
import com.ird.faa.ws.rest.provided.vo.EtatPaiementVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatPaiementAdminService extends AbstractService<EtatPaiement,Long,EtatPaiementVo>{




/**
    * delete EtatPaiement from database
    * @param id - id of EtatPaiement to be deleted
    *
    */
    int deleteById(Long id);









}
