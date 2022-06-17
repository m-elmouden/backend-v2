package com.ird.faa.dao;

import com.ird.faa.bean.TypeTauxCnss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TypeTauxCnssDao extends JpaRepository<TypeTauxCnss, Long> {


}
