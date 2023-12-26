package com.fuad.proposalManagement.mapper;

import com.fuad.proposalManagement.user.CustomUserDetails;
import com.fuad.proposalManagement.role.RoleResponse;
import com.fuad.proposalManagement.user.UserResponse;
import com.fuad.proposalManagement.user.User;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static CustomUserDetails toCustomUserUserDetails(User user){
        CustomUserDetails customUserDetails = new CustomUserDetails();
        BeanUtils.copyProperties(user, customUserDetails);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach( r -> {
            authorities.add(new SimpleGrantedAuthority( r.getName()));

            r.getPermissions().forEach(p -> {
                if (user.isVerified()){
                    authorities.add( new SimpleGrantedAuthority(p.getName()));
                }else if (!p.isRequiresVerification()){
                    authorities.add(new SimpleGrantedAuthority(p.getName()));
                }
            });

        });

        customUserDetails.setAuthorities(authorities);
        return customUserDetails;
    }

    public static UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse, "roles");

        List<RoleResponse> roles = new ArrayList<>();

        user.getRoles().forEach(role -> {
            RoleResponse roleResponse = new RoleResponse();
            BeanUtils.copyProperties(role, roleResponse, "permissions");

            List<String> permissions = new ArrayList<>();
            role.getPermissions().forEach(p -> permissions.add(p.getName()));
            roleResponse.setPermissions(permissions);
            roles.add(roleResponse);
        });

        userResponse.setRoles(roles);
        return userResponse;
    }
}
