package com.github.wikinray.redisLock.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by w on 2016/12/23.
 */
@Getter
@AllArgsConstructor
public enum  MonthType {

    JANUARY("JANUARY","Jan","一月"),
    FEBRUARY("FEBRUARY","Feb","二月"),
    MARCH("MARCH","Mar","三月"),
    APRIL("APRIL","Apr","四月"),
    MAY("MAY","May","五月"),
    JUNE("JUNE","Jun","六月"),
    JULY("JULY","Jul","七月"),
    AUGUST("AUGUST","Aug","八月"),
    SEPTEMBER("SEPTEMBER","Sep","九月"),
    OCTOBER("OCTOBER","Oct","十月"),
    NOVEMBER("NOVEMBER","Nov","十一月"),
    DECEMBER("DECEMBER","Dec","十二月");

    private String code;
    private String shortCode;
    private String message;

    public MonthType getType(String code){
        for(MonthType obj:MonthType.class.getEnumConstants()){
            if(obj.getCode().equalsIgnoreCase(code)){
                return obj;
            }
        }
        return null;
    }
}
