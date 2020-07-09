package com.example.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InputController {
    @GetMapping("/inputNameAgePage")
    public String getPageForInputNameAge() {
        return "secondLesson/inputNameAgePage";
    }

    @GetMapping("/inputNameAgePageProcess")
    public String processUserNameAge(@RequestParam String nameParam,
                                     @RequestParam Long ageParam,
                                     @RequestParam String dateParam,
                                     @RequestParam String cityParam,
                                     Model model) {
        //Получаем параметры из метода
        //И запихиваем их в модель
        model.addAttribute("name",nameParam);
        model.addAttribute("age",ageParam);
        model.addAttribute("date",dateParam);
        model.addAttribute("city",cityParam);
        return "secondLesson/nameAgePageResult";
    }

}
