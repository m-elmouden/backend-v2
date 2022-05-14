package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PaiementDeclarationIs;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface PaiementDeclarationIsDao extends JpaRepository<PaiementDeclarationIs,Long> {



    @Query("SELECT item FROM PaiementDeclarationIs item ORDER BY item.datePaiement ASC")
    List<PaiementDeclarationIs> findAll();

    PaiementDeclarationIs findByReference(String reference);

    int deleteByReference(String reference);

    List<PaiementDeclarationIs> findByDeclarationIsReference(String reference);
    int deleteByDeclarationIsReference(String reference);

    List<PaiementDeclarationIs> findByDeclarationIsId(Long id);

    int deleteByDeclarationIsId(Long id);


}
