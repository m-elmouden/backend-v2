package com.ird.faa.dao;

import com.ird.faa.bean.PrelevementSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrelevementSocialDao extends JpaRepository<PrelevementSocial, Long> {


    @Query("SELECT item FROM PrelevementSocial item ORDER BY item.dateMin ASC")
    List<PrelevementSocial> findAll();

    PrelevementSocial findByLibelle(String libelle);

    PrelevementSocial findByReference(String reference);


}
