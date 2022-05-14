package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Comptable;


@Repository
public interface ComptableDao extends JpaRepository<Comptable,Long> {

    Comptable findByUsername(String username);



    Comptable findByCode(String code);

    int deleteByCode(String code);

    List<Comptable> findByTypeComptableReference(String reference);
    int deleteByTypeComptableReference(String reference);

    List<Comptable> findByTypeComptableId(Long id);

    int deleteByTypeComptableId(Long id);


}
