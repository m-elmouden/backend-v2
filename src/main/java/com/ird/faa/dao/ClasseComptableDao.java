package com.ird.faa.dao;

import com.ird.faa.bean.ClasseComptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClasseComptableDao extends JpaRepository<ClasseComptable, Long> {


}
