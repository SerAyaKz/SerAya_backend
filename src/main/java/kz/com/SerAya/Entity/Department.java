package kz.com.SerAya.Entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department extends AbstractEntity {

    private String department_name;

    @OneToMany(mappedBy = "department")
    private List<Teacher> teachers;


}