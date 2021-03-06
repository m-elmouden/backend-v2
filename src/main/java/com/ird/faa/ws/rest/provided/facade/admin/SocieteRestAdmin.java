package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.Societe;
import com.ird.faa.service.admin.facade.SocieteAdminService;
import com.ird.faa.ws.rest.provided.converter.SocieteConverter;
import com.ird.faa.ws.rest.provided.vo.SocieteVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages societe services")
@RestController
@RequestMapping("api/admin/societe")
public class SocieteRestAdmin {

    @Autowired
    private SocieteAdminService societeService;

    @Autowired
    private SocieteConverter societeConverter;


    @ApiOperation("Updates the specified  societe")
    @PutMapping("/")
    public SocieteVo update(@RequestBody SocieteVo societeVo) {
        Societe societe = societeConverter.toItem(societeVo);
        societe = societeService.update(societe);
        return societeConverter.toVo(societe);
    }

    @ApiOperation("Finds a list of all societes")
    @GetMapping("/")
    public List<SocieteVo> findAll() {
        return societeConverter.toVo(societeService.findAll());
    }

    @ApiOperation("Finds a societe with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public SocieteVo findByIdWithAssociatedList(@PathVariable Long id) {
        return societeConverter.toVo(societeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search societe by a specific criteria")
    @PostMapping("/search")
    public List<SocieteVo> findByCriteria(@RequestBody SocieteVo societeVo) {
        return societeConverter.toVo(societeService.findByCriteria(societeVo));
    }

    @ApiOperation("Finds a societe by id")
    @GetMapping("/id/{id}")
    public SocieteVo findById(@PathVariable Long id) {
        return societeConverter.toVo(societeService.findById(id));
    }

    @ApiOperation("Saves the specified  societe")
    @PostMapping("/")
    public SocieteVo save(@RequestBody SocieteVo societeVo) {
        Societe societe = societeConverter.toItem(societeVo);
        societe = societeService.save(societe);
        return societeConverter.toVo(societe);
    }

    @ApiOperation("Delete the specified societe")
    @DeleteMapping("/")
    public int delete(@RequestBody SocieteVo societeVo) {
        Societe societe = societeConverter.toItem(societeVo);
        return societeService.delete(societe);
    }

    @ApiOperation("Deletes a societe by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return societeService.deleteById(id);
    }

    @ApiOperation("find by comptable code")
    @GetMapping("/comptable/code/{code}")
    public List<Societe> findByComptableCode(@PathVariable String code) {
        return societeService.findByComptableCode(code);
    }

    @ApiOperation("delete by comptable code")
    @DeleteMapping("/comptable/code/{code}")
    public int deleteByComptableCode(@PathVariable String code) {
        return societeService.deleteByComptableCode(code);
    }

    @ApiOperation("find by comptable id")
    @GetMapping("/comptable/id/{id}")
    public List<Societe> findByComptableId(@PathVariable Long id) {
        return societeService.findByComptableId(id);
    }

    @ApiOperation("delete by comptable id")
    @DeleteMapping("/comptable/id/{id}")
    public int deleteByComptableId(@PathVariable Long id) {
        return societeService.deleteByComptableId(id);
    }

    @ApiOperation("find by presidentSociete id")
    @GetMapping("/presidentSociete/id/{id}")
    public List<Societe> findByPresidentSocieteId(@PathVariable Long id) {
        return societeService.findByPresidentSocieteId(id);
    }

    @ApiOperation("delete by presidentSociete id")
    @DeleteMapping("/presidentSociete/id/{id}")
    public int deleteByPresidentSocieteId(@PathVariable Long id) {
        return societeService.deleteByPresidentSocieteId(id);
    }

    @ApiOperation("find by typeSociete code")
    @GetMapping("/typeSociete/code/{code}")
    public List<Societe> findByTypeSocieteCode(@PathVariable String code) {
        return societeService.findByTypeSocieteCode(code);
    }

    @ApiOperation("delete by typeSociete code")
    @DeleteMapping("/typeSociete/code/{code}")
    public int deleteByTypeSocieteCode(@PathVariable String code) {
        return societeService.deleteByTypeSocieteCode(code);
    }

    @ApiOperation("find by typeSociete id")
    @GetMapping("/typeSociete/id/{id}")
    public List<Societe> findByTypeSocieteId(@PathVariable Long id) {
        return societeService.findByTypeSocieteId(id);
    }

    @ApiOperation("delete by typeSociete id")
    @DeleteMapping("/typeSociete/id/{id}")
    public int deleteByTypeSocieteId(@PathVariable Long id) {
        return societeService.deleteByTypeSocieteId(id);
    }


}
