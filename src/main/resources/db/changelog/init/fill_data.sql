INSERT INTO disease  (name)
VALUES
('Грипп'),
('Перелом руки'),
('Перелом ноги'),
('Гайморит');

INSERT INTO speciality  (name)
VALUES
('Терапевт'),
('Хирург'),
('ЛОР');

INSERT INTO patient  (name, disease_id, age)
VALUES
('Иван', 2, 25),
('Николай', 4, 57),
('Зоя', 1, 20),
('Никита', 3, 41);

INSERT INTO doctor  (name, speciality_id, schedule)
VALUES
('Иванов И. И.', 1, 'Пн-Пт - 8:00-16:00'),
('Петров П. П.', 2, 'Вт, Чт - 10:00-16:00'),
('Сидоров С. С.', 3, 'Пн, Ср, Пт - 10:00-14:00');

INSERT INTO doctor_patient  (doctor_id, patient_id)
VALUES
(1, 3),
(2, 1),
(2, 4),
(3, 2);

