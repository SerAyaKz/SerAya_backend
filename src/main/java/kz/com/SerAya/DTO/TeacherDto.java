package kz.com.SerAya.DTO;

import kz.com.SerAya.Entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TeacherDto {

    private Integer id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private DepartmentDto department;
    private SchoolDto school;

    public static TeacherDto fromEntity(Teacher teacher) {
        return TeacherDto.builder()
                .id(teacher.getId())
                .first_name(teacher.getFirst_name())
                .middle_name(teacher.getMiddle_name())
                .last_name(teacher.getLast_name())
                .department(DepartmentDto.fromEntity(teacher.getDepartment()))
                .school(SchoolDto.fromEntity(teacher.getSchool()))
                .build();
    }

    public static Teacher toEntity(TeacherDto teacher) {
        return Teacher.builder()
                .id(teacher.getId())
                .first_name(teacher.getFirst_name())
                .middle_name(teacher.getMiddle_name())
                .last_name(teacher.getLast_name())
                .school(SchoolDto.toEntity(teacher.getSchool()))
                .department(DepartmentDto.toEntity(teacher.getDepartment()))
                .build();
    }

}
