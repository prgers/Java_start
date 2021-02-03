package com.prger.dao;

import com.prger.bean.Award;

import java.util.List;

public interface AwardDao extends BaseDao<Award>{
     List<String> getImageList(List<Integer> list);
}
