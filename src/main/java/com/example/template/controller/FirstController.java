package com.example.template.controller;

import com.example.template.model.Person;
import org.hibernate.dialect.lock.PessimisticEntityLockException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FirstController {

    @GetMapping("/feed")
    public String getViewWithOutModel() {
        //возвращает шаблон страницы firstExample.html из папки resources/templates
        return "firstExample";
    }

    @GetMapping("/singlePerson")
    public String getSinglePerson(Model model) {
        //создали новый объект и наполнили его данными
        Person person = new Person();
        person.setAge("22");
        person.setName("Игорь");

        //добавили объект в модель(положили)
        model.addAttribute("personKeyOne", person);
        return "singlePerson";
    }

    @GetMapping("/twoPerson")
    public String twoPerson(Model model) {
        //создали два объекта и наполнили их данными
        Person personOne = new Person("Игорь","22");
        Person personTwo = new Person("Роман","24");

        //положили в модель два объкта
        model.addAttribute("firstPerson",personOne);
        model.addAttribute("secondPerson",personTwo);

        return "twoPerson";
        }

    @GetMapping("/personList")
    public String personList(Model model) {
        //создали три обьекта с данными
        Person onePerson = new Person("Кракозября","22");
        Person twePerson = new Person("Мракозябра","122");
        Person threePerson = new Person("Грыкозябрка","223");

        //создали пустую коллекцию и положили в нее объекты
        List<Person> people = new ArrayList<>();
        people.add(onePerson);
        people.add(twePerson);
        people.add(threePerson);

        //положили коллекцию в модель
        model.addAttribute("people",people);

        return "personList";
    }
}
