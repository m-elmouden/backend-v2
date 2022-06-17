package com.ird.faa.dao;

import com.ird.faa.bean.EtatPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtatPaiementDao extends JpaRepository<EtatPaiement, Long> {


}
