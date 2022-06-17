package com.ird.faa.dao;

import com.ird.faa.bean.DemandePieceJointe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DemandePieceJointeDao extends JpaRepository<DemandePieceJointe, Long> {


    List<DemandePieceJointe> findByDemandeReference(String reference);

    int deleteByDemandeReference(String reference);

    List<DemandePieceJointe> findByDemandeId(Long id);

    int deleteByDemandeId(Long id);


}
