package  com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.service.comptable.facade.PrelevementSocialEmployeComptableService;

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
import com.ird.faa.bean.PrelevementSocialEmploye;
import com.ird.faa.ws.rest.provided.converter.PrelevementSocialEmployeConverter;
import com.ird.faa.ws.rest.provided.vo.PrelevementSocialEmployeVo;

@Api("Manages prelevementSocialEmploye services")
@RestController
@RequestMapping("api/comptable/prelevementSocialEmploye")
public class PrelevementSocialEmployeRestComptable {

@Autowired
private PrelevementSocialEmployeComptableService prelevementSocialEmployeService;

@Autowired
private PrelevementSocialEmployeConverter prelevementSocialEmployeConverter;


            @ApiOperation("Updates the specified  prelevementSocialEmploye")
            @PutMapping("/")
            public  PrelevementSocialEmployeVo update(@RequestBody  PrelevementSocialEmployeVo  prelevementSocialEmployeVo){
            PrelevementSocialEmploye prelevementSocialEmploye = prelevementSocialEmployeConverter.toItem(prelevementSocialEmployeVo);
            prelevementSocialEmploye = prelevementSocialEmployeService.update(prelevementSocialEmploye);
            return prelevementSocialEmployeConverter.toVo(prelevementSocialEmploye);
            }

    @ApiOperation("Finds a list of all prelevementSocialEmployes")
    @GetMapping("/")
    public List<PrelevementSocialEmployeVo> findAll(){
        return prelevementSocialEmployeConverter.toVo(prelevementSocialEmployeService.findAll());
    }

    @ApiOperation("Finds a prelevementSocialEmploye with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PrelevementSocialEmployeVo findByIdWithAssociatedList(@PathVariable Long id){
    return prelevementSocialEmployeConverter.toVo(prelevementSocialEmployeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search prelevementSocialEmploye by a specific criteria")
    @PostMapping("/search")
    public List<PrelevementSocialEmployeVo> findByCriteria(@RequestBody PrelevementSocialEmployeVo prelevementSocialEmployeVo){
        return prelevementSocialEmployeConverter.toVo(prelevementSocialEmployeService.findByCriteria(prelevementSocialEmployeVo));
        }

            @ApiOperation("Finds a prelevementSocialEmploye by id")
            @GetMapping("/id/{id}")
            public PrelevementSocialEmployeVo findById(@PathVariable Long id){
            return prelevementSocialEmployeConverter.toVo(prelevementSocialEmployeService.findById(id));
            }

            @ApiOperation("Saves the specified  prelevementSocialEmploye")
            @PostMapping("/")
            public PrelevementSocialEmployeVo save(@RequestBody PrelevementSocialEmployeVo prelevementSocialEmployeVo){
            PrelevementSocialEmploye prelevementSocialEmploye = prelevementSocialEmployeConverter.toItem(prelevementSocialEmployeVo);
            prelevementSocialEmploye = prelevementSocialEmployeService.save(prelevementSocialEmploye);
            return prelevementSocialEmployeConverter.toVo(prelevementSocialEmploye);
            }

            @ApiOperation("Delete the specified prelevementSocialEmploye")
            @DeleteMapping("/")
            public int delete(@RequestBody PrelevementSocialEmployeVo prelevementSocialEmployeVo){
            PrelevementSocialEmploye prelevementSocialEmploye = prelevementSocialEmployeConverter.toItem(prelevementSocialEmployeVo);
            return prelevementSocialEmployeService.delete(prelevementSocialEmploye);
            }

            @ApiOperation("Deletes a prelevementSocialEmploye by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return prelevementSocialEmployeService.deleteById(id);
            }
        @ApiOperation("find by prelevementSocial id")
        @GetMapping("/prelevementSocial/id/{id}")
        public List<PrelevementSocialEmploye> findByPrelevementSocialId(@PathVariable Long id){
        return prelevementSocialEmployeService.findByPrelevementSocialId(id);
        }

        @ApiOperation("delete by prelevementSocial id")
        @DeleteMapping("/prelevementSocial/id/{id}")
        public int deleteByPrelevementSocialId(@PathVariable Long id){
        return prelevementSocialEmployeService.deleteByPrelevementSocialId(id);
        }

        @ApiOperation("find by employe cin")
        @GetMapping("/employe/cin/{cin}")
        public List<PrelevementSocialEmploye> findByEmployeCin(@PathVariable String cin){
        return prelevementSocialEmployeService.findByEmployeCin(cin);
        }

        @ApiOperation("delete by employe cin")
        @DeleteMapping("/employe/cin/{cin}")
        public int deleteByEmployeCin(@PathVariable String cin){
        return prelevementSocialEmployeService.deleteByEmployeCin(cin);
        }

        @ApiOperation("find by employe id")
        @GetMapping("/employe/id/{id}")
        public List<PrelevementSocialEmploye> findByEmployeId(@PathVariable Long id){
        return prelevementSocialEmployeService.findByEmployeId(id);
        }

        @ApiOperation("delete by employe id")
        @DeleteMapping("/employe/id/{id}")
        public int deleteByEmployeId(@PathVariable Long id){
        return prelevementSocialEmployeService.deleteByEmployeId(id);
        }

        @ApiOperation("find by declarationIr refrerence")
        @GetMapping("/declarationIr/refrerence/{refrerence}")
        public List<PrelevementSocialEmploye> findByDeclarationIrRefrerence(@PathVariable String refrerence){
        return prelevementSocialEmployeService.findByDeclarationIrRefrerence(refrerence);
        }

        @ApiOperation("delete by declarationIr refrerence")
        @DeleteMapping("/declarationIr/refrerence/{refrerence}")
        public int deleteByDeclarationIrRefrerence(@PathVariable String refrerence){
        return prelevementSocialEmployeService.deleteByDeclarationIrRefrerence(refrerence);
        }

        @ApiOperation("find by declarationIr id")
        @GetMapping("/declarationIr/id/{id}")
        public List<PrelevementSocialEmploye> findByDeclarationIrId(@PathVariable Long id){
        return prelevementSocialEmployeService.findByDeclarationIrId(id);
        }

        @ApiOperation("delete by declarationIr id")
        @DeleteMapping("/declarationIr/id/{id}")
        public int deleteByDeclarationIrId(@PathVariable Long id){
        return prelevementSocialEmployeService.deleteByDeclarationIrId(id);
        }



            }
