package com.ird.faa.dao;

import com.ird.faa.bean.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireDao extends JpaRepository<Commentaire, Long> {


    @Query("SELECT item FROM Commentaire item ORDER BY item.dateCommentaire ASC")
    List<Commentaire> findAll();


    List<Commentaire> findByDemandeReference(String reference);

    int deleteByDemandeReference(String reference);

    List<Commentaire> findByDemandeId(Long id);

    int deleteByDemandeId(Long id);


}
