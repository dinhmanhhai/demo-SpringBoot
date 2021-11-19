package com.example.demo1811.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
@Getter
@Setter
public class UserTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    private Integer age;
    private String sex;
    private String address;
    private Boolean isDeleted;

}
