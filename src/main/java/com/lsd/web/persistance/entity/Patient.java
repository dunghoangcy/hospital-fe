package com.lsd.web.persistance.entity;



import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "patient")
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
public class Patient extends AuditRepon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date_examination")
    private Date dateExamination;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "name_patient")
    private String fullName;
    @Column(name = "year_birthday")
    private Integer yearBirthday;
    @Column(name = "phone")
    private String phone;
    @Column(name = "input_data_by")
    private  String inputDataBy;
    @Column(name = "input_data_invi")
    private String inputDataInvi;
    @Column(name = "analysis_of_customer")
    private  String analysisOfCustomer;
    @Column(name = "confirm_of_customer")
    private String confirmOfCustomer;
    @Column(name = "address")
    private String address;
    @Column(name = "status_patient")
    private String statusPatient;
    @Column(name = "updated_at")
    private Date updatedAt;

}
