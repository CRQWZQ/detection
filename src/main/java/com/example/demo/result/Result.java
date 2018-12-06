package com.example.demo.result;

import lombok.Data;
import java.io.Serializable;


public class Result implements Serializable{

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    private String resultCode="0";

    private String resultMessage = "success";

    public Result(){}

    public Result(String resultCode, String resultMessage){
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }


}