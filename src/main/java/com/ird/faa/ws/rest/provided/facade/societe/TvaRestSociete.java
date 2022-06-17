package com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.bean.Tva;
import com.ird.faa.service.societe.facade.TvaSocieteService;
import com.ird.faa.ws.rest.provided.converter.TvaConverter;
import com.ird.faa.ws.rest.provided.vo.TvaVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages tva services")
@RestController
@RequestMapping("api/societe/tva")
public class TvaRestSociete {

    @Autowired
    private TvaSocieteService tvaService;

    @Autowired
    private TvaConverter tvaConverter;


    @ApiOperation("Updates the specified  tva")
    @PutMapping("/")
    public TvaVo update(@RequestBody TvaVo tvaVo) {
        Tva tva = tvaConverter.toItem(tvaVo);
        tva = tvaService.update(tva);
        return tvaConverter.toVo(tva);
    }

    @ApiOperation("Finds a list of all tvas")
    @GetMapping("/")
    public List<TvaVo> findAll() {
        return tvaConverter.toVo(tvaService.findAll());
    }

    @ApiOperation("Finds a tva with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TvaVo findByIdWithAssociatedList(@PathVariable Long id) {
        return tvaConverter.toVo(tvaService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search tva by a specific criteria")
    @PostMapping("/search")
    public List<TvaVo> findByCriteria(@RequestBody TvaVo tvaVo) {
        return tvaConverter.toVo(tvaService.findByCriteria(tvaVo));
    }

    @ApiOperation("Finds a tva by id")
    @GetMapping("/id/{id}")
    public TvaVo findById(@PathVariable Long id) {
        return tvaConverter.toVo(tvaService.findById(id));
    }

    @ApiOperation("Saves the specified  tva")
    @PostMapping("/")
    public TvaVo save(@RequestBody TvaVo tvaVo) {
        Tva tva = tvaConverter.toItem(tvaVo);
        tva = tvaService.save(tva);
        return tvaConverter.toVo(tva);
    }

    @ApiOperation("Delete the specified tva")
    @DeleteMapping("/")
    public int delete(@RequestBody TvaVo tvaVo) {
        Tva tva = tvaConverter.toItem(tvaVo);
        return tvaService.delete(tva);
    }

    @ApiOperation("Deletes a tva by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return tvaService.deleteById(id);
    }


}
