package com.ird.faa.dao;

import com.ird.faa.bean.PaiementDeclarationTva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementDeclarationTvaDao extends JpaRepository<PaiementDeclarationTva, Long> {


    @Query("SELECT item FROM PaiementDeclarationTva item ORDER BY item.datePaiement ASC")
    List<PaiementDeclarationTva> findAll();

    PaiementDeclarationTva findByReference(String reference);

    int deleteByReference(String reference);

    List<PaiementDeclarationTva> findByDeclarationTvaReference(String reference);

    int deleteByDeclarationTvaReference(String reference);

    List<PaiementDeclarationTva> findByDeclarationTvaId(Long id);

    int deleteByDeclarationTvaId(Long id);


}
