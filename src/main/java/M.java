
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
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


        System.out.println("j "+j);

        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        Writer writer=new OutputStreamWriter(outputStream);


        objectMapper.writeValue(writer,j);


        System.out.println("properties representation \n"+new String(outputStream.toByteArray()));

        J newj=objectMapper.readValue(outputStream.toByteArray(),J.class);

        System.out.println("newj "+newj);
    }
}
