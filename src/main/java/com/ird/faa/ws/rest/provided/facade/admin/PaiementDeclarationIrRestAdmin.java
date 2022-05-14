package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.PaiementDeclarationIrAdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.ird.faa.bean.PaiementDeclarationIr;
import com.ird.faa.ws.rest.provided.converter.PaiementDeclarationIrConverter;
import com.ird.faa.ws.rest.provided.vo.PaiementDeclarationIrVo;

@Api("Manages paiementDeclarationIr services")
@RestController
@RequestMapping("api/admin/paiementDeclarationIr")
public class PaiementDeclarationIrRestAdmin {

@Autowired
private PaiementDeclarationIrAdminService paiementDeclarationIrService;

@Autowired
private PaiementDeclarationIrConverter paiementDeclarationIrConverter;


            @ApiOperation("Updates the specified  paiementDeclarationIr")
            @PutMapping("/")
            public  PaiementDeclarationIrVo update(@RequestBody  PaiementDeclarationIrVo  paiementDeclarationIrVo){
            PaiementDeclarationIr paiementDeclarationIr = paiementDeclarationIrConverter.toItem(paiementDeclarationIrVo);
            paiementDeclarationIr = paiementDeclarationIrService.update(paiementDeclarationIr);
            return paiementDeclarationIrConverter.toVo(paiementDeclarationIr);
            }

    @ApiOperation("Finds a list of all paiementDeclarationIrs")
    @GetMapping("/")
    public List<PaiementDeclarationIrVo> findAll(){
        return paiementDeclarationIrConverter.toVo(paiementDeclarationIrService.findAll());
    }

    @ApiOperation("Finds a paiementDeclarationIr with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PaiementDeclarationIrVo findByIdWithAssociatedList(@PathVariable Long id){
    return paiementDeclarationIrConverter.toVo(paiementDeclarationIrService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search paiementDeclarationIr by a specific criteria")
    @PostMapping("/search")
    public List<PaiementDeclarationIrVo> findByCriteria(@RequestBody PaiementDeclarationIrVo paiementDeclarationIrVo){
        return paiementDeclarationIrConverter.toVo(paiementDeclarationIrService.findByCriteria(paiementDeclarationIrVo));
        }

            @ApiOperation("Finds a paiementDeclarationIr by id")
            @GetMapping("/id/{id}")
            public PaiementDeclarationIrVo findById(@PathVariable Long id){
            return paiementDeclarationIrConverter.toVo(paiementDeclarationIrService.findById(id));
            }

            @ApiOperation("Saves the specified  paiementDeclarationIr")
            @PostMapping("/")
            public PaiementDeclarationIrVo save(@RequestBody PaiementDeclarationIrVo paiementDeclarationIrVo){
            PaiementDeclarationIr paiementDeclarationIr = paiementDeclarationIrConverter.toItem(paiementDeclarationIrVo);
            paiementDeclarationIr = paiementDeclarationIrService.save(paiementDeclarationIr);
            return paiementDeclarationIrConverter.toVo(paiementDeclarationIr);
            }

            @ApiOperation("Delete the specified paiementDeclarationIr")
            @DeleteMapping("/")
            public int delete(@RequestBody PaiementDeclarationIrVo paiementDeclarationIrVo){
            PaiementDeclarationIr paiementDeclarationIr = paiementDeclarationIrConverter.toItem(paiementDeclarationIrVo);
            return paiementDeclarationIrService.delete(paiementDeclarationIr);
            }

            @ApiOperation("Deletes a paiementDeclarationIr by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return paiementDeclarationIrService.deleteById(id);
            }
        @ApiOperation("find by declarationIr refrerence")
        @GetMapping("/declarationIr/refrerence/{refrerence}")
        public List<PaiementDeclarationIr> findByDeclarationIrRefrerence(@PathVariable String refrerence){
        return paiementDeclarationIrService.findByDeclarationIrRefrerence(refrerence);
        }

        @ApiOperation("delete by declarationIr refrerence")
        @DeleteMapping("/declarationIr/refrerence/{refrerence}")
        public int deleteByDeclarationIrRefrerence(@PathVariable String refrerence){
        return paiementDeclarationIrService.deleteByDeclarationIrRefrerence(refrerence);
        }

        @ApiOperation("find by declarationIr id")
        @GetMapping("/declarationIr/id/{id}")
        public List<PaiementDeclarationIr> findByDeclarationIrId(@PathVariable Long id){
        return paiementDeclarationIrService.findByDeclarationIrId(id);
        }

        @ApiOperation("delete by declarationIr id")
        @DeleteMapping("/declarationIr/id/{id}")
        public int deleteByDeclarationIrId(@PathVariable Long id){
        return paiementDeclarationIrService.deleteByDeclarationIrId(id);
        }



            }
