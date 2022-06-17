package com.ird.faa.upload.societe.message;

public class ResponseMessageSociete {
    private String message;

    public ResponseMessageSociete(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
