package com.companyname.easyDrive.controller;

import com.companyname.easyDrive.Dtos.Request.DriverRequest;
import com.companyname.easyDrive.Dtos.Response.DriverResponse;
import com.companyname.easyDrive.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
@RequiredArgsConstructor // This annotation will create constructor for final variables
public class DriverController {

    // Injecting Bean this way is good practice
    private final DriverService driverService;
    @PostMapping
    public ResponseEntity addDriverAndCab(@RequestBody DriverRequest driverRequest){
        String response = driverService.addDriverAndCab(driverRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping("/mobile/{mobile}")
    public DriverResponse getDriver(@PathVariable("mobile") long mobileNumber){
        return driverService.getDriver(mobileNumber);
    }

    //get all the drivers above a particular age

    //get the driver with maximum number of bookings

    //update the driver license
    //update the driver phoneNumber

    //delete the driver -> mobileNumber

    //driver with least number of bookings

    //get all the drivers who have less then 10 bookings
}
