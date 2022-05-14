package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.DemandePieceJointe;


@Repository
public interface DemandePieceJointeDao extends JpaRepository<DemandePieceJointe,Long> {





    List<DemandePieceJointe> findByDemandeReference(String reference);
    int deleteByDemandeReference(String reference);

    List<DemandePieceJointe> findByDemandeId(Long id);

    int deleteByDemandeId(Long id);


}
