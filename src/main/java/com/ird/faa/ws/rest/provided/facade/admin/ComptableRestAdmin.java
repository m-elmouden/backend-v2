package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.Comptable;
import com.ird.faa.service.admin.facade.ComptableAdminService;
import com.ird.faa.ws.rest.provided.converter.ComptableConverter;
import com.ird.faa.ws.rest.provided.vo.ComptableVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages comptable services")
@RestController
@RequestMapping("api/admin/comptable")
public class ComptableRestAdmin {

    @Autowired
    private ComptableAdminService comptableService;

    @Autowired
    private ComptableConverter comptableConverter;


    @ApiOperation("Updates the specified  comptable")
    @PutMapping("/")
    public ComptableVo update(@RequestBody ComptableVo comptableVo) {
        Comptable comptable = comptableConverter.toItem(comptableVo);
        comptable = comptableService.update(comptable);
        return comptableConverter.toVo(comptable);
    }

    @ApiOperation("Finds a list of all comptables")
    @GetMapping("/")
    public List<ComptableVo> findAll() {
        return comptableConverter.toVo(comptableService.findAll());
    }

    @ApiOperation("Finds a comptable with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ComptableVo findByIdWithAssociatedList(@PathVariable Long id) {
        return comptableConverter.toVo(comptableService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search comptable by a specific criteria")
    @PostMapping("/search")
    public List<ComptableVo> findByCriteria(@RequestBody ComptableVo comptableVo) {
        return comptableConverter.toVo(comptableService.findByCriteria(comptableVo));
    }

    @ApiOperation("Finds a comptable by id")
    @GetMapping("/id/{id}")
    public ComptableVo findById(@PathVariable Long id) {
        return comptableConverter.toVo(comptableService.findById(id));
    }

    @ApiOperation("Saves the specified  comptable")
    @PostMapping("/")
    public ComptableVo save(@RequestBody ComptableVo comptableVo) {
        Comptable comptable = comptableConverter.toItem(comptableVo);
        comptable = comptableService.save(comptable);
        return comptableConverter.toVo(comptable);
    }

    @ApiOperation("Delete the specified comptable")
    @DeleteMapping("/")
    public int delete(@RequestBody ComptableVo comptableVo) {
        Comptable comptable = comptableConverter.toItem(comptableVo);
        return comptableService.delete(comptable);
    }

    @ApiOperation("Deletes a comptable by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return comptableService.deleteById(id);
    }

    @ApiOperation("find by typeComptable reference")
    @GetMapping("/typeComptable/reference/{reference}")
    public List<Comptable> findByTypeComptableReference(@PathVariable String reference) {
        return comptableService.findByTypeComptableReference(reference);
    }

    @ApiOperation("delete by typeComptable reference")
    @DeleteMapping("/typeComptable/reference/{reference}")
    public int deleteByTypeComptableReference(@PathVariable String reference) {
        return comptableService.deleteByTypeComptableReference(reference);
    }

    @ApiOperation("find by typeComptable id")
    @GetMapping("/typeComptable/id/{id}")
    public List<Comptable> findByTypeComptableId(@PathVariable Long id) {
        return comptableService.findByTypeComptableId(id);
    }

    @ApiOperation("delete by typeComptable id")
    @DeleteMapping("/typeComptable/id/{id}")
    public int deleteByTypeComptableId(@PathVariable Long id) {
        return comptableService.deleteByTypeComptableId(id);
    }


}
