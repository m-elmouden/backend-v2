package com.ird.faa.dao;

import com.ird.faa.bean.TypeComptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TypeComptableDao extends JpaRepository<TypeComptable, Long> {


    TypeComptable findByReference(String reference);

    int deleteByReference(String reference);


}
