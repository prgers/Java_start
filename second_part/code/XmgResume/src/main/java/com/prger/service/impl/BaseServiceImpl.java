package com.prger.service.impl;

import com.prger.dao.BaseDao;
import com.prger.service.BaseService;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected BaseDao<T> dao = newDao();
    protected BaseDao<T> newDao() {
        //com.prger.service.impl.WebsiteServiceImpl
        //com.prger.dao.impl.WebsiteDaoImpl
        try {
            String clsName = getClass().getName()
                    .replace(".service.", ".dao.")
                    .replace("Service", "Dao");

            return (BaseDao<T>) Class.forName(clsName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    };

    @Override
    public List<T> list() {
        return dao.list();
    }

    @Override
    public T get(Integer id) {
        return dao.get(id);
    }

    @Override
    public boolean save(T bean) {
        return dao.save(bean);
    }

    @Override
    public boolean remove(List<Integer> list) {
        return dao.remove(list);
    }
}
