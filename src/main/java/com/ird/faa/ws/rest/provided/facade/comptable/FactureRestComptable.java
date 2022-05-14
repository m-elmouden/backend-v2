package  com.ird.faa.ws.rest.provided.facade.comptable;

import com.ird.faa.service.comptable.facade.FactureComptableService;

import java.math.BigDecimal;
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
import com.ird.faa.bean.Facture;
import com.ird.faa.ws.rest.provided.converter.FactureConverter;
import com.ird.faa.ws.rest.provided.vo.FactureVo;

@Api("Manages facture services")
@RestController
@RequestMapping("api/comptable/facture")
public class FactureRestComptable {

@Autowired
private FactureComptableService factureService;

@Autowired
private FactureConverter factureConverter;


            @ApiOperation("Updates the specified  facture")
            @PutMapping("/")
            public  FactureVo update(@RequestBody  FactureVo  factureVo){
            Facture facture = factureConverter.toItem(factureVo);
            facture = factureService.update(facture);
            return factureConverter.toVo(facture);
            }

    @ApiOperation("Finds a list of all factures")
    @GetMapping("/")
    public List<FactureVo> findAll(){
        return factureConverter.toVo(factureService.findAll());
    }

    @ApiOperation("Finds a facture with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public FactureVo findByIdWithAssociatedList(@PathVariable Long id){
    return factureConverter.toVo(factureService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search facture by a specific criteria")
    @PostMapping("/search")
    public List<FactureVo> findByCriteria(@RequestBody FactureVo factureVo){
        return factureConverter.toVo(factureService.findByCriteria(factureVo));
        }

            @ApiOperation("Finds a facture by id")
            @GetMapping("/id/{id}")
            public FactureVo findById(@PathVariable Long id){
            return factureConverter.toVo(factureService.findById(id));
            }

            @ApiOperation("Saves the specified  facture")
            @PostMapping("/")
            public FactureVo save(@RequestBody FactureVo factureVo){
            Facture facture = factureConverter.toItem(factureVo);
            facture = factureService.save(facture);
            return factureConverter.toVo(facture);
            }

            @ApiOperation("Delete the specified facture")
            @DeleteMapping("/")
            public int delete(@RequestBody FactureVo factureVo){
            Facture facture = factureConverter.toItem(factureVo);
            return factureService.delete(facture);
            }

            @ApiOperation("Deletes a facture by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return factureService.deleteById(id);
            }
        @ApiOperation("find by tva reference")
        @GetMapping("/tva/reference/{reference}")
        public List<Facture> findByTvaReference(@PathVariable String reference){
        return factureService.findByTvaReference(reference);
        }

        @ApiOperation("delete by tva reference")
        @DeleteMapping("/tva/reference/{reference}")
        public int deleteByTvaReference(@PathVariable String reference){
        return factureService.deleteByTvaReference(reference);
        }

        @ApiOperation("find by tva id")
        @GetMapping("/tva/id/{id}")
        public List<Facture> findByTvaId(@PathVariable Long id){
        return factureService.findByTvaId(id);
        }

        @ApiOperation("delete by tva id")
        @DeleteMapping("/tva/id/{id}")
        public int deleteByTvaId(@PathVariable Long id){
        return factureService.deleteByTvaId(id);
        }

        @ApiOperation("find by typeOperationFacture id")
        @GetMapping("/typeOperationFacture/id/{id}")
        public List<Facture> findByTypeOperationFactureId(@PathVariable Long id){
        return factureService.findByTypeOperationFactureId(id);
        }

        @ApiOperation("delete by typeOperationFacture id")
        @DeleteMapping("/typeOperationFacture/id/{id}")
        public int deleteByTypeOperationFactureId(@PathVariable Long id){
        return factureService.deleteByTypeOperationFactureId(id);
        }

        @ApiOperation("find by etatFacture id")
        @GetMapping("/etatFacture/id/{id}")
        public List<Facture> findByEtatFactureId(@PathVariable Long id){
        return factureService.findByEtatFactureId(id);
        }

        @ApiOperation("delete by etatFacture id")
        @DeleteMapping("/etatFacture/id/{id}")
        public int deleteByEtatFactureId(@PathVariable Long id){
        return factureService.deleteByEtatFactureId(id);
        }

        @ApiOperation("find by etatPaiement id")
        @GetMapping("/etatPaiement/id/{id}")
        public List<Facture> findByEtatPaiementId(@PathVariable Long id){
        return factureService.findByEtatPaiementId(id);
        }

        @ApiOperation("delete by etatPaiement id")
        @DeleteMapping("/etatPaiement/id/{id}")
        public int deleteByEtatPaiementId(@PathVariable Long id){
        return factureService.deleteByEtatPaiementId(id);
        }

        @ApiOperation("find by societe id")
        @GetMapping("/societe/id/{id}")
        public List<Facture> findBySocieteId(@PathVariable Long id){
        return factureService.findBySocieteId(id);
        }

        @ApiOperation("delete by societe id")
        @DeleteMapping("/societe/id/{id}")
        public int deleteBySocieteId(@PathVariable Long id){
        return factureService.deleteBySocieteId(id);
        }

        @ApiOperation("find by compteComptable numero")
        @GetMapping("/compteComptable/numero/{numero}")
        public List<Facture> findByCompteComptableNumero(@PathVariable BigDecimal numero){
        return factureService.findByCompteComptableNumero(numero);
        }

        @ApiOperation("delete by compteComptable numero")
        @DeleteMapping("/compteComptable/numero/{numero}")
        public int deleteByCompteComptableNumero(@PathVariable BigDecimal numero){
        return factureService.deleteByCompteComptableNumero(numero);
        }

        @ApiOperation("find by compteComptable id")
        @GetMapping("/compteComptable/id/{id}")
        public List<Facture> findByCompteComptableId(@PathVariable Long id){
        return factureService.findByCompteComptableId(id);
        }

        @ApiOperation("delete by compteComptable id")
        @DeleteMapping("/compteComptable/id/{id}")
        public int deleteByCompteComptableId(@PathVariable Long id){
        return factureService.deleteByCompteComptableId(id);
        }

        @ApiOperation("find by declarationIs reference")
        @GetMapping("/declarationIs/reference/{reference}")
        public List<Facture> findByDeclarationIsReference(@PathVariable String reference){
        return factureService.findByDeclarationIsReference(reference);
        }

        @ApiOperation("delete by declarationIs reference")
        @DeleteMapping("/declarationIs/reference/{reference}")
        public int deleteByDeclarationIsReference(@PathVariable String reference){
        return factureService.deleteByDeclarationIsReference(reference);
        }

        @ApiOperation("find by declarationIs id")
        @GetMapping("/declarationIs/id/{id}")
        public List<Facture> findByDeclarationIsId(@PathVariable Long id){
        return factureService.findByDeclarationIsId(id);
        }

        @ApiOperation("delete by declarationIs id")
        @DeleteMapping("/declarationIs/id/{id}")
        public int deleteByDeclarationIsId(@PathVariable Long id){
        return factureService.deleteByDeclarationIsId(id);
        }

        @ApiOperation("find by declarationTva reference")
        @GetMapping("/declarationTva/reference/{reference}")
        public List<Facture> findByDeclarationTvaReference(@PathVariable String reference){
        return factureService.findByDeclarationTvaReference(reference);
        }

        @ApiOperation("delete by declarationTva reference")
        @DeleteMapping("/declarationTva/reference/{reference}")
        public int deleteByDeclarationTvaReference(@PathVariable String reference){
        return factureService.deleteByDeclarationTvaReference(reference);
        }

        @ApiOperation("find by declarationTva id")
        @GetMapping("/declarationTva/id/{id}")
        public List<Facture> findByDeclarationTvaId(@PathVariable Long id){
        return factureService.findByDeclarationTvaId(id);
        }

        @ApiOperation("delete by declarationTva id")
        @DeleteMapping("/declarationTva/id/{id}")
        public int deleteByDeclarationTvaId(@PathVariable Long id){
        return factureService.deleteByDeclarationTvaId(id);
        }

        @ApiOperation("find by demande reference")
        @GetMapping("/demande/reference/{reference}")
        public List<Facture> findByDemandeReference(@PathVariable String reference){
        return factureService.findByDemandeReference(reference);
        }

        @ApiOperation("delete by demande reference")
        @DeleteMapping("/demande/reference/{reference}")
        public int deleteByDemandeReference(@PathVariable String reference){
        return factureService.deleteByDemandeReference(reference);
        }

        @ApiOperation("find by demande id")
        @GetMapping("/demande/id/{id}")
        public List<Facture> findByDemandeId(@PathVariable Long id){
        return factureService.findByDemandeId(id);
        }

        @ApiOperation("delete by demande id")
        @DeleteMapping("/demande/id/{id}")
        public int deleteByDemandeId(@PathVariable Long id){
        return factureService.deleteByDemandeId(id);
        }

        @ApiOperation("find by classeComptable id")
        @GetMapping("/classeComptable/id/{id}")
        public List<Facture> findByClasseComptableId(@PathVariable Long id){
        return factureService.findByClasseComptableId(id);
        }

        @ApiOperation("delete by classeComptable id")
        @DeleteMapping("/classeComptable/id/{id}")
        public int deleteByClasseComptableId(@PathVariable Long id){
        return factureService.deleteByClasseComptableId(id);
        }

        @ApiOperation("find by cpcFacture id")
        @GetMapping("/cpcFacture/id/{id}")
        public List<Facture> findByCpcFactureId(@PathVariable Long id){
        return factureService.findByCpcFactureId(id);
        }

        @ApiOperation("delete by cpcFacture id")
        @DeleteMapping("/cpcFacture/id/{id}")
        public int deleteByCpcFactureId(@PathVariable Long id){
        return factureService.deleteByCpcFactureId(id);
        }



            @PutMapping("/archiver/")
            public FactureVo archiver(@RequestBody FactureVo factureVo){
                Facture facture = factureService.archiver(factureConverter.toItem(factureVo));
                return factureConverter.toVo(facture);
                }

            @PutMapping("/desarchiver/")
            public FactureVo desarchiver(@RequestBody FactureVo factureVo){
                Facture facture = factureService.desarchiver(factureConverter.toItem(factureVo));
                return factureConverter.toVo(facture);}
            }
