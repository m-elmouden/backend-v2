package  com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.service.societe.facade.DeclarationIsSocieteService;

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
import com.ird.faa.bean.DeclarationIs;
import com.ird.faa.ws.rest.provided.converter.DeclarationIsConverter;
import com.ird.faa.ws.rest.provided.vo.DeclarationIsVo;

@Api("Manages declarationIs services")
@RestController
@RequestMapping("api/societe/declarationIs")
public class DeclarationIsRestSociete {

@Autowired
private DeclarationIsSocieteService declarationIsService;

@Autowired
private DeclarationIsConverter declarationIsConverter;


            @ApiOperation("Updates the specified  declarationIs")
            @PutMapping("/")
            public  DeclarationIsVo update(@RequestBody  DeclarationIsVo  declarationIsVo){
            DeclarationIs declarationIs = declarationIsConverter.toItem(declarationIsVo);
            declarationIs = declarationIsService.update(declarationIs);
            return declarationIsConverter.toVo(declarationIs);
            }

    @ApiOperation("Finds a list of all declarationIss")
    @GetMapping("/")
    public List<DeclarationIsVo> findAll(){
        return declarationIsConverter.toVo(declarationIsService.findAll());
    }

    @ApiOperation("Finds a declarationIs with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DeclarationIsVo findByIdWithAssociatedList(@PathVariable Long id){
    return declarationIsConverter.toVo(declarationIsService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search declarationIs by a specific criteria")
    @PostMapping("/search")
    public List<DeclarationIsVo> findByCriteria(@RequestBody DeclarationIsVo declarationIsVo){
        return declarationIsConverter.toVo(declarationIsService.findByCriteria(declarationIsVo));
        }

            @ApiOperation("Finds a declarationIs by id")
            @GetMapping("/id/{id}")
            public DeclarationIsVo findById(@PathVariable Long id){
            return declarationIsConverter.toVo(declarationIsService.findById(id));
            }

            @ApiOperation("Saves the specified  declarationIs")
            @PostMapping("/")
            public DeclarationIsVo save(@RequestBody DeclarationIsVo declarationIsVo){
            DeclarationIs declarationIs = declarationIsConverter.toItem(declarationIsVo);
            declarationIs = declarationIsService.save(declarationIs);
            return declarationIsConverter.toVo(declarationIs);
            }

            @ApiOperation("Delete the specified declarationIs")
            @DeleteMapping("/")
            public int delete(@RequestBody DeclarationIsVo declarationIsVo){
            DeclarationIs declarationIs = declarationIsConverter.toItem(declarationIsVo);
            return declarationIsService.delete(declarationIs);
            }

            @ApiOperation("Deletes a declarationIs by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return declarationIsService.deleteById(id);
            }
        @ApiOperation("find by societe id")
        @GetMapping("/societe/id/{id}")
        public List<DeclarationIs> findBySocieteId(@PathVariable Long id){
        return declarationIsService.findBySocieteId(id);
        }

        @ApiOperation("delete by societe id")
        @DeleteMapping("/societe/id/{id}")
        public int deleteBySocieteId(@PathVariable Long id){
        return declarationIsService.deleteBySocieteId(id);
        }

        @ApiOperation("find by tauxIs reference")
        @GetMapping("/tauxIs/reference/{reference}")
        public List<DeclarationIs> findByTauxIsReference(@PathVariable String reference){
        return declarationIsService.findByTauxIsReference(reference);
        }

        @ApiOperation("delete by tauxIs reference")
        @DeleteMapping("/tauxIs/reference/{reference}")
        public int deleteByTauxIsReference(@PathVariable String reference){
        return declarationIsService.deleteByTauxIsReference(reference);
        }

        @ApiOperation("find by tauxIs id")
        @GetMapping("/tauxIs/id/{id}")
        public List<DeclarationIs> findByTauxIsId(@PathVariable Long id){
        return declarationIsService.findByTauxIsId(id);
        }

        @ApiOperation("delete by tauxIs id")
        @DeleteMapping("/tauxIs/id/{id}")
        public int deleteByTauxIsId(@PathVariable Long id){
        return declarationIsService.deleteByTauxIsId(id);
        }

        @ApiOperation("find by tauxIsConfig reference")
        @GetMapping("/tauxIsConfig/reference/{reference}")
        public List<DeclarationIs> findByTauxIsConfigReference(@PathVariable String reference){
        return declarationIsService.findByTauxIsConfigReference(reference);
        }

        @ApiOperation("delete by tauxIsConfig reference")
        @DeleteMapping("/tauxIsConfig/reference/{reference}")
        public int deleteByTauxIsConfigReference(@PathVariable String reference){
        return declarationIsService.deleteByTauxIsConfigReference(reference);
        }

        @ApiOperation("find by tauxIsConfig id")
        @GetMapping("/tauxIsConfig/id/{id}")
        public List<DeclarationIs> findByTauxIsConfigId(@PathVariable Long id){
        return declarationIsService.findByTauxIsConfigId(id);
        }

        @ApiOperation("delete by tauxIsConfig id")
        @DeleteMapping("/tauxIsConfig/id/{id}")
        public int deleteByTauxIsConfigId(@PathVariable Long id){
        return declarationIsService.deleteByTauxIsConfigId(id);
        }

        @ApiOperation("find by etatDeclarationIs reference")
        @GetMapping("/etatDeclarationIs/reference/{reference}")
        public List<DeclarationIs> findByEtatDeclarationIsReference(@PathVariable String reference){
        return declarationIsService.findByEtatDeclarationIsReference(reference);
        }

        @ApiOperation("delete by etatDeclarationIs reference")
        @DeleteMapping("/etatDeclarationIs/reference/{reference}")
        public int deleteByEtatDeclarationIsReference(@PathVariable String reference){
        return declarationIsService.deleteByEtatDeclarationIsReference(reference);
        }

        @ApiOperation("find by etatDeclarationIs id")
        @GetMapping("/etatDeclarationIs/id/{id}")
        public List<DeclarationIs> findByEtatDeclarationIsId(@PathVariable Long id){
        return declarationIsService.findByEtatDeclarationIsId(id);
        }

        @ApiOperation("delete by etatDeclarationIs id")
        @DeleteMapping("/etatDeclarationIs/id/{id}")
        public int deleteByEtatDeclarationIsId(@PathVariable Long id){
        return declarationIsService.deleteByEtatDeclarationIsId(id);
        }

        @ApiOperation("find by paiementDeclarationIs reference")
        @GetMapping("/paiementDeclarationIs/reference/{reference}")
        public List<DeclarationIs> findByPaiementDeclarationIsReference(@PathVariable String reference){
        return declarationIsService.findByPaiementDeclarationIsReference(reference);
        }

        @ApiOperation("delete by paiementDeclarationIs reference")
        @DeleteMapping("/paiementDeclarationIs/reference/{reference}")
        public int deleteByPaiementDeclarationIsReference(@PathVariable String reference){
        return declarationIsService.deleteByPaiementDeclarationIsReference(reference);
        }

        @ApiOperation("find by paiementDeclarationIs id")
        @GetMapping("/paiementDeclarationIs/id/{id}")
        public List<DeclarationIs> findByPaiementDeclarationIsId(@PathVariable Long id){
        return declarationIsService.findByPaiementDeclarationIsId(id);
        }

        @ApiOperation("delete by paiementDeclarationIs id")
        @DeleteMapping("/paiementDeclarationIs/id/{id}")
        public int deleteByPaiementDeclarationIsId(@PathVariable Long id){
        return declarationIsService.deleteByPaiementDeclarationIsId(id);
        }



            @PutMapping("/archiver/")
            public DeclarationIsVo archiver(@RequestBody DeclarationIsVo declarationIsVo){
                DeclarationIs declarationIs = declarationIsService.archiver(declarationIsConverter.toItem(declarationIsVo));
                return declarationIsConverter.toVo(declarationIs);
                }

            @PutMapping("/desarchiver/")
            public DeclarationIsVo desarchiver(@RequestBody DeclarationIsVo declarationIsVo){
                DeclarationIs declarationIs = declarationIsService.desarchiver(declarationIsConverter.toItem(declarationIsVo));
                return declarationIsConverter.toVo(declarationIs);}
            }
