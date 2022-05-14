package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.EtatPaiementChercheurService;

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
import com.ird.faa.bean.EtatPaiement;
import com.ird.faa.ws.rest.provided.converter.EtatPaiementConverter;
import com.ird.faa.ws.rest.provided.vo.EtatPaiementVo;

@Api("Manages etatPaiement services")
@RestController
@RequestMapping("api/chercheur/etatPaiement")
public class EtatPaiementRestChercheur {

@Autowired
private EtatPaiementChercheurService etatPaiementService;

@Autowired
private EtatPaiementConverter etatPaiementConverter;


            @ApiOperation("Updates the specified  etatPaiement")
            @PutMapping("/")
            public  EtatPaiementVo update(@RequestBody  EtatPaiementVo  etatPaiementVo){
            EtatPaiement etatPaiement = etatPaiementConverter.toItem(etatPaiementVo);
            etatPaiement = etatPaiementService.update(etatPaiement);
            return etatPaiementConverter.toVo(etatPaiement);
            }

    @ApiOperation("Finds a list of all etatPaiements")
    @GetMapping("/")
    public List<EtatPaiementVo> findAll(){
        return etatPaiementConverter.toVo(etatPaiementService.findAll());
    }

    @ApiOperation("Finds a etatPaiement with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatPaiementVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatPaiementConverter.toVo(etatPaiementService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatPaiement by a specific criteria")
    @PostMapping("/search")
    public List<EtatPaiementVo> findByCriteria(@RequestBody EtatPaiementVo etatPaiementVo){
        return etatPaiementConverter.toVo(etatPaiementService.findByCriteria(etatPaiementVo));
        }

            @ApiOperation("Finds a etatPaiement by id")
            @GetMapping("/id/{id}")
            public EtatPaiementVo findById(@PathVariable Long id){
            return etatPaiementConverter.toVo(etatPaiementService.findById(id));
            }

            @ApiOperation("Saves the specified  etatPaiement")
            @PostMapping("/")
            public EtatPaiementVo save(@RequestBody EtatPaiementVo etatPaiementVo){
            EtatPaiement etatPaiement = etatPaiementConverter.toItem(etatPaiementVo);
            etatPaiement = etatPaiementService.save(etatPaiement);
            return etatPaiementConverter.toVo(etatPaiement);
            }

            @ApiOperation("Delete the specified etatPaiement")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatPaiementVo etatPaiementVo){
            EtatPaiement etatPaiement = etatPaiementConverter.toItem(etatPaiementVo);
            return etatPaiementService.delete(etatPaiement);
            }

            @ApiOperation("Deletes a etatPaiement by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatPaiementService.deleteById(id);
            }


            }
