package com.ird.faa.upload.societe.helper;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ird.faa.bean.*;
import com.ird.faa.security.bean.Role;
import com.ird.faa.security.service.impl.RoleServiceImpl;
import com.ird.faa.service.admin.facade.*;
import com.ird.faa.upload.employe.model.Employe;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Configuration
@Service
public class ExcelHelperSociete {
    @Autowired
    private RoleServiceImpl roleService;
    @Autowired
    private ComptableAdminService comptableAdminService;
    @Autowired
    private PresidentSocieteAdminService presidentSocieteAdminService;
    @Autowired
    private TypeSocieteAdminService typeSocieteAdminService;
    @Autowired
    private DemandeAdminService demandeAdminService;
    @Autowired
    private DeclarationIrAdminService declarationIrAdminService;
    @Autowired
    private EmployeAdminService employeAdminService;


    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"Id", "ice", "adresse", "fax", "telephone", "raisonSociale", "dateCreation", "anneeExploitation", "capitalSocial", "description", "age", "credentialsNonExpired", "enabled", "", "SalaireNetImposable", "passwordChanged", "createdAt", "updatedAt", "username", "password", "equivalenceAvecPanelErc", "baseHorizon", "role", "comptable", "presidentSociete", "typeSociete", "demandes", "declarationIrs", "employes"};
    static String SHEET = "Societe";

    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public   List<Societe> excelToSociete(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<Societe> societes = new ArrayList<Societe>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Societe societe = new Societe();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            societe.setId((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            societe.setIce(currentCell.getStringCellValue());
                            break;
                        case 2:
                            societe.setAdresse(currentCell.getStringCellValue());
                            break;
                        case 3:
                            societe.setFax(currentCell.getStringCellValue());
                            break;
                        case 4:
                            societe.setTelephone(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 5:
                            societe.setRaisonSociale(currentCell.getStringCellValue());
                            break;
                        case 6:
                            societe.setDateCreation(currentCell.getDateCellValue());
                            break;
                        case 7:
                            societe.setAnneeExploitation(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 8:
                            societe.setCapitalSocial((long) currentCell.getNumericCellValue());
                            break;
                        case 9:
                            societe.setDescription(currentCell.getStringCellValue());
                            break;
                        case 10:
                            societe.setAge(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 11:
                            societe.setCredentialsNonExpired(currentCell.getBooleanCellValue());
                            break;
                        case 12:
                            societe.setEnabled(currentCell.getBooleanCellValue());
                            break;
                        case 13:
                            societe.setAccountNonExpired(currentCell.getBooleanCellValue());
                            break;
                        case 14:
                            societe.setAccountNonLocked(currentCell.getBooleanCellValue());
                            break;
                        case 15:
                            societe.setPasswordChanged(currentCell.getBooleanCellValue());
                            break;
                        case 16:
                            societe.setCreatedAt(currentCell.getDateCellValue());
                            break;
                        case 17:
                            societe.setUpdatedAt(currentCell.getDateCellValue());
                            break;
                        case 18:
                            societe.setUsername(currentCell.getStringCellValue());
                            break;
                        case 19:
                            societe.setPassword(currentCell.getStringCellValue());
                            break;
                        case 20:
                            societe.setEquivalenceAvecPanelErc(currentCell.getStringCellValue());
                            break;
                        case 21:
                            societe.setBaseHorizon(currentCell.getStringCellValue());
                            break;
                        case 22:
                            DataFormatter formatter1 = new DataFormatter();
                            String authority = formatter1.formatCellValue(currentCell);
                            Role role = roleService.findByAuthority(authority);
                            societe.setRole(String.valueOf(role));
                            break;
                        case 23:
                            DataFormatter formatter7 = new DataFormatter();
                            String code = formatter7.formatCellValue(currentCell);
                            Comptable comptable = comptableAdminService.findByCode(code);
                            societe.setComptable(comptable);
                        case 24:
                            DataFormatter formatter2 = new DataFormatter();
                            String id = formatter2.formatCellValue(currentCell);
                            PresidentSociete presidentSociete = presidentSocieteAdminService.findById(Long.valueOf(id));
                            societe.setPresidentSociete(presidentSociete);
                            break;
                        case 25:
                            DataFormatter formatter3 = new DataFormatter();
                            String code1 = formatter3.formatCellValue(currentCell);
                            TypeSociete typeSociete = typeSocieteAdminService.findByCode(code1);
                            societe.setTypeSociete(typeSociete);
                        case 26:
                            DataFormatter formatter4 = new DataFormatter();
                            String ref = formatter4.formatCellValue(currentCell);
                            Demande demande = demandeAdminService.findByReference(ref);
                            societe.setDemandes((List<Demande>) demande);
                        case 27:
                            DataFormatter formatter5 = new DataFormatter();
                            String ref2 = formatter5.formatCellValue(currentCell);
                            DeclarationIr declarationIr = declarationIrAdminService.findByRefrerence(ref2);
                            societe.setDeclarationIrs((List<DeclarationIr>) declarationIr);
                        case 28:
                            DataFormatter formatter6 = new DataFormatter();
                            String cin = formatter6.formatCellValue(currentCell);
                            Employe employe = employeAdminService.findByCin(cin);
                            societe.setEmployes((List<Employe>) employe);

                        default:
                            break;
                    }
                    cellIdx++;
                }
                societes.add(societe);
            }
            workbook.close();
            return societes;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
