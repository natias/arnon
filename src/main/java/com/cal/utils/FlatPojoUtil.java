package com.cal.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class FlatPojoUtil {

    ObjectMapper objectMapper = new ObjectMapper(new JavaPropsFactory());

    public Map<String, String> toMap(Object o) {

        try {


            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Writer writer = new OutputStreamWriter(outputStream);


            objectMapper.writeValue(writer, o);


            Properties p = new Properties();
            p.load(new ByteArrayInputStream(outputStream.toByteArray()));

            Map<String, String> mapOfProperties = new LinkedHashMap(p);

            return mapOfProperties;

        } catch (IOException e) {
            e.printStackTrace();
        }

    return null;
    }



    public Object toObj(Map<String, String> m,Class c) {

        try {

            ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();

            m.forEach((s, s2) ->
                    {
                        try {
                            outputStream2.write((s + "=" + s2 + "\n").getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );

            System.out.println("load back from properties");
            Object newj = objectMapper.readValue(outputStream2.toByteArray(), c);

            return newj;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }




    public static void main(String[] args) throws IOException {


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
        anotherPojo2.setC("");
        anotherPojo.setD(0L);


        System.out.println("original:\n"+ pojo);


        FlatPojoUtil flatPojoUtil =new FlatPojoUtil();

        POJO newj= (POJO) flatPojoUtil.toObj(flatPojoUtil.toMap(pojo), pojo.getClass());


        System.out.println(flatPojoUtil.toMap(pojo));


        System.out.println("to map and back to obj:\n" + newj);

        System.out.println(newj.equals(pojo));

    }
}
