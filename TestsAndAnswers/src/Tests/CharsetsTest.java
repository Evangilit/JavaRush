package Tests;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

public class CharsetsTest {
    public static void main(String[] args) {
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (Map.Entry<String, Charset> pair: map.entrySet()){
            System.out.println(pair.getKey() + " = " + pair.getValue().toString());
        }
    }
}
