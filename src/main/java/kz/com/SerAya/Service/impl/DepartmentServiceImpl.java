package kz.com.SerAya.Service.impl;

import kz.com.SerAya.DTO.DepartmentDto;
import kz.com.SerAya.Entity.Department;
import kz.com.SerAya.Repository.DepartmentRepository;
import kz.com.SerAya.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Override
    public Integer save(DepartmentDto dto) {
        Department department = DepartmentDto.toEntity(dto);
        return repository.save(department).getId();
    }

    @Override
    public List<DepartmentDto> findAll() {
        return repository.findAll()
                .stream()
                .map(DepartmentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto findById(Integer id) {
        return repository.findById(id)
                .map(DepartmentDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No department found with the ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        // todo check delete
        repository.deleteById(id);
    }



}
