package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Societe;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface SocieteDao extends JpaRepository<Societe,Long> {

    Societe findByUsername(String username);


    @Query("SELECT item FROM Societe item ORDER BY item.dateCreation ASC")
    List<Societe> findAll();


    List<Societe> findByComptableCode(String code);
    int deleteByComptableCode(String code);

    List<Societe> findByComptableId(Long id);

    int deleteByComptableId(Long id);

    List<Societe> findByPresidentSocieteId(Long id);

    int deleteByPresidentSocieteId(Long id);
    List<Societe> findByTypeSocieteCode(String code);
    int deleteByTypeSocieteCode(String code);

    List<Societe> findByTypeSocieteId(Long id);

    int deleteByTypeSocieteId(Long id);


}
