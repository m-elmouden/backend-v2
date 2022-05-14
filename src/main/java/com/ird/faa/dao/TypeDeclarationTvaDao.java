package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TypeDeclarationTva;


@Repository
public interface TypeDeclarationTvaDao extends JpaRepository<TypeDeclarationTva,Long> {




    TypeDeclarationTva findByReference(String reference);

    int deleteByReference(String reference);



}
