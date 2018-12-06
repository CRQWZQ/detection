package com.example.demo.untils;

import java.util.UUID;

/**
 * 杭州蓝诗网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/04 <br>
 * @Author: <a href="wangzhiqiang@quannengzhanggui.cn">wzq</a>
 */
public class UuidUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
