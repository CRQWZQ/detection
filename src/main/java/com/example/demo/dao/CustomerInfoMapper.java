package com.example.demo.dao;

import com.example.demo.model.entity.CustomerInfo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/04 <br>
 */
@Mapper
@Component
public interface CustomerInfoMapper {

    @Select("select * from customer_info where relation_uuid =#{uuid}")
    List<CustomerInfo> selectCustomerInfoByUuid(@Param("uuid") String uuid);

    @Select("select * from customer_info where relation_uuid=#{uuid} limit #{pageNo}, #{pageSize}")
    PageInfo<CustomerInfo> SelectPageInfoByUuid(@Param("uuid")String uuid,@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

}
