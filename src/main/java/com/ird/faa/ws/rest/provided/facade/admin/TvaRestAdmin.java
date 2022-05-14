package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.TvaAdminService;

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
import com.ird.faa.bean.Tva;
import com.ird.faa.ws.rest.provided.converter.TvaConverter;
import com.ird.faa.ws.rest.provided.vo.TvaVo;

@Api("Manages tva services")
@RestController
@RequestMapping("api/admin/tva")
public class TvaRestAdmin {

@Autowired
private TvaAdminService tvaService;

@Autowired
private TvaConverter tvaConverter;


            @ApiOperation("Updates the specified  tva")
            @PutMapping("/")
            public  TvaVo update(@RequestBody  TvaVo  tvaVo){
            Tva tva = tvaConverter.toItem(tvaVo);
            tva = tvaService.update(tva);
            return tvaConverter.toVo(tva);
            }

    @ApiOperation("Finds a list of all tvas")
    @GetMapping("/")
    public List<TvaVo> findAll(){
        return tvaConverter.toVo(tvaService.findAll());
    }

    @ApiOperation("Finds a tva with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TvaVo findByIdWithAssociatedList(@PathVariable Long id){
    return tvaConverter.toVo(tvaService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search tva by a specific criteria")
    @PostMapping("/search")
    public List<TvaVo> findByCriteria(@RequestBody TvaVo tvaVo){
        return tvaConverter.toVo(tvaService.findByCriteria(tvaVo));
        }

            @ApiOperation("Finds a tva by id")
            @GetMapping("/id/{id}")
            public TvaVo findById(@PathVariable Long id){
            return tvaConverter.toVo(tvaService.findById(id));
            }

            @ApiOperation("Saves the specified  tva")
            @PostMapping("/")
            public TvaVo save(@RequestBody TvaVo tvaVo){
            Tva tva = tvaConverter.toItem(tvaVo);
            tva = tvaService.save(tva);
            return tvaConverter.toVo(tva);
            }

            @ApiOperation("Delete the specified tva")
            @DeleteMapping("/")
            public int delete(@RequestBody TvaVo tvaVo){
            Tva tva = tvaConverter.toItem(tvaVo);
            return tvaService.delete(tva);
            }

            @ApiOperation("Deletes a tva by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return tvaService.deleteById(id);
            }


            }
