package com.fuad.proposalManagement.proposal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuad.proposalManagement.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
    private String image;
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

    @ColumnDefault("false")
    private Boolean status = false;
}
