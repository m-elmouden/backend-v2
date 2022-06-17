package com.ird.faa.dao;

import com.ird.faa.bean.EtatDeclarationIr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtatDeclarationIrDao extends JpaRepository<EtatDeclarationIr, Long> {


    EtatDeclarationIr findByReference(String reference);

    int deleteByReference(String reference);


}
