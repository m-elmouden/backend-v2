package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.FacturePieceJointeChercheurService;

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
import com.ird.faa.bean.FacturePieceJointe;
import com.ird.faa.ws.rest.provided.converter.FacturePieceJointeConverter;
import com.ird.faa.ws.rest.provided.vo.FacturePieceJointeVo;

@Api("Manages facturePieceJointe services")
@RestController
@RequestMapping("api/chercheur/facturePieceJointe")
public class FacturePieceJointeRestChercheur {

@Autowired
private FacturePieceJointeChercheurService facturePieceJointeService;

@Autowired
private FacturePieceJointeConverter facturePieceJointeConverter;


            @ApiOperation("Updates the specified  facturePieceJointe")
            @PutMapping("/")
            public  FacturePieceJointeVo update(@RequestBody  FacturePieceJointeVo  facturePieceJointeVo){
            FacturePieceJointe facturePieceJointe = facturePieceJointeConverter.toItem(facturePieceJointeVo);
            facturePieceJointe = facturePieceJointeService.update(facturePieceJointe);
            return facturePieceJointeConverter.toVo(facturePieceJointe);
            }

    @ApiOperation("Finds a list of all facturePieceJointes")
    @GetMapping("/")
    public List<FacturePieceJointeVo> findAll(){
        return facturePieceJointeConverter.toVo(facturePieceJointeService.findAll());
    }

    @ApiOperation("Finds a facturePieceJointe with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public FacturePieceJointeVo findByIdWithAssociatedList(@PathVariable Long id){
    return facturePieceJointeConverter.toVo(facturePieceJointeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search facturePieceJointe by a specific criteria")
    @PostMapping("/search")
    public List<FacturePieceJointeVo> findByCriteria(@RequestBody FacturePieceJointeVo facturePieceJointeVo){
        return facturePieceJointeConverter.toVo(facturePieceJointeService.findByCriteria(facturePieceJointeVo));
        }

            @ApiOperation("Finds a facturePieceJointe by id")
            @GetMapping("/id/{id}")
            public FacturePieceJointeVo findById(@PathVariable Long id){
            return facturePieceJointeConverter.toVo(facturePieceJointeService.findById(id));
            }

            @ApiOperation("Saves the specified  facturePieceJointe")
            @PostMapping("/")
            public FacturePieceJointeVo save(@RequestBody FacturePieceJointeVo facturePieceJointeVo){
            FacturePieceJointe facturePieceJointe = facturePieceJointeConverter.toItem(facturePieceJointeVo);
            facturePieceJointe = facturePieceJointeService.save(facturePieceJointe);
            return facturePieceJointeConverter.toVo(facturePieceJointe);
            }

            @ApiOperation("Delete the specified facturePieceJointe")
            @DeleteMapping("/")
            public int delete(@RequestBody FacturePieceJointeVo facturePieceJointeVo){
            FacturePieceJointe facturePieceJointe = facturePieceJointeConverter.toItem(facturePieceJointeVo);
            return facturePieceJointeService.delete(facturePieceJointe);
            }

            @ApiOperation("Deletes a facturePieceJointe by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return facturePieceJointeService.deleteById(id);
            }
        @ApiOperation("find by facture reference")
        @GetMapping("/facture/reference/{reference}")
        public List<FacturePieceJointe> findByFactureReference(@PathVariable String reference){
        return facturePieceJointeService.findByFactureReference(reference);
        }

        @ApiOperation("delete by facture reference")
        @DeleteMapping("/facture/reference/{reference}")
        public int deleteByFactureReference(@PathVariable String reference){
        return facturePieceJointeService.deleteByFactureReference(reference);
        }

        @ApiOperation("find by facture id")
        @GetMapping("/facture/id/{id}")
        public List<FacturePieceJointe> findByFactureId(@PathVariable Long id){
        return facturePieceJointeService.findByFactureId(id);
        }

        @ApiOperation("delete by facture id")
        @DeleteMapping("/facture/id/{id}")
        public int deleteByFactureId(@PathVariable Long id){
        return facturePieceJointeService.deleteByFactureId(id);
        }



            }
