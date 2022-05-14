package  com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.service.societe.facade.DeclarationCnssDetailSocieteService;

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
import com.ird.faa.bean.DeclarationCnssDetail;
import com.ird.faa.ws.rest.provided.converter.DeclarationCnssDetailConverter;
import com.ird.faa.ws.rest.provided.vo.DeclarationCnssDetailVo;

@Api("Manages declarationCnssDetail services")
@RestController
@RequestMapping("api/societe/declarationCnssDetail")
public class DeclarationCnssDetailRestSociete {

@Autowired
private DeclarationCnssDetailSocieteService declarationCnssDetailService;

@Autowired
private DeclarationCnssDetailConverter declarationCnssDetailConverter;


            @ApiOperation("Updates the specified  declarationCnssDetail")
            @PutMapping("/")
            public  DeclarationCnssDetailVo update(@RequestBody  DeclarationCnssDetailVo  declarationCnssDetailVo){
            DeclarationCnssDetail declarationCnssDetail = declarationCnssDetailConverter.toItem(declarationCnssDetailVo);
            declarationCnssDetail = declarationCnssDetailService.update(declarationCnssDetail);
            return declarationCnssDetailConverter.toVo(declarationCnssDetail);
            }

    @ApiOperation("Finds a list of all declarationCnssDetails")
    @GetMapping("/")
    public List<DeclarationCnssDetailVo> findAll(){
        return declarationCnssDetailConverter.toVo(declarationCnssDetailService.findAll());
    }

    @ApiOperation("Finds a declarationCnssDetail with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DeclarationCnssDetailVo findByIdWithAssociatedList(@PathVariable Long id){
    return declarationCnssDetailConverter.toVo(declarationCnssDetailService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search declarationCnssDetail by a specific criteria")
    @PostMapping("/search")
    public List<DeclarationCnssDetailVo> findByCriteria(@RequestBody DeclarationCnssDetailVo declarationCnssDetailVo){
        return declarationCnssDetailConverter.toVo(declarationCnssDetailService.findByCriteria(declarationCnssDetailVo));
        }

            @ApiOperation("Finds a declarationCnssDetail by id")
            @GetMapping("/id/{id}")
            public DeclarationCnssDetailVo findById(@PathVariable Long id){
            return declarationCnssDetailConverter.toVo(declarationCnssDetailService.findById(id));
            }

            @ApiOperation("Saves the specified  declarationCnssDetail")
            @PostMapping("/")
            public DeclarationCnssDetailVo save(@RequestBody DeclarationCnssDetailVo declarationCnssDetailVo){
            DeclarationCnssDetail declarationCnssDetail = declarationCnssDetailConverter.toItem(declarationCnssDetailVo);
            declarationCnssDetail = declarationCnssDetailService.save(declarationCnssDetail);
            return declarationCnssDetailConverter.toVo(declarationCnssDetail);
            }

            @ApiOperation("Delete the specified declarationCnssDetail")
            @DeleteMapping("/")
            public int delete(@RequestBody DeclarationCnssDetailVo declarationCnssDetailVo){
            DeclarationCnssDetail declarationCnssDetail = declarationCnssDetailConverter.toItem(declarationCnssDetailVo);
            return declarationCnssDetailService.delete(declarationCnssDetail);
            }

            @ApiOperation("Deletes a declarationCnssDetail by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return declarationCnssDetailService.deleteById(id);
            }
        @ApiOperation("find by typeTauxCnss id")
        @GetMapping("/typeTauxCnss/id/{id}")
        public List<DeclarationCnssDetail> findByTypeTauxCnssId(@PathVariable Long id){
        return declarationCnssDetailService.findByTypeTauxCnssId(id);
        }

        @ApiOperation("delete by typeTauxCnss id")
        @DeleteMapping("/typeTauxCnss/id/{id}")
        public int deleteByTypeTauxCnssId(@PathVariable Long id){
        return declarationCnssDetailService.deleteByTypeTauxCnssId(id);
        }

        @ApiOperation("find by declarationCnss ref")
        @GetMapping("/declarationCnss/ref/{ref}")
        public List<DeclarationCnssDetail> findByDeclarationCnssRef(@PathVariable String ref){
        return declarationCnssDetailService.findByDeclarationCnssRef(ref);
        }

        @ApiOperation("delete by declarationCnss ref")
        @DeleteMapping("/declarationCnss/ref/{ref}")
        public int deleteByDeclarationCnssRef(@PathVariable String ref){
        return declarationCnssDetailService.deleteByDeclarationCnssRef(ref);
        }

        @ApiOperation("find by declarationCnss id")
        @GetMapping("/declarationCnss/id/{id}")
        public List<DeclarationCnssDetail> findByDeclarationCnssId(@PathVariable Long id){
        return declarationCnssDetailService.findByDeclarationCnssId(id);
        }

        @ApiOperation("delete by declarationCnss id")
        @DeleteMapping("/declarationCnss/id/{id}")
        public int deleteByDeclarationCnssId(@PathVariable Long id){
        return declarationCnssDetailService.deleteByDeclarationCnssId(id);
        }



            @PutMapping("/archiver/")
            public DeclarationCnssDetailVo archiver(@RequestBody DeclarationCnssDetailVo declarationCnssDetailVo){
                DeclarationCnssDetail declarationCnssDetail = declarationCnssDetailService.archiver(declarationCnssDetailConverter.toItem(declarationCnssDetailVo));
                return declarationCnssDetailConverter.toVo(declarationCnssDetail);
                }

            @PutMapping("/desarchiver/")
            public DeclarationCnssDetailVo desarchiver(@RequestBody DeclarationCnssDetailVo declarationCnssDetailVo){
                DeclarationCnssDetail declarationCnssDetail = declarationCnssDetailService.desarchiver(declarationCnssDetailConverter.toItem(declarationCnssDetailVo));
                return declarationCnssDetailConverter.toVo(declarationCnssDetail);}
            }
