package com.companyname.easyDrive.Dtos.Response;

import com.companyname.easyDrive.Enum.CabType;
import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {
    String cabNumber;
    CabType type;
    double farePerKm;
    boolean booked;
}
