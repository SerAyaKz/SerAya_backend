package kz.com.SerAya.DTO;

import kz.com.SerAya.Entity.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DepartmentDto {

    private Integer id;
    private String department_name;


    public static DepartmentDto fromEntity(Department department) {
        return DepartmentDto.builder()
                .id(department.getId())
                .department_name(department.getDepartment_name())
                .build();
    }

    public static Department toEntity(DepartmentDto departmentDto) {
        return Department.builder()
                .id(departmentDto.getId())
                .department_name(departmentDto.getDepartment_name())
                .build();
    }
}
