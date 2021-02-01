package com.prger.service.impl;
import com.prger.bean.Website;
import com.prger.dao.BaseDao;
import com.prger.dao.impl.WebsiteDaoImpl;
import com.prger.service.WebsiteService;

public class WebsiteServiceImpl extends BaseServiceImpl<Website> implements WebsiteService {

    @Override
    protected BaseDao<Website> newDao() {
        return new WebsiteDaoImpl();
    }
}
