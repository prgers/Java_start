package com.prger.service.impl;

import com.prger.bean.Award;
import com.prger.dao.AwardDao;
import com.prger.service.AwardService;
import org.apache.commons.io.FileUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class AwardServiceImpl extends BaseServiceImpl<Award> implements AwardService {

    public boolean remove(List<Integer> list, HttpServletRequest request) {

        List<String> images = ((AwardDao) dao).getImageList(list);
        if (images.size() > 0) {
            for (String image : images) {
                //删除图片
                FileUtils.deleteQuietly(new File(request.getServletContext().getRealPath(image)));
            }
        }

        return remove(list);
    }

    @Override
    public boolean remove(List<Integer> list) {
        return super.remove(list);
    }
}
