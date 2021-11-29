package com.politics.chn.service.official;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.entity.PersonDO;
import com.politics.chn.repo.official.po.PersonPO;
import com.politics.chn.repo.official.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xu
 * @since 2021-11-28
 */
@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public boolean addPerson(PersonDO personDO) {
        return personRepository.addOne(personDO);
    }

    public boolean deletePerson(long id) {
        return personRepository.deleteOne(id);
    }

    public boolean updatePerson(PersonDO personDO) {
        return personRepository.updateOne(personDO);
    }

    public List<PersonDO> getAllPerson() {
        return personRepository.getAll();
    }

    public PersonDO getPersonById(Long id) {
        return personRepository.getOneById(id);
    }

}
