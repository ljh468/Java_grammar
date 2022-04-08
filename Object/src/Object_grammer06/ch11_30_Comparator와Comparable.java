package Object_grammer06;

import java.util.Arrays;
import java.util.Comparator;

public class ch11_30_Comparator와Comparable {
    /*******************************************************************
     * Comparator와 Comparable
     * 객체 정렬에 필요한 메서드(정렬기준 제공)를 정의한 인터페이스
     * Comparable : 기본 정렬기준을 구현하는데 사용
     * Comparator : 기본 정렬기준 외에 다른 기준으로 정렬하고자 할 때 사용
     * - int compare(Object o1, Object o2) // o1, o2 두 객체를 비교
     * - int compareTo(Object o)           // 주어진 객체(o)를 자신과 비교
     *******************************************************************/
    /*******************************************************************
     * compare()와 compareTo()는 두객체의 비교결과를 반환하도록 작성
     * (같으면 0, 오른쪽이 크면 음수(-), 작으면 양수(+) - 양수면 자리바꿈
     *******************************************************************/
    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr); // String의 Comparable구현에 의한 정렬 (정렬기준 사전순으로 되어있음)
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대,소문자 구분없이 정렬
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending()); // 역순정렬
        System.out.println("strArr = " + Arrays.toString(strArr));
    }
}

class Descending implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Comparable && o2 instanceof Comparable){
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;

            // -1을 곱해서 기본정렬방식의 역으로 변경한다.
            // 또는 c2.compareTo(c1)와 같이 순서를 바꿔도 된다.
            return c1.compareTo(c2) * -1;
       }
        return -1;
    }
}