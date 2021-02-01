package com.prger.service;
import java.util.List;

public interface BaseService<T> {

    List<T> list();
    T get(Integer id);
    boolean save(T bean);
    boolean remove(List<Integer> list);

}
