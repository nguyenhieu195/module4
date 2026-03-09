package com.hieudev.ss1_chuyendoitiente.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static Map<String, String> dic = new HashMap<>();

    static {
        dic.put("hello", "xin chào");
        dic.put("book", "quyển sách");
        dic.put("computer", "máy tính");
        dic.put("student", "sinh viên");
        dic.put("teacher", "giáo viên");
    }

    @GetMapping("/dictionary")
    public String home() {
        return "displayDictionary";
    }

    @PostMapping("/dictionary/search")
    public String search(@RequestParam("word") String word, Model model) {
        String result = dic.get(word.toLowerCase());
        if (result != null) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "Không tìm thấy từ!");
        }

        model.addAttribute("word", word);

        return "displayDictionary";
    }
}
