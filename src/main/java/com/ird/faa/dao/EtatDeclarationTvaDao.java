package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.EtatDeclarationTva;


@Repository
public interface EtatDeclarationTvaDao extends JpaRepository<EtatDeclarationTva,Long> {




    EtatDeclarationTva findByReference(String reference);

    int deleteByReference(String reference);



}
