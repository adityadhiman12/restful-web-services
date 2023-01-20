package com.aditya.rest.webservices.restfulwebservices.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users=new ArrayList<>();
    static {
        users.add(new User(1, "Aditya", LocalDate.now().minusYears(24)));
        users.add(new User(2, "Abhishek", LocalDate.now().minusYears(26)));
        users.add(new User(3, "Adi", LocalDate.now().minusYears(24)));
    }
    public List<User> findAll() {
        return users;
    }

}
