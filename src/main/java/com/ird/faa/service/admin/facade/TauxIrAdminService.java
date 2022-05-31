package com.ird.faa.service.admin.facade;

import com.ird.faa.bean.TauxIr;
import com.ird.faa.ws.rest.provided.vo.TauxIrVo;
import com.ird.faa.service.core.facade.AbstractService;

import java.math.BigDecimal;
import java.util.List;

public interface TauxIrAdminService extends AbstractService<TauxIr,Long,TauxIrVo>{




/**
    * delete TauxIr from database
    * @param id - id of TauxIr to be deleted
    *
    */
    int deleteById(Long id);
    TauxIr findDernierTaux();
    List<TauxIr> findAll();
     TauxIr findTauxIrConvenable(BigDecimal salaire);
     TauxIr findByIntervalle(String intervalle);










}
