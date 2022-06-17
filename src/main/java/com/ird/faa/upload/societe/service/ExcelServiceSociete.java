package com.ird.faa.upload.societe.service;

import com.ird.faa.bean.Societe;
import com.ird.faa.dao.SocieteDao;
import com.ird.faa.upload.societe.helper.ExcelHelperSociete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceSociete {
    @Autowired
    SocieteDao societeDao;
    @Autowired
    ExcelHelperSociete excelHelperSociete;

    public void save(MultipartFile file) {
        try {
            List<Societe> societes = excelHelperSociete.excelToSociete(file.getInputStream());
            societeDao.saveAll(societes);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Societe> getAllSocietes() {
        return societeDao.findAll();
    }
}