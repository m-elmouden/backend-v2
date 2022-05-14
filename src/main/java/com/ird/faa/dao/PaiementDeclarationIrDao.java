package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PaiementDeclarationIr;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface PaiementDeclarationIrDao extends JpaRepository<PaiementDeclarationIr,Long> {



    @Query("SELECT item FROM PaiementDeclarationIr item ORDER BY item.datePaiement ASC")
    List<PaiementDeclarationIr> findAll();

    PaiementDeclarationIr findByReference(String reference);

    int deleteByReference(String reference);

    List<PaiementDeclarationIr> findByDeclarationIrRefrerence(String refrerence);
    int deleteByDeclarationIrRefrerence(String refrerence);

    List<PaiementDeclarationIr> findByDeclarationIrId(Long id);

    int deleteByDeclarationIrId(Long id);


}
