package com.example.service;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;

@Getter
@Setter
// wrapper for parameters of user interface
public class IdentityParameters {
    String name;


    String email;


    String phone;


    int age;


    String address;

    String nation;

    String passwd;

}
