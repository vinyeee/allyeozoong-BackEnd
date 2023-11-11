package Hungry.PatientAnalystic.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id", nullable = false)
    private Long id;

    private String name; // 이름

    private int age; // 나이

    private String symptom; // 증상

    private int lisk;
}
