package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Acompte;


@Repository
public interface AcompteDao extends JpaRepository<Acompte,Long> {






    List<Acompte> findBySocieteId(Long id);

    int deleteBySocieteId(Long id);


}
