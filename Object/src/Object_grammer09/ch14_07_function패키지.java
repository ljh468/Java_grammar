package Object_grammer09;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ch14_07_function패키지 {
    /*******************************************************************
     * java.util.function 패키지
     * 자주 사용되는 다양한 함수형 인터페이스를 제공
     * Runnable : 매개변수도 없고, 반환값도 없음
     * Supplier<T> : 매개변수는 없고, 반환값만 있음
     * Consumer<T> : Supplier와 반대로 매개변수만 있고, 반환값이 없음
     * Function<T, R> : 일반적인 함수. 하나의 매개변수를 받아서 결과를 반환
     * Predicate<T> :
     *                ex : Predicate<String> isEmptyStr = s -> s.length() == 0
     ******************************************************************/
    /*******************************************************************
     * 매개변수의 타입과 반환타입이 일치하는 함수형 인터페이스
     * UnaryOperator<T> : Function의 자손. Function과 달리 매개변수와 결과의 타입이 같다.
     * BinaryOperator<T> : BiFunction의 자손. BiFunction과 달리 매개변수와 결과의 타입이 같다.
     ******************************************************************/
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1; // 1~100난수
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0;                      // 짝수인지 검사
        Function<Integer, Integer> f = i -> i/10*10; // i의 일의자리를 버림

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);  // 리스트를 랜덤값으로 채움
        System.out.println(list);
        printEvenNum(p, c, list); // 짝수를 출력
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list){
        List<T> newList = new ArrayList<>();
        for(T i : list){
            newList.add(f.apply(i));
        }
        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list){
            if(p.test(i)) // 짝수인지 검사
                c.accept(i);
        }
    }
    static <T> void makeRandomList(Supplier<T> s, List<T> list){
        for (int i = 0; i < 10; i++) {
            list.add(s.get()); // Supplier로 부터 1~100의 난수를 받아서 list에 추가
        }
    }
}
