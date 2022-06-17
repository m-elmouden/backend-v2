package com.ird.faa.dao;

import com.ird.faa.bean.TypeOperationFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TypeOperationFactureDao extends JpaRepository<TypeOperationFacture, Long> {


}
