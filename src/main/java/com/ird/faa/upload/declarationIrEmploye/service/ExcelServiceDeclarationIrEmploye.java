package com.ird.faa.upload.declarationIrEmploye.service;

import com.ird.faa.bean.DeclarationIrEmploye;
import com.ird.faa.dao.DeclarationIrEmployeDao;
import com.ird.faa.upload.declarationIrEmploye.helper.ExcelHelperDeclarationIrEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceDeclarationIrEmploye {
    @Autowired
    DeclarationIrEmployeDao declarationIrEmployeExcelDao;
    @Autowired
    ExcelHelperDeclarationIrEmploye excelHelperDeclarationIrEmploye;

    public void save(MultipartFile file) {
        try {
            List<DeclarationIrEmploye> declarationIrEmployes = excelHelperDeclarationIrEmploye.excelToDeclarationIrEmployes(file.getInputStream());
            declarationIrEmployeExcelDao.saveAll(declarationIrEmployes);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<DeclarationIrEmploye> getAllDeclarationIrEmployes() {
        return declarationIrEmployeExcelDao.findAll();
    }
}