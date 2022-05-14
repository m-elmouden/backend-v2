package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Commentaire;
import com.ird.faa.ws.rest.provided.vo.CommentaireVo;

@Component
public class CommentaireConverter extends AbstractConverter<Commentaire,CommentaireVo>{

        @Autowired
        private DemandeConverter demandeConverter ;
    private Boolean demande;

public  CommentaireConverter(){
init(true);
}

@Override
public Commentaire toItem(CommentaireVo vo) {
if (vo == null) {
return null;
} else {
Commentaire item = new Commentaire();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getDateCommentaire()))
        item.setDateCommentaire(DateUtil.parse(vo.getDateCommentaire()));
        if(StringUtil.isNotEmpty(vo.getAuteur()))
        item.setAuteur(vo.getAuteur());
    if(vo.getDemandeVo()!=null && this.demande)
        item.setDemande(demandeConverter.toItem(vo.getDemandeVo())) ;


return item;
}
}

@Override
public CommentaireVo toVo(Commentaire item) {
if (item == null) {
return null;
} else {
CommentaireVo vo = new CommentaireVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        if(item.getDateCommentaire()!=null)
        vo.setDateCommentaire(DateUtil.formateDate(item.getDateCommentaire()));
        if(StringUtil.isNotEmpty(item.getAuteur()))
        vo.setAuteur(item.getAuteur());

    if(item.getDemande()!=null && this.demande) {
        vo.setDemandeVo(demandeConverter.toVo(item.getDemande())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    demande = value;
}


        public DemandeConverter getDemandeConverter(){
        return this.demandeConverter;
        }
        public void setDemandeConverter(DemandeConverter demandeConverter ){
        this.demandeConverter = demandeConverter;
        }

    public boolean  isDemande(){
    return this.demande;
    }
    public void  setDemande(boolean demande){
    this.demande = demande;
    }










}
