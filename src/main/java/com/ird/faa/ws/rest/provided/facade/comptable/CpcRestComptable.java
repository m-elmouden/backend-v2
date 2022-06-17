package com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.bean.Cpc;
import com.ird.faa.service.comptable.facade.CpcComptableService;
import com.ird.faa.ws.rest.provided.converter.CpcConverter;
import com.ird.faa.ws.rest.provided.vo.CpcVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages cpc services")
@RestController
@RequestMapping("api/comptable/cpc")
public class CpcRestComptable {

    @Autowired
    private CpcComptableService cpcService;

    @Autowired
    private CpcConverter cpcConverter;


    @ApiOperation("Updates the specified  cpc")
    @PutMapping("/")
    public CpcVo update(@RequestBody CpcVo cpcVo) {
        Cpc cpc = cpcConverter.toItem(cpcVo);
        cpc = cpcService.update(cpc);
        return cpcConverter.toVo(cpc);
    }

    @ApiOperation("Finds a list of all cpcs")
    @GetMapping("/")
    public List<CpcVo> findAll() {
        return cpcConverter.toVo(cpcService.findAll());
    }

    @ApiOperation("Finds a cpc with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CpcVo findByIdWithAssociatedList(@PathVariable Long id) {
        return cpcConverter.toVo(cpcService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search cpc by a specific criteria")
    @PostMapping("/search")
    public List<CpcVo> findByCriteria(@RequestBody CpcVo cpcVo) {
        return cpcConverter.toVo(cpcService.findByCriteria(cpcVo));
    }

    @ApiOperation("Finds a cpc by id")
    @GetMapping("/id/{id}")
    public CpcVo findById(@PathVariable Long id) {
        return cpcConverter.toVo(cpcService.findById(id));
    }

    @ApiOperation("Saves the specified  cpc")
    @PostMapping("/")
    public CpcVo save(@RequestBody CpcVo cpcVo) {
        Cpc cpc = cpcConverter.toItem(cpcVo);
        cpc = cpcService.save(cpc);
        return cpcConverter.toVo(cpc);
    }

    @ApiOperation("Delete the specified cpc")
    @DeleteMapping("/")
    public int delete(@RequestBody CpcVo cpcVo) {
        Cpc cpc = cpcConverter.toItem(cpcVo);
        return cpcService.delete(cpc);
    }

    @ApiOperation("Deletes a cpc by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return cpcService.deleteById(id);
    }


    @PutMapping("/archiver/")
    public CpcVo archiver(@RequestBody CpcVo cpcVo) {
        Cpc cpc = cpcService.archiver(cpcConverter.toItem(cpcVo));
        return cpcConverter.toVo(cpc);
    }

    @PutMapping("/desarchiver/")
    public CpcVo desarchiver(@RequestBody CpcVo cpcVo) {
        Cpc cpc = cpcService.desarchiver(cpcConverter.toItem(cpcVo));
        return cpcConverter.toVo(cpc);
    }
}
