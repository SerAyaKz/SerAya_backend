package kz.com.SerAya.Service.impl;

import kz.com.SerAya.DTO.TeacherDto;
import kz.com.SerAya.Entity.Teacher;
import kz.com.SerAya.Repository.TeacherRepository;
import kz.com.SerAya.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repository;

    @Override
    public Integer save(TeacherDto dto) {
        Teacher teacher = TeacherDto.toEntity(dto);
        return repository.save(teacher).getId();
    }

    @Override
    public List<TeacherDto> findAll() {
        return repository.findAll()
                .stream()
                .map(TeacherDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDto findById(Integer id) {
        return repository.findById(id)
                .map(TeacherDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No teacher found with the ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        // todo check delete
        repository.deleteById(id);
    }
    @Override
    public List<TeacherDto> findBySchoolId(int id) {
        return repository.findBySchoolId(id)
                .stream()
                .map(TeacherDto::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public List<TeacherDto> findByUser(int id) {
        return repository.findByUser(id)
                .stream()
                .map(TeacherDto::fromEntity)
                .collect(Collectors.toList());
    }
}
