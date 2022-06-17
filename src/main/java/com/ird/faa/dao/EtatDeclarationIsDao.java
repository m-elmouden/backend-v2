package com.ird.faa.dao;

import com.ird.faa.bean.EtatDeclarationIs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtatDeclarationIsDao extends JpaRepository<EtatDeclarationIs, Long> {


    EtatDeclarationIs findByReference(String reference);

    int deleteByReference(String reference);


}
