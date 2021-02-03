package com.prger.service.impl;

import com.prger.bean.Award;
import com.prger.dao.BaseDao;
import com.prger.dao.impl.AwardDaoImpl;
import com.prger.service.AwardService;
import com.prger.utils.Dbs;
import org.apache.commons.io.FileUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AwardServiceImpl extends BaseServiceImpl<Award> implements AwardService {

    private HttpServletRequest request;

    @Override
    protected BaseDao<Award> newDao() {
        return new AwardDaoImpl();
    }

    public boolean remove(List<Integer> list, HttpServletRequest request) {

        //根据id获取所有的图片路径
        List<Integer> args = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT image FROM award").append(" WHERE id IN (");
        for (Integer id : list) {
            sql.append("?, ");
            args.add(id);
        }
        sql.replace(sql.length() - 2, sql.length(), ")");
        List<String> images = Dbs.getTpl().queryForList(sql.toString(), String.class, args.toArray());
        for (String image : images) {
            //删除图片
            FileUtils.deleteQuietly(new File(request.getServletContext().getRealPath(image)));
        }
        return remove(list);
    }

    @Override
    public boolean remove(List<Integer> list) {
        return super.remove(list);
    }
}
