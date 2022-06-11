package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.DeclarationIs;
import com.ird.faa.service.admin.facade.DeclarationIrAdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.ird.faa.bean.DeclarationIr;
import com.ird.faa.ws.rest.provided.converter.DeclarationIrConverter;
import com.ird.faa.ws.rest.provided.vo.DeclarationIrVo;

@Api("Manages declarationIr services")
@RestController
@RequestMapping("api/admin/declarationIr")
public class DeclarationIrRestAdmin {

    @Autowired
    private DeclarationIrAdminService declarationIrService;

    @Autowired
    private DeclarationIrConverter declarationIrConverter;


    @ApiOperation("Updates the specified  declarationIr")
    @PutMapping("/")
    public DeclarationIrVo update(@RequestBody DeclarationIrVo declarationIrVo) {
        DeclarationIr declarationIr = declarationIrConverter.toItem(declarationIrVo);
        declarationIr = declarationIrService.update(declarationIr);
        return declarationIrConverter.toVo(declarationIr);
    }

    @ApiOperation("Finds a list of all declarationIrs")
    @GetMapping("/")
    public List<DeclarationIrVo> findAll() {
        return declarationIrConverter.toVo(declarationIrService.findAll());
    }

    @ApiOperation("Finds a declarationIr with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DeclarationIrVo findByIdWithAssociatedList(@PathVariable Long id) {
        return declarationIrConverter.toVo(declarationIrService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search declarationIr by a specific criteria")
    @PostMapping("/search")
    public List<DeclarationIrVo> findByCriteria(@RequestBody DeclarationIrVo declarationIrVo) {
        return declarationIrConverter.toVo(declarationIrService.findByCriteria(declarationIrVo));
    }

    @ApiOperation("Finds a declarationIr by id")
    @GetMapping("/id/{id}")
    public DeclarationIrVo findById(@PathVariable Long id) {
        return declarationIrConverter.toVo(declarationIrService.findById(id));
    }

    @ApiOperation("Saves the specified  declarationIr")
    @PostMapping("/")
    public DeclarationIrVo save(@RequestBody DeclarationIrVo declarationIrVo) {
        DeclarationIr declarationIr = declarationIrConverter.toItem(declarationIrVo);
        declarationIr = declarationIrService.save(declarationIr);

        return declarationIrConverter.toVo(declarationIr);

    }

    @ApiOperation("Delete the specified declarationIr")
    @DeleteMapping("/")
    public int delete(@RequestBody DeclarationIrVo declarationIrVo) {
        DeclarationIr declarationIr = declarationIrConverter.toItem(declarationIrVo);
        return declarationIrService.delete(declarationIr);
    }

    @ApiOperation("Deletes a declarationIr by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return declarationIrService.deleteById(id);
    }

    @ApiOperation("find by societe id")
    @GetMapping("/societe/id/{id}")
    public List<DeclarationIr> findBySocieteId(@PathVariable Long id) {
        return declarationIrService.findBySocieteId(id);
    }

    @ApiOperation("delete by societe id")
    @DeleteMapping("/societe/id/{id}")
    public int deleteBySocieteId(@PathVariable Long id) {
        return declarationIrService.deleteBySocieteId(id);
    }

    @ApiOperation("find by etatDeclarationIr reference")
    @GetMapping("/etatDeclarationIr/reference/{reference}")
    public List<DeclarationIr> findByEtatDeclarationIrReference(@PathVariable String reference) {
        return declarationIrService.findByEtatDeclarationIrReference(reference);
    }

    @ApiOperation("delete by etatDeclarationIr reference")
    @DeleteMapping("/etatDeclarationIr/reference/{reference}")
    public int deleteByEtatDeclarationIrReference(@PathVariable String reference) {
        return declarationIrService.deleteByEtatDeclarationIrReference(reference);
    }

    @ApiOperation("find by etatDeclarationIr id")
    @GetMapping("/etatDeclarationIr/id/{id}")
    public List<DeclarationIr> findByEtatDeclarationIrId(@PathVariable Long id) {
        return declarationIrService.findByEtatDeclarationIrId(id);
    }

    @ApiOperation("delete by etatDeclarationIr id")
    @DeleteMapping("/etatDeclarationIr/id/{id}")
    public int deleteByEtatDeclarationIrId(@PathVariable Long id) {
        return declarationIrService.deleteByEtatDeclarationIrId(id);
    }

    @ApiOperation("find by paiementDeclarationIr reference")
    @GetMapping("/paiementDeclarationIr/reference/{reference}")
    public List<DeclarationIr> findByPaiementDeclarationIrReference(@PathVariable String reference) {
        return declarationIrService.findByPaiementDeclarationIrReference(reference);
    }

    @ApiOperation("delete by paiementDeclarationIr reference")
    @DeleteMapping("/paiementDeclarationIr/reference/{reference}")
    public int deleteByPaiementDeclarationIrReference(@PathVariable String reference) {
        return declarationIrService.deleteByPaiementDeclarationIrReference(reference);
    }

    @ApiOperation("find by paiementDeclarationIr id")
    @GetMapping("/paiementDeclarationIr/id/{id}")
    public List<DeclarationIr> findByPaiementDeclarationIrId(@PathVariable Long id) {
        return declarationIrService.findByPaiementDeclarationIrId(id);
    }

    @ApiOperation("delete by paiementDeclarationIr id")
    @DeleteMapping("/paiementDeclarationIr/id/{id}")
    public int deleteByPaiementDeclarationIrId(@PathVariable Long id) {
        return declarationIrService.deleteByPaiementDeclarationIrId(id);
    }


    @PutMapping("/archiver/")
    public DeclarationIrVo archiver(@RequestBody DeclarationIrVo declarationIrVo) {
        DeclarationIr declarationIr = declarationIrService.archiver(declarationIrConverter.toItem(declarationIrVo));
        return declarationIrConverter.toVo(declarationIr);
    }

    @PutMapping("/desarchiver/")
    public DeclarationIrVo desarchiver(@RequestBody DeclarationIrVo declarationIrVo) {
        DeclarationIr declarationIr = declarationIrService.desarchiver(declarationIrConverter.toItem(declarationIrVo));
        return declarationIrConverter.toVo(declarationIr);
    }
    @PostMapping("/toXML/")
    public void declarationIrToXML(@RequestBody DeclarationIr declarationIR) {
        declarationIrService.declarationIrToXML(declarationIR);
    }
}

