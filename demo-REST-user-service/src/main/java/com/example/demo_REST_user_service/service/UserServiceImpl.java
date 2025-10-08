package com.example.demo_REST_user_service.service;

import com.example.demo_REST_user_service.model.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementazione dell'interfaccia di servizio per la gestione utenti
 */
@Service
public class UserServiceImpl implements IUserService {

    // Teniamo la lista degli utenti in memoria
    // dovremo spostarlo nel repository
    private final List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        // rispondo con un clone della lista per impedire side effect
        return new ArrayList<>(users);
    }

    @Override
    public User getUserByEmail(String email) {
//        for (User u : users)
//            if (u.email().equals(email))
//                return u;
//        return null;

        //Equivalente con stream
        return users.stream()
                .filter(user -> user.email().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User createUser(User user) {
        // TODO check se email esiste già
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(String email, User updateUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).email().equals(email)) {
                users.set(i, updateUser);
                return updateUser;
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(String email) {
        return users.removeIf(user -> user.email().equals(email));
    }
}








