package com.ird.faa.upload.employe.service;

import com.ird.faa.dao.EmployeDao;
import com.ird.faa.upload.employe.helper.ExcelHelperEmploye;
import com.ird.faa.upload.employe.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceEmploye {
    @Autowired
    EmployeDao employeDao;
    @Autowired
    ExcelHelperEmploye excelHelperEmploye;

    public void save(MultipartFile file) {
        try {
            List<Employe> employes = excelHelperEmploye.excelToEmployes(file.getInputStream());
            employeDao.saveAll(employes);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Employe> getAllEmployes() {
        return employeDao.findAll();
    }
}