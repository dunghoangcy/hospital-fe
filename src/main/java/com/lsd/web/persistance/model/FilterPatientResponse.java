package com.lsd.web.persistance.model;

import lombok.Data;

import java.util.List;

@Data
public class FilterPatientResponse {
    private List<PatientResponse> listRecord;
    private Integer totalRecord;
}
