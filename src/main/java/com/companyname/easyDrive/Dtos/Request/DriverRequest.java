package com.companyname.easyDrive.Dtos.Request;

import com.companyname.easyDrive.Dtos.Request.CabRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverRequest {

    String name;
    int age;
    String drvingLicenceNumber;
    long mobileNumber;
    CabRequest cab;
}
