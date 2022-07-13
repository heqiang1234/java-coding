package hq.java;

import org.apache.commons.collections.map.HashedMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author HQ
 * @program: java-coding
 * @description: map
 * @date 2022-07-12 23:03:33
 */
public class MapTest {

    public static void main(String args) {
        Map<String,Integer> map = new HashedMap();
        Set<String> set = map.keySet();

        Iterator<String> iterator = set.iterator();


        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String,Integer> m : entries ){
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }
}
