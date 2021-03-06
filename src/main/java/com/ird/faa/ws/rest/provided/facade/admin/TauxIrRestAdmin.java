package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.TauxIr;
import com.ird.faa.service.admin.facade.TauxIrAdminService;
import com.ird.faa.ws.rest.provided.converter.TauxIrConverter;
import com.ird.faa.ws.rest.provided.vo.TauxIrVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages tauxIr services")
@RestController
@RequestMapping("api/admin/tauxIr")
public class TauxIrRestAdmin {

    @Autowired
    private TauxIrAdminService tauxIrService;

    @Autowired
    private TauxIrConverter tauxIrConverter;


    @ApiOperation("Updates the specified  tauxIr")
    @PutMapping("/")
    public TauxIrVo update(@RequestBody TauxIrVo tauxIrVo) {
        TauxIr tauxIr = tauxIrConverter.toItem(tauxIrVo);
        tauxIr = tauxIrService.update(tauxIr);
        return tauxIrConverter.toVo(tauxIr);
    }

    @ApiOperation("Finds a list of all tauxIrs")
    @GetMapping("/")
    public List<TauxIrVo> findAll() {
        return tauxIrConverter.toVo(tauxIrService.findAll());
    }

    @ApiOperation("Finds a tauxIr with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TauxIrVo findByIdWithAssociatedList(@PathVariable Long id) {
        return tauxIrConverter.toVo(tauxIrService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search tauxIr by a specific criteria")
    @PostMapping("/search")
    public List<TauxIrVo> findByCriteria(@RequestBody TauxIrVo tauxIrVo) {
        return tauxIrConverter.toVo(tauxIrService.findByCriteria(tauxIrVo));
    }

    @ApiOperation("Finds a tauxIr by id")
    @GetMapping("/id/{id}")
    public TauxIrVo findById(@PathVariable Long id) {
        return tauxIrConverter.toVo(tauxIrService.findById(id));
    }

    @ApiOperation("Saves the specified  tauxIr")
    @PostMapping("/")
    public TauxIrVo save(@RequestBody TauxIrVo tauxIrVo) {
        TauxIr tauxIr = tauxIrConverter.toItem(tauxIrVo);
        tauxIr = tauxIrService.save(tauxIr);
        return tauxIrConverter.toVo(tauxIr);
    }

    @ApiOperation("Delete the specified tauxIr")
    @DeleteMapping("/")
    public int delete(@RequestBody TauxIrVo tauxIrVo) {
        TauxIr tauxIr = tauxIrConverter.toItem(tauxIrVo);
        return tauxIrService.delete(tauxIr);
    }

    @ApiOperation("Deletes a tauxIr by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return tauxIrService.deleteById(id);
    }


}
