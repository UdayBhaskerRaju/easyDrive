package com.companyname.easyDrive.converters;

import com.companyname.easyDrive.Dtos.Request.DriverRequest;
import com.companyname.easyDrive.Dtos.Response.DriverResponse;
import com.companyname.easyDrive.model.Driver;

public class DriverTransformer {

    public static Driver driverRequestToDriver(DriverRequest driverRequest){
       return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .mobileNumber(driverRequest.getMobileNumber())
                .drvingLicenceNumber(driverRequest.getDrvingLicenceNumber())
                .build();
    }
    public static DriverResponse driverResponseToDriver(Driver driver){
      return DriverResponse.builder()
                .name(driver.getName())
                .age(driver.getAge())
                .mobileNumber(driver.getMobileNumber())
                .drvingLicenceNumber(driver.getDrvingLicenceNumber())
                .cab(CabTransformer.cabToCabResponse(driver.getCab()))
                .build();
    }
}
