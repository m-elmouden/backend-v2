package com.ird.faa.upload.declarationIrEmploye.message;

public class ResponseMessageDeclarationIrEmploye {
    private String message;
    public ResponseMessageDeclarationIrEmploye(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
