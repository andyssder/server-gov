package com.politics.chn.service;

import com.politics.chn.repo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: andyssder
 * @create: 2021-02-18 17:52
 */
@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    private void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
