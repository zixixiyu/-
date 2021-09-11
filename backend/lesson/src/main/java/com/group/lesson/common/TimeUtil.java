package com.group.lesson.common;

import java.util.Date;

/**
 * @Author: hwj
 * @Date: 2021/9/11 18:38
 */
public class TimeUtil {
    public static Integer twoDaySub(Date begin,Date end){
        return (int)((end.getTime()-begin.getTime())/(60*60*24*1000L));
    }
}
