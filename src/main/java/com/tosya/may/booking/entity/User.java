package com.tosya.may.booking.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter

public class User implements UserDetails {
    @Id
    private String username;
    private String password;
    private static final long serialVersionUID = 1L;
    @Column(name = "account_non_locked")
    private boolean accountNonLocked;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private Gender gender;
    private LocalDateTime regDate;
    @OneToOne(mappedBy = "user")
    private Partner partner;
    @OneToMany(mappedBy = "user")
    private Set<Basket> baskets;
    @OneToMany(mappedBy = "user")
    private Set<Booking> bookings;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "user_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")})
    private Set<Role> roles;
    @Transient
    private String passwordConfirm;

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
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
