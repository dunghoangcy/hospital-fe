package com.lsd.web.persistance.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
public class AuditModel {
    private Boolean status;
    private Date createdAt;
}
