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

    private DistrictService districtService;

    private EthnicityService ethnicityService;

    private PartyService partyService;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Autowired
    public void setDistrictService(DistrictService districtService) {
        this.districtService = districtService;
    }

    @Autowired
    public void setEthnicityService(EthnicityService ethnicityService) {
        this.ethnicityService = ethnicityService;
    }

    @Autowired
    public void setPartyService(PartyService partyService) {
        this.partyService = partyService;
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
        List<PersonDO> result = list.stream().map(item -> {
            PersonDO personDO = BeanUtil.toBean(item, PersonDO.class);
            personDO.setAncestralHome(districtService.getById(item.getAncestralHomeId()));
            personDO.setBirthPlace(districtService.getById(item.getBirthPlaceId()));
            personDO.setWorkPlace(districtService.getById(item.getWorkPlaceId()));
            personDO.setEthnicity(ethnicityService.getEthnicityById(item.getEthnicityId()));
            personDO.setParty(partyService.getPartyById(item.getPartyId()));
            return personDO;
        }).collect(Collectors.toList());
        return result;
    }

    public PersonDO getPersonById(Long id) {
        PersonPO personPO = personRepository.getOneById(id);
        PersonDO person = BeanUtil.toBean(personPO, PersonDO.class);
        person.setAncestralHome(districtService.getById(personPO.getAncestralHomeId()));
        person.setBirthPlace(districtService.getById(personPO.getBirthPlaceId()));
        person.setWorkPlace(districtService.getById(personPO.getWorkPlaceId()));
        person.setEthnicity(ethnicityService.getEthnicityById(personPO.getEthnicityId()));
        person.setParty(partyService.getPartyById(personPO.getPartyId()));
        return person;
    }

}
