package com.companyname.easyDrive.controller;

import com.companyname.easyDrive.model.Coupon;
import com.companyname.easyDrive.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupons")
@RequiredArgsConstructor // This annotation will create constructor for the final variables
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    public ResponseEntity addCoupon(@RequestParam("code") String couponCode ,@RequestParam("discount") int discount){

        String couponResponse = couponService.addCoupon(couponCode,discount);
        return new ResponseEntity(couponResponse, HttpStatus.CREATED);
    }
}
