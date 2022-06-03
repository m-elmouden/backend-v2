package com.ird.faa.upload.declarationIrEmploye.helper;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ird.faa.bean.DeclarationIr;
import com.ird.faa.bean.DeclarationIrEmploye;
import com.ird.faa.upload.employe.model.Employe;
import com.ird.faa.bean.TauxIr;
import com.ird.faa.service.admin.facade.DeclarationIrAdminService;
import com.ird.faa.service.admin.facade.EmployeAdminService;
import com.ird.faa.service.admin.facade.TauxIrAdminService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Configuration
@Service
public class ExcelHelperDeclarationIrEmploye {
    @Autowired
    private DeclarationIrAdminService declarationIrAdminService;
    @Autowired
    private EmployeAdminService employeAdminService;
    @Autowired
    private TauxIrAdminService tauxIrAdminService;
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"id", "salaireNet", "salaireBrut", "salaireNetImposable", "salaireBase", "indemniteJustifie", "indemnite", "primes", "pourcentageAnciennete", "cotisation", "avantage", "heuresSupplementaires", "declarationIr", "employe","tauxIr"};
    static String SHEET = "declarationIrEmployes";

    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

     public  List<DeclarationIrEmploye> excelToDeclarationIrEmployes(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<DeclarationIrEmploye> declarationIrEmployes = new ArrayList<DeclarationIrEmploye>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                DeclarationIrEmploye declarationIrEmploye = new DeclarationIrEmploye();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            declarationIrEmploye.setId((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            declarationIrEmploye.setSalaireNet(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 2:
                            declarationIrEmploye.setSalaireBrut(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 3:
                            declarationIrEmploye.setSalaireNetImposable(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 4:
                            declarationIrEmploye.setSalaireBase(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 5:
                            declarationIrEmploye.setIndemniteJustifie(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 6:
                            declarationIrEmploye.setIndemnite(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 7:
                            declarationIrEmploye.setPrimes(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 8:
                            declarationIrEmploye.setPourcentageAnciennete(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 9:
                            declarationIrEmploye.setCotisation(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 10:
                            declarationIrEmploye.setAvantage(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 11:
                            declarationIrEmploye.setHeuresSupplementaires(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 12:
                            DataFormatter formatter1 = new DataFormatter();
                            String ref = formatter1.formatCellValue(currentCell);
                            DeclarationIr declarationIr = declarationIrAdminService.findByRefrerence(ref);
                            declarationIrEmploye.setDeclarationIr(declarationIr);
                            break;
                        case 13:
                            DataFormatter formatter2 = new DataFormatter();
                            String cin = formatter2.formatCellValue(currentCell);
                            Employe employe = employeAdminService.findByCin(cin);
                            declarationIrEmploye.setEmploye(employe);
                            break;
                        case 14:
                            DataFormatter formatter3 = new DataFormatter();
                            String intervalle = formatter3.formatCellValue(currentCell);
                            TauxIr tauxIr = tauxIrAdminService.findByIntervalle(intervalle);
                            declarationIrEmploye.setTauxIr(tauxIr);
                        default:
                            break;
                    }
                    cellIdx++;
                }
                declarationIrEmployes.add(declarationIrEmploye);
            }
            workbook.close();
            return declarationIrEmployes;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
