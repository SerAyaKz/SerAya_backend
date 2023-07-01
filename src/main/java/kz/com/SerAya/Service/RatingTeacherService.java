package kz.com.SerAya.Service;

import kz.com.SerAya.DTO.RatingTeacherDto;

import java.util.List;

public interface RatingTeacherService extends AbstractService<RatingTeacherDto> {

    List<RatingTeacherDto> findRatingTeachersByTeacher(int id);
    List<RatingTeacherDto> findRatingTeachersByUser(int id);


}
