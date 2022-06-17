package com.ird.faa.bean;

import java.util.Date;

public interface Archivable {

    Boolean getArchive();

    void setArchive(Boolean archive);

    Date getDateArchivage();

    void setDateArchivage(Date dateArchivage);

}
