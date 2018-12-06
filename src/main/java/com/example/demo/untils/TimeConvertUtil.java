package com.example.demo.untils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 杭州蓝诗网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/06 <br>
 * @Author: <a href="wangzhiqiang@quannengzhanggui.cn">wzq</a>
 */
public class TimeConvertUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeConvertUtil.class);

    /**
     * 判断两个时间是否超过24小时
     * @param date1 开始时间
     * @param date2 结束时间
     * @return
     * @throws Exception
     */
    public static boolean getTimeStampByValid(String date1, String date2) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = sdf.parse(date1);
        Date end = sdf.parse(date2);

        long cha = end.getTime() - start.getTime();

        if (cha < 0) {
            return false;
        }
        double result = cha * 1.0 / (100 * 60 * 60);
        if (result <= 24) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 日期转换成字符串
     * @param date
     * @return
     */
    public static String DateToStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(date);
        return str;
    }

    /**
     * 字符串转日期
     * @return
     */
    public static Date strToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
