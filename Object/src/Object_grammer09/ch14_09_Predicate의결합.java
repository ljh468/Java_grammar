package Object_grammer09;

import java.util.function.Function;
import java.util.function.Predicate;

public class ch14_09_Predicate의결합 {
    /*******************************************************************
     * Predicate의 결합
     * 조건식을 표현하는데 사용됨. 매개변수는 하나, 반환타입은 boolean
     * and(), or(), negate()로 두 Predicate를 하나로 결합(default메서드)
     * 등가비교를 위한 Predicate의 작성에는 isEqual()를 사용(static메서드)
     ******************************************************************/
    public static void main(String[] args) {
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16); // 16진수로 변환
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i); // 2진수로 변환

        Function<String, String> h = f.andThen(g); // f가 먼저
        Function<Integer, Integer> h2 = f.compose(g); // g가 먼저

        System.out.println(h.apply("FF")); // "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2));   // 2 -> "10" -> 16

        Function<String, String> f2 = x -> x; // 항등함수(identity function)
        System.out.println(f2.apply("AAA"));

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate(); // i >= 100 (p의 not)

        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));

        String str1 = new String("abc");
        String str2 = "abc";

        // str1과 str2가 같은지 비교한 결과를 반환
        Predicate<String> p2 = Predicate.isEqual(str1);
        boolean result = p2.test(str2);
        boolean result2 = Predicate.isEqual(str1).test(str2);
        boolean result3 = str1.equals(str2);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
}

