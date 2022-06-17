package com.ird.faa.dao;

import com.ird.faa.bean.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeDao extends JpaRepository<Demande, Long> {


    @Query("SELECT item FROM Demande item ORDER BY item.dateDemande ASC")
    List<Demande> findAll();

    Demande findByReference(String reference);

    int deleteByReference(String reference);


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


}
