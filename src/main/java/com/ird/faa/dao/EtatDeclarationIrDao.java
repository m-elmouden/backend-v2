package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.EtatDeclarationIr;


@Repository
public interface EtatDeclarationIrDao extends JpaRepository<EtatDeclarationIr,Long> {




    EtatDeclarationIr findByReference(String reference);

    int deleteByReference(String reference);



}
