package com.companyname.easyDrive.Dtos.Request;

import com.companyname.easyDrive.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    private String name;

    private int age;

    private String emailId;

    private Gender gender;
}
