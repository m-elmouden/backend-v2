package com.ird.faa.dao;

import com.ird.faa.bean.PresidentSociete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PresidentSocieteDao extends JpaRepository<PresidentSociete, Long> {


    List<PresidentSociete> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);


}
