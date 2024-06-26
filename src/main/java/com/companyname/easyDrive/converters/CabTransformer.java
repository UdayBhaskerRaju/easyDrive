package com.companyname.easyDrive.converters;

import com.companyname.easyDrive.Dtos.Request.CabRequest;
import com.companyname.easyDrive.Dtos.Response.CabResponse;
import com.companyname.easyDrive.model.Cab;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest){
      return  Cab.builder()
              .cabNumber(cabRequest.getCabNumber())
              .type(cabRequest.getType())
              .farePerKm(cabRequest.getFarePerKm())
              .booked(false)
              .build();
    }

    public static CabResponse cabToCabResponse(Cab cab){
       return CabResponse.builder()
                .cabNumber(cab.getCabNumber())
                .type(cab.getType())
                .farePerKm(cab.getFarePerKm())
                .booked(cab.isBooked())
                .build();
    }

}
