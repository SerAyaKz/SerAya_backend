package kz.com.SerAya.Service.impl;

import kz.com.SerAya.DTO.SchoolDto;
import kz.com.SerAya.Entity.School;
import kz.com.SerAya.Repository.SchoolRepository;
import kz.com.SerAya.Service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository repository;

    @Override
    public Integer save(SchoolDto dto) {
        School school = SchoolDto.toEntity(dto);
        return repository.save(school).getId();
    }

    @Override
    public List<SchoolDto> findAll() {
        return repository.findAll()
                .stream()
                .map(SchoolDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public SchoolDto findById(Integer id) {
        return repository.findById(id)
                .map(SchoolDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No school found with the ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        // todo check delete
        repository.deleteById(id);
    }



}
