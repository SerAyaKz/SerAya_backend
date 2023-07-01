package kz.com.SerAya.Controller;

import kz.com.SerAya.DTO.SavedTeacherDto;
import kz.com.SerAya.Service.SavedTeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SavedTeacherController {
    private final SavedTeacherService savedTeacherService;

    @RequestMapping(value="/savedTeacher",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<SavedTeacherDto>> findAll() {
        return ResponseEntity.ok(savedTeacherService.findAll());
    }
    @RequestMapping(value="/savedTeacher/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<SavedTeacherDto> findById(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(savedTeacherService.findById(id));
    }
    @RequestMapping(value = "/savedTeacher/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Void> delete(
            @PathVariable("id") Integer id
    ) {
        savedTeacherService.delete(id);
        return ResponseEntity.accepted().build();
    }
    @RequestMapping(value="/savedTeacher",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Integer> save(
            @RequestBody SavedTeacherDto savedTeacherDto
    ) {
        return ResponseEntity.ok(savedTeacherService.save(savedTeacherDto));
    }

}
