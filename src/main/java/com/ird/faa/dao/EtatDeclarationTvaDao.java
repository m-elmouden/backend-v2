package com.ird.faa.dao;

import com.ird.faa.bean.EtatDeclarationTva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtatDeclarationTvaDao extends JpaRepository<EtatDeclarationTva, Long> {


    EtatDeclarationTva findByReference(String reference);

    int deleteByReference(String reference);


}
