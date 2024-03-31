package com.lsd.web.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "statistics")
@Entity
@SuperBuilder
public class Statistic extends AuditRepon{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_medical")
    private Long idMedical;

    @Column(name = "id_detail")
    private Long idDetail;

    @Column(name = "type_note")
    private String typeNote;

    @Column(name = "value")
    private String value;

    @Column(name = "unit")
    private String unit;

}
