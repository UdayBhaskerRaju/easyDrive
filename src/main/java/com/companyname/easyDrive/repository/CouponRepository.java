package com.companyname.easyDrive.repository;

import com.companyname.easyDrive.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {
}
