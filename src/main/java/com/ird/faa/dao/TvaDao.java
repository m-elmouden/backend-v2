package com.ird.faa.dao;

import com.ird.faa.bean.Tva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TvaDao extends JpaRepository<Tva, Long> {


    Tva findByReference(String reference);

    int deleteByReference(String reference);


}
