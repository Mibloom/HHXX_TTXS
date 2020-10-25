import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/10/13 19:09
 **/
public class MapAPI {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("cKey","cValue");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key","value");
        ArrayList<String> list = new ArrayList<>();
        list.add("LPK");
        list.add("LPK");
        list.size();
    }
}
