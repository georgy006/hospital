CREATE TABLE doctor
(
    id bigserial CONSTRAINT doctor_PK PRIMARY KEY,
    name varchar(256) NOT NULL,
    speciality_id bigserial NOT NULL,
    schedule varchar(256) NOT NULL
);

CREATE TABLE patient
(
    id bigserial	 CONSTRAINT patient_PK PRIMARY KEY,
    name varchar(256) NOT NULL,
    disease_id bigserial NOT NULL,
    age integer NOT NULL
);

CREATE TABLE doctor_patient
(
    doctor_id bigserial	 NOT NULL,
    patient_id bigserial	 NOT NULL,
    PRIMARY KEY(doctor_id, patient_id)
);

CREATE TABLE disease
(
    id bigserial	 CONSTRAINT disease_PK PRIMARY KEY,
    name varchar(256) NOT NULL
);

CREATE TABLE speciality
(
    id bigserial	 CONSTRAINT speciality_PK PRIMARY KEY,
    name varchar(256) NOT NULL
);