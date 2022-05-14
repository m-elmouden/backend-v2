package com.ird.faa.service.societe.facade;

import java.util.List;
import com.ird.faa.bean.Commentaire;
import com.ird.faa.ws.rest.provided.vo.CommentaireVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CommentaireSocieteService extends AbstractService<Commentaire,Long,CommentaireVo>{




/**
    * delete Commentaire from database
    * @param id - id of Commentaire to be deleted
    *
    */
    int deleteById(Long id);


    List<Commentaire> findByDemandeReference(String reference);

    int deleteByDemandeReference(String reference);

    List<Commentaire> findByDemandeId(Long id);

    int deleteByDemandeId(Long id);







}
