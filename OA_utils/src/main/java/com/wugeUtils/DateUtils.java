package com.wugeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getDateStr(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(date);
    }
}
