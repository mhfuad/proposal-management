package com.fuad.proposalManagement.proposal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuad.proposalManagement.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image_name;
    @Lob
    @Column(length = 512)
    private String description;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    @JsonIgnore
    private User user;

    private Enum<Status> status;
}
