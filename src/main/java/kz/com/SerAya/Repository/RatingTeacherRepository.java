package kz.com.SerAya.Repository;

import kz.com.SerAya.Entity.RatingTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingTeacherRepository extends JpaRepository<RatingTeacher, Integer> {

    @Query(
            value = "SELECT * FROM rating_teacher WHERE teacher_id = ?",
            nativeQuery = true)
    List<RatingTeacher> findRatingTeachersByTeacher(int id);
    @Query(
            value = "SELECT * FROM rating_teacher WHERE user_id = ?",
            nativeQuery = true)
    List<RatingTeacher> findRatingTeachersByUser(int id);



}