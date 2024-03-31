package com.lsd.web.persistance.model;


import com.lsd.web.persistance.entity.InformationHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class InformationDetailModel extends AuditModel {
    private Long id;
    private String name;
    private InformationHeader headerId;
    private Long parentId;

    private List<InformationDetailModel> listChild;
}
