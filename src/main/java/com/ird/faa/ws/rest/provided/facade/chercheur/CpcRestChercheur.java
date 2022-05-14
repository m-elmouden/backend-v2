package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.CpcChercheurService;

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
import com.ird.faa.bean.Cpc;
import com.ird.faa.ws.rest.provided.converter.CpcConverter;
import com.ird.faa.ws.rest.provided.vo.CpcVo;

@Api("Manages cpc services")
@RestController
@RequestMapping("api/chercheur/cpc")
public class CpcRestChercheur {

@Autowired
private CpcChercheurService cpcService;

@Autowired
private CpcConverter cpcConverter;


            @ApiOperation("Updates the specified  cpc")
            @PutMapping("/")
            public  CpcVo update(@RequestBody  CpcVo  cpcVo){
            Cpc cpc = cpcConverter.toItem(cpcVo);
            cpc = cpcService.update(cpc);
            return cpcConverter.toVo(cpc);
            }

    @ApiOperation("Finds a list of all cpcs")
    @GetMapping("/")
    public List<CpcVo> findAll(){
        return cpcConverter.toVo(cpcService.findAll());
    }

    @ApiOperation("Finds a cpc with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CpcVo findByIdWithAssociatedList(@PathVariable Long id){
    return cpcConverter.toVo(cpcService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search cpc by a specific criteria")
    @PostMapping("/search")
    public List<CpcVo> findByCriteria(@RequestBody CpcVo cpcVo){
        return cpcConverter.toVo(cpcService.findByCriteria(cpcVo));
        }

            @ApiOperation("Finds a cpc by id")
            @GetMapping("/id/{id}")
            public CpcVo findById(@PathVariable Long id){
            return cpcConverter.toVo(cpcService.findById(id));
            }

            @ApiOperation("Saves the specified  cpc")
            @PostMapping("/")
            public CpcVo save(@RequestBody CpcVo cpcVo){
            Cpc cpc = cpcConverter.toItem(cpcVo);
            cpc = cpcService.save(cpc);
            return cpcConverter.toVo(cpc);
            }

            @ApiOperation("Delete the specified cpc")
            @DeleteMapping("/")
            public int delete(@RequestBody CpcVo cpcVo){
            Cpc cpc = cpcConverter.toItem(cpcVo);
            return cpcService.delete(cpc);
            }

            @ApiOperation("Deletes a cpc by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return cpcService.deleteById(id);
            }


            }
