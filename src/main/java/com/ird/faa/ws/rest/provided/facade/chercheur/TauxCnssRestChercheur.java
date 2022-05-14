package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.TauxCnssChercheurService;

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
import com.ird.faa.bean.TauxCnss;
import com.ird.faa.ws.rest.provided.converter.TauxCnssConverter;
import com.ird.faa.ws.rest.provided.vo.TauxCnssVo;

@Api("Manages tauxCnss services")
@RestController
@RequestMapping("api/chercheur/tauxCnss")
public class TauxCnssRestChercheur {

@Autowired
private TauxCnssChercheurService tauxCnssService;

@Autowired
private TauxCnssConverter tauxCnssConverter;


            @ApiOperation("Updates the specified  tauxCnss")
            @PutMapping("/")
            public  TauxCnssVo update(@RequestBody  TauxCnssVo  tauxCnssVo){
            TauxCnss tauxCnss = tauxCnssConverter.toItem(tauxCnssVo);
            tauxCnss = tauxCnssService.update(tauxCnss);
            return tauxCnssConverter.toVo(tauxCnss);
            }

    @ApiOperation("Finds a list of all tauxCnsss")
    @GetMapping("/")
    public List<TauxCnssVo> findAll(){
        return tauxCnssConverter.toVo(tauxCnssService.findAll());
    }

    @ApiOperation("Finds a tauxCnss with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TauxCnssVo findByIdWithAssociatedList(@PathVariable Long id){
    return tauxCnssConverter.toVo(tauxCnssService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search tauxCnss by a specific criteria")
    @PostMapping("/search")
    public List<TauxCnssVo> findByCriteria(@RequestBody TauxCnssVo tauxCnssVo){
        return tauxCnssConverter.toVo(tauxCnssService.findByCriteria(tauxCnssVo));
        }

            @ApiOperation("Finds a tauxCnss by id")
            @GetMapping("/id/{id}")
            public TauxCnssVo findById(@PathVariable Long id){
            return tauxCnssConverter.toVo(tauxCnssService.findById(id));
            }

            @ApiOperation("Saves the specified  tauxCnss")
            @PostMapping("/")
            public TauxCnssVo save(@RequestBody TauxCnssVo tauxCnssVo){
            TauxCnss tauxCnss = tauxCnssConverter.toItem(tauxCnssVo);
            tauxCnss = tauxCnssService.save(tauxCnss);
            return tauxCnssConverter.toVo(tauxCnss);
            }

            @ApiOperation("Delete the specified tauxCnss")
            @DeleteMapping("/")
            public int delete(@RequestBody TauxCnssVo tauxCnssVo){
            TauxCnss tauxCnss = tauxCnssConverter.toItem(tauxCnssVo);
            return tauxCnssService.delete(tauxCnss);
            }

            @ApiOperation("Deletes a tauxCnss by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return tauxCnssService.deleteById(id);
            }
        @ApiOperation("find by typeTauxCnss id")
        @GetMapping("/typeTauxCnss/id/{id}")
        public List<TauxCnss> findByTypeTauxCnssId(@PathVariable Long id){
        return tauxCnssService.findByTypeTauxCnssId(id);
        }

        @ApiOperation("delete by typeTauxCnss id")
        @DeleteMapping("/typeTauxCnss/id/{id}")
        public int deleteByTypeTauxCnssId(@PathVariable Long id){
        return tauxCnssService.deleteByTypeTauxCnssId(id);
        }



            }
