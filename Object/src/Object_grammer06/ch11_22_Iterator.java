package Object_grammer06;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class ch11_22_Iterator {
    /*******************************************************************
     * Iterator, ListIterator, Enumeration
     * - 컬렉션에 저장된 데이터를 접근하는데 사용되는 인터페이스
     * - 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화한 것
     * - 컬렉션에 iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용
     * 1. boolean hasNext() : 읽어 올 요소가 남아있는지 확인한다. 있으면 true, 없으면 false를 반환
     * 2. Obejct next() : 다음 요소를 읽어 온다.
     *
     * Enumeration은 Iterator의 구버젼
     * ListIterator는 Iterator의 접근성을 향상 시킨것 (양방향)
     *******************************************************************/
    /*******************************************************************
     * Map에는 iterator()가 없다.
     * entrySet(), KeySet(), values()를 호출해야 함
     *******************************************************************/
    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
        Collection list = new HashSet(); // Collection의 자손은 모두 이용가능
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator it = list.iterator();

        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }

        // iterator는 1회용 (재사용 불가)
        it = list.iterator();
        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}
