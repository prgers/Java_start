package com.prger.dao;

import com.prger.bean.Award;
import com.prger.bean.ContactListParam;
import com.prger.bean.ContactListResult;

import java.util.List;

public interface AwardDao extends BaseDao<Award>{
     List<String> getImageList(List<Integer> list);

}
