package com.hieudev.ss4.service;


import com.hieudev.ss4.entity.Mail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailSettingService {

    private static Mail mail = new Mail("Vietnamese",15,true,"Dat\nLol, Asgard");

    public Mail getMail() {
        return mail;
    }

    public  void setMail(Mail mail) {
        this.mail = mail;
    }
}
