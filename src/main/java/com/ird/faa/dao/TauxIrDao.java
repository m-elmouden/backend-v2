package com.ird.faa.dao;

import com.ird.faa.bean.TauxIr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TauxIrDao extends JpaRepository<TauxIr, Long> {


    @Query("SELECT item FROM TauxIr item ORDER BY item.dateMin ASC")
    List<TauxIr> findAll();

    @Query("SELECT item FROM TauxIr item WHERE item.salaireImpoMin <= ?1 and item.salaireImpoMax >= ?1")
    TauxIr findTauxBysalaire(BigDecimal salaire);

    @Query("select item from TauxIr item where item.salaireImpoMax>15000")
    TauxIr findDernierTaux();

    TauxIr findByIntervalle(String intervalle);


}
