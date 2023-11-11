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

    @OneToOne
    @JoinColumn(name = "user_account_user_id")
    UserAccount userAccount;

    private String symptom; // 증상

    private int lisk;

    public Patient(Long id, UserAccount userAccount, String symptom, int lisk) {
        this.id = id;
        this.userAccount = userAccount;
        this.symptom = symptom;
        this.lisk = lisk;
    }

    public Patient() {

    }
}
