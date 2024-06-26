package com.companyname.easyDrive.model;

import com.companyname.easyDrive.Enum.Gender;
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
@FieldDefaults(level = AccessLevel.PRIVATE)//This annotation will make attributes as private which are not having accessSpecifiers
@Builder
@Table(name = "customerDb")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Column(unique = true,nullable = false)
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    //One customer can do many bookings
    //Cardinality relation and bidirectional mapping
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)//Mapped to customer entity
    List<Booking> bookings = new ArrayList<>();
}
