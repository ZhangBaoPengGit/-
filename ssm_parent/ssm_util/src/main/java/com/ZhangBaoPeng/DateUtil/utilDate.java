package com.ZhangBaoPeng.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 张宝鹏
 * @date 2018/11/24 9:41
 */
public class utilDate {

    public static String dateForMart(Date date){

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
