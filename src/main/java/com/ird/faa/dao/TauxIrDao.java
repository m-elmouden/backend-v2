package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TauxIr;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface TauxIrDao extends JpaRepository<TauxIr,Long> {



    @Query("SELECT item FROM TauxIr item ORDER BY item.dateMin ASC")
    List<TauxIr> findAll();




}
