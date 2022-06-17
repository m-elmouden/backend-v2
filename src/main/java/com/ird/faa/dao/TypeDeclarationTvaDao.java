package com.ird.faa.dao;

import com.ird.faa.bean.TypeDeclarationTva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TypeDeclarationTvaDao extends JpaRepository<TypeDeclarationTva, Long> {


    TypeDeclarationTva findByReference(String reference);

    int deleteByReference(String reference);


}
