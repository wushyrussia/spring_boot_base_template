package com.example.template.controller;

import com.example.template.entity.Person;
import com.example.template.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @GetMapping("/getPersons")
    public String getPersons() {
        //возвращает шаблон страницы firstExample.html из папки resources/templates
        return "firstLesson/firstExample";
    }

    @GetMapping("/addPersonView")
    public String addPersonsView() {
        //отправляем страницу с формой. Без модели
        return "jpa/addPersonView";
    }

    @GetMapping("/persons")
    public String getPersonTable(Model model) {
        //получили все записи из таблицы Person и положили в коллекцию
        List<Person> personList = personRepo.findAll();
        //добавили коллекцию в модель
        model.addAttribute("person", personList);
        //отправили модель и вью в браузер
        return "jpa/persons";
    }

    @PostMapping("/addPerson")
    public String addPersons(@RequestParam String nameParam,
                             @RequestParam String ageParam,
                             Model model) {
        //получили параметры, которые нам отправил браузер
        //заполнили этими параметрами обьект Person
        Person person = new Person(nameParam,ageParam);
        //сохранили обьект Person в базу данных
        personRepo.save(person);

        //получили из базы данных(таблица Person) все записи и положили их в модель
        model.addAttribute("person", personRepo.findAll());
        return "jpa/persons";
    }
}
