package com.alkemy.challenge.models;

import java.util.List;


import lombok.Data;

@Data
public class EMail {

    private String mailFrom = "disneyjavaapi@gmail.com"; //Change if the email change
    private String mailTo;
    private String mailCc;
    private String mailBcc;
    private String mailSubject = "Disney API -Welcome";
    private String mailContent = "Welcome to Java Disney API \nThank's for use our API REST app";
    private String contentType;
    private List<Object> attachments;

}
