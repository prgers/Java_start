package com.prger.bean.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBean extends  BaseBean{
    private Date beginDay;
    private Date endDay;

    public Date getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(Date beginDay) {
        this.beginDay = beginDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    /**
     * 将对象转成json字符串
     * @return
     * @throws Exception
     */
    @JsonIgnore
    public String getJson() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        return mapper.writeValueAsString(this).replace("\"", "'");
    }
}
