package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.DeclarationIrEmploye;


@Repository
public interface DeclarationIrEmployeDao extends JpaRepository<DeclarationIrEmploye,Long> {





    List<DeclarationIrEmploye> findByDeclarationIrRefrerence(String refrerence);
    int deleteByDeclarationIrRefrerence(String refrerence);

    List<DeclarationIrEmploye> findByDeclarationIrId(Long id);

    int deleteByDeclarationIrId(Long id);
    List<DeclarationIrEmploye> findByEmployeCin(String cin);
    int deleteByEmployeCin(String cin);

    List<DeclarationIrEmploye> findByEmployeId(Long id);

    int deleteByEmployeId(Long id);

    List<DeclarationIrEmploye> findByTauxIrId(Long id);

    int deleteByTauxIrId(Long id);


}
