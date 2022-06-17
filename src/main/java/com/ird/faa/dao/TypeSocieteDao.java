package com.ird.faa.dao;

import com.ird.faa.bean.TypeSociete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TypeSocieteDao extends JpaRepository<TypeSociete, Long> {


    TypeSociete findByCode(String code);

    int deleteByCode(String code);


}
