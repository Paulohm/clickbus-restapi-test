package com.clickbus.restapi.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Place")
@Table(name="place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="slug",unique = true)
    private String slug;
    @Column(name="address")
    private String address;
    @Column(name="created_at",columnDefinition = "DATETIME")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name="updated_at",columnDefinition = "DATETIME")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @EqualsAndHashCode.Exclude private City city;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "place")
    @Builder.Default
    @JsonIgnore
    private Set<PlaceClientApplication> placeClientApplications = new HashSet<>();


}
