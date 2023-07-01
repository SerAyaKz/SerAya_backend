package kz.com.SerAya.Repository;

import kz.com.SerAya.Entity.RatingSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface RatingSchoolRepository extends JpaRepository<RatingSchool, Integer> {
    @Query(
            value = "SELECT * FROM rating_school WHERE school_id = ?",
            nativeQuery = true)
    List<RatingSchool> findRatingSchoolsBySchool(int id);

}