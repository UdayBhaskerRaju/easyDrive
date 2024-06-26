package com.companyname.easyDrive.Dtos.Response;

import com.companyname.easyDrive.Enum.BookingStatus;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {

    String bookingId;

    String pickup;

    String dropping;

    BookingStatus bookingStatus;

    int totalDistance;

    double totalFare;

    Date bookedDate;

   CustomerResponse customer;

   DriverResponse driver;
}
