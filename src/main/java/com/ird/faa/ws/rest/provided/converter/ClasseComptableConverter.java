package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.ClasseComptable;
import com.ird.faa.ws.rest.provided.vo.ClasseComptableVo;

@Component
public class ClasseComptableConverter extends AbstractConverter<ClasseComptable,ClasseComptableVo>{

        @Autowired
        private SousClasseComptableConverter sousClasseComptableConverter ;
        private Boolean sousClasseComptables;

public  ClasseComptableConverter(){
init(true);
}

@Override
public ClasseComptable toItem(ClasseComptableVo vo) {
if (vo == null) {
return null;
} else {
ClasseComptable item = new ClasseComptable();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getNumero()))
        item.setNumero(NumberUtil.toBigDecimal(vo.getNumero()));
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
            if(vo.getAdmin() != null)
            item.setAdmin(vo.getAdmin());
            if(vo.getVisible() != null)
            item.setVisible(vo.getVisible());
        if(StringUtil.isNotEmpty(vo.getUsername()))
        item.setUsername(vo.getUsername());

    if(ListUtil.isNotEmpty(vo.getSousClasseComptablesVo()) && this.sousClasseComptables)
        item.setSousClasseComptables(sousClasseComptableConverter.toItem(vo.getSousClasseComptablesVo()));

return item;
}
}

@Override
public ClasseComptableVo toVo(ClasseComptable item) {
if (item == null) {
return null;
} else {
ClasseComptableVo vo = new ClasseComptableVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getNumero()!=null)
        vo.setNumero(NumberUtil.toString(item.getNumero()));

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
        if(item.getAdmin()!=null)
        vo.setAdmin(item.getAdmin());
        if(item.getVisible()!=null)
        vo.setVisible(item.getVisible());
        if(StringUtil.isNotEmpty(item.getUsername()))
        vo.setUsername(item.getUsername());

        if(ListUtil.isNotEmpty(item.getSousClasseComptables()) && this.sousClasseComptables){
        sousClasseComptableConverter.init(true);
        sousClasseComptableConverter.setClasseComptable(false);
        vo.setSousClasseComptablesVo(sousClasseComptableConverter.toVo(item.getSousClasseComptables()));
        sousClasseComptableConverter.setClasseComptable(true);
        }

return vo;
}
}

public void init(Boolean value) {
        sousClasseComptables = value;
}


        public SousClasseComptableConverter getSousClasseComptableConverter(){
        return this.sousClasseComptableConverter;
        }
        public void setSousClasseComptableConverter(SousClasseComptableConverter sousClasseComptableConverter ){
        this.sousClasseComptableConverter = sousClasseComptableConverter;
        }








        public Boolean  isSousClasseComptables(){
        return this.sousClasseComptables ;
        }
        public void  setSousClasseComptables(Boolean sousClasseComptables ){
        this.sousClasseComptables  = sousClasseComptables ;
        }














}
