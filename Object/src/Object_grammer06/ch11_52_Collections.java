package Object_grammer06;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

// Collections를 생략가능
import static java.util.Collections.*;

public class ch11_52_Collections {
    /*******************************************************************
     * Collections
     *
     * 컬렉션을 위한 메서드(static)을 제공
     * 1. 컬렉션 채우기, 복사, 정렬, 검색 : fill(), copy(), sort(), binarysearch() 등
     * 2. 컬렉션의 동기화 : synchronizedXXX()
     *    ex ) List syncList = Collections.synchronizedList(new ArrayList());
     * 3. 변경불가(readOnly) 컬렉션 만들기 : unmodifiableXXX()
     * 4. 싱글콘 컬렉션 만들기 : singletonXXX()
     * 5. 한 종류의 객체만 저장하는 컬렉션 만들기 : checkedXXX()
     *    ex ) List checkedList = checkedList(new ArrayList(), String.class); // string만 저장가능
     *******************************************************************/
    /*******************************************************************
     * 컬렉션 클래스 정리 & 요약
     *
     * 배열기반 Collection : ArrayList, Vector -> Stack
     * ArrayList 추가, 삭제 기능 향상 -> LinkedList -> Queue
     * ArrayList 검색 기능 향상 -> HashMap (배열 + 링크드리스트)
     * LinkedList 검색, 범위검색, 정렬 기능 향상 -> TreeMap (중위 순회하면 정렬됨)
     * Map에서 key부분만으로 만듬 -> HashSet, TreeSet
     * Properties(String, String) : 파일 읽기와 쓰기에 용이한 Map 구조
     * HashMap 순서유지 기능 향상 -> LinkedHashMap
     * HashSet 순서유지 기능 향상 -> LinkedHashSet
     *******************************************************************/
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println("list = " + list);

        addAll(list, 1, 2, 3, 4, 5);
        System.out.println("list = " + list);

        rotate(list, 2);                // 반시계반향으로 두번 회전
        System.out.println("list = " + list);

        swap(list, 0, 2);                 // 첫 번째와 세 번째를 교환
        System.out.println("list = " + list);

        shuffle(list);                         // 저장된 요소의 위치를 임의로 변경
        System.out.println("list = " + list);

        sort(list, reverseOrder());            // 역순정렬 reverse(list);
        System.out.println("list = " + list);

        sort(list);                            // 정렬
        System.out.println("list = " + list);

        int idx = binarySearch(list, 3);   // 3이 저장된 위치
        System.out.println("index of 3 = " + idx);

        System.out.println("max(list) = " + max(list));
        System.out.println("min(list) = " + min(list));
        System.out.println("max(list, reverseOrder()) = " + max(list, reverseOrder()));

        fill(list, 9);                    // list를 9로 채움
        System.out.println("list" + list);

        // list와 같은 크기의 새로운 list를 생성하고 2로 채운다. 단, 결과는 변경불가
        List newList = nCopies(list.size(), 2);
        System.out.println("newList = " + newList);

        // 공통요소가 없으면 true
       System.out.println("disjoint(list, newList) = " + disjoint(list, newList));
        
       // newList를 복사해서 list에 저장
        copy(list, newList);
        System.out.println("newList = " + newList);
        System.out.println("list = " + list);

        replaceAll(list, 2, 1);
        System.out.println("list = " + list);

        Enumeration e = enumeration(list);
        ArrayList list2 = list(e);
        System.out.println("list2 = " + list2);
    }
}
