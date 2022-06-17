package com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.bean.EtatDeclarationIs;
import com.ird.faa.service.societe.facade.EtatDeclarationIsSocieteService;
import com.ird.faa.ws.rest.provided.converter.EtatDeclarationIsConverter;
import com.ird.faa.ws.rest.provided.vo.EtatDeclarationIsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages etatDeclarationIs services")
@RestController
@RequestMapping("api/societe/etatDeclarationIs")
public class EtatDeclarationIsRestSociete {

    @Autowired
    private EtatDeclarationIsSocieteService etatDeclarationIsService;

    @Autowired
    private EtatDeclarationIsConverter etatDeclarationIsConverter;


    @ApiOperation("Updates the specified  etatDeclarationIs")
    @PutMapping("/")
    public EtatDeclarationIsVo update(@RequestBody EtatDeclarationIsVo etatDeclarationIsVo) {
        EtatDeclarationIs etatDeclarationIs = etatDeclarationIsConverter.toItem(etatDeclarationIsVo);
        etatDeclarationIs = etatDeclarationIsService.update(etatDeclarationIs);
        return etatDeclarationIsConverter.toVo(etatDeclarationIs);
    }

    @ApiOperation("Finds a list of all etatDeclarationIss")
    @GetMapping("/")
    public List<EtatDeclarationIsVo> findAll() {
        return etatDeclarationIsConverter.toVo(etatDeclarationIsService.findAll());
    }

    @ApiOperation("Finds a etatDeclarationIs with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatDeclarationIsVo findByIdWithAssociatedList(@PathVariable Long id) {
        return etatDeclarationIsConverter.toVo(etatDeclarationIsService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatDeclarationIs by a specific criteria")
    @PostMapping("/search")
    public List<EtatDeclarationIsVo> findByCriteria(@RequestBody EtatDeclarationIsVo etatDeclarationIsVo) {
        return etatDeclarationIsConverter.toVo(etatDeclarationIsService.findByCriteria(etatDeclarationIsVo));
    }

    @ApiOperation("Finds a etatDeclarationIs by id")
    @GetMapping("/id/{id}")
    public EtatDeclarationIsVo findById(@PathVariable Long id) {
        return etatDeclarationIsConverter.toVo(etatDeclarationIsService.findById(id));
    }

    @ApiOperation("Saves the specified  etatDeclarationIs")
    @PostMapping("/")
    public EtatDeclarationIsVo save(@RequestBody EtatDeclarationIsVo etatDeclarationIsVo) {
        EtatDeclarationIs etatDeclarationIs = etatDeclarationIsConverter.toItem(etatDeclarationIsVo);
        etatDeclarationIs = etatDeclarationIsService.save(etatDeclarationIs);
        return etatDeclarationIsConverter.toVo(etatDeclarationIs);
    }

    @ApiOperation("Delete the specified etatDeclarationIs")
    @DeleteMapping("/")
    public int delete(@RequestBody EtatDeclarationIsVo etatDeclarationIsVo) {
        EtatDeclarationIs etatDeclarationIs = etatDeclarationIsConverter.toItem(etatDeclarationIsVo);
        return etatDeclarationIsService.delete(etatDeclarationIs);
    }

    @ApiOperation("Deletes a etatDeclarationIs by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return etatDeclarationIsService.deleteById(id);
    }


    @PutMapping("/archiver/")
    public EtatDeclarationIsVo archiver(@RequestBody EtatDeclarationIsVo etatDeclarationIsVo) {
        EtatDeclarationIs etatDeclarationIs = etatDeclarationIsService.archiver(etatDeclarationIsConverter.toItem(etatDeclarationIsVo));
        return etatDeclarationIsConverter.toVo(etatDeclarationIs);
    }

    @PutMapping("/desarchiver/")
    public EtatDeclarationIsVo desarchiver(@RequestBody EtatDeclarationIsVo etatDeclarationIsVo) {
        EtatDeclarationIs etatDeclarationIs = etatDeclarationIsService.desarchiver(etatDeclarationIsConverter.toItem(etatDeclarationIsVo));
        return etatDeclarationIsConverter.toVo(etatDeclarationIs);
    }
}
