package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.TypeSociete;
import com.ird.faa.service.admin.facade.TypeSocieteAdminService;
import com.ird.faa.ws.rest.provided.converter.TypeSocieteConverter;
import com.ird.faa.ws.rest.provided.vo.TypeSocieteVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages typeSociete services")
@RestController
@RequestMapping("api/admin/typeSociete")
public class TypeSocieteRestAdmin {

    @Autowired
    private TypeSocieteAdminService typeSocieteService;

    @Autowired
    private TypeSocieteConverter typeSocieteConverter;


    @ApiOperation("Updates the specified  typeSociete")
    @PutMapping("/")
    public TypeSocieteVo update(@RequestBody TypeSocieteVo typeSocieteVo) {
        TypeSociete typeSociete = typeSocieteConverter.toItem(typeSocieteVo);
        typeSociete = typeSocieteService.update(typeSociete);
        return typeSocieteConverter.toVo(typeSociete);
    }

    @ApiOperation("Finds a list of all typeSocietes")
    @GetMapping("/")
    public List<TypeSocieteVo> findAll() {
        return typeSocieteConverter.toVo(typeSocieteService.findAll());
    }

    @ApiOperation("Finds a typeSociete with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeSocieteVo findByIdWithAssociatedList(@PathVariable Long id) {
        return typeSocieteConverter.toVo(typeSocieteService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeSociete by a specific criteria")
    @PostMapping("/search")
    public List<TypeSocieteVo> findByCriteria(@RequestBody TypeSocieteVo typeSocieteVo) {
        return typeSocieteConverter.toVo(typeSocieteService.findByCriteria(typeSocieteVo));
    }

    @ApiOperation("Finds a typeSociete by id")
    @GetMapping("/id/{id}")
    public TypeSocieteVo findById(@PathVariable Long id) {
        return typeSocieteConverter.toVo(typeSocieteService.findById(id));
    }

    @ApiOperation("Saves the specified  typeSociete")
    @PostMapping("/")
    public TypeSocieteVo save(@RequestBody TypeSocieteVo typeSocieteVo) {
        TypeSociete typeSociete = typeSocieteConverter.toItem(typeSocieteVo);
        typeSociete = typeSocieteService.save(typeSociete);
        return typeSocieteConverter.toVo(typeSociete);
    }

    @ApiOperation("Delete the specified typeSociete")
    @DeleteMapping("/")
    public int delete(@RequestBody TypeSocieteVo typeSocieteVo) {
        TypeSociete typeSociete = typeSocieteConverter.toItem(typeSocieteVo);
        return typeSocieteService.delete(typeSociete);
    }

    @ApiOperation("Deletes a typeSociete by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return typeSocieteService.deleteById(id);
    }


}
