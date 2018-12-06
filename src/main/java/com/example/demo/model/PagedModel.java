package com.example.demo.model;

import java.io.Serializable;

/**
 * 杭州蓝诗网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
 * @Author: <a href="wangzhiqiang@quannengzhanggui.cn">wzq</a>
 */
public class PagedModel implements Serializable {
    private Long pageSize;

    private Long pageNo;

    private Long count;

    private String column;

    private String orderby;


    public PagedModel() {
        pageSize = 10L;
        pageNo = 0L;
    }

    public PagedModel(Long pageSize, Long pageNo) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public Long getPageSize() {
        if (pageSize == null || pageSize < 0) {
            pageSize = 10L;  //hard coded， is this OK？
        }
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageNo() {
        if (pageNo == null || pageNo < 0) {
            pageNo = 0L;
        }
        return pageNo;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }
}
