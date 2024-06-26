package com.companyname.easyDrive.service;

import com.companyname.easyDrive.model.Coupon;
import com.companyname.easyDrive.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // This annotation will create constructor for final variables
public class CouponService {

    private final CouponRepository couponRepository;
    public String addCoupon(String couponCode, int discount) {
     Coupon coupon = Coupon.builder()
             .cuponCode(couponCode)
             .discount(discount)
             .build();
       couponRepository.save(coupon);
      return "Coupon added successfully";
    }
}
