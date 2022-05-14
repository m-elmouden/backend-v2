package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TauxCnss;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface TauxCnssDao extends JpaRepository<TauxCnss,Long> {



    @Query("SELECT item FROM TauxCnss item ORDER BY item.dateApplicationMax ASC")
    List<TauxCnss> findAll();

    TauxCnss findByRef(String ref);

    int deleteByRef(String ref);


    List<TauxCnss> findByTypeTauxCnssId(Long id);

    int deleteByTypeTauxCnssId(Long id);


}
