package com.lsd.web.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "image")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Image extends AuditRepon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_medical", referencedColumnName = "id")
    private Medical idMedical;
    @ManyToOne
    @JoinColumn(name = "id_header", referencedColumnName = "id")
    private InformationHeader idHeader;
}
