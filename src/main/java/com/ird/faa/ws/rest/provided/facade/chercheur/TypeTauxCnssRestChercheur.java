package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.TypeTauxCnssChercheurService;

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
import com.ird.faa.bean.TypeTauxCnss;
import com.ird.faa.ws.rest.provided.converter.TypeTauxCnssConverter;
import com.ird.faa.ws.rest.provided.vo.TypeTauxCnssVo;

@Api("Manages typeTauxCnss services")
@RestController
@RequestMapping("api/chercheur/typeTauxCnss")
public class TypeTauxCnssRestChercheur {

@Autowired
private TypeTauxCnssChercheurService typeTauxCnssService;

@Autowired
private TypeTauxCnssConverter typeTauxCnssConverter;


            @ApiOperation("Updates the specified  typeTauxCnss")
            @PutMapping("/")
            public  TypeTauxCnssVo update(@RequestBody  TypeTauxCnssVo  typeTauxCnssVo){
            TypeTauxCnss typeTauxCnss = typeTauxCnssConverter.toItem(typeTauxCnssVo);
            typeTauxCnss = typeTauxCnssService.update(typeTauxCnss);
            return typeTauxCnssConverter.toVo(typeTauxCnss);
            }

    @ApiOperation("Finds a list of all typeTauxCnsss")
    @GetMapping("/")
    public List<TypeTauxCnssVo> findAll(){
        return typeTauxCnssConverter.toVo(typeTauxCnssService.findAll());
    }

    @ApiOperation("Finds a typeTauxCnss with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeTauxCnssVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeTauxCnssConverter.toVo(typeTauxCnssService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeTauxCnss by a specific criteria")
    @PostMapping("/search")
    public List<TypeTauxCnssVo> findByCriteria(@RequestBody TypeTauxCnssVo typeTauxCnssVo){
        return typeTauxCnssConverter.toVo(typeTauxCnssService.findByCriteria(typeTauxCnssVo));
        }

            @ApiOperation("Finds a typeTauxCnss by id")
            @GetMapping("/id/{id}")
            public TypeTauxCnssVo findById(@PathVariable Long id){
            return typeTauxCnssConverter.toVo(typeTauxCnssService.findById(id));
            }

            @ApiOperation("Saves the specified  typeTauxCnss")
            @PostMapping("/")
            public TypeTauxCnssVo save(@RequestBody TypeTauxCnssVo typeTauxCnssVo){
            TypeTauxCnss typeTauxCnss = typeTauxCnssConverter.toItem(typeTauxCnssVo);
            typeTauxCnss = typeTauxCnssService.save(typeTauxCnss);
            return typeTauxCnssConverter.toVo(typeTauxCnss);
            }

            @ApiOperation("Delete the specified typeTauxCnss")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeTauxCnssVo typeTauxCnssVo){
            TypeTauxCnss typeTauxCnss = typeTauxCnssConverter.toItem(typeTauxCnssVo);
            return typeTauxCnssService.delete(typeTauxCnss);
            }

            @ApiOperation("Deletes a typeTauxCnss by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeTauxCnssService.deleteById(id);
            }


            }
