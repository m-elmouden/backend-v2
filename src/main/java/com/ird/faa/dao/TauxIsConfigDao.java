package com.ird.faa.dao;

import com.ird.faa.bean.TauxIsConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TauxIsConfigDao extends JpaRepository<TauxIsConfig, Long> {


    @Query("SELECT item FROM TauxIsConfig item ORDER BY item.dateMax ASC")
    List<TauxIsConfig> findAll();

    TauxIsConfig findByReference(String reference);

    int deleteByReference(String reference);


}
