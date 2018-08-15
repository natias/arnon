package com.cal.utils;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

public class POJO {

    Map<String, AnotherPojo> hMap=new HashMap<>();
    AnotherPojo anotherPojo;
    String a;
    String b;

    public AnotherPojo getAnotherPojo() {
        return anotherPojo;
    }

    public void setAnotherPojo(AnotherPojo anotherPojo) {
        this.anotherPojo = anotherPojo;
    }


    public Map<String, AnotherPojo> gethMap() {
        return hMap;
    }

    public void sethMap(Map<String, AnotherPojo> hMap) {
        this.hMap = hMap;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
