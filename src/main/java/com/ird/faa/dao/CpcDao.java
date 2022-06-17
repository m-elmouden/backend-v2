package com.ird.faa.dao;

import com.ird.faa.bean.Cpc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CpcDao extends JpaRepository<Cpc, Long> {


    @Query("SELECT item FROM Cpc item ORDER BY item.dateMaxCpc ASC")
    List<Cpc> findAll();

    Cpc findByReference(String reference);

    int deleteByReference(String reference);


}
