package  com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.service.comptable.facade.DeclarationTvaComptableService;

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
import com.ird.faa.bean.DeclarationTva;
import com.ird.faa.ws.rest.provided.converter.DeclarationTvaConverter;
import com.ird.faa.ws.rest.provided.vo.DeclarationTvaVo;

@Api("Manages declarationTva services")
@RestController
@RequestMapping("api/comptable/declarationTva")
public class DeclarationTvaRestComptable {

@Autowired
private DeclarationTvaComptableService declarationTvaService;

@Autowired
private DeclarationTvaConverter declarationTvaConverter;


            @ApiOperation("Updates the specified  declarationTva")
            @PutMapping("/")
            public  DeclarationTvaVo update(@RequestBody  DeclarationTvaVo  declarationTvaVo){
            DeclarationTva declarationTva = declarationTvaConverter.toItem(declarationTvaVo);
            declarationTva = declarationTvaService.update(declarationTva);
            return declarationTvaConverter.toVo(declarationTva);
            }

    @ApiOperation("Finds a list of all declarationTvas")
    @GetMapping("/")
    public List<DeclarationTvaVo> findAll(){
        return declarationTvaConverter.toVo(declarationTvaService.findAll());
    }

    @ApiOperation("Finds a declarationTva with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DeclarationTvaVo findByIdWithAssociatedList(@PathVariable Long id){
    return declarationTvaConverter.toVo(declarationTvaService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search declarationTva by a specific criteria")
    @PostMapping("/search")
    public List<DeclarationTvaVo> findByCriteria(@RequestBody DeclarationTvaVo declarationTvaVo){
        return declarationTvaConverter.toVo(declarationTvaService.findByCriteria(declarationTvaVo));
        }

            @ApiOperation("Finds a declarationTva by id")
            @GetMapping("/id/{id}")
            public DeclarationTvaVo findById(@PathVariable Long id){
            return declarationTvaConverter.toVo(declarationTvaService.findById(id));
            }

            @ApiOperation("Saves the specified  declarationTva")
            @PostMapping("/")
            public DeclarationTvaVo save(@RequestBody DeclarationTvaVo declarationTvaVo){
            DeclarationTva declarationTva = declarationTvaConverter.toItem(declarationTvaVo);
            declarationTva = declarationTvaService.save(declarationTva);
            return declarationTvaConverter.toVo(declarationTva);
            }

            @ApiOperation("Delete the specified declarationTva")
            @DeleteMapping("/")
            public int delete(@RequestBody DeclarationTvaVo declarationTvaVo){
            DeclarationTva declarationTva = declarationTvaConverter.toItem(declarationTvaVo);
            return declarationTvaService.delete(declarationTva);
            }

            @ApiOperation("Deletes a declarationTva by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return declarationTvaService.deleteById(id);
            }
        @ApiOperation("find by societe id")
        @GetMapping("/societe/id/{id}")
        public List<DeclarationTva> findBySocieteId(@PathVariable Long id){
        return declarationTvaService.findBySocieteId(id);
        }

        @ApiOperation("delete by societe id")
        @DeleteMapping("/societe/id/{id}")
        public int deleteBySocieteId(@PathVariable Long id){
        return declarationTvaService.deleteBySocieteId(id);
        }

        @ApiOperation("find by typeDeclarationTva reference")
        @GetMapping("/typeDeclarationTva/reference/{reference}")
        public List<DeclarationTva> findByTypeDeclarationTvaReference(@PathVariable String reference){
        return declarationTvaService.findByTypeDeclarationTvaReference(reference);
        }

        @ApiOperation("delete by typeDeclarationTva reference")
        @DeleteMapping("/typeDeclarationTva/reference/{reference}")
        public int deleteByTypeDeclarationTvaReference(@PathVariable String reference){
        return declarationTvaService.deleteByTypeDeclarationTvaReference(reference);
        }

        @ApiOperation("find by typeDeclarationTva id")
        @GetMapping("/typeDeclarationTva/id/{id}")
        public List<DeclarationTva> findByTypeDeclarationTvaId(@PathVariable Long id){
        return declarationTvaService.findByTypeDeclarationTvaId(id);
        }

        @ApiOperation("delete by typeDeclarationTva id")
        @DeleteMapping("/typeDeclarationTva/id/{id}")
        public int deleteByTypeDeclarationTvaId(@PathVariable Long id){
        return declarationTvaService.deleteByTypeDeclarationTvaId(id);
        }

        @ApiOperation("find by etatDeclarationTva reference")
        @GetMapping("/etatDeclarationTva/reference/{reference}")
        public List<DeclarationTva> findByEtatDeclarationTvaReference(@PathVariable String reference){
        return declarationTvaService.findByEtatDeclarationTvaReference(reference);
        }

        @ApiOperation("delete by etatDeclarationTva reference")
        @DeleteMapping("/etatDeclarationTva/reference/{reference}")
        public int deleteByEtatDeclarationTvaReference(@PathVariable String reference){
        return declarationTvaService.deleteByEtatDeclarationTvaReference(reference);
        }

        @ApiOperation("find by etatDeclarationTva id")
        @GetMapping("/etatDeclarationTva/id/{id}")
        public List<DeclarationTva> findByEtatDeclarationTvaId(@PathVariable Long id){
        return declarationTvaService.findByEtatDeclarationTvaId(id);
        }

        @ApiOperation("delete by etatDeclarationTva id")
        @DeleteMapping("/etatDeclarationTva/id/{id}")
        public int deleteByEtatDeclarationTvaId(@PathVariable Long id){
        return declarationTvaService.deleteByEtatDeclarationTvaId(id);
        }

        @ApiOperation("find by paiementDeclarationTva reference")
        @GetMapping("/paiementDeclarationTva/reference/{reference}")
        public List<DeclarationTva> findByPaiementDeclarationTvaReference(@PathVariable String reference){
        return declarationTvaService.findByPaiementDeclarationTvaReference(reference);
        }

        @ApiOperation("delete by paiementDeclarationTva reference")
        @DeleteMapping("/paiementDeclarationTva/reference/{reference}")
        public int deleteByPaiementDeclarationTvaReference(@PathVariable String reference){
        return declarationTvaService.deleteByPaiementDeclarationTvaReference(reference);
        }

        @ApiOperation("find by paiementDeclarationTva id")
        @GetMapping("/paiementDeclarationTva/id/{id}")
        public List<DeclarationTva> findByPaiementDeclarationTvaId(@PathVariable Long id){
        return declarationTvaService.findByPaiementDeclarationTvaId(id);
        }

        @ApiOperation("delete by paiementDeclarationTva id")
        @DeleteMapping("/paiementDeclarationTva/id/{id}")
        public int deleteByPaiementDeclarationTvaId(@PathVariable Long id){
        return declarationTvaService.deleteByPaiementDeclarationTvaId(id);
        }



            @PutMapping("/archiver/")
            public DeclarationTvaVo archiver(@RequestBody DeclarationTvaVo declarationTvaVo){
                DeclarationTva declarationTva = declarationTvaService.archiver(declarationTvaConverter.toItem(declarationTvaVo));
                return declarationTvaConverter.toVo(declarationTva);
                }

            @PutMapping("/desarchiver/")
            public DeclarationTvaVo desarchiver(@RequestBody DeclarationTvaVo declarationTvaVo){
                DeclarationTva declarationTva = declarationTvaService.desarchiver(declarationTvaConverter.toItem(declarationTvaVo));
                return declarationTvaConverter.toVo(declarationTva);}
            }
