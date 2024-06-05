package com.example.hospital.persistance.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    @ManyToMany
    @JoinTable(
            name = "doctor_patient",
            joinColumns = { @JoinColumn(name = "patient_id") },
            inverseJoinColumns = { @JoinColumn(name = "doctor_id") }
    )
    @JsonIgnore
    private List<Doctor> doctors;
}
