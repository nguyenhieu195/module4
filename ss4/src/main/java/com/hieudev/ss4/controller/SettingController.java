package com.hieudev.ss4.controller;


import com.hieudev.ss4.entity.Mail;
import com.hieudev.ss4.service.MailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SettingController {
    @Autowired
    private MailSettingService mailSettingService;

    @GetMapping("/setting")
    public String showSetting(Model model) {
        String[] languages = new String[]{"English","Vietnamese","Japanese","Chinese"};
        Integer[] pageSizes = new Integer[]{5,10,15,25,50,100};

        model.addAttribute("languages", languages);
        model.addAttribute("pageSizes", pageSizes);
        model.addAttribute("setting", mailSettingService.getMail());
        return "view";
    }

    @PostMapping("/update")
    public String updateSetting(@ModelAttribute("setting") Mail mail){
        mailSettingService.setMail(mail);
        return "redirect:/setting";
    }
}
