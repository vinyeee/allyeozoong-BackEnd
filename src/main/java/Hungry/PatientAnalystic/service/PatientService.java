package Hungry.PatientAnalystic.service;

import Hungry.PatientAnalystic.dto.Frequency;
import Hungry.PatientAnalystic.dto.GroupAges;
import Hungry.PatientAnalystic.dto.PatientDto;
import Hungry.PatientAnalystic.entity.Patient;
import Hungry.PatientAnalystic.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;


    public void create(PatientDto dto){

        Patient patient = new Patient();

        int age = (dto.getAge() / 10 ) * 10; // user 실제 나이에서 일의 자리 제거 ex) 23 => 20대로 만들어줌
        patient.setName(dto.getName());
        patient.setSymptom(dto.getSymptom());
        patient.setAge(age);
        patient.setLisk(dto.getLisk());

        patientRepository.save(patient);
    }

    public double getFrequency(String symptom){
        Frequency frequencyDTO = patientRepository.findFrequencyBySymptom(symptom); // 증상 + count
        long count = frequencyDTO.getCount(); // count

        long total = patientRepository.getCount();

        double percentage =   ((double) count / total ) * 100;

        // Math.round를 사용하여 소수점 두 자리까지 반올림
        percentage = (double) Math.round(percentage * 100) / 100;


//        System.out.println(total);
//        System.out.println(count);
//        System.out.println(percentage);
//        String frequency = "";

//        // 개체군 100명이라 가정
//        if(count >= 50) {
//            frequency = "자주 보임";
//        }else if(count >= 30){
//            frequency = "가끔 보임";
//        }else if(count >= 10){
//            frequency = "드물게 보임";
//        }else{
//            frequency = "거의 보이지 않음";
//        }


        return percentage;
    }


    public List<GroupAges> getCountOfAgeGroup(String symptom){

        List<GroupAges> groupAges = patientRepository.findSymptomAges(symptom);

        //Map<Integer, Long> ageStatistics = new HashMap<>();
//        for (GroupAges groupAge : groupAges) {
//            ageStatistics.put(groupAge.getGroup(), groupAge.getCount());
//        }

        return groupAges;
    }

    public List<PatientDto> findAllByName(String name){
        return patientRepository.findAllByName(name).stream().map(PatientDto::fromEntity).collect(Collectors.toList());
    }


}
