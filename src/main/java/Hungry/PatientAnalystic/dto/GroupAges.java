package Hungry.PatientAnalystic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupAges {

    private int id; // 연령층 그룹
    private Long value; // 발병자 수

    public GroupAges() {
    }

    public GroupAges(int group, Long count) {
        this.id = group;
        this.value = count;
    }
}
