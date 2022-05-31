package com.ird.faa.upload.declarationIr.service;

import java.io.IOException;
import java.util.List;

import com.ird.faa.bean.DeclarationIr;
import com.ird.faa.dao.DeclarationIrDao;
import com.ird.faa.dao.DeclarationIrEmployeDao;
import com.ird.faa.bean.DeclarationIrEmploye;
import com.ird.faa.upload.declarationIr.helper.ExcelHelperDeclarationIr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelServiceDeclarationIr {
    @Autowired
    DeclarationIrDao declarationIrDao;
    @Autowired
    ExcelHelperDeclarationIr excelHelperDeclarationIr;


    public void save(MultipartFile file) {
        try {
            List<DeclarationIr> declarationIrs = excelHelperDeclarationIr.excelToDeclarationIrs(file.getInputStream());
            declarationIrDao.saveAll(declarationIrs);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<DeclarationIr> getAllDeclarationIrs() {
        return declarationIrDao.findAll();
    }
}