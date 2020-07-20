package com.example.demo.service;

import com.example.demo.model.dto.ActivityDto;
import com.example.demo.model.entity.Activity;

import java.util.List;

/**
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
 */
public interface ActivityService {

    List<Activity> findActivityByShopId(Long shopId);

    void saveActivity(ActivityDto activityDto);

    Boolean deleteActivityById(int id);

    void updateActivityStatus(Integer id, String status);
}
