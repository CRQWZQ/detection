package com.example.demo.service;

import com.example.demo.dao.ActivityMapper;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.dto.ActivityDto;
import com.example.demo.model.entity.Activity;
import com.example.demo.result.CodeMsg;
import com.example.demo.untils.UuidUtil;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
 */
@Service
public class ActivityServiceImpl  implements ActivityService{

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public List<Activity> findActivityByShopId(Long shopId) {
//        PageHelper.startPage(0, 10);
        return activityMapper.selectActivityList(shopId);

    }

    @Override
    public void saveActivity(ActivityDto activityDto) {
        Activity activity = new Activity();
        activity.setUuid(UuidUtil.uuid());
        activity.setStatus(activityDto.getStatus());
        activity.setShopId(activityDto.getShopId());
        activity.setName(activityDto.getName());
        activity.setIsDelete(0);
        activity.setModifyTime(new Date());
        activity.setCreateTime(new Date());
        int activityId = activityMapper.insertActivity(activity);
        if ( activityId < 0 ) {
            LOGGER.warn("saveActivity is error | shopId ={} | activityName ={}", activityDto.getShopId(), activityDto.getName());
            throw new BusinessException(CodeMsg.SQL_ERROR, "saveActivity is error:shopId=" + activityDto.getShopId());
        }
       return;
    }

    @Override
    public Boolean deleteActivityById(int id) {
        try {
            activityMapper.deleteActivityById(id);
        }catch (Exception e){
            LOGGER.warn("deleteActivityById is error | id = {}", id);
            throw new BusinessException(CodeMsg.SQL_ERROR, "deleteActivity is error:id =" + id);
        }
        return true;
    }

    @Override
    public void updateActivityStatus(Integer id, String status) {
        try {
            activityMapper.updateActivityStatus(id, status);
        }catch (Exception e){
            LOGGER.warn("updateActivityStatus is error | id ={} | status = {}",id, status);
            throw new BusinessException(CodeMsg.SQL_ERROR, "updateActivityStatus is error: id=" + id + " |status= " + status );
        }
        return;
    }

}
