package com.template.bit235.service;

import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    public boolean validateUser(String username, String password) {
        return "admin".equals(username) && "123".equals(password);
    }
}