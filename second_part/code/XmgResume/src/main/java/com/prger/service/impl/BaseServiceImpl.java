package com.prger.service.impl;

import com.prger.dao.BaseDao;
import com.prger.service.BaseService;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected BaseDao<T> dao = newDao();
    protected abstract BaseDao<T> newDao();

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
