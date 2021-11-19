package com.example.demo1811.service;

import com.example.demo1811.entity.UserTest;
//import com.example.demo1811.filter.SortingUtils;
import com.example.demo1811.filter.UserFilter;
import com.example.demo1811.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class ServiceImpl implements ServiceUser {

    private final UserFilter userFilter;

    private final UserRepository userRepository;

    public ServiceImpl(UserFilter userFilter, UserRepository repository) {
        this.userFilter = userFilter;
        this.userRepository = repository;
    }

    @Override
    public Page<UserTest> getAllUsers(Integer page, Integer limit, String sort) {
        Map<String, String> map = new HashMap();
        map.put("id", "desc");
        return userRepository.findAll(userFilter.filter(0, map), PageRequest.of(page - 1, limit));
    }

    @Override
    public Boolean addUser(String name, String password, Integer age, String sex, String address) {
        UserTest tmp = userRepository.findUserByUserName(name);
        if (tmp == null) {
            tmp = new UserTest();
            tmp.setUserName(name);
            tmp.setPassword(password);
            tmp.setAge(age);
            tmp.setSex(sex);
            tmp.setAddress(address);
            tmp.setIsDeleted(false);
            userRepository.save(tmp);
            return true;
        }
        return false;
    }

    @Override
    public Boolean changeUserInfo(String name, String password, Integer age, String sex, String address) {
        UserTest tmp = userRepository.findUserByUserName(name);
        if (tmp != null) {
            tmp.setUserName(name);
            tmp.setPassword(password);
            tmp.setAge(age);
            tmp.setSex(sex);
            tmp.setAddress(address);
            userRepository.save(tmp);
            return true;
        }
        return false;
    }

    @Override
    public UserTest getUserByName(String name) {
        return userRepository.findUserByUserName(name);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        Optional<UserTest> tmp = userRepository.findById(id);
        if (tmp.isPresent()) {
            UserTest tmp2 = tmp.get();
            tmp2.setIsDeleted(true);
            userRepository.save(tmp2);
            return true;
        }
        return false;
    }
}
