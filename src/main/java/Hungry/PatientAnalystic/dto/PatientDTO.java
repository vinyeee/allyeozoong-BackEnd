package Hungry.PatientAnalystic.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PatientDTO {

    private String name; // 이름

    private int age; // 나이

    private String symptom; // 증상

    private int lisk; // 위험도

    public PatientDTO(String name, int age, String symptom, int lisk) {
        this.name = name;
        this.age = age;
        this.symptom = symptom;
        this.lisk = lisk;
    }

    public PatientDTO() {
    }

    public PatientDTO(String name, int age, String symptom) {
        this.name = name;
        this.age = age;
        this.symptom = symptom;
    }
}
