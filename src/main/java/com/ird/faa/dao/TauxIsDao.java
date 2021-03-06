package com.ird.faa.dao;

import com.ird.faa.bean.TauxIs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TauxIsDao extends JpaRepository<TauxIs, Long> {


    TauxIs findByReference(String reference);

    int deleteByReference(String reference);

    List<TauxIs> findByTauxIsConfigReference(String reference);

    int deleteByTauxIsConfigReference(String reference);

    List<TauxIs> findByTauxIsConfigId(Long id);

    int deleteByTauxIsConfigId(Long id);


}
