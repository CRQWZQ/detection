package com.example.demo.dao;

import com.example.demo.model.entity.Activity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/04 <br>
 */
@Mapper
public interface ActivityMapper  {

    @Results({
            @Result(property = "id" , column = "id"),
            @Result(property = "shopId", column = "shop_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "modifyTime", column = "modify_time")
    })
    @Insert("insert into activity(shop_id,uuid, `name`, is_delete, `status`, create_time, modify_time) " +
            "values(#{shopId}, #{uuid}, #{name}, #{isDelete}, #{status}, #{createTime}, #{modifyTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insertActivity(Activity activity);

    @Results({
            @Result(property = "shopId", column = "shop_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "modifyTime", column = "modify_time")
    })
    @Select("select id, shop_id, uuid, name, is_delete, status, create_time, modify_time from activity " +
            "where shop_id=#{shopId} and is_delete =0 and status='NORMAL'")
    List<Activity> selectActivityList(@Param("shopId") Long shopId);

    @Update("update activity set is_delete=1 , modify_time=now() , status ='END'  where id=#{id}")
    int deleteActivityById(@Param("id")Integer id);

    @Delete("delete activity where id =#{id}")
    int deleteByParamKey(@Param("id") int id);

    @Select("select count(*) from activity where shop_id=#{shopId} and is_delete=0 and status='NORMAL'")
    int selectActivityCount(@Param("shopId") Long shopId);

    @Update("update activity set status =#{status}, modify_time=now() where id=#{id}")
    int updateActivityStatus(@Param("id") int id, @Param("status") String status);
}
