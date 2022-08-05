package com.tosya.may.booking.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;



/*@NamedNativeQuery() Query(name = "Apartment.getApartmentByComfort",
        query = "   SELECT * from  apartment a "  +
        " left join Apartment.apartmentComfort comfort" +
         "  ON a.id = comfort.id "+
         " WHERE a.address.city=:city " +
         "and a.type=:type " +
         "and a.bookings " +
         "not in " +
         "(select b " +
         "from Booking b" +
         " where " +
         "(b.dateStart between :dateSt and :dateTo) " +
         "and " +
         "(b.dateTo between :dateSt and :dateTo))*/
@NamedNativeQueries({@NamedNativeQuery(
        name  = "Apartment.getApartmentByComfort",
        query = "SELECT distinct a.* " +
                "FROM apartment a"+
                " INNER JOIN comfort_apartment c_a"+
                " ON a.id = c_a.apartment_id "+
                " INNER JOIN comfort c"+
                " ON c_a.comfort_id = c.id"+
                " INNER JOIN address ad"+
                " ON a.address_id = ad.id"+
                " WHERE ad.city_id=:city " +
                " and a.type_id=:type " +
                " and a.capacity>=:count " +
                " and c.id in (:comfort)"+
                " and a.id " +
                " not in " +
                "(select ba.apartment_id from booking_apartment ba where ba.booking_id  in "+
                " (select b.id " +
                " from Booking b" +
                " where " +
                " (b.date_Start " +
                " between :dateSt and :dateTo) " +
                " and " +
                " (b.date_To " +
                " between :dateSt and :dateTo)))"
        ,
        resultClass=Apartment.class
),
        @NamedNativeQuery(
                name  = "Apartment.getApartmentWithoutComfortSet",
                query = "SELECT distinct a.* " +
                        "FROM apartment a"+
                        " INNER JOIN address ad"+
                        " ON a.address_id = ad.id"+
                        " WHERE ad.city_id=:city " +
                        " and a.type_id=:type " +
                        " and a.capacity>=:count " +
                        " and a.id " +
                        " not in " +
                        "(select ba.apartment_id from booking_apartment ba where ba.booking_id  in "+
                        " (select b.id " +
                        " from Booking b" +
                        " where " +
                        " (b.date_Start " +
                        " between :dateSt and :dateTo) " +
                        " and " +
                        " (b.date_To " +
                        " between :dateSt and :dateTo))) "+
                        " order by  :order"
                ,
                resultClass=Apartment.class
        )
})

@Entity(name = "Apartment")
@Getter
@Setter
public class Apartment {
    @Id
    private int id;
    private String name;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
    private int capacity;
    private BigDecimal price;
    private double rating;
    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;
    @ManyToOne()
    @JoinColumn(name = "image_id")
    private Image image;
    @ManyToMany
    @JoinTable(
            name = "comfort_apartment",
            joinColumns = @JoinColumn(name = "apartment_id"),
            inverseJoinColumns = @JoinColumn(name = "comfort_id"))
    private Set<Comfort> apartmentComfort;
    @ManyToMany(mappedBy = "basketApartment")
    Set<Basket> baskets;
    @ManyToMany(mappedBy = "bookingApartment")
    Set<Booking> bookings;
}
