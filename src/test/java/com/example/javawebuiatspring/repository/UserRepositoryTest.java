package com.example.javawebuiatspring.repository;

import com.example.javawebuiatspring.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads(){

        List<User> users = prepareTestData();
        List<User> savedUsers = userRepository.saveAll(users);

        User george = userRepository.getOne(5L);
        Assertions.assertEquals("Георгий", george.getName());

        List<User> allByAgeBetween20and25 = userRepository.findAllByAgeBetween(20, 25);
        Assertions.assertEquals(6, allByAgeBetween20and25.size());
    }

    private List<User> prepareTestData() {
        ArrayList<User> usersList = new ArrayList<>();
        usersList.add(new User(null, "Антон", 18,"anton@mail.ru"));
        usersList.add(new User(null, "Алекс", 19, "alex@mail.ru"));
        usersList.add(new User(null, "Борис", 20,"boris@mail.ru"));
        usersList.add(new User(null, "Влад", 21,"vlad@mail.ru"));
        usersList.add(new User(null, "Георгий", 22,"george@mail.ru"));
        usersList.add(new User(null, "Данил", 23,"dan@mail.ru"));
        usersList.add(new User(null, "Егор", 24,"egor@mail.ru"));
        usersList.add(new User(null, "Женя", 25,"john@mail.ru"));
        usersList.add(new User(null, "Захар", 26,"zakaria@mail.ru"));
        usersList.add(new User(null, "Илья", 27,"ilya@mail.ru"));
        return usersList;
    }
}