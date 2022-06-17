package com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.bean.ClasseComptable;
import com.ird.faa.service.comptable.facade.ClasseComptableComptableService;
import com.ird.faa.ws.rest.provided.converter.ClasseComptableConverter;
import com.ird.faa.ws.rest.provided.vo.ClasseComptableVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages classeComptable services")
@RestController
@RequestMapping("api/comptable/classeComptable")
public class ClasseComptableRestComptable {

    @Autowired
    private ClasseComptableComptableService classeComptableService;

    @Autowired
    private ClasseComptableConverter classeComptableConverter;


    @ApiOperation("Updates the specified  classeComptable")
    @PutMapping("/")
    public ClasseComptableVo update(@RequestBody ClasseComptableVo classeComptableVo) {
        ClasseComptable classeComptable = classeComptableConverter.toItem(classeComptableVo);
        classeComptable = classeComptableService.update(classeComptable);
        return classeComptableConverter.toVo(classeComptable);
    }

    @ApiOperation("Finds a list of all classeComptables")
    @GetMapping("/")
    public List<ClasseComptableVo> findAll() {
        return classeComptableConverter.toVo(classeComptableService.findAll());
    }

    @ApiOperation("Finds a classeComptable with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ClasseComptableVo findByIdWithAssociatedList(@PathVariable Long id) {
        return classeComptableConverter.toVo(classeComptableService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search classeComptable by a specific criteria")
    @PostMapping("/search")
    public List<ClasseComptableVo> findByCriteria(@RequestBody ClasseComptableVo classeComptableVo) {
        return classeComptableConverter.toVo(classeComptableService.findByCriteria(classeComptableVo));
    }

    @ApiOperation("Finds a classeComptable by id")
    @GetMapping("/id/{id}")
    public ClasseComptableVo findById(@PathVariable Long id) {
        return classeComptableConverter.toVo(classeComptableService.findById(id));
    }

    @ApiOperation("Saves the specified  classeComptable")
    @PostMapping("/")
    public ClasseComptableVo save(@RequestBody ClasseComptableVo classeComptableVo) {
        ClasseComptable classeComptable = classeComptableConverter.toItem(classeComptableVo);
        classeComptable = classeComptableService.save(classeComptable);
        return classeComptableConverter.toVo(classeComptable);
    }

    @ApiOperation("Delete the specified classeComptable")
    @DeleteMapping("/")
    public int delete(@RequestBody ClasseComptableVo classeComptableVo) {
        ClasseComptable classeComptable = classeComptableConverter.toItem(classeComptableVo);
        return classeComptableService.delete(classeComptable);
    }

    @ApiOperation("Deletes a classeComptable by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return classeComptableService.deleteById(id);
    }


    @PutMapping("/archiver/")
    public ClasseComptableVo archiver(@RequestBody ClasseComptableVo classeComptableVo) {
        ClasseComptable classeComptable = classeComptableService.archiver(classeComptableConverter.toItem(classeComptableVo));
        return classeComptableConverter.toVo(classeComptable);
    }

    @PutMapping("/desarchiver/")
    public ClasseComptableVo desarchiver(@RequestBody ClasseComptableVo classeComptableVo) {
        ClasseComptable classeComptable = classeComptableService.desarchiver(classeComptableConverter.toItem(classeComptableVo));
        return classeComptableConverter.toVo(classeComptable);
    }
}
