package top.moxingwang.simplemock.client.serialization;

import org.junit.Test;
import top.moxingwang.simplemock.core.serialization.FastJSONSerialization;

import java.util.HashMap;
import java.util.Map;

public class FastJSONSerializationTest {
    @Test
    public void test() {
        FastJSONSerialization fastJSONSerialization = new FastJSONSerialization();
        Map<String, String> map = new HashMap<>();
        map.put("key1", "string1");
        map.put("key2", "string2");
        map.put("key3", "string3");

        System.out.println(new String(fastJSONSerialization.serialize(map)));
    }
}
