package hashmap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class AboutHashMap {


    /**
     * 测试map的put方法返回值
     */
    @Test
    public void testPutResult() {
        Map<String,String> map1 = new HashMap();
        map1.put("name","王磊");
        String oldvalue = map1.put("name","李磊");
        System.out.println(oldvalue);
    }
}
