package com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.service.societe.facade.EmployeSocieteService;
import com.ird.faa.upload.employe.model.Employe;
import com.ird.faa.ws.rest.provided.converter.EmployeConverter;
import com.ird.faa.ws.rest.provided.vo.EmployeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages employe services")
@RestController
@RequestMapping("api/societe/employe")
public class EmployeRestSociete {

    @Autowired
    private EmployeSocieteService employeService;

    @Autowired
    private EmployeConverter employeConverter;


    @ApiOperation("Updates the specified  employe")
    @PutMapping("/")
    public EmployeVo update(@RequestBody EmployeVo employeVo) {
        Employe employe = employeConverter.toItem(employeVo);
        employe = employeService.update(employe);
        return employeConverter.toVo(employe);
    }

    @ApiOperation("Finds a list of all employes")
    @GetMapping("/")
    public List<EmployeVo> findAll() {
        return employeConverter.toVo(employeService.findAll());
    }

    @ApiOperation("Finds a employe with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EmployeVo findByIdWithAssociatedList(@PathVariable Long id) {
        return employeConverter.toVo(employeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search employe by a specific criteria")
    @PostMapping("/search")
    public List<EmployeVo> findByCriteria(@RequestBody EmployeVo employeVo) {
        return employeConverter.toVo(employeService.findByCriteria(employeVo));
    }

    @ApiOperation("Finds a employe by id")
    @GetMapping("/id/{id}")
    public EmployeVo findById(@PathVariable Long id) {
        return employeConverter.toVo(employeService.findById(id));
    }

    @ApiOperation("Saves the specified  employe")
    @PostMapping("/")
    public EmployeVo save(@RequestBody EmployeVo employeVo) {
        Employe employe = employeConverter.toItem(employeVo);
        employe = employeService.save(employe);
        return employeConverter.toVo(employe);
    }

    @ApiOperation("Delete the specified employe")
    @DeleteMapping("/")
    public int delete(@RequestBody EmployeVo employeVo) {
        Employe employe = employeConverter.toItem(employeVo);
        return employeService.delete(employe);
    }

    @ApiOperation("Deletes a employe by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return employeService.deleteById(id);
    }

    @ApiOperation("find by typeEmploye code")
    @GetMapping("/typeEmploye/code/{code}")
    public List<Employe> findByTypeEmployeCode(@PathVariable String code) {
        return employeService.findByTypeEmployeCode(code);
    }

    @ApiOperation("delete by typeEmploye code")
    @DeleteMapping("/typeEmploye/code/{code}")
    public int deleteByTypeEmployeCode(@PathVariable String code) {
        return employeService.deleteByTypeEmployeCode(code);
    }

    @ApiOperation("find by typeEmploye id")
    @GetMapping("/typeEmploye/id/{id}")
    public List<Employe> findByTypeEmployeId(@PathVariable Long id) {
        return employeService.findByTypeEmployeId(id);
    }

    @ApiOperation("delete by typeEmploye id")
    @DeleteMapping("/typeEmploye/id/{id}")
    public int deleteByTypeEmployeId(@PathVariable Long id) {
        return employeService.deleteByTypeEmployeId(id);
    }

    @ApiOperation("find by societe id")
    @GetMapping("/societe/id/{id}")
    public List<Employe> findBySocieteId(@PathVariable Long id) {
        return employeService.findBySocieteId(id);
    }

    @ApiOperation("delete by societe id")
    @DeleteMapping("/societe/id/{id}")
    public int deleteBySocieteId(@PathVariable Long id) {
        return employeService.deleteBySocieteId(id);
    }

    @ApiOperation("find by declarationCnss ref")
    @GetMapping("/declarationCnss/ref/{ref}")
    public List<Employe> findByDeclarationCnssRef(@PathVariable String ref) {
        return employeService.findByDeclarationCnssRef(ref);
    }

    @ApiOperation("delete by declarationCnss ref")
    @DeleteMapping("/declarationCnss/ref/{ref}")
    public int deleteByDeclarationCnssRef(@PathVariable String ref) {
        return employeService.deleteByDeclarationCnssRef(ref);
    }

    @ApiOperation("find by declarationCnss id")
    @GetMapping("/declarationCnss/id/{id}")
    public List<Employe> findByDeclarationCnssId(@PathVariable Long id) {
        return employeService.findByDeclarationCnssId(id);
    }

    @ApiOperation("delete by declarationCnss id")
    @DeleteMapping("/declarationCnss/id/{id}")
    public int deleteByDeclarationCnssId(@PathVariable Long id) {
        return employeService.deleteByDeclarationCnssId(id);
    }


}
