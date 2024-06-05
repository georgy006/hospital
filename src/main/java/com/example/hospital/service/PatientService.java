package com.example.hospital.service;

import com.example.hospital.persistance.domain.Patient;
import com.example.hospital.transport.request.CreatePatientRequest;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();
    List<Patient> getPatientsByIds(List<Long> ids);
    Patient getPatient(Long id);

    void deletePatient(Long id);

    Patient createPatient(CreatePatientRequest request);
}
