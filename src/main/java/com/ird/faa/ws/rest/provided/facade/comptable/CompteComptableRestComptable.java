package com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.bean.CompteComptable;
import com.ird.faa.service.comptable.facade.CompteComptableComptableService;
import com.ird.faa.ws.rest.provided.converter.CompteComptableConverter;
import com.ird.faa.ws.rest.provided.vo.CompteComptableVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages compteComptable services")
@RestController
@RequestMapping("api/comptable/compteComptable")
public class CompteComptableRestComptable {

    @Autowired
    private CompteComptableComptableService compteComptableService;

    @Autowired
    private CompteComptableConverter compteComptableConverter;


    @ApiOperation("Updates the specified  compteComptable")
    @PutMapping("/")
    public CompteComptableVo update(@RequestBody CompteComptableVo compteComptableVo) {
        CompteComptable compteComptable = compteComptableConverter.toItem(compteComptableVo);
        compteComptable = compteComptableService.update(compteComptable);
        return compteComptableConverter.toVo(compteComptable);
    }

    @ApiOperation("Finds a list of all compteComptables")
    @GetMapping("/")
    public List<CompteComptableVo> findAll() {
        return compteComptableConverter.toVo(compteComptableService.findAll());
    }

    @ApiOperation("Finds a compteComptable with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CompteComptableVo findByIdWithAssociatedList(@PathVariable Long id) {
        return compteComptableConverter.toVo(compteComptableService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search compteComptable by a specific criteria")
    @PostMapping("/search")
    public List<CompteComptableVo> findByCriteria(@RequestBody CompteComptableVo compteComptableVo) {
        return compteComptableConverter.toVo(compteComptableService.findByCriteria(compteComptableVo));
    }

    @ApiOperation("Finds a compteComptable by id")
    @GetMapping("/id/{id}")
    public CompteComptableVo findById(@PathVariable Long id) {
        return compteComptableConverter.toVo(compteComptableService.findById(id));
    }

    @ApiOperation("Saves the specified  compteComptable")
    @PostMapping("/")
    public CompteComptableVo save(@RequestBody CompteComptableVo compteComptableVo) {
        CompteComptable compteComptable = compteComptableConverter.toItem(compteComptableVo);
        compteComptable = compteComptableService.save(compteComptable);
        return compteComptableConverter.toVo(compteComptable);
    }

    @ApiOperation("Delete the specified compteComptable")
    @DeleteMapping("/")
    public int delete(@RequestBody CompteComptableVo compteComptableVo) {
        CompteComptable compteComptable = compteComptableConverter.toItem(compteComptableVo);
        return compteComptableService.delete(compteComptable);
    }

    @ApiOperation("Deletes a compteComptable by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return compteComptableService.deleteById(id);
    }

    @ApiOperation("find by sousClasseComptable id")
    @GetMapping("/sousClasseComptable/id/{id}")
    public List<CompteComptable> findBySousClasseComptableId(@PathVariable Long id) {
        return compteComptableService.findBySousClasseComptableId(id);
    }

    @ApiOperation("delete by sousClasseComptable id")
    @DeleteMapping("/sousClasseComptable/id/{id}")
    public int deleteBySousClasseComptableId(@PathVariable Long id) {
        return compteComptableService.deleteBySousClasseComptableId(id);
    }


}
