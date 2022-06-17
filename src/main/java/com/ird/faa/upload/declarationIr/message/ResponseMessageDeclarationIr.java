package com.ird.faa.upload.declarationIr.message;

public class ResponseMessageDeclarationIr {
    private String message;

    public ResponseMessageDeclarationIr(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
