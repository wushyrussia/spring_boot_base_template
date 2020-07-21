package com.example.template.controller.dto_facade;

import com.example.template.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonDTOController {

    @Autowired
    PersonService personService;

    @GetMapping("/addPersonDTOView")
    public String addPersonPage(){
        return "/dto_facade/addPersonView";
    }

    @PostMapping("/addPersonDTOSave")
    public String addPersonToDB(@RequestParam String nameParam,
                                @RequestParam String ageParam,
                                @RequestParam String logoParam,
                                @RequestParam String passParam,
                                @RequestParam String cardParam,
                                Model model){

        personService.savePersonToDB(nameParam,ageParam,logoParam,passParam,cardParam);

        model.addAttribute("person",personService.getListPersonOutterDTO());
        return "/dto_facade/persons";
    }

    @GetMapping("/personListView")
    public String getPersonListView( Model model){
        model.addAttribute("person",personService.getListPersonOutterDTO());
        return "/dto_facade/persons";
    }
}
