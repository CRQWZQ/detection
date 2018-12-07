package com.example.demo.result;

import lombok.Data;

/**
 * 杭州蓝诗网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
 * @Author: <a href="wangzhiqiang@quannengzhanggui.cn">wzq</a>
 */

public class ResultData<T> extends Result {

    private T data;

    public ResultData() {}

    public  ResultData(String resultCode, String resultMessage, T data) {
        super(resultCode, resultMessage);
        this.data = data;
    }

    public ResultData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
