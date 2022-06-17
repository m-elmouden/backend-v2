package com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.bean.CpcFacture;
import com.ird.faa.service.societe.facade.CpcFactureSocieteService;
import com.ird.faa.ws.rest.provided.converter.CpcFactureConverter;
import com.ird.faa.ws.rest.provided.vo.CpcFactureVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages cpcFacture services")
@RestController
@RequestMapping("api/societe/cpcFacture")
public class CpcFactureRestSociete {

    @Autowired
    private CpcFactureSocieteService cpcFactureService;

    @Autowired
    private CpcFactureConverter cpcFactureConverter;


    @ApiOperation("Updates the specified  cpcFacture")
    @PutMapping("/")
    public CpcFactureVo update(@RequestBody CpcFactureVo cpcFactureVo) {
        CpcFacture cpcFacture = cpcFactureConverter.toItem(cpcFactureVo);
        cpcFacture = cpcFactureService.update(cpcFacture);
        return cpcFactureConverter.toVo(cpcFacture);
    }

    @ApiOperation("Finds a list of all cpcFactures")
    @GetMapping("/")
    public List<CpcFactureVo> findAll() {
        return cpcFactureConverter.toVo(cpcFactureService.findAll());
    }

    @ApiOperation("Finds a cpcFacture with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CpcFactureVo findByIdWithAssociatedList(@PathVariable Long id) {
        return cpcFactureConverter.toVo(cpcFactureService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search cpcFacture by a specific criteria")
    @PostMapping("/search")
    public List<CpcFactureVo> findByCriteria(@RequestBody CpcFactureVo cpcFactureVo) {
        return cpcFactureConverter.toVo(cpcFactureService.findByCriteria(cpcFactureVo));
    }

    @ApiOperation("Finds a cpcFacture by id")
    @GetMapping("/id/{id}")
    public CpcFactureVo findById(@PathVariable Long id) {
        return cpcFactureConverter.toVo(cpcFactureService.findById(id));
    }

    @ApiOperation("Saves the specified  cpcFacture")
    @PostMapping("/")
    public CpcFactureVo save(@RequestBody CpcFactureVo cpcFactureVo) {
        CpcFacture cpcFacture = cpcFactureConverter.toItem(cpcFactureVo);
        cpcFacture = cpcFactureService.save(cpcFacture);
        return cpcFactureConverter.toVo(cpcFacture);
    }

    @ApiOperation("Delete the specified cpcFacture")
    @DeleteMapping("/")
    public int delete(@RequestBody CpcFactureVo cpcFactureVo) {
        CpcFacture cpcFacture = cpcFactureConverter.toItem(cpcFactureVo);
        return cpcFactureService.delete(cpcFacture);
    }

    @ApiOperation("Deletes a cpcFacture by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return cpcFactureService.deleteById(id);
    }

    @ApiOperation("find by cpc reference")
    @GetMapping("/cpc/reference/{reference}")
    public List<CpcFacture> findByCpcReference(@PathVariable String reference) {
        return cpcFactureService.findByCpcReference(reference);
    }

    @ApiOperation("delete by cpc reference")
    @DeleteMapping("/cpc/reference/{reference}")
    public int deleteByCpcReference(@PathVariable String reference) {
        return cpcFactureService.deleteByCpcReference(reference);
    }

    @ApiOperation("find by cpc id")
    @GetMapping("/cpc/id/{id}")
    public List<CpcFacture> findByCpcId(@PathVariable Long id) {
        return cpcFactureService.findByCpcId(id);
    }

    @ApiOperation("delete by cpc id")
    @DeleteMapping("/cpc/id/{id}")
    public int deleteByCpcId(@PathVariable Long id) {
        return cpcFactureService.deleteByCpcId(id);
    }

    @ApiOperation("find by facture reference")
    @GetMapping("/facture/reference/{reference}")
    public List<CpcFacture> findByFactureReference(@PathVariable String reference) {
        return cpcFactureService.findByFactureReference(reference);
    }

    @ApiOperation("delete by facture reference")
    @DeleteMapping("/facture/reference/{reference}")
    public int deleteByFactureReference(@PathVariable String reference) {
        return cpcFactureService.deleteByFactureReference(reference);
    }

    @ApiOperation("find by facture id")
    @GetMapping("/facture/id/{id}")
    public List<CpcFacture> findByFactureId(@PathVariable Long id) {
        return cpcFactureService.findByFactureId(id);
    }

    @ApiOperation("delete by facture id")
    @DeleteMapping("/facture/id/{id}")
    public int deleteByFactureId(@PathVariable Long id) {
        return cpcFactureService.deleteByFactureId(id);
    }


}
