package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.EtatDemandeAdminService;

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
import com.ird.faa.bean.EtatDemande;
import com.ird.faa.ws.rest.provided.converter.EtatDemandeConverter;
import com.ird.faa.ws.rest.provided.vo.EtatDemandeVo;

@Api("Manages etatDemande services")
@RestController
@RequestMapping("api/admin/etatDemande")
public class EtatDemandeRestAdmin {

@Autowired
private EtatDemandeAdminService etatDemandeService;

@Autowired
private EtatDemandeConverter etatDemandeConverter;


            @ApiOperation("Updates the specified  etatDemande")
            @PutMapping("/")
            public  EtatDemandeVo update(@RequestBody  EtatDemandeVo  etatDemandeVo){
            EtatDemande etatDemande = etatDemandeConverter.toItem(etatDemandeVo);
            etatDemande = etatDemandeService.update(etatDemande);
            return etatDemandeConverter.toVo(etatDemande);
            }

    @ApiOperation("Finds a list of all etatDemandes")
    @GetMapping("/")
    public List<EtatDemandeVo> findAll(){
        return etatDemandeConverter.toVo(etatDemandeService.findAll());
    }

    @ApiOperation("Finds a etatDemande with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatDemandeVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatDemandeConverter.toVo(etatDemandeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatDemande by a specific criteria")
    @PostMapping("/search")
    public List<EtatDemandeVo> findByCriteria(@RequestBody EtatDemandeVo etatDemandeVo){
        return etatDemandeConverter.toVo(etatDemandeService.findByCriteria(etatDemandeVo));
        }

            @ApiOperation("Finds a etatDemande by id")
            @GetMapping("/id/{id}")
            public EtatDemandeVo findById(@PathVariable Long id){
            return etatDemandeConverter.toVo(etatDemandeService.findById(id));
            }

            @ApiOperation("Saves the specified  etatDemande")
            @PostMapping("/")
            public EtatDemandeVo save(@RequestBody EtatDemandeVo etatDemandeVo){
            EtatDemande etatDemande = etatDemandeConverter.toItem(etatDemandeVo);
            etatDemande = etatDemandeService.save(etatDemande);
            return etatDemandeConverter.toVo(etatDemande);
            }

            @ApiOperation("Delete the specified etatDemande")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatDemandeVo etatDemandeVo){
            EtatDemande etatDemande = etatDemandeConverter.toItem(etatDemandeVo);
            return etatDemandeService.delete(etatDemande);
            }

            @ApiOperation("Deletes a etatDemande by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatDemandeService.deleteById(id);
            }


            }
