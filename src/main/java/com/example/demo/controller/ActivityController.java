package com.example.demo.controller;

import com.example.demo.dao.ActivityMapper;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.dto.ActivityDto;
import com.example.demo.model.entity.Activity;
import com.example.demo.result.CodeMsg;
import com.example.demo.result.ResultData;
import com.example.demo.service.ActivityService;
import com.example.demo.untils.UuidUtil;
import com.mysql.cj.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 杭州蓝诗网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
 * @Author: <a href="wangzhiqiang@quannengzhanggui.cn">wzq</a>
 */
@RestController
public class ActivityController {

    private static Logger LOGGER = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultData<Activity> saveActivity(ActivityDto activityDto){

        parameterCalibration(activityDto);

        return activityService.saveActivity(activityDto);
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
