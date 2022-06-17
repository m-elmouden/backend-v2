package com.ird.faa.dao;

import com.ird.faa.bean.DeclarationIs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeclarationIsDao extends JpaRepository<DeclarationIs, Long> {


    DeclarationIs findByReference(String reference);

    int deleteByReference(String reference);


    List<DeclarationIs> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);

    List<DeclarationIs> findByTauxIsReference(String reference);

    int deleteByTauxIsReference(String reference);

    List<DeclarationIs> findByTauxIsId(Long id);

    int deleteByTauxIsId(Long id);

    List<DeclarationIs> findByTauxIsConfigReference(String reference);

    int deleteByTauxIsConfigReference(String reference);

    List<DeclarationIs> findByTauxIsConfigId(Long id);

    int deleteByTauxIsConfigId(Long id);

    List<DeclarationIs> findByEtatDeclarationIsReference(String reference);

    int deleteByEtatDeclarationIsReference(String reference);

    List<DeclarationIs> findByEtatDeclarationIsId(Long id);

    int deleteByEtatDeclarationIsId(Long id);

    List<DeclarationIs> findByPaiementDeclarationIsReference(String reference);

    int deleteByPaiementDeclarationIsReference(String reference);

    List<DeclarationIs> findByPaiementDeclarationIsId(Long id);

    int deleteByPaiementDeclarationIsId(Long id);


}
