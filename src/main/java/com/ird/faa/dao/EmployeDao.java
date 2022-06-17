package com.ird.faa.dao;

import com.ird.faa.upload.employe.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {


    Employe findByCin(String cin);

    int deleteByCin(String cin);

    List<Employe> findByTypeEmployeCode(String code);

    int deleteByTypeEmployeCode(String code);

    List<Employe> findByTypeEmployeId(Long id);

    int deleteByTypeEmployeId(Long id);

    List<Employe> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);

    List<Employe> findByDeclarationCnssRef(String ref);

    int deleteByDeclarationCnssRef(String ref);

    List<Employe> findByDeclarationCnssId(Long id);

    int deleteByDeclarationCnssId(Long id);


}
