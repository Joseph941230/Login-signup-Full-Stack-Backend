package com.example.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity

public class User {


    @Id
    @GeneratedValue
    int id;

    @Column(name = "name")
    String name;

    @Column
    String email;

    @Column
    String phone;

    @Column
    int age;

    @Column
    String address;

    @Column
    String nation;

    @Column
    String passwd;



}
