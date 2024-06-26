package com.companyname.easyDrive.Dtos.Request;

import com.companyname.easyDrive.Enum.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingRequest {
    String bookingId;
    String pickup;
    String dropping;
    BookingStatus bookingStatus;
    int totalDistance;
    double totalFare;
    String mailAttachment;
    String emailId;
}
