package kz.com.SerAya.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ratingTeacher")
public class RatingTeacher extends AbstractEntity {
    private String course_code;
    private boolean isOnline;
    private int quality;
    private int difficulty;
    private boolean willTakeTeacherAgain;
    private boolean tookCredit;
    private boolean usedTextbooks;
    private boolean attendanceMandatory;
    private String gradeReceived;

    // private List<String> tags;
    private String review;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


}