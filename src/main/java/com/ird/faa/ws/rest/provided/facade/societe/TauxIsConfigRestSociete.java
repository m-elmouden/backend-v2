package com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.bean.TauxIsConfig;
import com.ird.faa.service.societe.facade.TauxIsConfigSocieteService;
import com.ird.faa.ws.rest.provided.converter.TauxIsConfigConverter;
import com.ird.faa.ws.rest.provided.vo.TauxIsConfigVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages tauxIsConfig services")
@RestController
@RequestMapping("api/societe/tauxIsConfig")
public class TauxIsConfigRestSociete {

    @Autowired
    private TauxIsConfigSocieteService tauxIsConfigService;

    @Autowired
    private TauxIsConfigConverter tauxIsConfigConverter;


    @ApiOperation("Updates the specified  tauxIsConfig")
    @PutMapping("/")
    public TauxIsConfigVo update(@RequestBody TauxIsConfigVo tauxIsConfigVo) {
        TauxIsConfig tauxIsConfig = tauxIsConfigConverter.toItem(tauxIsConfigVo);
        tauxIsConfig = tauxIsConfigService.update(tauxIsConfig);
        return tauxIsConfigConverter.toVo(tauxIsConfig);
    }

    @ApiOperation("Finds a list of all tauxIsConfigs")
    @GetMapping("/")
    public List<TauxIsConfigVo> findAll() {
        return tauxIsConfigConverter.toVo(tauxIsConfigService.findAll());
    }

    @ApiOperation("Finds a tauxIsConfig with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TauxIsConfigVo findByIdWithAssociatedList(@PathVariable Long id) {
        return tauxIsConfigConverter.toVo(tauxIsConfigService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search tauxIsConfig by a specific criteria")
    @PostMapping("/search")
    public List<TauxIsConfigVo> findByCriteria(@RequestBody TauxIsConfigVo tauxIsConfigVo) {
        return tauxIsConfigConverter.toVo(tauxIsConfigService.findByCriteria(tauxIsConfigVo));
    }

    @ApiOperation("Finds a tauxIsConfig by id")
    @GetMapping("/id/{id}")
    public TauxIsConfigVo findById(@PathVariable Long id) {
        return tauxIsConfigConverter.toVo(tauxIsConfigService.findById(id));
    }

    @ApiOperation("Saves the specified  tauxIsConfig")
    @PostMapping("/")
    public TauxIsConfigVo save(@RequestBody TauxIsConfigVo tauxIsConfigVo) {
        TauxIsConfig tauxIsConfig = tauxIsConfigConverter.toItem(tauxIsConfigVo);
        tauxIsConfig = tauxIsConfigService.save(tauxIsConfig);
        return tauxIsConfigConverter.toVo(tauxIsConfig);
    }

    @ApiOperation("Delete the specified tauxIsConfig")
    @DeleteMapping("/")
    public int delete(@RequestBody TauxIsConfigVo tauxIsConfigVo) {
        TauxIsConfig tauxIsConfig = tauxIsConfigConverter.toItem(tauxIsConfigVo);
        return tauxIsConfigService.delete(tauxIsConfig);
    }

    @ApiOperation("Deletes a tauxIsConfig by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return tauxIsConfigService.deleteById(id);
    }


}
