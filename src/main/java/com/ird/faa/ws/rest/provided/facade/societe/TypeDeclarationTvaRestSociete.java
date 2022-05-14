package  com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.service.societe.facade.TypeDeclarationTvaSocieteService;

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
import com.ird.faa.bean.TypeDeclarationTva;
import com.ird.faa.ws.rest.provided.converter.TypeDeclarationTvaConverter;
import com.ird.faa.ws.rest.provided.vo.TypeDeclarationTvaVo;

@Api("Manages typeDeclarationTva services")
@RestController
@RequestMapping("api/societe/typeDeclarationTva")
public class TypeDeclarationTvaRestSociete {

@Autowired
private TypeDeclarationTvaSocieteService typeDeclarationTvaService;

@Autowired
private TypeDeclarationTvaConverter typeDeclarationTvaConverter;


            @ApiOperation("Updates the specified  typeDeclarationTva")
            @PutMapping("/")
            public  TypeDeclarationTvaVo update(@RequestBody  TypeDeclarationTvaVo  typeDeclarationTvaVo){
            TypeDeclarationTva typeDeclarationTva = typeDeclarationTvaConverter.toItem(typeDeclarationTvaVo);
            typeDeclarationTva = typeDeclarationTvaService.update(typeDeclarationTva);
            return typeDeclarationTvaConverter.toVo(typeDeclarationTva);
            }

    @ApiOperation("Finds a list of all typeDeclarationTvas")
    @GetMapping("/")
    public List<TypeDeclarationTvaVo> findAll(){
        return typeDeclarationTvaConverter.toVo(typeDeclarationTvaService.findAll());
    }

    @ApiOperation("Finds a typeDeclarationTva with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeDeclarationTvaVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeDeclarationTvaConverter.toVo(typeDeclarationTvaService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeDeclarationTva by a specific criteria")
    @PostMapping("/search")
    public List<TypeDeclarationTvaVo> findByCriteria(@RequestBody TypeDeclarationTvaVo typeDeclarationTvaVo){
        return typeDeclarationTvaConverter.toVo(typeDeclarationTvaService.findByCriteria(typeDeclarationTvaVo));
        }

            @ApiOperation("Finds a typeDeclarationTva by id")
            @GetMapping("/id/{id}")
            public TypeDeclarationTvaVo findById(@PathVariable Long id){
            return typeDeclarationTvaConverter.toVo(typeDeclarationTvaService.findById(id));
            }

            @ApiOperation("Saves the specified  typeDeclarationTva")
            @PostMapping("/")
            public TypeDeclarationTvaVo save(@RequestBody TypeDeclarationTvaVo typeDeclarationTvaVo){
            TypeDeclarationTva typeDeclarationTva = typeDeclarationTvaConverter.toItem(typeDeclarationTvaVo);
            typeDeclarationTva = typeDeclarationTvaService.save(typeDeclarationTva);
            return typeDeclarationTvaConverter.toVo(typeDeclarationTva);
            }

            @ApiOperation("Delete the specified typeDeclarationTva")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeDeclarationTvaVo typeDeclarationTvaVo){
            TypeDeclarationTva typeDeclarationTva = typeDeclarationTvaConverter.toItem(typeDeclarationTvaVo);
            return typeDeclarationTvaService.delete(typeDeclarationTva);
            }

            @ApiOperation("Deletes a typeDeclarationTva by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeDeclarationTvaService.deleteById(id);
            }


            }
