package com.github.wikinray.redisLock.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by w on 2016/12/23.
 */
@Getter
@AllArgsConstructor
public enum WeekType {

    MONDAY("MONDAY","MON","周一"),
    TUESDAY("TUESDAY","TUE","周二"),
    WEDNESDAY("WEDNESDAY","WED","周三"),
    THURSDAY("THURSDAY","THU","周四"),
    FRIDAY("FRIDAY","FRI","周五"),
    SATURDAY("SATURDAY","SAT","周六"),
    SUNDAY("SUNDAY","SUN","周日");

    private String code;
    private String shortCode;
    private String message;

    public WeekType getType(String code){
        for(WeekType obj:WeekType.class.getEnumConstants()){
            if(obj.getCode().equalsIgnoreCase(code)){
                return obj;
            }
        }
        return null;
    }
}
