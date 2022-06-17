package com.ird.faa.dao;

import com.ird.faa.bean.CompteComptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface CompteComptableDao extends JpaRepository<CompteComptable, Long> {


    CompteComptable findByNumero(BigDecimal numero);

    int deleteByNumero(BigDecimal numero);


    List<CompteComptable> findBySousClasseComptableId(Long id);

    int deleteBySousClasseComptableId(Long id);


}
