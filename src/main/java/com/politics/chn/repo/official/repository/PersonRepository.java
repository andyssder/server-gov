package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.entity.PersonDO;
import com.politics.chn.repo.official.dao.PersonDao;
import com.politics.chn.repo.official.po.PersonPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xu
 * @since 2021-11-28
 */
@Repository
public class PersonRepository {

    private PersonDao personDao;

    private DistrictRepositoryImpl districtRepositoryImpl;

    private EthnicityRepository ethnicityRepository;

    private PartyRepository partyRepository;

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Autowired
    public void setDistrictRepository(DistrictRepositoryImpl districtRepositoryImpl) {
        this.districtRepositoryImpl = districtRepositoryImpl;
    }

    @Autowired
    public void setEthnicityRepository(EthnicityRepository ethnicityRepository) {
        this.ethnicityRepository = ethnicityRepository;
    }

    @Autowired
    public void setPartyRepository(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    public boolean addOne(PersonDO personDO) {
        PersonPO personPO = BeanUtil.toBean(personDO, PersonPO.class);
        if (!personDao.addOne(personPO)) {
            return false;
        }
        personDO.setId(personPO.getId());
        return true;
    }

    public boolean deleteOne(long id) {
        return personDao.deleteOne(id);
    }

    public boolean updateOne(PersonDO personDO) {
        PersonPO personPO = BeanUtil.toBean(personDO, PersonPO.class);
        return personDao.updateOne(personPO);
    }

    public List<PersonDO> getAll() {
        List<PersonPO> list = personDao.getAll();
        List<PersonDO> result = list.stream().map(item -> {
            PersonDO personDO = BeanUtil.toBean(item, PersonDO.class);
            personDO.setAncestralHome(districtRepositoryImpl.getById(item.getAncestralHomeId()));
            personDO.setBirthPlace(districtRepositoryImpl.getById(item.getBirthPlaceId()));
            personDO.setWorkPlace(districtRepositoryImpl.getById(item.getWorkPlaceId()));
            personDO.setEthnicity(ethnicityRepository.getOneById(item.getEthnicityId()));
            personDO.setParty(partyRepository.getOneById(item.getPartyId()));
            return personDO;
        }).collect(Collectors.toList());
        return result;
    }

    public PersonDO getOneById(Long id) {
        PersonPO personPO = personDao.getOneById(id);
        PersonDO personDO = BeanUtil.toBean(personPO, PersonDO.class);
        personDO.setAncestralHome(districtRepositoryImpl.getById(personPO.getAncestralHomeId()));
        personDO.setBirthPlace(districtRepositoryImpl.getById(personPO.getBirthPlaceId()));
        personDO.setWorkPlace(districtRepositoryImpl.getById(personPO.getWorkPlaceId()));
        personDO.setEthnicity(ethnicityRepository.getOneById(personPO.getEthnicityId()));
        personDO.setParty(partyRepository.getOneById(personPO.getPartyId()));
        return personDO;
    }

}
