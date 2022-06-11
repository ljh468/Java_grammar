package Object_grammer09;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ch14_35_Optional객체02 {
  public static void main(String[] args) {
    Optional<String> optStr = Optional.of("abcde");
    Optional<Integer> optInt = optStr.map((s) -> s.length());
    System.out.println("optStr.get() = " + optStr.get());
    System.out.println("optInt.get() = " + optInt.get());

    int result1 = Optional.of("123")
                          .filter(x -> x.length() > 0) // true
                          .map(s -> Integer.parseInt(s)).get();

    int result2 = Optional.of("")
                          .filter(x -> x.length() > 0) // false
                          .map(s -> Integer.parseInt(s)).orElse(-1);

    System.out.println("result1 = " + result1);
    System.out.println("result2 = " + result2);

    Optional.of("456").map(s -> Integer.parseInt(s))
            .ifPresent(s -> System.out.printf("result3 = %d%n", s)); // 값이 있으면 출력

    OptionalInt optInt1 = OptionalInt.of(0); // 0을 저장
    OptionalInt optInt2 = OptionalInt.empty();     // 빈 객체를 생성

    System.out.println("optInt1.isPresent() = " + optInt1.isPresent()); // true
    System.out.println("optInt2.isPresent() = " + optInt2.isPresent()); // false

    System.out.println(optInt1.getAsInt());
    // System.out.println(optInt2.getAsInt()); // NoSuchElementException

    System.out.println("optInt1 = " + optInt1);
    System.out.println("optInt2 = " + optInt2);
    System.out.println("optInt1.equals(optInt2) = " + optInt1.equals(optInt2));

    OptionalInt optInt3 = OptionalInt.of(0);
    System.out.println("optInt1.equals(optInt3) = " + optInt1.equals(optInt3)); // 안의 값이 같으면 같음
  }
}
