package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.EtatDeclarationTva;
import com.ird.faa.service.admin.facade.EtatDeclarationTvaAdminService;
import com.ird.faa.ws.rest.provided.converter.EtatDeclarationTvaConverter;
import com.ird.faa.ws.rest.provided.vo.EtatDeclarationTvaVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages etatDeclarationTva services")
@RestController
@RequestMapping("api/admin/etatDeclarationTva")
public class EtatDeclarationTvaRestAdmin {

    @Autowired
    private EtatDeclarationTvaAdminService etatDeclarationTvaService;

    @Autowired
    private EtatDeclarationTvaConverter etatDeclarationTvaConverter;


    @ApiOperation("Updates the specified  etatDeclarationTva")
    @PutMapping("/")
    public EtatDeclarationTvaVo update(@RequestBody EtatDeclarationTvaVo etatDeclarationTvaVo) {
        EtatDeclarationTva etatDeclarationTva = etatDeclarationTvaConverter.toItem(etatDeclarationTvaVo);
        etatDeclarationTva = etatDeclarationTvaService.update(etatDeclarationTva);
        return etatDeclarationTvaConverter.toVo(etatDeclarationTva);
    }

    @ApiOperation("Finds a list of all etatDeclarationTvas")
    @GetMapping("/")
    public List<EtatDeclarationTvaVo> findAll() {
        return etatDeclarationTvaConverter.toVo(etatDeclarationTvaService.findAll());
    }

    @ApiOperation("Finds a etatDeclarationTva with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatDeclarationTvaVo findByIdWithAssociatedList(@PathVariable Long id) {
        return etatDeclarationTvaConverter.toVo(etatDeclarationTvaService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatDeclarationTva by a specific criteria")
    @PostMapping("/search")
    public List<EtatDeclarationTvaVo> findByCriteria(@RequestBody EtatDeclarationTvaVo etatDeclarationTvaVo) {
        return etatDeclarationTvaConverter.toVo(etatDeclarationTvaService.findByCriteria(etatDeclarationTvaVo));
    }

    @ApiOperation("Finds a etatDeclarationTva by id")
    @GetMapping("/id/{id}")
    public EtatDeclarationTvaVo findById(@PathVariable Long id) {
        return etatDeclarationTvaConverter.toVo(etatDeclarationTvaService.findById(id));
    }

    @ApiOperation("Saves the specified  etatDeclarationTva")
    @PostMapping("/")
    public EtatDeclarationTvaVo save(@RequestBody EtatDeclarationTvaVo etatDeclarationTvaVo) {
        EtatDeclarationTva etatDeclarationTva = etatDeclarationTvaConverter.toItem(etatDeclarationTvaVo);
        etatDeclarationTva = etatDeclarationTvaService.save(etatDeclarationTva);
        return etatDeclarationTvaConverter.toVo(etatDeclarationTva);
    }

    @ApiOperation("Delete the specified etatDeclarationTva")
    @DeleteMapping("/")
    public int delete(@RequestBody EtatDeclarationTvaVo etatDeclarationTvaVo) {
        EtatDeclarationTva etatDeclarationTva = etatDeclarationTvaConverter.toItem(etatDeclarationTvaVo);
        return etatDeclarationTvaService.delete(etatDeclarationTva);
    }

    @ApiOperation("Deletes a etatDeclarationTva by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return etatDeclarationTvaService.deleteById(id);
    }


    @PutMapping("/archiver/")
    public EtatDeclarationTvaVo archiver(@RequestBody EtatDeclarationTvaVo etatDeclarationTvaVo) {
        EtatDeclarationTva etatDeclarationTva = etatDeclarationTvaService.archiver(etatDeclarationTvaConverter.toItem(etatDeclarationTvaVo));
        return etatDeclarationTvaConverter.toVo(etatDeclarationTva);
    }

    @PutMapping("/desarchiver/")
    public EtatDeclarationTvaVo desarchiver(@RequestBody EtatDeclarationTvaVo etatDeclarationTvaVo) {
        EtatDeclarationTva etatDeclarationTva = etatDeclarationTvaService.desarchiver(etatDeclarationTvaConverter.toItem(etatDeclarationTvaVo));
        return etatDeclarationTvaConverter.toVo(etatDeclarationTva);
    }
}
