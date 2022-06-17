package com.ird.faa.dao;

import com.ird.faa.bean.TypeEmploye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TypeEmployeDao extends JpaRepository<TypeEmploye, Long> {


    TypeEmploye findByCode(String code);

    int deleteByCode(String code);


}
