package com.example.demo.untils;

import java.util.UUID;

/**
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/04 <br>
 */
public class UuidUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
