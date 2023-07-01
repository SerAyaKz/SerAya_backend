package kz.com.SerAya.Controller;

import kz.com.SerAya.DTO.TeacherDto;
import kz.com.SerAya.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @RequestMapping(value="/teacher",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<TeacherDto>> findAll() {
        return ResponseEntity.ok(teacherService.findAll());
    }
    @RequestMapping(value="/teacher/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<TeacherDto> findById(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(teacherService.findById(id));
    }
    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Void> delete(
            @PathVariable("id") Integer id
    ) {
        teacherService.delete(id);
        return ResponseEntity.accepted().build();
    }
    @RequestMapping(value="/teacher",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Integer> save(
            @RequestBody TeacherDto addressDto
    ) {

        return ResponseEntity.ok(teacherService.save(addressDto));
    }
    @RequestMapping(value="/teachers/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<TeacherDto>> findBySchoolId(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(teacherService.findBySchoolId(id));
    }
    @RequestMapping(value="/savedTeacher/user/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<TeacherDto>> findByUser(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(teacherService.findByUser(id));
    }
}
