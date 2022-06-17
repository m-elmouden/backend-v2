package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.TypeEmploye;
import com.ird.faa.service.admin.facade.TypeEmployeAdminService;
import com.ird.faa.ws.rest.provided.converter.TypeEmployeConverter;
import com.ird.faa.ws.rest.provided.vo.TypeEmployeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages typeEmploye services")
@RestController
@RequestMapping("api/admin/typeEmploye")
public class TypeEmployeRestAdmin {

    @Autowired
    private TypeEmployeAdminService typeEmployeService;

    @Autowired
    private TypeEmployeConverter typeEmployeConverter;


    @ApiOperation("Updates the specified  typeEmploye")
    @PutMapping("/")
    public TypeEmployeVo update(@RequestBody TypeEmployeVo typeEmployeVo) {
        TypeEmploye typeEmploye = typeEmployeConverter.toItem(typeEmployeVo);
        typeEmploye = typeEmployeService.update(typeEmploye);
        return typeEmployeConverter.toVo(typeEmploye);
    }

    @ApiOperation("Finds a list of all typeEmployes")
    @GetMapping("/")
    public List<TypeEmployeVo> findAll() {
        return typeEmployeConverter.toVo(typeEmployeService.findAll());
    }

    @ApiOperation("Finds a typeEmploye with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeEmployeVo findByIdWithAssociatedList(@PathVariable Long id) {
        return typeEmployeConverter.toVo(typeEmployeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeEmploye by a specific criteria")
    @PostMapping("/search")
    public List<TypeEmployeVo> findByCriteria(@RequestBody TypeEmployeVo typeEmployeVo) {
        return typeEmployeConverter.toVo(typeEmployeService.findByCriteria(typeEmployeVo));
    }

    @ApiOperation("Finds a typeEmploye by id")
    @GetMapping("/id/{id}")
    public TypeEmployeVo findById(@PathVariable Long id) {
        return typeEmployeConverter.toVo(typeEmployeService.findById(id));
    }

    @ApiOperation("Saves the specified  typeEmploye")
    @PostMapping("/")
    public TypeEmployeVo save(@RequestBody TypeEmployeVo typeEmployeVo) {
        TypeEmploye typeEmploye = typeEmployeConverter.toItem(typeEmployeVo);
        typeEmploye = typeEmployeService.save(typeEmploye);
        return typeEmployeConverter.toVo(typeEmploye);
    }

    @ApiOperation("Delete the specified typeEmploye")
    @DeleteMapping("/")
    public int delete(@RequestBody TypeEmployeVo typeEmployeVo) {
        TypeEmploye typeEmploye = typeEmployeConverter.toItem(typeEmployeVo);
        return typeEmployeService.delete(typeEmploye);
    }

    @ApiOperation("Deletes a typeEmploye by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return typeEmployeService.deleteById(id);
    }


}
