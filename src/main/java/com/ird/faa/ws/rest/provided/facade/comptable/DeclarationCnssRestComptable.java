package  com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.service.comptable.facade.DeclarationCnssComptableService;

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
import com.ird.faa.bean.DeclarationCnss;
import com.ird.faa.ws.rest.provided.converter.DeclarationCnssConverter;
import com.ird.faa.ws.rest.provided.vo.DeclarationCnssVo;

@Api("Manages declarationCnss services")
@RestController
@RequestMapping("api/comptable/declarationCnss")
public class DeclarationCnssRestComptable {

@Autowired
private DeclarationCnssComptableService declarationCnssService;

@Autowired
private DeclarationCnssConverter declarationCnssConverter;


            @ApiOperation("Updates the specified  declarationCnss")
            @PutMapping("/")
            public  DeclarationCnssVo update(@RequestBody  DeclarationCnssVo  declarationCnssVo){
            DeclarationCnss declarationCnss = declarationCnssConverter.toItem(declarationCnssVo);
            declarationCnss = declarationCnssService.update(declarationCnss);
            return declarationCnssConverter.toVo(declarationCnss);
            }

    @ApiOperation("Finds a list of all declarationCnsss")
    @GetMapping("/")
    public List<DeclarationCnssVo> findAll(){
        return declarationCnssConverter.toVo(declarationCnssService.findAll());
    }

    @ApiOperation("Finds a declarationCnss with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DeclarationCnssVo findByIdWithAssociatedList(@PathVariable Long id){
    return declarationCnssConverter.toVo(declarationCnssService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search declarationCnss by a specific criteria")
    @PostMapping("/search")
    public List<DeclarationCnssVo> findByCriteria(@RequestBody DeclarationCnssVo declarationCnssVo){
        return declarationCnssConverter.toVo(declarationCnssService.findByCriteria(declarationCnssVo));
        }

            @ApiOperation("Finds a declarationCnss by id")
            @GetMapping("/id/{id}")
            public DeclarationCnssVo findById(@PathVariable Long id){
            return declarationCnssConverter.toVo(declarationCnssService.findById(id));
            }

            @ApiOperation("Saves the specified  declarationCnss")
            @PostMapping("/")
            public DeclarationCnssVo save(@RequestBody DeclarationCnssVo declarationCnssVo){
            DeclarationCnss declarationCnss = declarationCnssConverter.toItem(declarationCnssVo);
            declarationCnss = declarationCnssService.save(declarationCnss);
            return declarationCnssConverter.toVo(declarationCnss);
            }

            @ApiOperation("Delete the specified declarationCnss")
            @DeleteMapping("/")
            public int delete(@RequestBody DeclarationCnssVo declarationCnssVo){
            DeclarationCnss declarationCnss = declarationCnssConverter.toItem(declarationCnssVo);
            return declarationCnssService.delete(declarationCnss);
            }

            @ApiOperation("Deletes a declarationCnss by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return declarationCnssService.deleteById(id);
            }
        @ApiOperation("find by employe cin")
        @GetMapping("/employe/cin/{cin}")
        public List<DeclarationCnss> findByEmployeCin(@PathVariable String cin){
        return declarationCnssService.findByEmployeCin(cin);
        }

        @ApiOperation("delete by employe cin")
        @DeleteMapping("/employe/cin/{cin}")
        public int deleteByEmployeCin(@PathVariable String cin){
        return declarationCnssService.deleteByEmployeCin(cin);
        }

        @ApiOperation("find by employe id")
        @GetMapping("/employe/id/{id}")
        public List<DeclarationCnss> findByEmployeId(@PathVariable Long id){
        return declarationCnssService.findByEmployeId(id);
        }

        @ApiOperation("delete by employe id")
        @DeleteMapping("/employe/id/{id}")
        public int deleteByEmployeId(@PathVariable Long id){
        return declarationCnssService.deleteByEmployeId(id);
        }

        @ApiOperation("find by societe id")
        @GetMapping("/societe/id/{id}")
        public List<DeclarationCnss> findBySocieteId(@PathVariable Long id){
        return declarationCnssService.findBySocieteId(id);
        }

        @ApiOperation("delete by societe id")
        @DeleteMapping("/societe/id/{id}")
        public int deleteBySocieteId(@PathVariable Long id){
        return declarationCnssService.deleteBySocieteId(id);
        }



            @PutMapping("/archiver/")
            public DeclarationCnssVo archiver(@RequestBody DeclarationCnssVo declarationCnssVo){
                DeclarationCnss declarationCnss = declarationCnssService.archiver(declarationCnssConverter.toItem(declarationCnssVo));
                return declarationCnssConverter.toVo(declarationCnss);
                }

            @PutMapping("/desarchiver/")
            public DeclarationCnssVo desarchiver(@RequestBody DeclarationCnssVo declarationCnssVo){
                DeclarationCnss declarationCnss = declarationCnssService.desarchiver(declarationCnssConverter.toItem(declarationCnssVo));
                return declarationCnssConverter.toVo(declarationCnss);}
            }
