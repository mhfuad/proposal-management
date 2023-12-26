package com.fuad.proposalManagement.user_info;

import com.fuad.proposalManagement.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponse {
    private Long id;
    private User user;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String address;
    private String image;

}
