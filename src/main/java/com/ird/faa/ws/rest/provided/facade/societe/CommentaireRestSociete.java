package  com.ird.faa.ws.rest.provided.facade.societe;

import com.ird.faa.service.societe.facade.CommentaireSocieteService;

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
import com.ird.faa.bean.Commentaire;
import com.ird.faa.ws.rest.provided.converter.CommentaireConverter;
import com.ird.faa.ws.rest.provided.vo.CommentaireVo;

@Api("Manages commentaire services")
@RestController
@RequestMapping("api/societe/commentaire")
public class CommentaireRestSociete {

@Autowired
private CommentaireSocieteService commentaireService;

@Autowired
private CommentaireConverter commentaireConverter;


            @ApiOperation("Updates the specified  commentaire")
            @PutMapping("/")
            public  CommentaireVo update(@RequestBody  CommentaireVo  commentaireVo){
            Commentaire commentaire = commentaireConverter.toItem(commentaireVo);
            commentaire = commentaireService.update(commentaire);
            return commentaireConverter.toVo(commentaire);
            }

    @ApiOperation("Finds a list of all commentaires")
    @GetMapping("/")
    public List<CommentaireVo> findAll(){
        return commentaireConverter.toVo(commentaireService.findAll());
    }

    @ApiOperation("Finds a commentaire with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CommentaireVo findByIdWithAssociatedList(@PathVariable Long id){
    return commentaireConverter.toVo(commentaireService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search commentaire by a specific criteria")
    @PostMapping("/search")
    public List<CommentaireVo> findByCriteria(@RequestBody CommentaireVo commentaireVo){
        return commentaireConverter.toVo(commentaireService.findByCriteria(commentaireVo));
        }

            @ApiOperation("Finds a commentaire by id")
            @GetMapping("/id/{id}")
            public CommentaireVo findById(@PathVariable Long id){
            return commentaireConverter.toVo(commentaireService.findById(id));
            }

            @ApiOperation("Saves the specified  commentaire")
            @PostMapping("/")
            public CommentaireVo save(@RequestBody CommentaireVo commentaireVo){
            Commentaire commentaire = commentaireConverter.toItem(commentaireVo);
            commentaire = commentaireService.save(commentaire);
            return commentaireConverter.toVo(commentaire);
            }

            @ApiOperation("Delete the specified commentaire")
            @DeleteMapping("/")
            public int delete(@RequestBody CommentaireVo commentaireVo){
            Commentaire commentaire = commentaireConverter.toItem(commentaireVo);
            return commentaireService.delete(commentaire);
            }

            @ApiOperation("Deletes a commentaire by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return commentaireService.deleteById(id);
            }
        @ApiOperation("find by demande reference")
        @GetMapping("/demande/reference/{reference}")
        public List<Commentaire> findByDemandeReference(@PathVariable String reference){
        return commentaireService.findByDemandeReference(reference);
        }

        @ApiOperation("delete by demande reference")
        @DeleteMapping("/demande/reference/{reference}")
        public int deleteByDemandeReference(@PathVariable String reference){
        return commentaireService.deleteByDemandeReference(reference);
        }

        @ApiOperation("find by demande id")
        @GetMapping("/demande/id/{id}")
        public List<Commentaire> findByDemandeId(@PathVariable Long id){
        return commentaireService.findByDemandeId(id);
        }

        @ApiOperation("delete by demande id")
        @DeleteMapping("/demande/id/{id}")
        public int deleteByDemandeId(@PathVariable Long id){
        return commentaireService.deleteByDemandeId(id);
        }



            }
