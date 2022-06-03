package com.ird.faa.upload.employe.controller;

import java.util.List;

import com.ird.faa.bean.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/excel")
public class ExcelControllerEmploye {
    @Autowired
    com.ird.faa.upload.employe.service.ExcelServiceEmploye fileService;
    @PostMapping("/upload-employes")
    public ResponseEntity<com.ird.faa.upload.employe.message.ResponseMessageEmploye> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (com.ird.faa.upload.employe.helper.ExcelHelperEmploye.hasExcelFormat(file)) {
            try {
                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new com.ird.faa.upload.employe.message.ResponseMessageEmploye(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new com.ird.faa.upload.employe.message.ResponseMessageEmploye(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new com.ird.faa.upload.employe.message.ResponseMessageEmploye(message));
    }
    @GetMapping("/list-employes")
    public ResponseEntity<List<Employe>> getAllListEmploye() {
        try {
            List<Employe> employes = fileService.getAllEmployes();
            if (employes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}