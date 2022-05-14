package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.PrelevementSocialChercheurService;

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
import com.ird.faa.bean.PrelevementSocial;
import com.ird.faa.ws.rest.provided.converter.PrelevementSocialConverter;
import com.ird.faa.ws.rest.provided.vo.PrelevementSocialVo;

@Api("Manages prelevementSocial services")
@RestController
@RequestMapping("api/chercheur/prelevementSocial")
public class PrelevementSocialRestChercheur {

@Autowired
private PrelevementSocialChercheurService prelevementSocialService;

@Autowired
private PrelevementSocialConverter prelevementSocialConverter;


            @ApiOperation("Updates the specified  prelevementSocial")
            @PutMapping("/")
            public  PrelevementSocialVo update(@RequestBody  PrelevementSocialVo  prelevementSocialVo){
            PrelevementSocial prelevementSocial = prelevementSocialConverter.toItem(prelevementSocialVo);
            prelevementSocial = prelevementSocialService.update(prelevementSocial);
            return prelevementSocialConverter.toVo(prelevementSocial);
            }

    @ApiOperation("Finds a list of all prelevementSocials")
    @GetMapping("/")
    public List<PrelevementSocialVo> findAll(){
        return prelevementSocialConverter.toVo(prelevementSocialService.findAll());
    }

    @ApiOperation("Finds a prelevementSocial with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PrelevementSocialVo findByIdWithAssociatedList(@PathVariable Long id){
    return prelevementSocialConverter.toVo(prelevementSocialService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search prelevementSocial by a specific criteria")
    @PostMapping("/search")
    public List<PrelevementSocialVo> findByCriteria(@RequestBody PrelevementSocialVo prelevementSocialVo){
        return prelevementSocialConverter.toVo(prelevementSocialService.findByCriteria(prelevementSocialVo));
        }

            @ApiOperation("Finds a prelevementSocial by id")
            @GetMapping("/id/{id}")
            public PrelevementSocialVo findById(@PathVariable Long id){
            return prelevementSocialConverter.toVo(prelevementSocialService.findById(id));
            }

            @ApiOperation("Saves the specified  prelevementSocial")
            @PostMapping("/")
            public PrelevementSocialVo save(@RequestBody PrelevementSocialVo prelevementSocialVo){
            PrelevementSocial prelevementSocial = prelevementSocialConverter.toItem(prelevementSocialVo);
            prelevementSocial = prelevementSocialService.save(prelevementSocial);
            return prelevementSocialConverter.toVo(prelevementSocial);
            }

            @ApiOperation("Delete the specified prelevementSocial")
            @DeleteMapping("/")
            public int delete(@RequestBody PrelevementSocialVo prelevementSocialVo){
            PrelevementSocial prelevementSocial = prelevementSocialConverter.toItem(prelevementSocialVo);
            return prelevementSocialService.delete(prelevementSocial);
            }

            @ApiOperation("Deletes a prelevementSocial by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return prelevementSocialService.deleteById(id);
            }


            }
