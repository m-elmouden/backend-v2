package com.ird.faa.service.societe.facade;

import com.ird.faa.bean.EtatPaiement;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.EtatPaiementVo;

public interface EtatPaiementSocieteService extends AbstractService<EtatPaiement, Long, EtatPaiementVo> {


    /**
     * delete EtatPaiement from database
     *
     * @param id - id of EtatPaiement to be deleted
     */
    int deleteById(Long id);


}
