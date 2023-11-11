package Hungry.PatientAnalystic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Frequency {

    private String symptom;
    private Long count;


    public Frequency() {
    }

    public Frequency(String symptom, Long count) {
        this.symptom = symptom;
        this.count = count;
    }
}
