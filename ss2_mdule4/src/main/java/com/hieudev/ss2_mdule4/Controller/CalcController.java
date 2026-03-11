package com.hieudev.ss2_mdule4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {
    @GetMapping("/calc")
    public String showForm() {
        return "calc";
    }

    @PostMapping("/calc")
    public String calculate(@RequestParam ("num1") double num1,
                            @RequestParam ("num2") double num2,
                            @RequestParam ("operation")String operation,
                            Model model) {

        double result = 0;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    model.addAttribute("error", "Cannot divide by zero");
                    return "calc";
                }
                result = num1 / num2;
                break;
        }

        model.addAttribute("result", result);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);

        return "calc";
    }
}
