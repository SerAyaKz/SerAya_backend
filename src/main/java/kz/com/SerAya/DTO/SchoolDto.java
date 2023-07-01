package kz.com.SerAya.DTO;

import kz.com.SerAya.Entity.School;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SchoolDto {

    private Integer id;
    private String name;
    private String country;
    private String state;
    private String city;
    private String website;
    private String email;

    public static SchoolDto fromEntity(School school) {
        return SchoolDto.builder()
                .id(school.getId())
                .name(school.getName())
                .country(school.getCountry())
                .state(school.getState())
                .city(school.getCity())
                .website(school.getWebsite())
                .email(school.getEmail())
                .build();
    }

    public static School toEntity(SchoolDto school) {
        return School.builder()
                .id(school.getId())
                .name(school.getName())
                .country(school.getCountry())
                .state(school.getState())
                .city(school.getCity())
                .website(school.getWebsite())
                .email(school.getEmail())
                .build();
    }
}
