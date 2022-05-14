package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.DeclarationTva;


@Repository
public interface DeclarationTvaDao extends JpaRepository<DeclarationTva,Long> {




    DeclarationTva findByReference(String reference);

    int deleteByReference(String reference);


    List<DeclarationTva> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);
    List<DeclarationTva> findByTypeDeclarationTvaReference(String reference);
    int deleteByTypeDeclarationTvaReference(String reference);

    List<DeclarationTva> findByTypeDeclarationTvaId(Long id);

    int deleteByTypeDeclarationTvaId(Long id);
    List<DeclarationTva> findByEtatDeclarationTvaReference(String reference);
    int deleteByEtatDeclarationTvaReference(String reference);

    List<DeclarationTva> findByEtatDeclarationTvaId(Long id);

    int deleteByEtatDeclarationTvaId(Long id);
    List<DeclarationTva> findByPaiementDeclarationTvaReference(String reference);
    int deleteByPaiementDeclarationTvaReference(String reference);

    List<DeclarationTva> findByPaiementDeclarationTvaId(Long id);

    int deleteByPaiementDeclarationTvaId(Long id);


}
