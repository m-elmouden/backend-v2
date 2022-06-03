package com.ird.faa.upload.societe.controller;

import java.util.List;

import com.ird.faa.bean.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/excel")
public class ExcelControllerSociete {
    @Autowired
    com.ird.faa.upload.societe.service.ExcelServiceSociete fileService;
    @PostMapping("/upload-societes")
    public ResponseEntity<com.ird.faa.upload.societe.message.ResponseMessageSociete> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (com.ird.faa.upload.societe.helper.ExcelHelperSociete.hasExcelFormat(file)) {
            try {
                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new com.ird.faa.upload.societe.message.ResponseMessageSociete(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new com.ird.faa.upload.societe.message.ResponseMessageSociete(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new com.ird.faa.upload.societe.message.ResponseMessageSociete(message));
    }
    @GetMapping("/list-societes")
    public ResponseEntity<List<Societe>> getAllListSociete() {
        try {
            List<Societe> societes = fileService.getAllSocietes();
            if (societes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(societes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}