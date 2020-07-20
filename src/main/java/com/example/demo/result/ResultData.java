package com.example.demo.result;

/**
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/05 <br>
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
