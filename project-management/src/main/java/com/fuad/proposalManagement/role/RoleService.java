package com.fuad.proposalManagement.role;

import com.fuad.proposalManagement.user.UserTypeEnum;

public interface RoleService {
    Role getRoleByUserType(UserTypeEnum userType);
}
