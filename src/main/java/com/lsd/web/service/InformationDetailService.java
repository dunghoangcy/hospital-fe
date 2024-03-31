package com.lsd.web.service;

import com.lsd.web.persistance.model.InformationDetailModel;
import com.lsd.web.persistance.model.InformationHeaderModel;

import java.util.ArrayList;
import java.util.List;

public interface InformationDetailService extends BaseService<InformationDetailModel, Long> {
    ArrayList<InformationDetailModel> listDetailByHeaderId(Long headerId);
    List<InformationDetailModel> listDetailByParentId(Long parentId);
    ArrayList<InformationDetailModel> getDetailHavHeader();
}
