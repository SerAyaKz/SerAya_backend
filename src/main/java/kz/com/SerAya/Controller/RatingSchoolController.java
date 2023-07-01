package kz.com.SerAya.Controller;

import kz.com.SerAya.DTO.RatingSchoolDto;
import kz.com.SerAya.Service.RatingSchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RatingSchoolController {
    private final RatingSchoolService schoolRatingService;

    @RequestMapping(value="/schoolRating",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<RatingSchoolDto>> findAll() {
        return ResponseEntity.ok(schoolRatingService.findAll());
    }
    @RequestMapping(value="/schoolRating/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<RatingSchoolDto> findById(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(schoolRatingService.findById(id));
    }

    @RequestMapping(value="/schoolRating/school/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<RatingSchoolDto>> findBySchoolId(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(schoolRatingService.findRatingSchoolsBySchool(id));
    }
    @RequestMapping(value = "/schoolRating/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Void> delete(
            @PathVariable("id") Integer id
    ) {
        schoolRatingService.delete(id);
        return ResponseEntity.accepted().build();
    }
    @RequestMapping(value="/schoolRating",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Integer> save(
            @RequestBody RatingSchoolDto schoolRatingDto
    ) {
        return ResponseEntity.ok(schoolRatingService.save(schoolRatingDto));
    }

}
