package com.companyname.easyDrive.repository;

import com.companyname.easyDrive.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
