package com.privat.privatbankstack.domain.entities;

import com.privat.privatbankstack.domain.IUser;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@ToString
@Document(collection = "user")
public class User implements Serializable, IUser {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String serialNumber;
    private String address;
    private String phone;

    public User(IUser iUser) {
        this.id = UUID.randomUUID().toString();
        this.firstName = iUser.getFirstName();
        this.lastName = iUser.getLastName();
        this.serialNumber = iUser.getSerialNumber();
        this.address = iUser.getAddress();
        this.phone = iUser.getPhone();
    }
}
