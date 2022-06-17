package com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.bean.EtatFacture;
import com.ird.faa.service.comptable.facade.EtatFactureComptableService;
import com.ird.faa.ws.rest.provided.converter.EtatFactureConverter;
import com.ird.faa.ws.rest.provided.vo.EtatFactureVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages etatFacture services")
@RestController
@RequestMapping("api/comptable/etatFacture")
public class EtatFactureRestComptable {

    @Autowired
    private EtatFactureComptableService etatFactureService;

    @Autowired
    private EtatFactureConverter etatFactureConverter;


    @ApiOperation("Updates the specified  etatFacture")
    @PutMapping("/")
    public EtatFactureVo update(@RequestBody EtatFactureVo etatFactureVo) {
        EtatFacture etatFacture = etatFactureConverter.toItem(etatFactureVo);
        etatFacture = etatFactureService.update(etatFacture);
        return etatFactureConverter.toVo(etatFacture);
    }

    @ApiOperation("Finds a list of all etatFactures")
    @GetMapping("/")
    public List<EtatFactureVo> findAll() {
        return etatFactureConverter.toVo(etatFactureService.findAll());
    }

    @ApiOperation("Finds a etatFacture with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatFactureVo findByIdWithAssociatedList(@PathVariable Long id) {
        return etatFactureConverter.toVo(etatFactureService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatFacture by a specific criteria")
    @PostMapping("/search")
    public List<EtatFactureVo> findByCriteria(@RequestBody EtatFactureVo etatFactureVo) {
        return etatFactureConverter.toVo(etatFactureService.findByCriteria(etatFactureVo));
    }

    @ApiOperation("Finds a etatFacture by id")
    @GetMapping("/id/{id}")
    public EtatFactureVo findById(@PathVariable Long id) {
        return etatFactureConverter.toVo(etatFactureService.findById(id));
    }

    @ApiOperation("Saves the specified  etatFacture")
    @PostMapping("/")
    public EtatFactureVo save(@RequestBody EtatFactureVo etatFactureVo) {
        EtatFacture etatFacture = etatFactureConverter.toItem(etatFactureVo);
        etatFacture = etatFactureService.save(etatFacture);
        return etatFactureConverter.toVo(etatFacture);
    }

    @ApiOperation("Delete the specified etatFacture")
    @DeleteMapping("/")
    public int delete(@RequestBody EtatFactureVo etatFactureVo) {
        EtatFacture etatFacture = etatFactureConverter.toItem(etatFactureVo);
        return etatFactureService.delete(etatFacture);
    }

    @ApiOperation("Deletes a etatFacture by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return etatFactureService.deleteById(id);
    }


}
