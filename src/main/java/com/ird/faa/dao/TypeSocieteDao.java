package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TypeSociete;


@Repository
public interface TypeSocieteDao extends JpaRepository<TypeSociete,Long> {




    TypeSociete findByCode(String code);

    int deleteByCode(String code);



}
