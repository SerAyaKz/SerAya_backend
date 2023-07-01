package kz.com.SerAya.Service.impl;

import kz.com.SerAya.DTO.RatingSchoolDto;
import kz.com.SerAya.Entity.RatingSchool;
import kz.com.SerAya.Repository.RatingSchoolRepository;
import kz.com.SerAya.Repository.SchoolRepository;
import kz.com.SerAya.Service.RatingSchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingSchoolServiceImpl implements RatingSchoolService {

    private final RatingSchoolRepository repository;

    @Override
    public Integer save(RatingSchoolDto dto) {
        RatingSchool school = RatingSchoolDto.toEntity(dto);
        return repository.save(school).getId();
    }

    @Override
    public List<RatingSchoolDto> findAll() {
        return repository.findAll()
                .stream()
                .map(RatingSchoolDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public RatingSchoolDto findById(Integer id) {
        return repository.findById(id)
                .map(RatingSchoolDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No school found with the ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        // todo check delete
        repository.deleteById(id);
    }




    @Override
    public List<RatingSchoolDto> findRatingSchoolsBySchool(int id) {

        return repository.findRatingSchoolsBySchool(id)
                .stream()
                .map(RatingSchoolDto::fromEntity)
                .collect(Collectors.toList());
    }
}
