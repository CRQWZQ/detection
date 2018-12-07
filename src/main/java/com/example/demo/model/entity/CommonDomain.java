package com.example.demo.model.entity;

import org.springframework.data.annotation.Id;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * 杭州蓝诗网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/04 <br>
 * @Author: <a href="wangzhiqiang@quannengzhanggui.cn">wzq</a>
 */

public class CommonDomain implements Serializable {
    private static final long serialVersionUID = -942922853757839363L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "modify_time")
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
