package com.example.demo.result;

import com.example.demo.model.PagedModel;

import java.util.List;

/**
 * 杭州蓝诗网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
 * @Author: <a href="wangzhiqiang@quannengzhanggui.cn">wzq</a>
 */
public class ResultPagedList<T> extends Result {

    private List<T> data;

    private Long pageSize = 10L;

    private Long pageNo = 0L;

    private Long count = 0L;

    public ResultPagedList(){}

    public ResultPagedList(List<T> data, Long count, PagedModel pagedModel) {
        this.data = data;
        this.count = count;
        this.pageSize = pagedModel.getPageSize();
        this.pageNo = pagedModel.getPageNo();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageNo() {
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

    public ResultPagedList(String resultCode, String resultMessage, List<T> data) {
        super(resultCode, resultMessage);
        this.data = data;
    }

    public ResultPagedList(Long pageSize, Long pageNo, Long count) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.count = count;
    }

}
