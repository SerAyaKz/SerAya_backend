package kz.com.SerAya.Controller;

import kz.com.SerAya.DTO.DepartmentDto;
import kz.com.SerAya.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @RequestMapping(value="/department",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<DepartmentDto>> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }
    @RequestMapping(value="/department/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<DepartmentDto> findById(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(departmentService.findById(id));
    }
    @RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Void> delete(
            @PathVariable("id") Integer id
    ) {
        departmentService.delete(id);
        return ResponseEntity.accepted().build();
    }
    @RequestMapping(value="/department",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Integer> save(
            @RequestBody DepartmentDto addressDto
    ) {
        return ResponseEntity.ok(departmentService.save(addressDto));
    }

}
