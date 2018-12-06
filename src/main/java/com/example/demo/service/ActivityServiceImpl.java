package com.example.demo.service;

import com.example.demo.dao.ActivityMapper;
import com.example.demo.model.dto.ActivityDto;
import com.example.demo.model.entity.Activity;
import com.example.demo.result.Result;
import com.example.demo.result.ResultData;
import com.example.demo.result.ResultList;
import com.example.demo.untils.UuidUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 杭州蓝诗网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
 * @Author: <a href="wangzhiqiang@quannengzhanggui.cn">wzq</a>
 */
@Service
public class ActivityServiceImpl  implements ActivityService{

    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public ResultList<Activity> findActivityByShopId(Long shopId) {
        PageHelper.startPage(0, 10);
        List<Activity> activityList = activityMapper.selectActivityList(shopId);

        return null;
    }

    @Override
    public ResultData<Activity> saveActivity(ActivityDto activityDto) {
        Activity activity = new Activity();
        activity.setUuid(UuidUtil.uuid());
        activity.setStatus(activityDto.getStatus());
        activity.setShopId(activityDto.getShopId());
        activity.setName(activityDto.getName());
        activity.setIsDelete(0);
        activity.setModifyTime(new Date());
        activity.setCreateTime(new Date());
        int activityId = activityMapper.insertActivity(activity);

        return null;
    }
}
