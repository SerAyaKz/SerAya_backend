package kz.com.SerAya.Service;

import kz.com.SerAya.DTO.TeacherDto;

import java.util.List;

public interface TeacherService extends AbstractService<TeacherDto> {
    List<TeacherDto> findBySchoolId(int id);
    List<TeacherDto> findByUser(int id);

}
