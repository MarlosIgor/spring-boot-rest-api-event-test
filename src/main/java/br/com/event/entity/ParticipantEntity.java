package br.com.event.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@Table(name = "Participant")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ParticipantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Invalid name")
    private String name;

    @CPF(message = "Invalid CPF")
    private String cpf;

    @Email
    private String email;

    @NotEmpty(message = "Invalid address")
    private String address;

    @NotEmpty(message = "Invalid neighborhood")
    private String neighborhood;

    @NotEmpty(message = "Invalid postal code")
    @Column(name = "postal_code")
    private String postalCode;

    @NotEmpty(message = "Invalid phone number")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotEmpty(message = "Invalid WhatsApp")
    private String whatsapp;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventEntity eventEntity;

}
