package br.com.event.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Event")
@Getter
@Setter
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 1, max = 50, message = "Invalid name")
    private String name;

    @Column(name = "registrants_count")
    private int registrantsCount;

    @OneToMany(mappedBy = "eventEntity")
    private List<ParticipantEntity> participants;

}
