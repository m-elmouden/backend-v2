package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TypeComptable;


@Repository
public interface TypeComptableDao extends JpaRepository<TypeComptable,Long> {




    TypeComptable findByReference(String reference);

    int deleteByReference(String reference);



}
