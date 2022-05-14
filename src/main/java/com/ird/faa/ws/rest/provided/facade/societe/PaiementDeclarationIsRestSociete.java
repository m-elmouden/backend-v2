package  com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.service.societe.facade.PaiementDeclarationIsSocieteService;

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
import com.ird.faa.bean.PaiementDeclarationIs;
import com.ird.faa.ws.rest.provided.converter.PaiementDeclarationIsConverter;
import com.ird.faa.ws.rest.provided.vo.PaiementDeclarationIsVo;

@Api("Manages paiementDeclarationIs services")
@RestController
@RequestMapping("api/societe/paiementDeclarationIs")
public class PaiementDeclarationIsRestSociete {

@Autowired
private PaiementDeclarationIsSocieteService paiementDeclarationIsService;

@Autowired
private PaiementDeclarationIsConverter paiementDeclarationIsConverter;


            @ApiOperation("Updates the specified  paiementDeclarationIs")
            @PutMapping("/")
            public  PaiementDeclarationIsVo update(@RequestBody  PaiementDeclarationIsVo  paiementDeclarationIsVo){
            PaiementDeclarationIs paiementDeclarationIs = paiementDeclarationIsConverter.toItem(paiementDeclarationIsVo);
            paiementDeclarationIs = paiementDeclarationIsService.update(paiementDeclarationIs);
            return paiementDeclarationIsConverter.toVo(paiementDeclarationIs);
            }

    @ApiOperation("Finds a list of all paiementDeclarationIss")
    @GetMapping("/")
    public List<PaiementDeclarationIsVo> findAll(){
        return paiementDeclarationIsConverter.toVo(paiementDeclarationIsService.findAll());
    }

    @ApiOperation("Finds a paiementDeclarationIs with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PaiementDeclarationIsVo findByIdWithAssociatedList(@PathVariable Long id){
    return paiementDeclarationIsConverter.toVo(paiementDeclarationIsService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search paiementDeclarationIs by a specific criteria")
    @PostMapping("/search")
    public List<PaiementDeclarationIsVo> findByCriteria(@RequestBody PaiementDeclarationIsVo paiementDeclarationIsVo){
        return paiementDeclarationIsConverter.toVo(paiementDeclarationIsService.findByCriteria(paiementDeclarationIsVo));
        }

            @ApiOperation("Finds a paiementDeclarationIs by id")
            @GetMapping("/id/{id}")
            public PaiementDeclarationIsVo findById(@PathVariable Long id){
            return paiementDeclarationIsConverter.toVo(paiementDeclarationIsService.findById(id));
            }

            @ApiOperation("Saves the specified  paiementDeclarationIs")
            @PostMapping("/")
            public PaiementDeclarationIsVo save(@RequestBody PaiementDeclarationIsVo paiementDeclarationIsVo){
            PaiementDeclarationIs paiementDeclarationIs = paiementDeclarationIsConverter.toItem(paiementDeclarationIsVo);
            paiementDeclarationIs = paiementDeclarationIsService.save(paiementDeclarationIs);
            return paiementDeclarationIsConverter.toVo(paiementDeclarationIs);
            }

            @ApiOperation("Delete the specified paiementDeclarationIs")
            @DeleteMapping("/")
            public int delete(@RequestBody PaiementDeclarationIsVo paiementDeclarationIsVo){
            PaiementDeclarationIs paiementDeclarationIs = paiementDeclarationIsConverter.toItem(paiementDeclarationIsVo);
            return paiementDeclarationIsService.delete(paiementDeclarationIs);
            }

            @ApiOperation("Deletes a paiementDeclarationIs by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return paiementDeclarationIsService.deleteById(id);
            }
        @ApiOperation("find by declarationIs reference")
        @GetMapping("/declarationIs/reference/{reference}")
        public List<PaiementDeclarationIs> findByDeclarationIsReference(@PathVariable String reference){
        return paiementDeclarationIsService.findByDeclarationIsReference(reference);
        }

        @ApiOperation("delete by declarationIs reference")
        @DeleteMapping("/declarationIs/reference/{reference}")
        public int deleteByDeclarationIsReference(@PathVariable String reference){
        return paiementDeclarationIsService.deleteByDeclarationIsReference(reference);
        }

        @ApiOperation("find by declarationIs id")
        @GetMapping("/declarationIs/id/{id}")
        public List<PaiementDeclarationIs> findByDeclarationIsId(@PathVariable Long id){
        return paiementDeclarationIsService.findByDeclarationIsId(id);
        }

        @ApiOperation("delete by declarationIs id")
        @DeleteMapping("/declarationIs/id/{id}")
        public int deleteByDeclarationIsId(@PathVariable Long id){
        return paiementDeclarationIsService.deleteByDeclarationIsId(id);
        }



            }
