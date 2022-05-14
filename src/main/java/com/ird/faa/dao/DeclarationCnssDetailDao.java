package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.DeclarationCnssDetail;


@Repository
public interface DeclarationCnssDetailDao extends JpaRepository<DeclarationCnssDetail,Long> {




    DeclarationCnssDetail findByRef(String ref);

    int deleteByRef(String ref);


    List<DeclarationCnssDetail> findByTypeTauxCnssId(Long id);

    int deleteByTypeTauxCnssId(Long id);
    List<DeclarationCnssDetail> findByDeclarationCnssRef(String ref);
    int deleteByDeclarationCnssRef(String ref);

    List<DeclarationCnssDetail> findByDeclarationCnssId(Long id);

    int deleteByDeclarationCnssId(Long id);


}
