package com.example.demo1811.service;

import com.example.demo1811.entity.UserTest;
import org.springframework.data.domain.Page;

public interface ServiceUser {
    Page<UserTest> getAllUsers(Integer page, Integer limit, String sort);

    Boolean addUser(String name, String password, Integer age, String sex, String address);

    Boolean changeUserInfo(String name, String password, Integer age, String sex, String address);

    UserTest getUserByName(String name);

    Boolean deleteUser(Integer id);
}
