package com.ird.faa.dao;

import com.ird.faa.bean.EtatDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtatDemandeDao extends JpaRepository<EtatDemande, Long> {


    EtatDemande findByReference(String reference);

    int deleteByReference(String reference);


}
