package com.ird.faa.dao;

import com.ird.faa.bean.EtatFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtatFactureDao extends JpaRepository<EtatFacture, Long> {


}
