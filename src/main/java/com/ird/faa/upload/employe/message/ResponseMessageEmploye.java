package com.ird.faa.upload.employe.message;

public class ResponseMessageEmploye {
    private String message;
    public ResponseMessageEmploye(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
