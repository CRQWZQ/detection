package com.example.demo.model.vo;

import com.example.demo.model.entity.Activity;
import com.example.demo.untils.TimeConvertUtil;

import java.util.Date;

/**
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/10 <br>
 */
public class ActivityVo {
    private Integer id;

    private String relationUuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRelationUuid() {
        return relationUuid;
    }

    public void setRelationUuid(String relationUuid) {
        this.relationUuid = relationUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getQrUrl() {
        return qrUrl;
    }

    public void setQrUrl(String qrUrl) {
        this.qrUrl = qrUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    private String name;

    private Date endTime;

    private String qrUrl;

    private String shortUrl;

    public static ActivityVo vauleOf(Activity activity) {
        ActivityVo activityVo = new ActivityVo();
        activityVo.setId(activity.getId());
        activityVo.setName(activity.getName());
        activityVo.setRelationUuid(activity.getUuid());
        activityVo.setEndTime(TimeConvertUtil.getDelayByEndTime(activity.getModifyTime(), 24));
        return activityVo;
    }
}
