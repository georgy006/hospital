package com.example.hospital.persistance.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctor")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;
    private String schedule;

    @ManyToMany(mappedBy = "doctors")
    private List<Patient> patients;

}
