package kz.com.SerAya.Controller;

import kz.com.SerAya.DTO.SchoolDto;
import kz.com.SerAya.Service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @RequestMapping(value="/school",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<SchoolDto>> findAll() {
        return ResponseEntity.ok(schoolService.findAll());
    }
    @RequestMapping(value="/school/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<SchoolDto> findById(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(schoolService.findById(id));
    }
    @RequestMapping(value = "/school/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Void> delete(
            @PathVariable("id") Integer id
    ) {
        schoolService.delete(id);
        return ResponseEntity.accepted().build();
    }
    @RequestMapping(value="/school",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Integer> save(
            @RequestBody SchoolDto addressDto
    ) {
        return ResponseEntity.ok(schoolService.save(addressDto));
    }

}