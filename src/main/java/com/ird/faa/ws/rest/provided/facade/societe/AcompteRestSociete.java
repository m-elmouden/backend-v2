package  com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.service.societe.facade.AcompteSocieteService;

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
import com.ird.faa.bean.Acompte;
import com.ird.faa.ws.rest.provided.converter.AcompteConverter;
import com.ird.faa.ws.rest.provided.vo.AcompteVo;

@Api("Manages acompte services")
@RestController
@RequestMapping("api/societe/acompte")
public class AcompteRestSociete {

@Autowired
private AcompteSocieteService acompteService;

@Autowired
private AcompteConverter acompteConverter;


            @ApiOperation("Updates the specified  acompte")
            @PutMapping("/")
            public  AcompteVo update(@RequestBody  AcompteVo  acompteVo){
            Acompte acompte = acompteConverter.toItem(acompteVo);
            acompte = acompteService.update(acompte);
            return acompteConverter.toVo(acompte);
            }

    @ApiOperation("Finds a list of all acomptes")
    @GetMapping("/")
    public List<AcompteVo> findAll(){
        return acompteConverter.toVo(acompteService.findAll());
    }

    @ApiOperation("Finds a acompte with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public AcompteVo findByIdWithAssociatedList(@PathVariable Long id){
    return acompteConverter.toVo(acompteService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search acompte by a specific criteria")
    @PostMapping("/search")
    public List<AcompteVo> findByCriteria(@RequestBody AcompteVo acompteVo){
        return acompteConverter.toVo(acompteService.findByCriteria(acompteVo));
        }

            @ApiOperation("Finds a acompte by id")
            @GetMapping("/id/{id}")
            public AcompteVo findById(@PathVariable Long id){
            return acompteConverter.toVo(acompteService.findById(id));
            }

            @ApiOperation("Saves the specified  acompte")
            @PostMapping("/")
            public AcompteVo save(@RequestBody AcompteVo acompteVo){
            Acompte acompte = acompteConverter.toItem(acompteVo);
            acompte = acompteService.save(acompte);
            return acompteConverter.toVo(acompte);
            }

            @ApiOperation("Delete the specified acompte")
            @DeleteMapping("/")
            public int delete(@RequestBody AcompteVo acompteVo){
            Acompte acompte = acompteConverter.toItem(acompteVo);
            return acompteService.delete(acompte);
            }

            @ApiOperation("Deletes a acompte by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return acompteService.deleteById(id);
            }
        @ApiOperation("find by societe id")
        @GetMapping("/societe/id/{id}")
        public List<Acompte> findBySocieteId(@PathVariable Long id){
        return acompteService.findBySocieteId(id);
        }

        @ApiOperation("delete by societe id")
        @DeleteMapping("/societe/id/{id}")
        public int deleteBySocieteId(@PathVariable Long id){
        return acompteService.deleteBySocieteId(id);
        }



            @PutMapping("/archiver/")
            public AcompteVo archiver(@RequestBody AcompteVo acompteVo){
                Acompte acompte = acompteService.archiver(acompteConverter.toItem(acompteVo));
                return acompteConverter.toVo(acompte);
                }

            @PutMapping("/desarchiver/")
            public AcompteVo desarchiver(@RequestBody AcompteVo acompteVo){
                Acompte acompte = acompteService.desarchiver(acompteConverter.toItem(acompteVo));
                return acompteConverter.toVo(acompte);}
            }
