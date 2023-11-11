package Hungry.PatientAnalystic.repository;

import Hungry.PatientAnalystic.dto.Frequency;
import Hungry.PatientAnalystic.dto.GroupAges;
import Hungry.PatientAnalystic.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    // 해당 증상의 빈도수를 가져옴
    @Query("SELECT new Hungry.PatientAnalystic.dto.Frequency(p.symptom, COUNT(p)) FROM Patient p " +
            "WHERE p.symptom = :symptom " +
            "GROUP BY p.symptom")
    public Frequency findFrequencyBySymptom (@Param("symptom") String symptom);

    public List<Patient> findAllByName(String name);

    // 해당 증상의 나이대별 발병자 count 수를 가져옴
    @Query("SELECT new Hungry.PatientAnalystic.dto.GroupAges(p.age, COUNT(p)) FROM Patient p " +
            "WHERE p.symptom = :symptom "+
            "GROUP BY p.age")
    public List<GroupAges> findSymptomAges(@Param("symptom") String symptom);

    @Query("SELECT COUNT(p) FROM Patient p")
    public Long getCount();
}
