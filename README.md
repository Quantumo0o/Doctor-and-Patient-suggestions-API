# Doctor-Patient Registration and Suggestion System 🩺

This project implements backend APIs for a platform where doctors can register patients through a mobile or web portal. The core functionalities include adding doctors with their specialties, adding patients with their symptoms, and suggesting suitable doctors based on patient symptoms. The system aims to facilitate efficient management of doctor-patient data and enhance the user experience by quickly connecting patients with relevant medical professionals. 

## Task Details

### Doctor's Entity

In our database, we store the following details for each doctor:

- **Name**: Name of the doctor.
- **City**: City where the doctor practices. Allowed values: Delhi, Noida, Faridabad.
- **Email**: Email address of the doctor.
- **Phone Number**: Contact number of the doctor.
- **Speciality**: Area of specialization of the doctor. Allowed values: Orthopedic, Gynecology, Dermatology, ENT specialist.

### Patient's Entity

In our database, we store the following details for each patient:

- **Name**: Name of the patient.
- **City**: City where the patient resides. Any value is allowed.
- **Email**: Email address of the patient.
- **Phone Number**: Contact number of the patient.
- **Symptom**: Symptom(s) reported by the patient. Allowed values: Arthritis, Back Pain, Tissue injuries (Orthopedic), Dysmenorrhea (Gynecology), Skin infection, Skin burn (Dermatology), Ear pain (ENT specialist).

### Validations

The following fields have the mentioned validations at the backend:

- **Name**: Should be at least 3 characters.
- **City**: Should be at max 20 characters.
- **Email**: Should be a valid email address.
- **Phone number**: Should contain at least 10 digits.

### Suggesting Doctors

There will be an API that accepts a patient ID and suggests doctors based on the patient's location and symptom. 

- **Logic**: The suggested doctors will be based on the patient's symptom that links to the doctor's specialty.
- **Edge Cases**:
 - If there are no doctors available at the patient's location (outside Delhi, Noida, Faridabad), the response should indicate "We are still waiting to expand to your location".
 - If there are no doctors available for the patient's symptom at that location, the response should indicate "There isn’t any doctor present at your location for your symptom".

## How to Achieve this Task?

- **Framework**: Use Spring Boot for core functionalities. [![Spring Boot Version](https://img.shields.io/badge/Spring%20Boot-3.0.0-green)](https://spring.io/projects/spring-boot)
- **Database Operations**: Use Hibernate for carrying out database operations. [![Hibernate ORM](https://img.shields.io/badge/Hibernate%20ORM-5.6.0-blue)](https://hibernate.org/)
- **API Documentation**: Use Swagger to list all your APIs (optional but recommended for better integration and understanding).

## Project Structure

```
.
├── .mvn
│ └── wrapper
│  ├── maven-wrapper.jar
│  └── maven-wrapper.properties
├── src
│ └── main
│  ├── java
│  │ └── com
│  │  └── hospital
│  │   └── hospital
│  │    ├── Application.java
│  │    ├── Doctor.java
│  │    ├── DoctorController.java
│  │    ├── DoctorRepository.java
│  │    ├── DoctorService.java
│  │    ├── GlobalExceptionHandler.java
│  │    ├── Patient.java
│  │    ├── PatientController.java
│  │    ├── PatientRepository.java
│  │    ├── PatientService.java
│  │    ├── ResourceNotFoundException.java
│  │    ├── Speciality.java
│  │    ├── SuggestedDoctorController.java
│  │    ├── Symptom.java
│  │    └── sdsdsdsd.java
│  └── resources
│   └── application.properties
├── .gitignore
├── duplicate
├── mvn
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Setup

1. **Clone the Repository**:

 ```bash
 git clone https://github.com/Quantumo0o/hospital.git
 ```

2. **Navigate to the Project Directory**:

 ```bash
 cd hospital
 ```

3. **Build the Project**:

 ```bash
 mvn clean install
 ```

4. **Run the Project**:

 ```bash
 java -jar target/hospital.jar
 ```

## API Endpoints

### Doctor Controller

- **Get Doctor by ID**: `GET /doctors/{id}`
- **Update Doctor**: `PUT /doctors/{id}`
- **Delete Doctor**: `DELETE /doctors/{id}`
- **Get All Doctors**: `GET /doctors`
- **Add Doctor**: `POST /doctors`

### Patient Controller

- **Get Patient by ID**: `GET /patients/{id}`
- **Update Patient**: `PUT /patients/{id}`
- **Delete Patient**: `DELETE /patients/{id}`
- **Get All Patients**: `GET /patients`
- **Add Patient**: `POST /patients`

### Suggested Doctor Controller

- **Suggest Doctors**: `GET /suggested-doctors/suggest`

## Schemas

**Table 1: Patient Schema**

| Field         | Data Type | Description                                 |
|----------------|-----------|----------------------------------------------|
| id             | integer   | Unique identifier for the patient             |
| name           | string    | Name of the patient                          |
| city           | string    | City where the patient resides               |
| email          | string    | Email address of the patient                 |
| phoneNumber   | string    | Contact number of the patient                 |
| symptom        | string    | (Patient only) Reported symptom(s)            |

**Table 2: Doctor Schema**

| Field         | Data Type | Description                                 |
|----------------|-----------|----------------------------------------------|
| id             | integer   | Unique identifier for the doctor             |
| name           | string    | Name of the doctor                          |
| city           | string    | City where the doctor practices              |
| email          | string    | Email address of the doctor                 |
| phoneNumber   | string    | Contact number of the doctor                 |
| speciality     | string    | (Doctor only) Area of specialization        |

## Validations

- **Name**: Should be at least 3 characters.
- **City**: Should be at most 20 characters.
- **Email**: Should be a valid email address.
- **Phone number**: Should contain at least 10 digits.

## Suggestion Logic

- The suggestion API recommends doctors based on the patient's symptom and location.
- In case no doctors are available in the patient's location, the response indicates the need for expansion.
- If no doctors are available for the patient's symptom in their location, the response indicates the absence of suitable doctors.

## Additional Features

- **Swagger Documentation**: Optional but recommended for documenting API endpoints and facilitating integration.

## Contributors

- [Quantumo0o](https://github.com/Quantumo0o) [![GitHub followers](https://img.shields.io/github/followers/Quantumo0o?style=social)](https://github.com/Quantumo0o)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details. 





