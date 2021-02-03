package com.prger.service;

import com.prger.bean.Award;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AwardService extends BaseService<Award>{
    public boolean remove(List<Integer> list, HttpServletRequest request);
}
