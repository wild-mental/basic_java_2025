package w3_2_collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSample {
    public static void main(String[] args) {
        // Map 자료형
        // {"":"", "":"", "":"", "":""}
        // 아래 구문은 Map 인터페이스에 구현체인 HashMap 객체를 생성해서 할당
        Map<String, Integer> myIntMap= new HashMap<>();

        myIntMap.put(null, 1);
        myIntMap.put("", 1);
        myIntMap.put("", 2);
        // 키가 중복 저장될 수 없다
        // -> put 메서드로 중복 키 할당 시 덮어쓰는 형태로 키 고유성 유지
        System.out.println(myIntMap);

        System.out.println(myIntMap.containsKey(""));
        System.out.println(myIntMap.containsKey(null));

        System.out.println(myIntMap.containsValue(1));
        System.out.println(myIntMap.containsValue(2));

        System.out.println(myIntMap.get(null));
        System.out.println(myIntMap.get(""));
        System.out.println(myIntMap.get("key not exist"));  // 없는 키 할당 시 null 리턴

        System.out.println(myIntMap.isEmpty());
        myIntMap.clear();
        System.out.println(myIntMap.isEmpty());

        myIntMap.put("A", 100);
        myIntMap.put("B", 200);
        myIntMap.put("C", 300);
        System.out.println(myIntMap);
        System.out.println(myIntMap.keySet());    // 키만 순회하고자 할 때 주로 사용
        System.out.println(myIntMap.values());    // 값만 순회하고자 할 때 주로 사용
                                                  // Collection 타입으로 리턴 -> Iterable 객체로 순회 가능
        myIntMap.remove("C");
        System.out.println(myIntMap.entrySet());  // Map 자체를 통째로 순회하고 싶을 때 사용하는 Set 객체 리턴
        System.out.println(myIntMap.entrySet().getClass());

//        myIntMap.put("A", 1);
//        myIntMap.put("B", 1);
//        myIntMap.put("C", 1);
//        myIntMap.put("D", 1);
//        myIntMap.put("E", 1);
//        System.out.println(myIntMap);
//
//        System.out.println(myIntMap.keySet() instanceof Set);
//        System.out.println(myIntMap.values() instanceof Collection<Integer>);
//        System.out.println(myIntMap.values());
//        System.out.println(myIntMap.entrySet() instanceof Set<Map.Entry<String, Integer>>);
    }
}
