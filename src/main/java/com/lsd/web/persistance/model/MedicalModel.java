package com.lsd.web.persistance.model;



import com.lsd.web.persistance.entity.Statistic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MedicalModel extends AuditModel {
    private Long id;
    private Long patientId;
    private String nameDoctor;
    private Date dateOfInstallation;
    private Date dateOfBrackets;
    private String targetNote;
    private String preoperative;
    private Date appointment;
    private ArrayList<Statistic> statistic;
    private ArrayList<InformationHeaderModel> informationHeaderModelArrayList;
    private ArrayList<InformationDetailModel> informationDetailModelArrayList;



}
