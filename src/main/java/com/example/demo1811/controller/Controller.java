package com.example.demo1811.controller;


import com.example.demo1811.service.ServiceUser;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final ServiceUser services;

    public Controller(ServiceUser services) {
        this.services = services;
    }

    @GetMapping("/getAllUsers")
    public Object getAllUsers(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(value = "limit", required = false, defaultValue = "3") Integer limit,
                              @RequestParam(value = "sort", required = false, defaultValue = "") String sort) {
        return services.getAllUsers(page, limit, sort);
    }

    @GetMapping("/getUserByName")
    public Object getUserByName(@RequestParam(value = "name") String name) {
        return services.getUserByName(name);
    }

    @PostMapping("/addUser")
    public Boolean addUser(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "age") Integer age,
            @RequestParam(value = "sex") String sex,
            @RequestParam(value = "address") String address) {
        return services.addUser(name, password, age, sex, address);
    }

    @PostMapping("/changeUserInfo")
    public Boolean changeUserInfo(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "age") Integer age,
            @RequestParam(value = "sex") String sex,
            @RequestParam(value = "address") String address) {
        return services.changeUserInfo(name, password, age, sex, address);
    }

    @PostMapping("/deleteUser")
    public Boolean deleteUser(@RequestParam(value = "id") Integer id) {
        return services.deleteUser(id);
    }


}
