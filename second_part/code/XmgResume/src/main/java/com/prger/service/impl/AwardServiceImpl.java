package com.prger.service.impl;

import com.prger.bean.Award;
import com.prger.dao.BaseDao;
import com.prger.dao.impl.AwardDaoImpl;
import com.prger.service.AwardService;

public class AwardServiceImpl extends BaseServiceImpl<Award> implements AwardService {
    @Override
    protected BaseDao<Award> newDao() {
        return new AwardDaoImpl();
    }
}
