package com.prger.dao.impl;

import com.prger.dao.BaseDao;
import com.prger.utils.Dbs;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    private String table = table();
    protected abstract String table();

    @Override
    public boolean remove(List<Integer> list) {
        List<Integer> args = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM ").append(table).append(" WHERE id IN (");
        for (Integer id : list) {
            sql.append("?, ");
            args.add(id);
        }
        sql.replace(sql.length() - 2, sql.length(), ")");
        return Dbs.getTpl().update(sql.toString(), args.toArray()) > 0;
    }
}
