package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TypeOperationFacture;


@Repository
public interface TypeOperationFactureDao extends JpaRepository<TypeOperationFacture,Long> {







}
