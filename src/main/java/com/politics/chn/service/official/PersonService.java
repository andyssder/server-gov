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
    public void setPersonDao(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public boolean addPerson(PersonDO personDO) {
        PersonPO person = BeanUtil.toBean(personDO, PersonPO.class);
        return personRepository.addOne(person);
    }

    public boolean deletePerson(long id) {
        return personRepository.deleteOne(id);
    }

    public boolean updatePerson(PersonDO personDO) {

        PersonPO person = BeanUtil.toBean(personDO, PersonPO.class);
        return personRepository.updateOne(person);
    }

    public List<PersonDO> getAllPerson() {
        List<PersonPO> list = personRepository.getAll();
        List<PersonDO> result = list.stream().map(item -> BeanUtil.toBean(item, PersonDO.class)).collect(Collectors.toList());
        return result;
    }

    public PersonDO getPersonById(Long id) {
        PersonPO personPO = personRepository.getOneById(id);
        PersonDO person = BeanUtil.toBean(personPO, PersonDO.class);
        return person;
    }

}
