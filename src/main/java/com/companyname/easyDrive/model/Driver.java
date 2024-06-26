package com.companyname.easyDrive.model;

import com.companyname.easyDrive.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)//This annotation will make attributes as private which are not having accessSpecifiers
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "driverName")
    String name;
    int age;
    @Column(unique = true,nullable = false)
    String drvingLicenceNumber;

    @Column(unique = true,nullable = false)
    long mobileNumber;

    //Adding cardinality relationship and bidirectional mapping(contains variables both sides)
    //One driver can belong to one cab
    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)//mapping to the driver entity
    Cab cab;

    //One driver can have many bookings
    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Booking> bookings = new ArrayList<>();
}
