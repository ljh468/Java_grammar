import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 함수형 인터페이스 : 단 하나의 추상 메서드만 선언된 인터페이스
@FunctionalInterface
interface MyFunction {
//        public abstract int max(int a, int b);
    int max(int a, int b);
}

public class lambda_00 {
    public static void main(String[] args) {
        /**
         * 익명객체를 생성 ( 자바에서 메서드는 객체 안에 있어야함 )
         * 객체를 다루기위한 참조변수 필요
         */
//        Object obj = (a, b) -> a > b ? a : b; // 람다식 (익명객체)
//
//        Object obj = new Object() {
//            int max(int a, int b) {
//                return a > b ? a : b;
//            }
//        };
        /**
         * Object객체안에는 max 리모컨이 없다.
         * 메서드를 다루기위해서는 함수형 인터페이스가 필요
         */
//        int value = obj.max(3, 5);

        /**
         * 함수형 인터페이스 타입의 참조변수로 람다식을 참조할 수 있음 (매개변수 개수와 반환타입이 같아야함)
         */
        MyFunction f = new MyFunction() {
            public int max(int a, int b) { // 오버라이딩 규칙 ( 접근제어자는 좁게 바꾸지 못한다. )
                return a > b ? a : b;
            }
        };
        int value = f.max(3, 5); // 실제로는 람다식(익명 함수)이 호출됨
        System.out.println("value : " + value);

        /**
         * 람다식 (익명객체) 활용
         * 람다식을 다루기 위한 참조변수의 타입은 함수형인터페이스로 한다.
         */
        MyFunction f2 = (a, b) -> a > b ? a : b;
        int value2 = f.max(3, 5); // 실제로는 람다식(익명 함수)이 호출됨
                                        // 람다식과 함수형 인터페이스의 반환타입과 매개변수의 개수는 같아야함
        System.out.println("value2 : " + value2);

        /**
         * 함수형 인터페이스 - example
         * 익명 객체를 람다식으로 대체
         */
        List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
        Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
        System.out.println("list = " + list);

    }

}
