package Object_grammer06;

import java.util.ArrayList;
import java.util.Collections;

public class ch11_07_ArrayList {
    /*******************************************************************
     * ArrayList - 순서 ok, 중복 ok
     * ArrayList는 기존의 Vector를 개선한 것으로 구현원리와 기능적으로 동일
     * ArrayList와 달리 Vector는 자체적으로 동기화처리가 되어있다.
     * List인터페이스를 구현하므로, 저장순서가 유지되고 중복을 허용한다.
     * 데이터의 저장공간으로 배열을 사용한다.(배열기반)
     *******************************************************************/
    /*******************************************************************
     * ArrayList의 메서드
     * 추가 : boolean add(Obejct o), addAll(Collection c)
     * 삭제 : boolean remove(Object o), removeAll(Collection c), void clear()
     * 검색 : int indexOf(Object o), boolean contains(Object o), get(), set()
     *******************************************************************/
    public static void main(String[] args) {
        // 기본 길이(용량, capacity)가 10인 ArrayList를 생성
        ArrayList list1 = new ArrayList(10);
        // ArrayList에는 객체만 저장가능(autoboxing에 의해 기본형이 참조형으로 자동변환)
        list1.add(5);
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));
        list1.add(new Integer(5));
        
        // subList는 읽기 전용
        // ArrayList(Collection c)
        ArrayList list2 = new ArrayList(list1.subList(1, 4));
        print(list1, list2);

        /**
         * list1, list2를 오름차순 정렬
         */
        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        /**
         * containsAll()
         * 모든요소 포함여부 확인
         */
        System.out.println("list1.containsAll(list2) = " + list1.containsAll(list2));

        list2.add("B");
        list2.add("C");
        list2.add(3, "A");
        print(list1, list2);

        /**
         * 변경
         */
        list2.set(3, "AA");
        print(list1, list2);

        /**
         * indexOf()는 지정된 객체의 위치(인덱스)를 알려준다.
         */
        list1.add(0, "1");
        System.out.println("index = " + list1.indexOf("1"));
        System.out.println("index = " + list1.indexOf(1));

        /**
         * 삭제
         * 1. boolean remove(Object obj)
         * 2. Obejct remove(int index)
         */
        list1.remove(new Integer(1)); // 1
        list1.remove(0); // 2
        print(list1, list2);

        /**
         * list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제
         */
        System.out.println("list1.retainAll(list2) = " + list1.retainAll(list2));
        print(list1, list2);

        /**
         * list2에서 list1에 포함된 객체들을 삭제한다.
         */
        for(int i = list2.size()-1; i >= 0; i--){
            if (list1.contains(list2.get(i))) {
                list2.remove(i);
            }
        }
        /*******************************************************************
         * ArrayList에 저장된 객체의 삭제과정
         * 1. 삭제할 데이터 아래의 데이터를 한 칸씩 위로 복사해서 삭제할 데이터를 덮어쓴다.
         * 2. 데이터가 모두 한 칸씩 이동했으므로 마지막 데이터는 null로 변경한다.
         * 3. 데이터가 삭제되어 데이터의 개수가 줄었으므로 size의 값을 감소시킨다.
         *    마지막 데이터를 삭제하는 경우, 1의과정(배열의 복사)은 필요없다.
         *
         * ArrayList에 저장된 첫번째 객체부터 삭제하는 경우(배열 복사 발생)
         * ArrayList에 저장된 마지막 객체부터 삭제하는 경우(배열 복상 발생 X)
         *******************************************************************/
    }
    static void print(ArrayList list1, ArrayList list2){
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println();
    }
}
