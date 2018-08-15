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
     public String toString() {
         return ToStringBuilder.reflectionToString(this);
     }
 }
