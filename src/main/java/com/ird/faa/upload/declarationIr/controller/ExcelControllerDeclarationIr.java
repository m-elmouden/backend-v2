package com.ird.faa.upload.declarationIr.controller;

import java.util.List;

import com.ird.faa.bean.DeclarationIr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/excel")
public class ExcelControllerDeclarationIr {
    @Autowired
    com.ird.faa.upload.declarationIr.service.ExcelServiceDeclarationIr fileService;
    @PostMapping("/upload-declaration-ir")
    public ResponseEntity<com.ird.faa.upload.declarationIr.message.ResponseMessageDeclarationIr> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (com.ird.faa.upload.declarationIr.helper.ExcelHelperDeclarationIr.hasExcelFormat(file)) {
            try {
                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new com.ird.faa.upload.declarationIr.message.ResponseMessageDeclarationIr(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new com.ird.faa.upload.declarationIr.message.ResponseMessageDeclarationIr(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new com.ird.faa.upload.declarationIr.message.ResponseMessageDeclarationIr(message));
    }
    @GetMapping("/declaration-ir")
    public ResponseEntity<List<DeclarationIr>> getAllDeclarationIrs() {
        try {
            List<DeclarationIr> declarationIrs = fileService.getAllDeclarationIrs();
            if (declarationIrs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(declarationIrs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}