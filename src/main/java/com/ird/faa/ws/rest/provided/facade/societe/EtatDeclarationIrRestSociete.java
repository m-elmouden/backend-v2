package com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.bean.EtatDeclarationIr;
import com.ird.faa.service.societe.facade.EtatDeclarationIrSocieteService;
import com.ird.faa.ws.rest.provided.converter.EtatDeclarationIrConverter;
import com.ird.faa.ws.rest.provided.vo.EtatDeclarationIrVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages etatDeclarationIr services")
@RestController
@RequestMapping("api/societe/etatDeclarationIr")
public class EtatDeclarationIrRestSociete {

    @Autowired
    private EtatDeclarationIrSocieteService etatDeclarationIrService;

    @Autowired
    private EtatDeclarationIrConverter etatDeclarationIrConverter;


    @ApiOperation("Updates the specified  etatDeclarationIr")
    @PutMapping("/")
    public EtatDeclarationIrVo update(@RequestBody EtatDeclarationIrVo etatDeclarationIrVo) {
        EtatDeclarationIr etatDeclarationIr = etatDeclarationIrConverter.toItem(etatDeclarationIrVo);
        etatDeclarationIr = etatDeclarationIrService.update(etatDeclarationIr);
        return etatDeclarationIrConverter.toVo(etatDeclarationIr);
    }

    @ApiOperation("Finds a list of all etatDeclarationIrs")
    @GetMapping("/")
    public List<EtatDeclarationIrVo> findAll() {
        return etatDeclarationIrConverter.toVo(etatDeclarationIrService.findAll());
    }

    @ApiOperation("Finds a etatDeclarationIr with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatDeclarationIrVo findByIdWithAssociatedList(@PathVariable Long id) {
        return etatDeclarationIrConverter.toVo(etatDeclarationIrService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatDeclarationIr by a specific criteria")
    @PostMapping("/search")
    public List<EtatDeclarationIrVo> findByCriteria(@RequestBody EtatDeclarationIrVo etatDeclarationIrVo) {
        return etatDeclarationIrConverter.toVo(etatDeclarationIrService.findByCriteria(etatDeclarationIrVo));
    }

    @ApiOperation("Finds a etatDeclarationIr by id")
    @GetMapping("/id/{id}")
    public EtatDeclarationIrVo findById(@PathVariable Long id) {
        return etatDeclarationIrConverter.toVo(etatDeclarationIrService.findById(id));
    }

    @ApiOperation("Saves the specified  etatDeclarationIr")
    @PostMapping("/")
    public EtatDeclarationIrVo save(@RequestBody EtatDeclarationIrVo etatDeclarationIrVo) {
        EtatDeclarationIr etatDeclarationIr = etatDeclarationIrConverter.toItem(etatDeclarationIrVo);
        etatDeclarationIr = etatDeclarationIrService.save(etatDeclarationIr);
        return etatDeclarationIrConverter.toVo(etatDeclarationIr);
    }

    @ApiOperation("Delete the specified etatDeclarationIr")
    @DeleteMapping("/")
    public int delete(@RequestBody EtatDeclarationIrVo etatDeclarationIrVo) {
        EtatDeclarationIr etatDeclarationIr = etatDeclarationIrConverter.toItem(etatDeclarationIrVo);
        return etatDeclarationIrService.delete(etatDeclarationIr);
    }

    @ApiOperation("Deletes a etatDeclarationIr by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return etatDeclarationIrService.deleteById(id);
    }


    @PutMapping("/archiver/")
    public EtatDeclarationIrVo archiver(@RequestBody EtatDeclarationIrVo etatDeclarationIrVo) {
        EtatDeclarationIr etatDeclarationIr = etatDeclarationIrService.archiver(etatDeclarationIrConverter.toItem(etatDeclarationIrVo));
        return etatDeclarationIrConverter.toVo(etatDeclarationIr);
    }

    @PutMapping("/desarchiver/")
    public EtatDeclarationIrVo desarchiver(@RequestBody EtatDeclarationIrVo etatDeclarationIrVo) {
        EtatDeclarationIr etatDeclarationIr = etatDeclarationIrService.desarchiver(etatDeclarationIrConverter.toItem(etatDeclarationIrVo));
        return etatDeclarationIrConverter.toVo(etatDeclarationIr);
    }
}
