package com.ird.faa.dao;

import com.ird.faa.bean.CpcFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CpcFactureDao extends JpaRepository<CpcFacture, Long> {


    List<CpcFacture> findByCpcReference(String reference);

    int deleteByCpcReference(String reference);

    List<CpcFacture> findByCpcId(Long id);

    int deleteByCpcId(Long id);

    List<CpcFacture> findByFactureReference(String reference);

    int deleteByFactureReference(String reference);

    List<CpcFacture> findByFactureId(Long id);

    int deleteByFactureId(Long id);


}
