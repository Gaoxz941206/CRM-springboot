package com.myself.crm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-24 10:13
 * @apiNote
 */
public class DateTimeUtil {

    //获取当前时间
    public static String CURRENT_TIME(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(new Date());
    }
    //获取当前日期
    public static String CURRENT_DATE(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
}
