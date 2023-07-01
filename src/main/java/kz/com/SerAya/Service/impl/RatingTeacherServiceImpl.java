package kz.com.SerAya.Service.impl;

import kz.com.SerAya.DTO.RatingTeacherDto;
import kz.com.SerAya.Entity.RatingTeacher;
import kz.com.SerAya.Repository.RatingTeacherRepository;
import kz.com.SerAya.Service.RatingTeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingTeacherServiceImpl implements RatingTeacherService {

    private final RatingTeacherRepository repository;

    @Override
    public Integer save(RatingTeacherDto dto) {

        RatingTeacher teacher = RatingTeacherDto.toEntity(dto);
        return repository.save(teacher).getId();
    }

    @Override
    public List<RatingTeacherDto> findAll() {
        return repository.findAll()
                .stream()
                .map(RatingTeacherDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public RatingTeacherDto findById(Integer id) {
        return repository.findById(id)
                .map(RatingTeacherDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No teacher found with the ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        // todo check delete
        repository.deleteById(id);
    }

    @Override
    public List<RatingTeacherDto> findRatingTeachersByTeacher(int id) {

        return repository.findRatingTeachersByTeacher(id)
                .stream()
                .map(RatingTeacherDto::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public List<RatingTeacherDto> findRatingTeachersByUser(int id) {

        return repository.findRatingTeachersByUser(id)
                .stream()
                .map(RatingTeacherDto::fromEntity)
                .collect(Collectors.toList());
    }


}
