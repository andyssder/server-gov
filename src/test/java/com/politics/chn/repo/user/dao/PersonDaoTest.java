package com.politics.chn.repo.user.dao;

import com.politics.chn.repo.official.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @since 2021-02-19
 * @author andyssder
 */
//@SpringBootTest
class PersonDaoTest {

    private PersonDao personDao;

    @Autowired
    private void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

//    @Test
//    void addOne() {
//        Person person = getPersonDO("test-addOne");
//        Assertions.assertTrue(personDao.addOne(person), "插入person失败");
//        personDao.deleteOne(person.getId(), true);
//    }

//    @Test
//    void deleteOne() {
//        Person person = getPersonDO("test-deleteOne");
//        personDao.addOne(person);
//        Long id = person.getId();
//        Assertions.assertTrue(personDao.deleteOne(id), "删除person失败");
//        Person deletedPerson = personDao.getOneById(id);
//        Assertions.assertTrue(deletedPerson.getDeleted(), "标记person删除失败");
//        personDao.deleteOne(id, true);
//    }
//
//    @Test
//    void updateOne() {
//        Person person = getPersonDO("test-updateOne");
//        personDao.addOne(person);
//        Long id = person.getId();
//
//        Person targetPerson = getPersonDO("test-after-updateOne");
//        targetPerson.setId(id);
//        Assertions.assertTrue(personDao.updateOne(targetPerson), "更新person失败");
//        Person updatedPerson = personDao.getOneById(id);
//        Assertions.assertEquals(targetPerson.getName(), updatedPerson.getName(), "更新person name失败");
//        personDao.deleteOne(id, true);
//    }
//
//    @Test
//    void getAll() {
//        Assertions.assertNotNull(personDao.getAll(), "获取所有person失败");
//    }
//
//    @Test
//    void getOneById() {
//        Person person1 = getPersonDO("test-getOneById");
//        personDao.addOne(person1);
//        Long id = person1.getId();
//
//        Person person2 = personDao.getOneById(id);
//        Assertions.assertEquals(person1, person2, "根据Id获取person失败");
//        personDao.deleteOne(id, true);
//    }
//
//    private Person getPersonDO(String name) {
//        Person person = new Person();
//        person.setName(name);
//        person.setGender(1);
//        Date date = DateUtil.parse(DateUtil.today());
//        person.setCreateTime(date);
//        person.setUpdateTime(date);
//        person.setDeleted(false);
//        return person;
//    }
}