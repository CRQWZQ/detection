package com.example.demo.controller;

import com.example.demo.exception.BusinessException;
import com.example.demo.model.dto.ActivityDto;
import com.example.demo.model.entity.Activity;
import com.example.demo.result.CodeMsg;
import com.example.demo.result.ResultData;
import com.example.demo.result.ResultList;
import com.example.demo.service.ActivityService;
import com.mysql.cj.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 杭州蓝诗网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
 * @Author: <a href="wangzhiqiang@quannengzhanggui.cn">wzq</a>
 */
@RestController
@RequestMapping(value = "/activity")
public class ActivityController {

    protected  Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    ResultData<Activity> saveActivity(HttpServletRequest request, @RequestBody ActivityDto activityDto){
        ResultData<Activity> resultData = new ResultData<>();
        parameterCalibration(activityDto);
        Activity activity = activityService.saveActivity(activityDto);
        resultData.setData(activity);
        return resultData;
    }
    @RequestMapping(value = "/findActivity", method = RequestMethod.GET)
    ResultList<List<Activity>> findActivity(HttpServletRequest request, Long shopId){
        ResultList resultList = new ResultList<>();
        if (shopId == null) {
            throw new BusinessException(CodeMsg.PARAM_ERROR, "请求shopId为空");
        }
        List<Activity> activityList = activityService.findActivityByShopId(shopId);
        resultList.setData(activityList);
        return resultList;
    }

    private void parameterCalibration(ActivityDto activityDto) {
        if (StringUtils.isNullOrEmpty(activityDto.getName())) {
            throw new BusinessException(CodeMsg.PARAM_ERROR, "name活动名字未设置");
        }
        if (!activityDto.getStatus().equals("NORMAL") || activityDto.getStatus() == null) {
            throw new BusinessException(CodeMsg.PARAM_ERROR, "status状态错误");
        }
        if (activityDto.getShopId() == null ) {
            throw new BusinessException(CodeMsg.PARAM_ERROR, "shopId为空");
        }
        /*if (activityDto.getTimestamp() == null || activityDto.getTimestamp().toString().length()!= 11) {
            throw new BusinessException(CodeMsg.PARAM_ERROR, "timeStamp时间戳错误");
        }*/
    }
}
