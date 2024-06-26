package com.companyname.easyDrive.controller;

import com.companyname.easyDrive.Dtos.Request.BookingRequest;
import com.companyname.easyDrive.Dtos.Response.BookingResponse;
import com.companyname.easyDrive.model.Cab;
import com.companyname.easyDrive.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor // This annotation will use to create constructor for final variables
public class BookingController {

    //making bean this way will make your task easier when your writing testCases instead of writing @Autowired annotation
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity bookCab(@RequestBody BookingRequest bookingRequest){
        try {
            BookingResponse response = bookingService.bookCab(bookingRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
