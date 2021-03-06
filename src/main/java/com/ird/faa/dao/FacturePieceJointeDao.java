package com.ird.faa.dao;

import com.ird.faa.bean.FacturePieceJointe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FacturePieceJointeDao extends JpaRepository<FacturePieceJointe, Long> {


    List<FacturePieceJointe> findByFactureReference(String reference);

    int deleteByFactureReference(String reference);

    List<FacturePieceJointe> findByFactureId(Long id);

    int deleteByFactureId(Long id);


}
