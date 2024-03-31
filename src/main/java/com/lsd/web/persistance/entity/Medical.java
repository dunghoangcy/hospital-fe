package com.lsd.web.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medical")
@Entity
@SuperBuilder
public class Medical extends AuditRepon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "name_doctor")
    private String nameDoctor;

    @Column(name = "date_of_installation")
    private Date dateOfInstallation;

    @Column(name = "date_of_brackets")
    private Date dateOfBrackets;

    @Column(name = "target_note")
    private String targetNote;

    @Column(name = "preoperative")
    private String preoperative;

    @Column(name = "appointment")
    private Date appointment;

}
