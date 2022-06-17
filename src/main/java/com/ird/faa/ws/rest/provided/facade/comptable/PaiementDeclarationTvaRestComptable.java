package com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.bean.PaiementDeclarationTva;
import com.ird.faa.service.comptable.facade.PaiementDeclarationTvaComptableService;
import com.ird.faa.ws.rest.provided.converter.PaiementDeclarationTvaConverter;
import com.ird.faa.ws.rest.provided.vo.PaiementDeclarationTvaVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages paiementDeclarationTva services")
@RestController
@RequestMapping("api/comptable/paiementDeclarationTva")
public class PaiementDeclarationTvaRestComptable {

    @Autowired
    private PaiementDeclarationTvaComptableService paiementDeclarationTvaService;

    @Autowired
    private PaiementDeclarationTvaConverter paiementDeclarationTvaConverter;


    @ApiOperation("Updates the specified  paiementDeclarationTva")
    @PutMapping("/")
    public PaiementDeclarationTvaVo update(@RequestBody PaiementDeclarationTvaVo paiementDeclarationTvaVo) {
        PaiementDeclarationTva paiementDeclarationTva = paiementDeclarationTvaConverter.toItem(paiementDeclarationTvaVo);
        paiementDeclarationTva = paiementDeclarationTvaService.update(paiementDeclarationTva);
        return paiementDeclarationTvaConverter.toVo(paiementDeclarationTva);
    }

    @ApiOperation("Finds a list of all paiementDeclarationTvas")
    @GetMapping("/")
    public List<PaiementDeclarationTvaVo> findAll() {
        return paiementDeclarationTvaConverter.toVo(paiementDeclarationTvaService.findAll());
    }

    @ApiOperation("Finds a paiementDeclarationTva with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PaiementDeclarationTvaVo findByIdWithAssociatedList(@PathVariable Long id) {
        return paiementDeclarationTvaConverter.toVo(paiementDeclarationTvaService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search paiementDeclarationTva by a specific criteria")
    @PostMapping("/search")
    public List<PaiementDeclarationTvaVo> findByCriteria(@RequestBody PaiementDeclarationTvaVo paiementDeclarationTvaVo) {
        return paiementDeclarationTvaConverter.toVo(paiementDeclarationTvaService.findByCriteria(paiementDeclarationTvaVo));
    }

    @ApiOperation("Finds a paiementDeclarationTva by id")
    @GetMapping("/id/{id}")
    public PaiementDeclarationTvaVo findById(@PathVariable Long id) {
        return paiementDeclarationTvaConverter.toVo(paiementDeclarationTvaService.findById(id));
    }

    @ApiOperation("Saves the specified  paiementDeclarationTva")
    @PostMapping("/")
    public PaiementDeclarationTvaVo save(@RequestBody PaiementDeclarationTvaVo paiementDeclarationTvaVo) {
        PaiementDeclarationTva paiementDeclarationTva = paiementDeclarationTvaConverter.toItem(paiementDeclarationTvaVo);
        paiementDeclarationTva = paiementDeclarationTvaService.save(paiementDeclarationTva);
        return paiementDeclarationTvaConverter.toVo(paiementDeclarationTva);
    }

    @ApiOperation("Delete the specified paiementDeclarationTva")
    @DeleteMapping("/")
    public int delete(@RequestBody PaiementDeclarationTvaVo paiementDeclarationTvaVo) {
        PaiementDeclarationTva paiementDeclarationTva = paiementDeclarationTvaConverter.toItem(paiementDeclarationTvaVo);
        return paiementDeclarationTvaService.delete(paiementDeclarationTva);
    }

    @ApiOperation("Deletes a paiementDeclarationTva by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return paiementDeclarationTvaService.deleteById(id);
    }

    @ApiOperation("find by declarationTva reference")
    @GetMapping("/declarationTva/reference/{reference}")
    public List<PaiementDeclarationTva> findByDeclarationTvaReference(@PathVariable String reference) {
        return paiementDeclarationTvaService.findByDeclarationTvaReference(reference);
    }

    @ApiOperation("delete by declarationTva reference")
    @DeleteMapping("/declarationTva/reference/{reference}")
    public int deleteByDeclarationTvaReference(@PathVariable String reference) {
        return paiementDeclarationTvaService.deleteByDeclarationTvaReference(reference);
    }

    @ApiOperation("find by declarationTva id")
    @GetMapping("/declarationTva/id/{id}")
    public List<PaiementDeclarationTva> findByDeclarationTvaId(@PathVariable Long id) {
        return paiementDeclarationTvaService.findByDeclarationTvaId(id);
    }

    @ApiOperation("delete by declarationTva id")
    @DeleteMapping("/declarationTva/id/{id}")
    public int deleteByDeclarationTvaId(@PathVariable Long id) {
        return paiementDeclarationTvaService.deleteByDeclarationTvaId(id);
    }


}
