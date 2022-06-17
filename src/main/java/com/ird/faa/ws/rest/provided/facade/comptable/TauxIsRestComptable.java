package com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.bean.TauxIs;
import com.ird.faa.service.comptable.facade.TauxIsComptableService;
import com.ird.faa.ws.rest.provided.converter.TauxIsConverter;
import com.ird.faa.ws.rest.provided.vo.TauxIsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages tauxIs services")
@RestController
@RequestMapping("api/comptable/tauxIs")
public class TauxIsRestComptable {

    @Autowired
    private TauxIsComptableService tauxIsService;

    @Autowired
    private TauxIsConverter tauxIsConverter;


    @ApiOperation("Updates the specified  tauxIs")
    @PutMapping("/")
    public TauxIsVo update(@RequestBody TauxIsVo tauxIsVo) {
        TauxIs tauxIs = tauxIsConverter.toItem(tauxIsVo);
        tauxIs = tauxIsService.update(tauxIs);
        return tauxIsConverter.toVo(tauxIs);
    }

    @ApiOperation("Finds a list of all tauxIss")
    @GetMapping("/")
    public List<TauxIsVo> findAll() {
        return tauxIsConverter.toVo(tauxIsService.findAll());
    }

    @ApiOperation("Finds a tauxIs with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TauxIsVo findByIdWithAssociatedList(@PathVariable Long id) {
        return tauxIsConverter.toVo(tauxIsService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search tauxIs by a specific criteria")
    @PostMapping("/search")
    public List<TauxIsVo> findByCriteria(@RequestBody TauxIsVo tauxIsVo) {
        return tauxIsConverter.toVo(tauxIsService.findByCriteria(tauxIsVo));
    }

    @ApiOperation("Finds a tauxIs by id")
    @GetMapping("/id/{id}")
    public TauxIsVo findById(@PathVariable Long id) {
        return tauxIsConverter.toVo(tauxIsService.findById(id));
    }

    @ApiOperation("Saves the specified  tauxIs")
    @PostMapping("/")
    public TauxIsVo save(@RequestBody TauxIsVo tauxIsVo) {
        TauxIs tauxIs = tauxIsConverter.toItem(tauxIsVo);
        tauxIs = tauxIsService.save(tauxIs);
        return tauxIsConverter.toVo(tauxIs);
    }

    @ApiOperation("Delete the specified tauxIs")
    @DeleteMapping("/")
    public int delete(@RequestBody TauxIsVo tauxIsVo) {
        TauxIs tauxIs = tauxIsConverter.toItem(tauxIsVo);
        return tauxIsService.delete(tauxIs);
    }

    @ApiOperation("Deletes a tauxIs by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return tauxIsService.deleteById(id);
    }

    @ApiOperation("find by tauxIsConfig reference")
    @GetMapping("/tauxIsConfig/reference/{reference}")
    public List<TauxIs> findByTauxIsConfigReference(@PathVariable String reference) {
        return tauxIsService.findByTauxIsConfigReference(reference);
    }

    @ApiOperation("delete by tauxIsConfig reference")
    @DeleteMapping("/tauxIsConfig/reference/{reference}")
    public int deleteByTauxIsConfigReference(@PathVariable String reference) {
        return tauxIsService.deleteByTauxIsConfigReference(reference);
    }

    @ApiOperation("find by tauxIsConfig id")
    @GetMapping("/tauxIsConfig/id/{id}")
    public List<TauxIs> findByTauxIsConfigId(@PathVariable Long id) {
        return tauxIsService.findByTauxIsConfigId(id);
    }

    @ApiOperation("delete by tauxIsConfig id")
    @DeleteMapping("/tauxIsConfig/id/{id}")
    public int deleteByTauxIsConfigId(@PathVariable Long id) {
        return tauxIsService.deleteByTauxIsConfigId(id);
    }


}
