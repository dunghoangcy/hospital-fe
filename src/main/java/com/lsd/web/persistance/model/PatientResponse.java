package com.lsd.web.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {
    private Long id;
    private Date dateExamination;
    private String fullName;
    private Integer yearBirthday;
    private String phone;
    private String address;

}
