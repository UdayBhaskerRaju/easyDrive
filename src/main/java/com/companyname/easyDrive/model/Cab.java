package com.companyname.easyDrive.model;

import com.companyname.easyDrive.Enum.CabType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//This annotation will make attributes as private which are not having accessSpecifiers
    int id;

    @Column(unique = true,nullable = false)
    String cabNumber;

    @Column(unique = true,nullable = false)
    CabType type;

    double farePerKm;

    boolean booked;

    //One cab belong to one driver
    //Cab is the dependent table so make foreign key in cab
    @OneToOne
    @JoinColumn
    @JsonIgnore
    Driver driver;
}
