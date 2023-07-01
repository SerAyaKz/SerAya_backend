package kz.com.SerAya.Controller;

import kz.com.SerAya.DTO.RatingTeacherDto;
import kz.com.SerAya.Service.RatingTeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RatingTeacherController {
    private final RatingTeacherService teacherRatingService;

    @RequestMapping(value="/teacherRating",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<RatingTeacherDto>> findAll() {
        return ResponseEntity.ok(teacherRatingService.findAll());
    }
    @RequestMapping(value="/teacherRating/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<RatingTeacherDto> findById(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(teacherRatingService.findById(id));
    }

    @RequestMapping(value="/teacherRating/teacher/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<RatingTeacherDto>> findByTeacherId(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(teacherRatingService.findRatingTeachersByTeacher(id));
    }
    @RequestMapping(value="/teacherRating/user/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<RatingTeacherDto>> findByUserId(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(teacherRatingService.findRatingTeachersByUser(id));
    }
    @RequestMapping(value = "/teacherRating/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Void> delete(
            @PathVariable("id") Integer id
    ) {
        teacherRatingService.delete(id);
        return ResponseEntity.accepted().build();
    }
    @RequestMapping(value="/teacherRating",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Integer> save(
            @RequestBody RatingTeacherDto teacherRatingDto
    ) {
        return ResponseEntity.ok(teacherRatingService.save(teacherRatingDto));
    }

}
