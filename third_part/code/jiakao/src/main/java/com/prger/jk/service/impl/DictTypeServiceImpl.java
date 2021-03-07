package com.prger.jk.service.impl;

import com.prger.jk.mapper.DictTypeMapper;
import com.prger.jk.pojo.po.DictType;
import com.prger.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DictTypeServiceImpl implements DictTypeService {


    private DictTypeMapper mapper;

    @Autowired
    public void setMapper(DictTypeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<DictType> list() {
        return mapper.list();
    }
}
