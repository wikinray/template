package com.github.wikinray.template.test.redis.wikinray.template.domain.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by w on 2017/1/3.
 * 节假日工具类
 */
public class HolidayUtils {

    /**
     * 工作日计算
     * @param calendar
     * @return
     */
    public Calendar addWorkDay(Calendar calendar,int day){
        for(int i=0;i<day;i++){
            calendar.add(Calendar.DAY_OF_MONTH,1);
            //节假日取配置数据
            if(checkHoliday(calendar,new ArrayList<Calendar>())){
                i--;
            }
        }
        return calendar;
    }

    /**
     * //判断周六日
     * //判断节假日
     * @param calendar
     * @param holidayList
     * @return
     */
    public boolean checkHoliday(Calendar calendar,List<Calendar> holidayList){
        if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY||
                calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
            return true;
        }
        for (Calendar holiday:holidayList){
            if(calendar.get(Calendar.DAY_OF_MONTH)==holiday.get(Calendar.DAY_OF_MONTH)&&
                    calendar.get(Calendar.MONTH)==holiday.get(Calendar.MONTH)&&
                    calendar.get(Calendar.YEAR)==holiday.get(Calendar.YEAR)){
                return true;
            }
        }
        return false;
    }
}
