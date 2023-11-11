package Hungry.PatientAnalystic.dto;

import Hungry.PatientAnalystic.domain.Patient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDto {

    private String name;

    private String age;

    private String symptom; // 증상

    private int lisk; // 위험도

    public PatientDto(String name, String age, String symptom, int lisk) {
        this.name = name;
        this.age = age;
        this.symptom = symptom;
        this.lisk = lisk;
    }

    public PatientDto(Patient patient) {
        this.name = patient.getUserAccount().getNickname();
        this.age = patient.getUserAccount().getAge();
        this.symptom = patient.getSymptom();
        this.lisk = patient.getLisk();
    }

    public static PatientDto of(String name, String age, String symptom, int lisk) {
        return new PatientDto(name, age, symptom, lisk);
    }

    public static PatientDto of(Patient patient) {
        return new PatientDto(patient);
    }

    public Patient toEntity() {
        return new Patient(null, null, symptom, lisk);
    }

    public static PatientDto from(Patient entity) {
        return new PatientDto(
                entity.getUserAccount().getNickname(),
                entity.getUserAccount().getAge(),
                entity.getSymptom(),
                entity.getLisk()
        );
    }
}
