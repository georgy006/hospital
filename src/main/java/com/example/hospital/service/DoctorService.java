package com.example.hospital.service;

import com.example.hospital.persistance.domain.Doctor;
import com.example.hospital.transport.request.CreateDoctorRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();
    List<Doctor> getDoctorsByIds(List<Long> ids);
    Doctor getDoctorById(Long id);

    void deleteDoctorById(Long id);

    Doctor createDoctor(CreateDoctorRequest request);

}
