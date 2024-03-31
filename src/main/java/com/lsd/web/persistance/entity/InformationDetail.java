package com.lsd.web.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "information_detail")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class InformationDetail extends AuditRepon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_header", referencedColumnName = "id")
    private InformationHeader headerId;

    @Column(name = "parent_id")
    private Long parentId;

}
