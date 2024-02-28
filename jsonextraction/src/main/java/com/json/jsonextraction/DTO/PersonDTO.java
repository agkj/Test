package com.json.jsonextraction.DTO;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PersonDTO {

    private Integer id;
    private String nameS;
    private String dob;
}
