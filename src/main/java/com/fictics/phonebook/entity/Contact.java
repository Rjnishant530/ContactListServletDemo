package com.fictics.phonebook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class Contact {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String avatar;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private Date createdAt;
}
