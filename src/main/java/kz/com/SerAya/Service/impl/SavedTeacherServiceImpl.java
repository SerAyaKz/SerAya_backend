package kz.com.SerAya.Service.impl;

import kz.com.SerAya.DTO.SavedTeacherDto;
import kz.com.SerAya.Entity.SavedTeacher;
import kz.com.SerAya.Repository.SavedTeacherRepository;
import kz.com.SerAya.Service.SavedTeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SavedTeacherServiceImpl implements SavedTeacherService {

    private final SavedTeacherRepository repository;

    @Override
    public Integer save(SavedTeacherDto dto) {
        SavedTeacher savedTeacher = SavedTeacherDto.toEntity(dto);
        return repository.save(savedTeacher).getId();
    }

    @Override
    public List<SavedTeacherDto> findAll() {
        return repository.findAll()
                .stream()
                .map(SavedTeacherDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public SavedTeacherDto findById(Integer id) {
        return repository.findById(id)
                .map(SavedTeacherDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No savedSavedTeacher found with the ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        // todo check delete
        repository.deleteById(id);
    }


}
