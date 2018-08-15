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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        POJO pojo = (POJO) o;

        if (gethMap() != null ? !gethMap().equals(pojo.gethMap()) : pojo.gethMap() != null) return false;
        if (getAnotherPojo() != null ? !getAnotherPojo().equals(pojo.getAnotherPojo()) : pojo.getAnotherPojo() != null)
            return false;
        if (getA() != null ? !getA().equals(pojo.getA()) : pojo.getA() != null) return false;
        return getB() != null ? getB().equals(pojo.getB()) : pojo.getB() == null;
    }

    @Override
    public int hashCode() {
        int result = gethMap() != null ? gethMap().hashCode() : 0;
        result = 31 * result + (getAnotherPojo() != null ? getAnotherPojo().hashCode() : 0);
        result = 31 * result + (getA() != null ? getA().hashCode() : 0);
        result = 31 * result + (getB() != null ? getB().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
