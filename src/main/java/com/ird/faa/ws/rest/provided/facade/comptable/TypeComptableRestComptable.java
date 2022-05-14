package  com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.service.comptable.facade.TypeComptableComptableService;

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
import com.ird.faa.bean.TypeComptable;
import com.ird.faa.ws.rest.provided.converter.TypeComptableConverter;
import com.ird.faa.ws.rest.provided.vo.TypeComptableVo;

@Api("Manages typeComptable services")
@RestController
@RequestMapping("api/comptable/typeComptable")
public class TypeComptableRestComptable {

@Autowired
private TypeComptableComptableService typeComptableService;

@Autowired
private TypeComptableConverter typeComptableConverter;


            @ApiOperation("Updates the specified  typeComptable")
            @PutMapping("/")
            public  TypeComptableVo update(@RequestBody  TypeComptableVo  typeComptableVo){
            TypeComptable typeComptable = typeComptableConverter.toItem(typeComptableVo);
            typeComptable = typeComptableService.update(typeComptable);
            return typeComptableConverter.toVo(typeComptable);
            }

    @ApiOperation("Finds a list of all typeComptables")
    @GetMapping("/")
    public List<TypeComptableVo> findAll(){
        return typeComptableConverter.toVo(typeComptableService.findAll());
    }

    @ApiOperation("Finds a typeComptable with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeComptableVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeComptableConverter.toVo(typeComptableService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeComptable by a specific criteria")
    @PostMapping("/search")
    public List<TypeComptableVo> findByCriteria(@RequestBody TypeComptableVo typeComptableVo){
        return typeComptableConverter.toVo(typeComptableService.findByCriteria(typeComptableVo));
        }

            @ApiOperation("Finds a typeComptable by id")
            @GetMapping("/id/{id}")
            public TypeComptableVo findById(@PathVariable Long id){
            return typeComptableConverter.toVo(typeComptableService.findById(id));
            }

            @ApiOperation("Saves the specified  typeComptable")
            @PostMapping("/")
            public TypeComptableVo save(@RequestBody TypeComptableVo typeComptableVo){
            TypeComptable typeComptable = typeComptableConverter.toItem(typeComptableVo);
            typeComptable = typeComptableService.save(typeComptable);
            return typeComptableConverter.toVo(typeComptable);
            }

            @ApiOperation("Delete the specified typeComptable")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeComptableVo typeComptableVo){
            TypeComptable typeComptable = typeComptableConverter.toItem(typeComptableVo);
            return typeComptableService.delete(typeComptable);
            }

            @ApiOperation("Deletes a typeComptable by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeComptableService.deleteById(id);
            }


            }
