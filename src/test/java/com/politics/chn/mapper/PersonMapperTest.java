package com.politics.chn.mapper;

import com.politics.chn.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void testInsert() throws Exception {
        Person person = new Person();
        personMapper.insert(person);
    }

    @Test
    public void testQuery() throws Exception {
        List<Person> people = personMapper.getAll();
        System.out.println(people.toString());
    }


    @Test
    public void testUpdate() throws Exception {
    }
}