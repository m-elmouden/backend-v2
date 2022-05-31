package com.ird.faa.upload.declarationIrEmploye.controller;

import java.util.List;

import com.ird.faa.bean.DeclarationIrEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/excel")
public class ExcelControllerDeclarationIrEmploye {
    @Autowired
    com.ird.faa.upload.declarationIrEmploye.service.ExcelServiceDeclarationIrEmploye fileService;
    @PostMapping("/upload-declaration-ir-emloyes")
    public ResponseEntity<com.ird.faa.upload.declarationIrEmploye.message.ResponseMessageDeclarationIrEmploye> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (com.ird.faa.upload.declarationIrEmploye.helper.ExcelHelperDeclarationIrEmploye.hasExcelFormat(file)) {
            try {
                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new com.ird.faa.upload.declarationIrEmploye.message.ResponseMessageDeclarationIrEmploye(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new com.ird.faa.upload.declarationIrEmploye.message.ResponseMessageDeclarationIrEmploye(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new com.ird.faa.upload.declarationIrEmploye.message.ResponseMessageDeclarationIrEmploye(message));
    }
    @GetMapping("/declaration-ir-emloyes")
    public ResponseEntity<List<DeclarationIrEmploye>> getAllDeclarationIrEmployes() {
        try {
            List<DeclarationIrEmploye> declarationIrEmployes = fileService.getAllDeclarationIrEmployes();
            if (declarationIrEmployes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(declarationIrEmployes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}