package com.lsd.web.persistance.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PatientModel extends AuditModel {
    private Long id;
    private String dateExamination;
    private Boolean gender;
    private String fullName;
    private Integer yearBirthday;
    private String phone;
    private String inputDataBy;
    private String inputDataInvi;
    private String analysisOfCustomer;
    private String confirmOfCustomer;
    private String address;
    private String statusPatient;
    private Date updatedAt;

    private MedicalModel medicalModel;
}
