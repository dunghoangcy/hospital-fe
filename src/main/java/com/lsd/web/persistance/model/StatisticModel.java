package com.lsd.web.persistance.model;

import com.lsd.web.persistance.entity.Medical;
import com.lsd.web.persistance.entity.Statistic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class StatisticModel extends AuditModel{
    private Long id;
    private Long idMedical;
    private Long idDetail;
    private String typeNote;
    private String value;
    private String unit;
    private Medical medical;
}
