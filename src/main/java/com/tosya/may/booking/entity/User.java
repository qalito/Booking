package com.tosya.may.booking.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
@Entity
@Getter
@Setter
public class User implements UserDetails {
    @Id
    private int id;
    private String login;
    private String name;
    private String password;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private Gender gender;
    private LocalDateTime regDate;
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
    @OneToOne(mappedBy = "user")
    private Partner partner;
    @OneToMany(mappedBy = "user")
    private Set<Basket> baskets;
    @OneToMany(mappedBy = "user")
    private Set<Booking> bookings;
    @Transient
    private String passwordConfirm;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection<? extends GrantedAuthority>) getRole();
    }

    @Override
    public String getUsername() {
        return this.getLogin();
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
    public enum Gender {
        MALE, FEMALE
    }
}
