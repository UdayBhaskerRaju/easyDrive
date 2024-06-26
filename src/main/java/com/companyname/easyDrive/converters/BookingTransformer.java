package com.companyname.easyDrive.converters;

import com.companyname.easyDrive.Dtos.Request.BookingRequest;
import com.companyname.easyDrive.Dtos.Response.BookingResponse;
import com.companyname.easyDrive.Enum.BookingStatus;
import com.companyname.easyDrive.model.Booking;
import com.companyname.easyDrive.model.Cab;

import java.util.UUID;

public class BookingTransformer {

    public static Booking BookingRequestToBooking(BookingRequest bookingRequest, Cab cab){
       return Booking.builder()
                .bookingId(String.valueOf(UUID.randomUUID()))
                .pickup(bookingRequest.getPickup())
                .dropping(bookingRequest.getDropping())
                .bookingStatus(BookingStatus.CONFIRMED)
                .totalDistance(bookingRequest.getTotalDistance())
                .totalFare(bookingRequest.getTotalDistance()*cab.getFarePerKm())
                .build();
    }

    public static BookingResponse bookingToBookingResponse(Booking booking){
      return  BookingResponse.builder()
                .bookingId(booking.getBookingId())
                .bookingStatus(booking.getBookingStatus())
                .pickup(booking.getPickup())
                .dropping(booking.getDropping())
                .totalDistance(booking.getTotalDistance())
                .totalFare(booking.getTotalFare())
                .bookedDate(booking.getBookedDate())
                .customer(CustomerTransformer.customerToCustomerResponse(booking.getCustomer()))
                .driver(DriverTransformer.driverResponseToDriver(booking.getDriver()))
                .build();
    }
}
