package Object_grammer09;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*******************************************************************
 * 함수형 인터페이스
 * 단 하나의 추상 메서드만 선언된 인터페이스
 * @FunctionalInterface
 ******************************************************************/
@FunctionalInterface
interface MyFunction{
    public abstract int max(int a, int b); // 몸통 X
}

public class ch14_05_함수형인터페이스 {
    public static void main(String[] args) {
        /*******************************************************************
         * 함수형 인터페이스 타입의 참조변수로 익명객체 생성
         ******************************************************************/
        MyFunction f = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };
        int value = f.max(3, 5); // 함수형 인터페이스에 max리모컨이 있음
        System.out.println("value = " + value);

        /*******************************************************************
         * 익명 객체를 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
         *
         * 함수형 인터페이스 타입의 참조변수로 람다식을 참조할 수 있다. (단 하나의 추상메서드)
         * 즉, 추상메서드를 통해서 람다식을 호출
         * (단, 함수형 인터페이스의 메서드와 람다식의 매개변수 개수와 반환타입이 일치해야함.)
         ******************************************************************/
        MyFunction f2 = (a, b) -> a > b ? a : b;
        int value2 = f2.max(3, 5); // 실제로는 람다식(익명 함수)이 호출됨
        System.out.println("value2 = " + value2);

        /*******************************************************************
         * 익명 객체를 람다식으로 대체
         ******************************************************************/
        List<String> list = Arrays.asList("abc", "aaa", "bbb", "ccc", "ddd");

        // 익명객체 생성
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(list);

        // 익명객체를 람다식으로 활용
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
        System.out.println(list);
    }
}
