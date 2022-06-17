package com.ird.faa.service.admin.facade;

import com.ird.faa.bean.Commentaire;
import com.ird.faa.service.core.facade.AbstractService;
import com.ird.faa.ws.rest.provided.vo.CommentaireVo;

import java.util.List;

public interface CommentaireAdminService extends AbstractService<Commentaire, Long, CommentaireVo> {


    /**
     * delete Commentaire from database
     *
     * @param id - id of Commentaire to be deleted
     */
    int deleteById(Long id);


    List<Commentaire> findByDemandeReference(String reference);

    int deleteByDemandeReference(String reference);

    List<Commentaire> findByDemandeId(Long id);

    int deleteByDemandeId(Long id);


}
