package com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.bean.TypeOperationFacture;
import com.ird.faa.service.societe.facade.TypeOperationFactureSocieteService;
import com.ird.faa.ws.rest.provided.converter.TypeOperationFactureConverter;
import com.ird.faa.ws.rest.provided.vo.TypeOperationFactureVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages typeOperationFacture services")
@RestController
@RequestMapping("api/societe/typeOperationFacture")
public class TypeOperationFactureRestSociete {

    @Autowired
    private TypeOperationFactureSocieteService typeOperationFactureService;

    @Autowired
    private TypeOperationFactureConverter typeOperationFactureConverter;


    @ApiOperation("Updates the specified  typeOperationFacture")
    @PutMapping("/")
    public TypeOperationFactureVo update(@RequestBody TypeOperationFactureVo typeOperationFactureVo) {
        TypeOperationFacture typeOperationFacture = typeOperationFactureConverter.toItem(typeOperationFactureVo);
        typeOperationFacture = typeOperationFactureService.update(typeOperationFacture);
        return typeOperationFactureConverter.toVo(typeOperationFacture);
    }

    @ApiOperation("Finds a list of all typeOperationFactures")
    @GetMapping("/")
    public List<TypeOperationFactureVo> findAll() {
        return typeOperationFactureConverter.toVo(typeOperationFactureService.findAll());
    }

    @ApiOperation("Finds a typeOperationFacture with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeOperationFactureVo findByIdWithAssociatedList(@PathVariable Long id) {
        return typeOperationFactureConverter.toVo(typeOperationFactureService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeOperationFacture by a specific criteria")
    @PostMapping("/search")
    public List<TypeOperationFactureVo> findByCriteria(@RequestBody TypeOperationFactureVo typeOperationFactureVo) {
        return typeOperationFactureConverter.toVo(typeOperationFactureService.findByCriteria(typeOperationFactureVo));
    }

    @ApiOperation("Finds a typeOperationFacture by id")
    @GetMapping("/id/{id}")
    public TypeOperationFactureVo findById(@PathVariable Long id) {
        return typeOperationFactureConverter.toVo(typeOperationFactureService.findById(id));
    }

    @ApiOperation("Saves the specified  typeOperationFacture")
    @PostMapping("/")
    public TypeOperationFactureVo save(@RequestBody TypeOperationFactureVo typeOperationFactureVo) {
        TypeOperationFacture typeOperationFacture = typeOperationFactureConverter.toItem(typeOperationFactureVo);
        typeOperationFacture = typeOperationFactureService.save(typeOperationFacture);
        return typeOperationFactureConverter.toVo(typeOperationFacture);
    }

    @ApiOperation("Delete the specified typeOperationFacture")
    @DeleteMapping("/")
    public int delete(@RequestBody TypeOperationFactureVo typeOperationFactureVo) {
        TypeOperationFacture typeOperationFacture = typeOperationFactureConverter.toItem(typeOperationFactureVo);
        return typeOperationFactureService.delete(typeOperationFacture);
    }

    @ApiOperation("Deletes a typeOperationFacture by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return typeOperationFactureService.deleteById(id);
    }


}
