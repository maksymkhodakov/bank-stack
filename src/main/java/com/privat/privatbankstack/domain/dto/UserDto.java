package com.privat.privatbankstack.domain.dto;

import com.privat.privatbankstack.domain.IUser;
import lombok.Data;
import lombok.ToString;

@Data
public class UserDto implements IUser {
    private String username;
    @ToString.Exclude
    private String password;
    private String firstName;
    private String lastName;
    private String serialNumber;
    private String address;
    private String phone;
}
