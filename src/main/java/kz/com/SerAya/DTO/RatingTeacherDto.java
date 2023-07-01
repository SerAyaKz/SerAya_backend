package kz.com.SerAya.DTO;

import kz.com.SerAya.Entity.RatingTeacher;
import kz.com.SerAya.Entity.Teacher;
import kz.com.SerAya.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RatingTeacherDto {
    private int id;
    private String course_code;
    private boolean isOnline;
    private int quality;
    private int difficulty;
    private boolean willTakeTeacherAgain;
    private boolean tookCredit;
    private boolean usedTextbooks;
    private boolean attendanceMandatory;
    private String gradeReceived;
    private String review;
    private int user_id;
    private int teacher_id;

    public static RatingTeacherDto fromEntity(RatingTeacher ratingTeacher) {
        return RatingTeacherDto.builder()
                .id(ratingTeacher.getId())
                .course_code(ratingTeacher.getCourse_code())
                .quality(ratingTeacher.getQuality())
                .difficulty(ratingTeacher.getDifficulty())
                .willTakeTeacherAgain(ratingTeacher.isWillTakeTeacherAgain())
                .tookCredit(ratingTeacher.isTookCredit())
                .usedTextbooks(ratingTeacher.isUsedTextbooks())
                .attendanceMandatory(ratingTeacher.isAttendanceMandatory())
                .gradeReceived(ratingTeacher.getGradeReceived())
                .review(ratingTeacher.getReview())
                .user_id(ratingTeacher.getUser().getId())
                .teacher_id(ratingTeacher.getTeacher().getId())
                .build();
    }

    public static RatingTeacher toEntity(RatingTeacherDto ratingTeacher) {
        return RatingTeacher.builder()
                .id(ratingTeacher.getId())
                .course_code(ratingTeacher.getCourse_code())
                .quality(ratingTeacher.getQuality())
                .difficulty(ratingTeacher.getDifficulty())
                .willTakeTeacherAgain(ratingTeacher.isWillTakeTeacherAgain())
                .tookCredit(ratingTeacher.isTookCredit())
                .usedTextbooks(ratingTeacher.isUsedTextbooks())
                .attendanceMandatory(ratingTeacher.isAttendanceMandatory())
                .gradeReceived(ratingTeacher.getGradeReceived())
                .review(ratingTeacher.getReview())
                .user(
                        User.builder()
                                .id(ratingTeacher.getUser_id())
                                .build()
                )
                .teacher(
                        Teacher.builder()
                                .id(ratingTeacher.getTeacher_id())
                                .build()
                )
                .build();
    }
}
