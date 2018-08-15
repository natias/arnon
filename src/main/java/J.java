import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

public class J {

    Map<String, H> hMap=new HashMap<>();
    H h;
    String a;
    String b;

    public H getH() {
        return h;
    }

    public void setH(H h) {
        this.h = h;
    }


    public Map<String, H> gethMap() {
        return hMap;
    }

    public void sethMap(Map<String, H> hMap) {
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
        return ToStringBuilder.reflectionToString(this);
    }
}
