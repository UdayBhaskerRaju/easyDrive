package com.companyname.easyDrive.Dtos.Response;

import com.companyname.easyDrive.Dtos.Response.CabResponse;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DriverResponse {
    String name;
    int age;
    String drvingLicenceNumber;
    long mobileNumber;
    CabResponse cab;
}
