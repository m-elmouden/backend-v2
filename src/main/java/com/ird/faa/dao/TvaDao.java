package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Tva;


@Repository
public interface TvaDao extends JpaRepository<Tva,Long> {




    Tva findByReference(String reference);

    int deleteByReference(String reference);



}
