package com.fuad.proposalManagement.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuad.proposalManagement.proposal.Proposal;
import com.fuad.proposalManagement.role.Role;
import com.fuad.proposalManagement.user_info.UserInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    private String phoneNumber;

    @JsonIgnore
    @NotNull(message = "Password is required")
    private String password;

    @Column(unique = true)
    @NotNull(message = "Username is required")
    private String username;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    private boolean verified;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserInfo userInfo;

}
