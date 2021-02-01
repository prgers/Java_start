package com.prger.service.impl;

import com.prger.bean.Skill;
import com.prger.dao.BaseDao;
import com.prger.dao.impl.SkillDaoImpl;
import com.prger.service.SkillService;

public class SkillServiceImpl extends BaseServiceImpl<Skill> implements SkillService {
    @Override
    protected BaseDao<Skill> newDao() {
        return new SkillDaoImpl();
    }
}
