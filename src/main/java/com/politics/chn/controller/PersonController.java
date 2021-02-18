package com.politics.chn.controller;

import com.politics.chn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: andyssder
 * @create: 2021-02-18 17:53
 */
@RestController
@RequestMapping
@CrossOrigin
public class PersonController {
    private PersonService personService;

    @Autowired
    private void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
