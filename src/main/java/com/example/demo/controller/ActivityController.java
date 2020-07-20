package com.example.demo.controller;

import com.example.demo.dao.ActivityMapper;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.PagedModel;
import com.example.demo.model.dto.ActivityDto;
import com.example.demo.model.entity.Activity;
import com.example.demo.model.vo.ActivityVo;
import com.example.demo.result.CodeMsg;
import com.example.demo.result.ResultData;
import com.example.demo.result.ResultList;
import com.example.demo.result.ResultPagedList;
import com.example.demo.service.ActivityService;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
 */
@RestController
@RequestMapping(value = "/activity")
public class ActivityController {

    protected  Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityMapper activityMapper;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    ResultData<Boolean> saveActivity(HttpServletRequest request, @RequestBody ActivityDto activityDto){
        parameterCalibration(activityDto);
        activityService.saveActivity(activityDto);
        return new ResultData<>(true);
    }

    @RequestMapping(value = "/findActivity", method = RequestMethod.GET)
    @ResponseBody
    ResultList<Activity> findActivity(HttpServletRequest request, Long shopId){
        if (shopId == null) {
            throw new BusinessException(CodeMsg.PARAM_ERROR, "请求shopId为空");
        }
        List<Activity> activityList = activityService.findActivityByShopId(shopId);
        return new ResultList<>(activityList);
    }

    @RequestMapping(value = "deleteById", method = RequestMethod.GET)
    @ResponseBody
    ResultData<Boolean> deleteActivityById(HttpServletRequest request, Integer id) {
        if (id == 0 || id == null) {
            throw new BusinessException(CodeMsg.PARAM_ERROR, "id 不能为空");
        }
        activityService.deleteActivityById(id);
        return new ResultData<>(true);
    }

    @RequestMapping(value = "/findActivityByPage", method = RequestMethod.POST)
    ResultPagedList<Activity> findActivityPage(HttpServletRequest request, @RequestBody PagedModel pagedModel) {
        if (pagedModel.getShopId() == null ) {
            throw new BusinessException(CodeMsg.PARAM_ERROR, "shopId不能为空");
        }
        List<Activity> activitityList = activityService.findActivityByShopId(pagedModel.getShopId());
        long count = activityMapper.selectActivityCount(pagedModel.getShopId());
        return new ResultPagedList<>(activitityList, count, pagedModel);
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.GET)
    @ResponseBody
    ResultData<Boolean> updateActivityStatus (HttpServletRequest request, Integer id, String status){
        if (id == null || StringUtils.isEmpty(status)) {
            LOGGER.warn("updateActivityStatus is error: status is null !");
            throw new BusinessException(CodeMsg.PARAM_ERROR, "id or status 不能为空");
        }
        activityService.updateActivityStatus(id, status);
        return new ResultData<>(true);
    }

    @RequestMapping(value = "/activitySharingList", method = RequestMethod.GET)
    @ResponseBody
    ResultList<ActivityVo> selectActivitySharingList(HttpServletRequest request ,@RequestParam Long shopId) {
        if (shopId == null ) {
            LOGGER.warn("selectActivitySharingList is error : shopId is null !");
            throw new BusinessException(CodeMsg.PARAM_ERROR, "shopId 不能为空");
        }
        List <Activity> activityList  = activityService.findActivityByShopId(shopId);
        List<ActivityVo> activityVoList = new ArrayList<>();
        activityTransformActivityVo(activityList, activityVoList);

        return new ResultList<ActivityVo>(activityVoList);
    }

    private void activityTransformActivityVo(List<Activity> activityList, List<ActivityVo> activityVoList) {
        if (activityList.size() == 0 || activityList == null) {
            return;
        }
        for (Activity activity : activityList) {
            ActivityVo activityVo = ActivityVo.vauleOf(activity);

            activityVoList.add(activityVo);
        }

    }

    private void parameterCalibration(ActivityDto activityDto) {
        if (Strings.isNullOrEmpty(activityDto.getName())) {
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
