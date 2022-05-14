package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.DemandePieceJointeChercheurService;

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
import com.ird.faa.bean.DemandePieceJointe;
import com.ird.faa.ws.rest.provided.converter.DemandePieceJointeConverter;
import com.ird.faa.ws.rest.provided.vo.DemandePieceJointeVo;

@Api("Manages demandePieceJointe services")
@RestController
@RequestMapping("api/chercheur/demandePieceJointe")
public class DemandePieceJointeRestChercheur {

@Autowired
private DemandePieceJointeChercheurService demandePieceJointeService;

@Autowired
private DemandePieceJointeConverter demandePieceJointeConverter;


            @ApiOperation("Updates the specified  demandePieceJointe")
            @PutMapping("/")
            public  DemandePieceJointeVo update(@RequestBody  DemandePieceJointeVo  demandePieceJointeVo){
            DemandePieceJointe demandePieceJointe = demandePieceJointeConverter.toItem(demandePieceJointeVo);
            demandePieceJointe = demandePieceJointeService.update(demandePieceJointe);
            return demandePieceJointeConverter.toVo(demandePieceJointe);
            }

    @ApiOperation("Finds a list of all demandePieceJointes")
    @GetMapping("/")
    public List<DemandePieceJointeVo> findAll(){
        return demandePieceJointeConverter.toVo(demandePieceJointeService.findAll());
    }

    @ApiOperation("Finds a demandePieceJointe with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DemandePieceJointeVo findByIdWithAssociatedList(@PathVariable Long id){
    return demandePieceJointeConverter.toVo(demandePieceJointeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search demandePieceJointe by a specific criteria")
    @PostMapping("/search")
    public List<DemandePieceJointeVo> findByCriteria(@RequestBody DemandePieceJointeVo demandePieceJointeVo){
        return demandePieceJointeConverter.toVo(demandePieceJointeService.findByCriteria(demandePieceJointeVo));
        }

            @ApiOperation("Finds a demandePieceJointe by id")
            @GetMapping("/id/{id}")
            public DemandePieceJointeVo findById(@PathVariable Long id){
            return demandePieceJointeConverter.toVo(demandePieceJointeService.findById(id));
            }

            @ApiOperation("Saves the specified  demandePieceJointe")
            @PostMapping("/")
            public DemandePieceJointeVo save(@RequestBody DemandePieceJointeVo demandePieceJointeVo){
            DemandePieceJointe demandePieceJointe = demandePieceJointeConverter.toItem(demandePieceJointeVo);
            demandePieceJointe = demandePieceJointeService.save(demandePieceJointe);
            return demandePieceJointeConverter.toVo(demandePieceJointe);
            }

            @ApiOperation("Delete the specified demandePieceJointe")
            @DeleteMapping("/")
            public int delete(@RequestBody DemandePieceJointeVo demandePieceJointeVo){
            DemandePieceJointe demandePieceJointe = demandePieceJointeConverter.toItem(demandePieceJointeVo);
            return demandePieceJointeService.delete(demandePieceJointe);
            }

            @ApiOperation("Deletes a demandePieceJointe by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return demandePieceJointeService.deleteById(id);
            }
        @ApiOperation("find by demande reference")
        @GetMapping("/demande/reference/{reference}")
        public List<DemandePieceJointe> findByDemandeReference(@PathVariable String reference){
        return demandePieceJointeService.findByDemandeReference(reference);
        }

        @ApiOperation("delete by demande reference")
        @DeleteMapping("/demande/reference/{reference}")
        public int deleteByDemandeReference(@PathVariable String reference){
        return demandePieceJointeService.deleteByDemandeReference(reference);
        }

        @ApiOperation("find by demande id")
        @GetMapping("/demande/id/{id}")
        public List<DemandePieceJointe> findByDemandeId(@PathVariable Long id){
        return demandePieceJointeService.findByDemandeId(id);
        }

        @ApiOperation("delete by demande id")
        @DeleteMapping("/demande/id/{id}")
        public int deleteByDemandeId(@PathVariable Long id){
        return demandePieceJointeService.deleteByDemandeId(id);
        }



            }
