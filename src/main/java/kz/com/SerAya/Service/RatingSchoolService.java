package kz.com.SerAya.Service;

import kz.com.SerAya.DTO.RatingSchoolDto;

import java.util.List;

public interface RatingSchoolService extends AbstractService<RatingSchoolDto> {
    List<RatingSchoolDto> findRatingSchoolsBySchool(int id);

}
