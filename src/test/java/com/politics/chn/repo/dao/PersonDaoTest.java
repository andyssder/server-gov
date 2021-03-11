package com.politics.chn.repo.dao;

import cn.hutool.core.date.DateUtil;
import com.politics.chn.model.domain.entity.PersonDO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author andyssder
 * @create 2021-02-19 17:22
 */
@SpringBootTest
class PersonDaoTest {

    private PersonDao personDao;

    @Autowired
    private void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Test
    void addOne() {
        PersonDO person = getPersonDO("test-addOne");
        Assertions.assertTrue(personDao.addOne(person), "插入person失败");
        personDao.deleteOne(person.getId(), true);
    }

    @Test
    void deleteOne() {
        PersonDO person = getPersonDO("test-deleteOne");
        personDao.addOne(person);
        Long id = person.getId();
        Assertions.assertTrue(personDao.deleteOne(id), "删除person失败");
        PersonDO deletedPerson = personDao.getOneById(id).getPerson();
        Assertions.assertTrue(deletedPerson.getDeleted(), "标记person删除失败");
        personDao.deleteOne(id, true);
    }

    @Test
    void updateOne() {
        PersonDO person = getPersonDO("test-updateOne");
        personDao.addOne(person);
        Long id = person.getId();

        PersonDO targetPerson = getPersonDO("test-after-updateOne");
        targetPerson.setId(id);
        Assertions.assertTrue(personDao.updateOne(targetPerson), "更新person失败");
        PersonDO updatedPerson = personDao.getOneById(id).getPerson();
        Assertions.assertEquals(targetPerson.getName(), updatedPerson.getName(), "更新person name失败");
        personDao.deleteOne(id, true);
    }

    @Test
    void getAll() {
        Assertions.assertNotNull(personDao.getAll(), "获取所有person失败");
    }

    @Test
    void getOneById() {
        PersonDO person1 = getPersonDO("test-getOneById");
        personDao.addOne(person1);
        Long id = person1.getId();

        PersonDO person2 = personDao.getOneById(id).getPerson();
        Assertions.assertEquals(person1, person2, "根据Id获取person失败");
        personDao.deleteOne(id, true);
    }

    private PersonDO getPersonDO(String name) {
        PersonDO person = new PersonDO();
        person.setName(name);
        person.setGender(1);
        Date date = DateUtil.parse(DateUtil.today());
        person.setCreateTime(date);
        person.setUpdateTime(date);
        person.setDeleted(false);
        return person;
    }
}