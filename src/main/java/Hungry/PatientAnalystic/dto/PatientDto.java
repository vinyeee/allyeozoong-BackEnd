package Hungry.PatientAnalystic.dto;

import Hungry.PatientAnalystic.domain.Patient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDto {

    private String name; // 이름

    private int age; // 나이

    private String symptom; // 증상

    private int lisk; // 위험도

    public PatientDto(String name, int age, String symptom, int lisk) {
        this.name = name;
        this.age = age;
        this.symptom = symptom;
        this.lisk = lisk;
    }

    public PatientDto() {
    }

    public PatientDto(String name, int age, String symptom) {
        this.name = name;
        this.age = age;
        this.symptom = symptom;
    }

    public static PatientDto fromEntity(Patient patient){
        return new PatientDto(patient.getName(), patient.getAge(), patient.getSymptom(), patient.getLisk());
    }

}
