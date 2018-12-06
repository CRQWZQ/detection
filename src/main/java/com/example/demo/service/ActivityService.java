package com.example.demo.service;

import com.example.demo.model.dto.ActivityDto;
import com.example.demo.model.entity.Activity;
import com.example.demo.result.Result;
import com.example.demo.result.ResultData;
import com.example.demo.result.ResultList;
import org.springframework.stereotype.Service;

/**
 * 杭州蓝诗网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
 * @Author: <a href="wangzhiqiang@quannengzhanggui.cn">wzq</a>
 */
public interface ActivityService {

    ResultList<Activity> findActivityByShopId(Long shopId);

    ResultData<Activity> saveActivity(ActivityDto activityDto);
}
