package com.companyname.easyDrive.service;

import com.companyname.easyDrive.Dtos.Request.DriverRequest;
import com.companyname.easyDrive.Dtos.Response.DriverResponse;
import com.companyname.easyDrive.converters.CabTransformer;
import com.companyname.easyDrive.converters.DriverTransformer;
import com.companyname.easyDrive.model.Cab;
import com.companyname.easyDrive.model.Driver;
import com.companyname.easyDrive.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // This annotation will create constructor for final variables
public class DriverService {
    private final DriverRepository driverRepository;
    public String addDriverAndCab(DriverRequest driverRequest) {

        //Entity to Dto
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        Cab cab = CabTransformer.cabRequestToCab(driverRequest.getCab());
        cab.isBooked();

        driver.setCab(cab);
        cab.setDriver(driver);

        driverRepository.save(driver);
        return "Driver added succesfully";
    }
    public DriverResponse getDriver(long mobileNumber) {
        Driver savedDriver = driverRepository.findByMobileNumber(mobileNumber);
        // convert driver Entity to responseDto
         return DriverTransformer.driverResponseToDriver(savedDriver);
    }
}
