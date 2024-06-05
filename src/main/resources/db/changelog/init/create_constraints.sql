ALTER TABLE patient
    ADD CONSTRAINT disease_id_FK FOREIGN KEY (disease_id)
        REFERENCES disease (id);

ALTER TABLE doctor_patient
    ADD CONSTRAINT doctor_id_FK FOREIGN KEY (doctor_id)
        REFERENCES doctor (id);

ALTER TABLE doctor_patient
    ADD CONSTRAINT patient_id_FK FOREIGN KEY (patient_id)
        REFERENCES patient (id);

ALTER TABLE doctor
    ADD CONSTRAINT speciality_id_FK FOREIGN KEY (speciality_id)
        REFERENCES speciality (id);