package kz.com.SerAya.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "school")
public class School extends AbstractEntity {
    @Column(unique = true)
    private String name;
    private String country;
    private String state;
    private String city;
    private String website;
    private String email;

    @OneToMany(mappedBy = "school")
    private List<Teacher> teachers;


}