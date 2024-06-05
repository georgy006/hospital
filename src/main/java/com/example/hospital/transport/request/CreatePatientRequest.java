package com.example.hospital.transport.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientRequest {

    private String name;
    private Long diseaseId;
    private Integer age;
    private Long doctorId;
}
