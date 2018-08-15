package com.cal.utils;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AnotherPojo {

     public AnotherPojo()
     {

     }
     String c;
     Long d;

     public String getC() {
         return c;
     }

     public void setC(String c) {
         this.c = c;
     }

     public Long getD() {
         return d;
     }

     public void setD(Long d) {
         this.d = d;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnotherPojo that = (AnotherPojo) o;

        if (getC() != null ? !getC().equals(that.getC()) : that.getC() != null) return false;
        return getD() != null ? getD().equals(that.getD()) : that.getD() == null;
    }

    @Override
    public int hashCode() {
        int result = getC() != null ? getC().hashCode() : 0;
        result = 31 * result + (getD() != null ? getD().hashCode() : 0);
        return result;
    }

    @Override
     public String toString() {
         return ToStringBuilder.reflectionToString(this);
     }
 }
