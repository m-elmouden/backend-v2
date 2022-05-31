package com.ird.faa.upload.declarationIr.helper;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.ird.faa.bean.*;
import com.ird.faa.service.admin.facade.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Configuration
@Service
public class ExcelHelperDeclarationIr {
    @Autowired
    private SocieteAdminService societeAdminService;
    @Autowired
    private EtatDeclarationIrAdminService etatDeclarationIrAdminService;
    @Autowired
    private PaiementDeclarationIrAdminService paiementDeclarationIrAdminService;
    @Autowired
    private DeclarationIrEmployeAdminService declarationIrEmployeAdminService;
    @Autowired
    private PrelevementSocialEmployeAdminService prelevementSocialEmployeAdminService;

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"id", "refrerence", "annee", "mois", "montantIrCalcule", "montantIrAPaye", "totalAPaye", "totalSalaireNet", "totalSalaireBrut", "archive", "dateArchivage", "dateCreation", "admin", "visible", "username", "societe", "etatDeclarationIr", "paiementDeclarationIr", "declarationIrEmployes", "prelevementSocialEmployes"};
    static String SHEET = "DeclarationIr";

    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public  List<DeclarationIr> excelToDeclarationIrs(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<DeclarationIr> declarationIrs = new ArrayList<DeclarationIr>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                DeclarationIr declarationIr = new DeclarationIr();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            declarationIr.setId((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            declarationIr.setRefrerence(currentCell.getStringCellValue());
                            break;
                        case 2:
                            declarationIr.setAnnee(currentCell.getStringCellValue());
                            break;
                        case 3:
                            declarationIr.setMois(currentCell.getStringCellValue());

                        case 4:
                            declarationIr.setMontantIrCalcule(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 5:
                            declarationIr.setMontantIrAPaye(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 6:
                            declarationIr.setTotalAPaye(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 7:
                            declarationIr.setTotalSalaireNet(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 8:
                            declarationIr.setTotalSalaireBrut(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 9:
                            declarationIr.setArchive(currentCell.getBooleanCellValue());
                            break;
                        case 10:
                            declarationIr.setDateArchivage(currentCell.getDateCellValue());
                            break;
                        case 11:
                            declarationIr.setDateCreation(currentCell.getDateCellValue());
                            break;
                        case 12:
                            declarationIr.setAdmin(currentCell.getBooleanCellValue());
                            break;
                        case 13:
                            declarationIr.setVisible(currentCell.getBooleanCellValue());
                            break;
                        case 14:
                            declarationIr.setUsername(currentCell.getStringCellValue());
                            break;
                        case 15:
                            DataFormatter formatter1 = new DataFormatter();
                            String username = formatter1.formatCellValue(currentCell);
                            Societe societe = societeAdminService.findByUsername(username);
                            declarationIr.setSociete(societe);
                            break;
                        case 16:
                            DataFormatter formatter2 = new DataFormatter();
                            String ref = formatter2.formatCellValue(currentCell);
                            EtatDeclarationIr etatDeclarationIr = etatDeclarationIrAdminService.findByReference(ref);
                            declarationIr.setEtatDeclarationIr(etatDeclarationIr);
                            break;
                        case 17:
                            DataFormatter formatter3 = new DataFormatter();
                            String ref2 = formatter3.formatCellValue(currentCell);
                            PaiementDeclarationIr paiementDeclarationIr = paiementDeclarationIrAdminService.findByReference(ref2);
                            declarationIr.setPaiementDeclarationIr(paiementDeclarationIr);
                            break;
                        case 18:
                            DataFormatter formatter4 = new DataFormatter();
                            String ref3 = formatter4.formatCellValue(currentCell);
                            DeclarationIrEmploye declarationIrEmploye = (DeclarationIrEmploye) declarationIrEmployeAdminService.findByDeclarationIrRefrerence(ref3);
                            declarationIr.setDeclarationIrEmployes((List<DeclarationIrEmploye>) declarationIrEmploye);
                            break;
                        case 19:
                            DataFormatter formatter5 = new DataFormatter();
                            String ref4 = formatter5.formatCellValue(currentCell);
                            PrelevementSocialEmploye prelevementSocialEmploye = (PrelevementSocialEmploye) prelevementSocialEmployeAdminService.findByPrelevementSocialId(Long.valueOf(ref4));
                            declarationIr.setPrelevementSocialEmployes((List<PrelevementSocialEmploye>) prelevementSocialEmploye);
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                declarationIrs.add(declarationIr);
            }
            workbook.close();
            return declarationIrs;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
