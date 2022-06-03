package com.ird.faa.upload.employe.helper;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ird.faa.upload.employe.model.Employe;
import com.ird.faa.bean.Societe;
import com.ird.faa.bean.TypeEmploye;
import com.ird.faa.service.admin.facade.SocieteAdminService;
import com.ird.faa.service.admin.facade.TypeEmployeAdminService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

@Configuration
public class ExcelHelperEmploye {
    @Autowired
    private TypeEmployeAdminService typeEmployeAdminService;
    @Autowired
    private SocieteAdminService societeAdminService;
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"id", "cin", "nom", "prenom", "nombreFamille", "typeEmploye", "societe"};
    static String SHEET="Employe";
    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public  List<Employe> excelToEmployes(InputStream is) {
        try {

            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            List<Employe> employes = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Employe employe = new Employe();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            employe.setId((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            employe.setCin(currentCell.getStringCellValue());
                            break;
                        case 2:
                            employe.setNom(currentCell.getStringCellValue());
                            break;
                        case 3:
                            employe.setPrenom(currentCell.getStringCellValue());
                            break;
                        case 4:
                            employe.setTotalSalaireNet(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 5:
                            employe.setNombreFamille(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 6:
                            DataFormatter formatter1 = new DataFormatter();
                            String code = formatter1.formatCellValue(currentCell);
                            TypeEmploye typeEmploye = typeEmployeAdminService.findByCode(code);
                            employe.setTypeEmploye(typeEmploye);
                            break;
                        case 7:
                            DataFormatter formatter2 = new DataFormatter();
                            String username = formatter2.formatCellValue(currentCell);
                            Societe societe = societeAdminService.findById((long) currentCell.getNumericCellValue());
                            employe.setSociete(societe);
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                employes.add(employe);
            }
            workbook.close();
            return employes;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
