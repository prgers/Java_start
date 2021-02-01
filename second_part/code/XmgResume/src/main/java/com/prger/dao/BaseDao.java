package com.prger.dao;
import java.util.List;

public interface BaseDao<T> {

    List<T> list();
    boolean save(T bean);
    boolean remove(List<Integer> list);
    T get(Integer id);
}
