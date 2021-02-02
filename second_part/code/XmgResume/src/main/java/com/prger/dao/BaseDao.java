package com.prger.dao;
import java.util.List;

public interface BaseDao<T> {

    List<T> list();
    T get(Integer id);
    boolean save(T bean);
    boolean remove(List<Integer> list);
}
