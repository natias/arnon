
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class M {

    public static void main(String[] args) throws IOException {


        ObjectMapper objectMapper=new ObjectMapper(new JavaPropsFactory());
        J j=new J();
        j.a="aa";
        j.b="bb";
        H h= new H();
        H h2= new H();

        final int[] i = {0};
        j.sethMap(Arrays.asList(h2,h).stream().collect(Collectors.toMap(o->"A"+ i[0]++, o->o)));
        j.setH(h);
        h.setC("CC");
        h.setD(122L);


        System.out.println("j is "+j);

        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        Writer writer=new OutputStreamWriter(outputStream);


        objectMapper.writeValue(writer,j);


        System.out.println("properties representation of j\n"+new String(outputStream.toByteArray()));



        Properties p=new Properties();
        p.load(new ByteArrayInputStream(outputStream.toByteArray()));

        Map<String, String> mapOfProperties = new LinkedHashMap(p);


        System.out.println("j as map: "+mapOfProperties);


        System.out.println("save map as properties");

        ByteArrayOutputStream outputStream2=new ByteArrayOutputStream();
        //Writer writer=new OutputStreamWriter(outputStream);

        mapOfProperties.forEach((s, s2) ->
                {
                    try {
                        outputStream2.write((s+"="+s2+"\n").getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        System.out.println("load back from properties");
        J newj=objectMapper.readValue(outputStream2.toByteArray(),J.class);

        System.out.println("newj is "+newj);
    }
}
