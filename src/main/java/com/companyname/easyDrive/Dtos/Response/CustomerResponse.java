package com.companyname.easyDrive.Dtos.Response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {
    private String name;

    private String emailId;
}
