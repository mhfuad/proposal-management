package com.fuad.proposalManagement.user_info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoRequest {

    private Long user_id;
    private String fatherName;
    private String motherName;
    private String address;
    private String image;
}
