package com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.bean.PresidentSociete;
import com.ird.faa.service.societe.facade.PresidentSocieteSocieteService;
import com.ird.faa.ws.rest.provided.converter.PresidentSocieteConverter;
import com.ird.faa.ws.rest.provided.vo.PresidentSocieteVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages presidentSociete services")
@RestController
@RequestMapping("api/societe/presidentSociete")
public class PresidentSocieteRestSociete {

    @Autowired
    private PresidentSocieteSocieteService presidentSocieteService;

    @Autowired
    private PresidentSocieteConverter presidentSocieteConverter;


    @ApiOperation("Updates the specified  presidentSociete")
    @PutMapping("/")
    public PresidentSocieteVo update(@RequestBody PresidentSocieteVo presidentSocieteVo) {
        PresidentSociete presidentSociete = presidentSocieteConverter.toItem(presidentSocieteVo);
        presidentSociete = presidentSocieteService.update(presidentSociete);
        return presidentSocieteConverter.toVo(presidentSociete);
    }

    @ApiOperation("Finds a list of all presidentSocietes")
    @GetMapping("/")
    public List<PresidentSocieteVo> findAll() {
        return presidentSocieteConverter.toVo(presidentSocieteService.findAll());
    }

    @ApiOperation("Finds a presidentSociete with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PresidentSocieteVo findByIdWithAssociatedList(@PathVariable Long id) {
        return presidentSocieteConverter.toVo(presidentSocieteService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search presidentSociete by a specific criteria")
    @PostMapping("/search")
    public List<PresidentSocieteVo> findByCriteria(@RequestBody PresidentSocieteVo presidentSocieteVo) {
        return presidentSocieteConverter.toVo(presidentSocieteService.findByCriteria(presidentSocieteVo));
    }

    @ApiOperation("Finds a presidentSociete by id")
    @GetMapping("/id/{id}")
    public PresidentSocieteVo findById(@PathVariable Long id) {
        return presidentSocieteConverter.toVo(presidentSocieteService.findById(id));
    }

    @ApiOperation("Saves the specified  presidentSociete")
    @PostMapping("/")
    public PresidentSocieteVo save(@RequestBody PresidentSocieteVo presidentSocieteVo) {
        PresidentSociete presidentSociete = presidentSocieteConverter.toItem(presidentSocieteVo);
        presidentSociete = presidentSocieteService.save(presidentSociete);
        return presidentSocieteConverter.toVo(presidentSociete);
    }

    @ApiOperation("Delete the specified presidentSociete")
    @DeleteMapping("/")
    public int delete(@RequestBody PresidentSocieteVo presidentSocieteVo) {
        PresidentSociete presidentSociete = presidentSocieteConverter.toItem(presidentSocieteVo);
        return presidentSocieteService.delete(presidentSociete);
    }

    @ApiOperation("Deletes a presidentSociete by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return presidentSocieteService.deleteById(id);
    }

    @ApiOperation("find by societe id")
    @GetMapping("/societe/id/{id}")
    public List<PresidentSociete> findBySocieteId(@PathVariable Long id) {
        return presidentSocieteService.findBySocieteId(id);
    }

    @ApiOperation("delete by societe id")
    @DeleteMapping("/societe/id/{id}")
    public int deleteBySocieteId(@PathVariable Long id) {
        return presidentSocieteService.deleteBySocieteId(id);
    }


}
