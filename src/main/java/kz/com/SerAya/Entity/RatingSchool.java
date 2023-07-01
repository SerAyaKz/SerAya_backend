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
@Table(name = "ratingSchool")
public class RatingSchool extends AbstractEntity {
    private int reputation;
    private int location;
    private int opportunity;
    private int facility;
    private int internet;
    private int food;
    private int clubs;
    private int social;
    private int happiness;
    private int safety;
    private String review;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;




}