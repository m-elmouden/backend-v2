package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TypeEmploye;


@Repository
public interface TypeEmployeDao extends JpaRepository<TypeEmploye,Long> {




    TypeEmploye findByCode(String code);

    int deleteByCode(String code);



}
