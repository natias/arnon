package com.cal.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TestFlatPojoUtil {

    @Test
    public void check() {

        // build a pojo
        POJO pojo = new POJO();
        pojo.a = "aa";
        pojo.b = "bb";
        AnotherPojo anotherPojo = new AnotherPojo();
        AnotherPojo anotherPojo2 = new AnotherPojo();
        final int[] i = {0};
        pojo.sethMap(Arrays.asList(anotherPojo2, anotherPojo).stream().collect(Collectors.toMap(o -> "A" + i[0]++, o -> o)));
        pojo.setAnotherPojo(anotherPojo);
        anotherPojo.setC("CC");
        anotherPojo.setD(122L);

        anotherPojo2.setC("jjh");
        anotherPojo2.setD(123L);

        FlatPojoUtil flatPojoUtil = new FlatPojoUtil();

        POJO pojo1 = (POJO) flatPojoUtil.toObj(flatPojoUtil.toMap(pojo), pojo.getClass());

        Assert.assertEquals(pojo1,pojo);

        }
}
