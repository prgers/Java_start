package com.prger.service.impl;

import com.prger.bean.Education;
import com.prger.dao.BaseDao;
import com.prger.dao.impl.EducationDaoImpl;
import com.prger.service.EducationService;

public class EducationServiceImpl extends BaseServiceImpl<Education> implements EducationService {

    @Override
    protected BaseDao<Education> newDao() {
        return new EducationDaoImpl();
    }
}
