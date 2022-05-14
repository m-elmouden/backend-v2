package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PrelevementSocialEmploye;


@Repository
public interface PrelevementSocialEmployeDao extends JpaRepository<PrelevementSocialEmploye,Long> {






    List<PrelevementSocialEmploye> findByPrelevementSocialId(Long id);

    int deleteByPrelevementSocialId(Long id);
    List<PrelevementSocialEmploye> findByEmployeCin(String cin);
    int deleteByEmployeCin(String cin);

    List<PrelevementSocialEmploye> findByEmployeId(Long id);

    int deleteByEmployeId(Long id);
    List<PrelevementSocialEmploye> findByDeclarationIrRefrerence(String refrerence);
    int deleteByDeclarationIrRefrerence(String refrerence);

    List<PrelevementSocialEmploye> findByDeclarationIrId(Long id);

    int deleteByDeclarationIrId(Long id);


}
