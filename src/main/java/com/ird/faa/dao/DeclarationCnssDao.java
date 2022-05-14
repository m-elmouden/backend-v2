package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.DeclarationCnss;


@Repository
public interface DeclarationCnssDao extends JpaRepository<DeclarationCnss,Long> {




    DeclarationCnss findByRef(String ref);

    int deleteByRef(String ref);

    List<DeclarationCnss> findByEmployeCin(String cin);
    int deleteByEmployeCin(String cin);

    List<DeclarationCnss> findByEmployeId(Long id);

    int deleteByEmployeId(Long id);

    List<DeclarationCnss> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);


}
