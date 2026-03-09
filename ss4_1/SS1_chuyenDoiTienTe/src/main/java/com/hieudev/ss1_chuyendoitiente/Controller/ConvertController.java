package com.hieudev.ss1_chuyendoitiente.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ConvertController {

    @GetMapping("/convert")
    public String showForm() {
        return "displayConvert";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam ("usd") double usd,
                          @RequestParam ("rate")double rate,
                          Model model) {
        double vnd = usd * rate;
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        model.addAttribute("vnd", vnd);
        return "displayConvert";
    }
}
