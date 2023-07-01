package kz.com.SerAya.DTO;

import kz.com.SerAya.Entity.RatingSchool;
import kz.com.SerAya.Entity.School;
import kz.com.SerAya.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RatingSchoolDto {

    private Integer id;
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
    private int user_id;
    private int school_id;
    public static RatingSchoolDto fromEntity(RatingSchool ratingSchool) {
        return RatingSchoolDto.builder()
                .id(ratingSchool.getId())
                .reputation(ratingSchool.getReputation())
                .location(ratingSchool.getLocation())
                .opportunity(ratingSchool.getOpportunity())
                .facility(ratingSchool.getFacility())
                .internet(ratingSchool.getInternet())
                .food(ratingSchool.getFood())
                .clubs(ratingSchool.getClubs())
                .social(ratingSchool.getSocial())
                .happiness(ratingSchool.getHappiness())
                .safety(ratingSchool.getSafety())
                .review(ratingSchool.getReview())
                .user_id(ratingSchool.getUser().getId())
                .school_id(ratingSchool.getSchool().getId())
                .build();
    }

    public static RatingSchool toEntity(RatingSchoolDto ratingSchool) {
        return RatingSchool.builder()
                .id(ratingSchool.getId())
                .reputation(ratingSchool.getReputation())
                .location(ratingSchool.getLocation())
                .opportunity(ratingSchool.getOpportunity())
                .facility(ratingSchool.getFacility())
                .internet(ratingSchool.getInternet())
                .food(ratingSchool.getFood())
                .clubs(ratingSchool.getClubs())
                .social(ratingSchool.getSocial())
                .happiness(ratingSchool.getHappiness())
                .safety(ratingSchool.getSafety())
                .review(ratingSchool.getReview())
                .user(
                        User.builder()
                                .id(ratingSchool.getUser_id())
                                .build()
                )
                .school(
                        School.builder()
                                .id(ratingSchool.getSchool_id())
                                .build()
                )
                .build();
    }
}