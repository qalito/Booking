package com.tosya.may.booking.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class City {
    @Id   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;
    @OneToMany(mappedBy = "city")
    private Set<Address> addresses;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", country=" + country +
                ", addresses=" + addresses +
                '}';
    }

}
