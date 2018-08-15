import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.stream.Collectors;

public class M {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
        J j=new J();
        j.a="aa";
        j.b="bb";
        J.H h= new J.H();
        J.H h2= new J.H();

        final int[] i = {0};
        j.sethMap(Arrays.asList(h2,h).stream().collect(Collectors.toMap(o->""+ i[0]++, o->o)));
        h.setC("CC");
        h.setD(122L);


        System.out.println("j "+j);

        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        Writer writer=new OutputStreamWriter(outputStream);


        objectMapper.writeValue(writer,j);


        System.out.println("yaml representation \n"+new String(outputStream.toByteArray()));

        J newj=objectMapper.readValue(outputStream.toByteArray(),J.class);

        System.out.println("newj "+newj);
    }
}
