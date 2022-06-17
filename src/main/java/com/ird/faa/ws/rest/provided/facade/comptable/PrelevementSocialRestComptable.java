package com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.bean.PrelevementSocial;
import com.ird.faa.service.comptable.facade.PrelevementSocialComptableService;
import com.ird.faa.ws.rest.provided.converter.PrelevementSocialConverter;
import com.ird.faa.ws.rest.provided.vo.PrelevementSocialVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages prelevementSocial services")
@RestController
@RequestMapping("api/comptable/prelevementSocial")
public class PrelevementSocialRestComptable {

    @Autowired
    private PrelevementSocialComptableService prelevementSocialService;

    @Autowired
    private PrelevementSocialConverter prelevementSocialConverter;


    @ApiOperation("Updates the specified  prelevementSocial")
    @PutMapping("/")
    public PrelevementSocialVo update(@RequestBody PrelevementSocialVo prelevementSocialVo) {
        PrelevementSocial prelevementSocial = prelevementSocialConverter.toItem(prelevementSocialVo);
        prelevementSocial = prelevementSocialService.update(prelevementSocial);
        return prelevementSocialConverter.toVo(prelevementSocial);
    }

    @ApiOperation("Finds a list of all prelevementSocials")
    @GetMapping("/")
    public List<PrelevementSocialVo> findAll() {
        return prelevementSocialConverter.toVo(prelevementSocialService.findAll());
    }

    @ApiOperation("Finds a prelevementSocial with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PrelevementSocialVo findByIdWithAssociatedList(@PathVariable Long id) {
        return prelevementSocialConverter.toVo(prelevementSocialService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search prelevementSocial by a specific criteria")
    @PostMapping("/search")
    public List<PrelevementSocialVo> findByCriteria(@RequestBody PrelevementSocialVo prelevementSocialVo) {
        return prelevementSocialConverter.toVo(prelevementSocialService.findByCriteria(prelevementSocialVo));
    }

    @ApiOperation("Finds a prelevementSocial by id")
    @GetMapping("/id/{id}")
    public PrelevementSocialVo findById(@PathVariable Long id) {
        return prelevementSocialConverter.toVo(prelevementSocialService.findById(id));
    }

    @ApiOperation("Saves the specified  prelevementSocial")
    @PostMapping("/")
    public PrelevementSocialVo save(@RequestBody PrelevementSocialVo prelevementSocialVo) {
        PrelevementSocial prelevementSocial = prelevementSocialConverter.toItem(prelevementSocialVo);
        prelevementSocial = prelevementSocialService.save(prelevementSocial);
        return prelevementSocialConverter.toVo(prelevementSocial);
    }

    @ApiOperation("Delete the specified prelevementSocial")
    @DeleteMapping("/")
    public int delete(@RequestBody PrelevementSocialVo prelevementSocialVo) {
        PrelevementSocial prelevementSocial = prelevementSocialConverter.toItem(prelevementSocialVo);
        return prelevementSocialService.delete(prelevementSocial);
    }

    @ApiOperation("Deletes a prelevementSocial by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return prelevementSocialService.deleteById(id);
    }


}
