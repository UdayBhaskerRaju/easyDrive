package com.companyname.easyDrive.repository;

import com.companyname.easyDrive.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DriverRepository extends JpaRepository<Driver,Integer> {

    public Driver findByMobileNumber(long mobileNumber);
}
