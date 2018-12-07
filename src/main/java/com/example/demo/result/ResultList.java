package com.example.demo.result;

import java.util.List;

/**
 * 杭州蓝诗网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
 * @Author: <a href="wangzhiqiang@quannengzhanggui.cn">wzq</a>
 */
public class ResultList<T> extends Result{

    private List<T> data;

    public ResultList(String resultCode, String resultMessage, List<T> data) {
        super(resultCode, resultMessage);
        this.data = data;
    }

    public ResultList(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
