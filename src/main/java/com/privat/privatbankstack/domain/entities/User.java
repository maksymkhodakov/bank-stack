package com.privat.privatbankstack.domain.entities;

import com.privat.privatbankstack.domain.IUser;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
@Document(collection = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable, IUser, UserDetails {
    @Serial
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    @Id
    private String id;

    private String username;

    @ToString.Exclude
    private String password;

    private String firstName;

    private String lastName;

    private String serialNumber;

    private String address;

    private String phone;


    public User(IUser iUser) {
        this.id = UUID.randomUUID().toString();
        this.username = iUser.getUsername();
        this.password = iUser.getPassword();
        this.firstName = iUser.getFirstName();
        this.lastName = iUser.getLastName();
        this.serialNumber = iUser.getSerialNumber();
        this.address = iUser.getAddress();
        this.phone = iUser.getPhone();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
