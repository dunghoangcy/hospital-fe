package com.lsd.web.persistance.model;

import com.lsd.web.persistance.entity.InformationHeader;
import com.lsd.web.persistance.entity.Medical;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ImageModel extends AuditModel{
    private Long id;
    private String name;
    private Medical idMedical;
    private InformationHeader idHeader;

}
