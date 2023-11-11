package Hungry.PatientAnalystic.service;

import Hungry.PatientAnalystic.dto.Frequency;
import Hungry.PatientAnalystic.dto.GroupAges;
import Hungry.PatientAnalystic.dto.PatientDto;
import Hungry.PatientAnalystic.domain.Patient;
import Hungry.PatientAnalystic.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;


    @Transactional
    public void create(Patient patient){
        patientRepository.save(patient);
    }

    @Transactional
    public double getFrequency(String symptom){
        Frequency frequencyDTO = patientRepository.findFrequencyBySymptom(symptom); // 증상 + count
        long count = frequencyDTO.getCount(); // count
        long total = patientRepository.getCount();
        double percentage =   ((double) count / total ) * 100;
        percentage = (double) Math.round(percentage * 100) / 100;
        return percentage;
    }


    @Transactional
    public List<GroupAges> getCountOfAgeGroup(String symptom){

        List<GroupAges> groupAges = patientRepository.findSymptomAges(symptom);
        return groupAges;
    }

    public List<PatientDto> findAllByName(String name){
        return patientRepository.findAllByName(name).stream().map(PatientDto::from).collect(Collectors.toList());
    }


}
