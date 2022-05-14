package  com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.service.comptable.facade.DemandeComptableService;

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
import com.ird.faa.bean.Demande;
import com.ird.faa.ws.rest.provided.converter.DemandeConverter;
import com.ird.faa.ws.rest.provided.vo.DemandeVo;

@Api("Manages demande services")
@RestController
@RequestMapping("api/comptable/demande")
public class DemandeRestComptable {

@Autowired
private DemandeComptableService demandeService;

@Autowired
private DemandeConverter demandeConverter;


            @ApiOperation("Updates the specified  demande")
            @PutMapping("/")
            public  DemandeVo update(@RequestBody  DemandeVo  demandeVo){
            Demande demande = demandeConverter.toItem(demandeVo);
            demande = demandeService.update(demande);
            return demandeConverter.toVo(demande);
            }

    @ApiOperation("Finds a list of all demandes")
    @GetMapping("/")
    public List<DemandeVo> findAll(){
        return demandeConverter.toVo(demandeService.findAll());
    }

    @ApiOperation("Finds a demande with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DemandeVo findByIdWithAssociatedList(@PathVariable Long id){
    return demandeConverter.toVo(demandeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search demande by a specific criteria")
    @PostMapping("/search")
    public List<DemandeVo> findByCriteria(@RequestBody DemandeVo demandeVo){
        return demandeConverter.toVo(demandeService.findByCriteria(demandeVo));
        }

            @ApiOperation("Finds a demande by id")
            @GetMapping("/id/{id}")
            public DemandeVo findById(@PathVariable Long id){
            return demandeConverter.toVo(demandeService.findById(id));
            }

            @ApiOperation("Saves the specified  demande")
            @PostMapping("/")
            public DemandeVo save(@RequestBody DemandeVo demandeVo){
            Demande demande = demandeConverter.toItem(demandeVo);
            demande = demandeService.save(demande);
            return demandeConverter.toVo(demande);
            }

            @ApiOperation("Delete the specified demande")
            @DeleteMapping("/")
            public int delete(@RequestBody DemandeVo demandeVo){
            Demande demande = demandeConverter.toItem(demandeVo);
            return demandeService.delete(demande);
            }

            @ApiOperation("Deletes a demande by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return demandeService.deleteById(id);
            }
        @ApiOperation("find by societe id")
        @GetMapping("/societe/id/{id}")
        public List<Demande> findBySocieteId(@PathVariable Long id){
        return demandeService.findBySocieteId(id);
        }

        @ApiOperation("delete by societe id")
        @DeleteMapping("/societe/id/{id}")
        public int deleteBySocieteId(@PathVariable Long id){
        return demandeService.deleteBySocieteId(id);
        }

        @ApiOperation("find by comptable code")
        @GetMapping("/comptable/code/{code}")
        public List<Demande> findByComptableCode(@PathVariable String code){
        return demandeService.findByComptableCode(code);
        }

        @ApiOperation("delete by comptable code")
        @DeleteMapping("/comptable/code/{code}")
        public int deleteByComptableCode(@PathVariable String code){
        return demandeService.deleteByComptableCode(code);
        }

        @ApiOperation("find by comptable id")
        @GetMapping("/comptable/id/{id}")
        public List<Demande> findByComptableId(@PathVariable Long id){
        return demandeService.findByComptableId(id);
        }

        @ApiOperation("delete by comptable id")
        @DeleteMapping("/comptable/id/{id}")
        public int deleteByComptableId(@PathVariable Long id){
        return demandeService.deleteByComptableId(id);
        }

        @ApiOperation("find by etatDemande reference")
        @GetMapping("/etatDemande/reference/{reference}")
        public List<Demande> findByEtatDemandeReference(@PathVariable String reference){
        return demandeService.findByEtatDemandeReference(reference);
        }

        @ApiOperation("delete by etatDemande reference")
        @DeleteMapping("/etatDemande/reference/{reference}")
        public int deleteByEtatDemandeReference(@PathVariable String reference){
        return demandeService.deleteByEtatDemandeReference(reference);
        }

        @ApiOperation("find by etatDemande id")
        @GetMapping("/etatDemande/id/{id}")
        public List<Demande> findByEtatDemandeId(@PathVariable Long id){
        return demandeService.findByEtatDemandeId(id);
        }

        @ApiOperation("delete by etatDemande id")
        @DeleteMapping("/etatDemande/id/{id}")
        public int deleteByEtatDemandeId(@PathVariable Long id){
        return demandeService.deleteByEtatDemandeId(id);
        }



            @PutMapping("/archiver/")
            public DemandeVo archiver(@RequestBody DemandeVo demandeVo){
                Demande demande = demandeService.archiver(demandeConverter.toItem(demandeVo));
                return demandeConverter.toVo(demande);
                }

            @PutMapping("/desarchiver/")
            public DemandeVo desarchiver(@RequestBody DemandeVo demandeVo){
                Demande demande = demandeService.desarchiver(demandeConverter.toItem(demandeVo));
                return demandeConverter.toVo(demande);}
            }
