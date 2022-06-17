package com.ird.faa.dao;

import com.ird.faa.bean.DeclarationIr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeclarationIrDao extends JpaRepository<DeclarationIr, Long> {


    DeclarationIr findByRefrerence(String refrerence);

    int deleteByRefrerence(String refrerence);


    List<DeclarationIr> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);

    List<DeclarationIr> findByEtatDeclarationIrReference(String reference);

    int deleteByEtatDeclarationIrReference(String reference);

    List<DeclarationIr> findByEtatDeclarationIrId(Long id);

    int deleteByEtatDeclarationIrId(Long id);

    List<DeclarationIr> findByPaiementDeclarationIrReference(String reference);

    int deleteByPaiementDeclarationIrReference(String reference);

    List<DeclarationIr> findByPaiementDeclarationIrId(Long id);

    int deleteByPaiementDeclarationIrId(Long id);


}
