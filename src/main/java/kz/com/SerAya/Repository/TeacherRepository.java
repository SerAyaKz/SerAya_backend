package kz.com.SerAya.Repository;

import kz.com.SerAya.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(
            value = "SELECT * FROM teacher WHERE school_id = ?",
            nativeQuery = true)
    List<Teacher> findBySchoolId(int id);
    @Query(
            value = " SELECT teacher.* FROM teacher  JOIN saved_teacher ON teacher.id = saved_teacher.teacher_id WHERE saved_teacher.user_id = ?;",
            nativeQuery = true)
    List<Teacher> findByUser(int id);
}
