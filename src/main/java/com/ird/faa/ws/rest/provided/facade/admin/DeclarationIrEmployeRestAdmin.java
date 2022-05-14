package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.DeclarationIrEmployeAdminService;

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
import com.ird.faa.bean.DeclarationIrEmploye;
import com.ird.faa.ws.rest.provided.converter.DeclarationIrEmployeConverter;
import com.ird.faa.ws.rest.provided.vo.DeclarationIrEmployeVo;

@Api("Manages declarationIrEmploye services")
@RestController
@RequestMapping("api/admin/declarationIrEmploye")
public class DeclarationIrEmployeRestAdmin {

@Autowired
private DeclarationIrEmployeAdminService declarationIrEmployeService;

@Autowired
private DeclarationIrEmployeConverter declarationIrEmployeConverter;


            @ApiOperation("Updates the specified  declarationIrEmploye")
            @PutMapping("/")
            public  DeclarationIrEmployeVo update(@RequestBody  DeclarationIrEmployeVo  declarationIrEmployeVo){
            DeclarationIrEmploye declarationIrEmploye = declarationIrEmployeConverter.toItem(declarationIrEmployeVo);
            declarationIrEmploye = declarationIrEmployeService.update(declarationIrEmploye);
            return declarationIrEmployeConverter.toVo(declarationIrEmploye);
            }

    @ApiOperation("Finds a list of all declarationIrEmployes")
    @GetMapping("/")
    public List<DeclarationIrEmployeVo> findAll(){
        return declarationIrEmployeConverter.toVo(declarationIrEmployeService.findAll());
    }

    @ApiOperation("Finds a declarationIrEmploye with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DeclarationIrEmployeVo findByIdWithAssociatedList(@PathVariable Long id){
    return declarationIrEmployeConverter.toVo(declarationIrEmployeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search declarationIrEmploye by a specific criteria")
    @PostMapping("/search")
    public List<DeclarationIrEmployeVo> findByCriteria(@RequestBody DeclarationIrEmployeVo declarationIrEmployeVo){
        return declarationIrEmployeConverter.toVo(declarationIrEmployeService.findByCriteria(declarationIrEmployeVo));
        }

            @ApiOperation("Finds a declarationIrEmploye by id")
            @GetMapping("/id/{id}")
            public DeclarationIrEmployeVo findById(@PathVariable Long id){
            return declarationIrEmployeConverter.toVo(declarationIrEmployeService.findById(id));
            }

            @ApiOperation("Saves the specified  declarationIrEmploye")
            @PostMapping("/")
            public DeclarationIrEmployeVo save(@RequestBody DeclarationIrEmployeVo declarationIrEmployeVo){
            DeclarationIrEmploye declarationIrEmploye = declarationIrEmployeConverter.toItem(declarationIrEmployeVo);
            declarationIrEmploye = declarationIrEmployeService.save(declarationIrEmploye);
            return declarationIrEmployeConverter.toVo(declarationIrEmploye);
            }

            @ApiOperation("Delete the specified declarationIrEmploye")
            @DeleteMapping("/")
            public int delete(@RequestBody DeclarationIrEmployeVo declarationIrEmployeVo){
            DeclarationIrEmploye declarationIrEmploye = declarationIrEmployeConverter.toItem(declarationIrEmployeVo);
            return declarationIrEmployeService.delete(declarationIrEmploye);
            }

            @ApiOperation("Deletes a declarationIrEmploye by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return declarationIrEmployeService.deleteById(id);
            }
        @ApiOperation("find by declarationIr refrerence")
        @GetMapping("/declarationIr/refrerence/{refrerence}")
        public List<DeclarationIrEmploye> findByDeclarationIrRefrerence(@PathVariable String refrerence){
        return declarationIrEmployeService.findByDeclarationIrRefrerence(refrerence);
        }

        @ApiOperation("delete by declarationIr refrerence")
        @DeleteMapping("/declarationIr/refrerence/{refrerence}")
        public int deleteByDeclarationIrRefrerence(@PathVariable String refrerence){
        return declarationIrEmployeService.deleteByDeclarationIrRefrerence(refrerence);
        }

        @ApiOperation("find by declarationIr id")
        @GetMapping("/declarationIr/id/{id}")
        public List<DeclarationIrEmploye> findByDeclarationIrId(@PathVariable Long id){
        return declarationIrEmployeService.findByDeclarationIrId(id);
        }

        @ApiOperation("delete by declarationIr id")
        @DeleteMapping("/declarationIr/id/{id}")
        public int deleteByDeclarationIrId(@PathVariable Long id){
        return declarationIrEmployeService.deleteByDeclarationIrId(id);
        }

        @ApiOperation("find by employe cin")
        @GetMapping("/employe/cin/{cin}")
        public List<DeclarationIrEmploye> findByEmployeCin(@PathVariable String cin){
        return declarationIrEmployeService.findByEmployeCin(cin);
        }

        @ApiOperation("delete by employe cin")
        @DeleteMapping("/employe/cin/{cin}")
        public int deleteByEmployeCin(@PathVariable String cin){
        return declarationIrEmployeService.deleteByEmployeCin(cin);
        }

        @ApiOperation("find by employe id")
        @GetMapping("/employe/id/{id}")
        public List<DeclarationIrEmploye> findByEmployeId(@PathVariable Long id){
        return declarationIrEmployeService.findByEmployeId(id);
        }

        @ApiOperation("delete by employe id")
        @DeleteMapping("/employe/id/{id}")
        public int deleteByEmployeId(@PathVariable Long id){
        return declarationIrEmployeService.deleteByEmployeId(id);
        }

        @ApiOperation("find by tauxIr id")
        @GetMapping("/tauxIr/id/{id}")
        public List<DeclarationIrEmploye> findByTauxIrId(@PathVariable Long id){
        return declarationIrEmployeService.findByTauxIrId(id);
        }

        @ApiOperation("delete by tauxIr id")
        @DeleteMapping("/tauxIr/id/{id}")
        public int deleteByTauxIrId(@PathVariable Long id){
        return declarationIrEmployeService.deleteByTauxIrId(id);
        }



            }
