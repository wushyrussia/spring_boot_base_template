package com.example.template.service;

import com.example.template.DTO.PersonInnerDTO;
import com.example.template.DTO.PersonOutterDTO;
import com.example.template.entity.Person;
import com.example.template.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    public boolean savePersonToDB( String nameParam,
                                   String ageParam,
                                   String logoParam,
                                   String passParam,
                                   String cardParam){
        //преобразовать dto в модель
        Person person = new Person(nameParam,ageParam,logoParam,passParam,cardParam);
        personRepo.save(person);
        return true;
    }

    public List<PersonOutterDTO> getListPersonOutterDTO() {
        List<PersonOutterDTO> personOutterDTOS = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        
        people = personRepo.findAll();
        
        for (Person person:people){
            PersonOutterDTO dto = model2DTO(person); 
            personOutterDTOS.add(dto);
        }
        
            return personOutterDTOS;
    }
    
    public PersonOutterDTO model2DTO(Person person){
        PersonOutterDTO personOutterDTO = new PersonOutterDTO();
        personOutterDTO.setAge(person.getAge());
        personOutterDTO.setLogo(person.getLogo());
        personOutterDTO.setName(person.getName());
        return personOutterDTO;
    }
    
    public Person dto2model(PersonInnerDTO dto){
        Person person = new Person();
        person.setAge(dto.getAge());
        person.setName(dto.getName());
        person.setCardNumber(dto.getCardNumber());
        person.setLogo(dto.getLogo());
        person.setPassword(dto.getPassword());
        return person;
    }
}
