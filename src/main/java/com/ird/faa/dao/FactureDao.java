package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import com.ird.faa.bean.Facture;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface FactureDao extends JpaRepository<Facture,Long> {



    @Query("SELECT item FROM Facture item ORDER BY item.dateOperation ASC")
    List<Facture> findAll();

    Facture findByReference(String reference);

    int deleteByReference(String reference);

    List<Facture> findByTvaReference(String reference);
    int deleteByTvaReference(String reference);

    List<Facture> findByTvaId(Long id);

    int deleteByTvaId(Long id);

    List<Facture> findByTypeOperationFactureId(Long id);

    int deleteByTypeOperationFactureId(Long id);

    List<Facture> findByEtatFactureId(Long id);

    int deleteByEtatFactureId(Long id);

    List<Facture> findByEtatPaiementId(Long id);

    int deleteByEtatPaiementId(Long id);

    List<Facture> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);
    List<Facture> findByCompteComptableNumero(BigDecimal numero);
    int deleteByCompteComptableNumero(BigDecimal numero);

    List<Facture> findByCompteComptableId(Long id);

    int deleteByCompteComptableId(Long id);
    List<Facture> findByDeclarationIsReference(String reference);
    int deleteByDeclarationIsReference(String reference);

    List<Facture> findByDeclarationIsId(Long id);

    int deleteByDeclarationIsId(Long id);
    List<Facture> findByDeclarationTvaReference(String reference);
    int deleteByDeclarationTvaReference(String reference);

    List<Facture> findByDeclarationTvaId(Long id);

    int deleteByDeclarationTvaId(Long id);
    List<Facture> findByDemandeReference(String reference);
    int deleteByDemandeReference(String reference);

    List<Facture> findByDemandeId(Long id);

    int deleteByDemandeId(Long id);

    List<Facture> findByClasseComptableId(Long id);

    int deleteByClasseComptableId(Long id);

    List<Facture> findByCpcFactureId(Long id);

    int deleteByCpcFactureId(Long id);


}
