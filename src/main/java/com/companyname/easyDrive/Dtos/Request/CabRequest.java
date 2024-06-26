package com.companyname.easyDrive.Dtos.Request;

import com.companyname.easyDrive.Enum.CabType;
import com.companyname.easyDrive.model.Driver;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CabRequest {

    String cabNumber;
    CabType type;
    double farePerKm;
    boolean booked;
    Driver driver;
}
