package kz.com.SerAya.DTO;

import kz.com.SerAya.Entity.SavedTeacher;
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
public class SavedTeacherDto {

    private Integer id;
    private Integer teacher_id;
    private Integer user_id;

    public static SavedTeacherDto fromEntity(SavedTeacher savedTeacher) {
        return SavedTeacherDto.builder()
                .id(savedTeacher.getId())
                .teacher_id(savedTeacher.getTeacher().getId())
                .user_id(savedTeacher.getUser().getId())
                .build();
    }

    public static SavedTeacher toEntity(SavedTeacherDto savedTeacherDto) {
        return SavedTeacher.builder()
                .id(savedTeacherDto.getId())
                .teacher(
                        Teacher.builder()
                                .id(savedTeacherDto.getTeacher_id())
                                .build()
                )
                .user(
                        User.builder()
                                .id(savedTeacherDto.getUser_id())
                                .build()
                )
                .build();
    }
}
