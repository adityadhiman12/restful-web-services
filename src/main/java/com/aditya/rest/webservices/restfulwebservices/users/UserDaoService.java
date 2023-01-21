package com.aditya.rest.webservices.restfulwebservices.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users=new ArrayList<>();
    private static int idCount=0;
    static {
        users.add(new User(++idCount, "Aditya", LocalDate.now().minusYears(24)));
        users.add(new User(++idCount, "Abhishek", LocalDate.now().minusYears(26)));
        users.add(new User(++idCount, "Adi", LocalDate.now().minusYears(24)));
    }
    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deletebyId(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

    public User save(User user) {
        user.setId(++idCount);
        users.add(user);
        return user;
    }

}
