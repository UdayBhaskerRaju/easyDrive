package com.companyname.easyDrive.model;

import com.companyname.easyDrive.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor//creates default constructor
@AllArgsConstructor//creates constructor with args
@Getter//creates getters
@Setter//creates setters
@Entity//mapping this class to DB table
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)//This annotation will make attributes as private which are not having accessSpecifiers
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    @Column(unique = true,nullable = false)
    String bookingId;//UUID

    String pickup;

    String dropping;

    @Enumerated(EnumType.STRING)
    BookingStatus bookingStatus;

    int totalDistance;

    double totalFare;

    @CreationTimestamp
     Date bookedDate;

     String mailAttachment;

    //Many bookings can be done by one customer
    //Many side holds foreign key column
    @ManyToOne
    @JoinColumn
    Customer customer;

    //Many bookings assign for One driver
    // //Many side holds foreign key column
    @ManyToOne
    @JoinColumn
    Driver driver;
}
