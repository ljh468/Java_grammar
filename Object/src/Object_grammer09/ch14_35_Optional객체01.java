package Object_grammer09;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ch14_35_Optional객체01 {
  /*******************************************************************
   * Optional<T>
   * T타입 객체의 래퍼클래스, 모든 종류의 객체 저장가능
   * 1. null 을 직접다루는것은 위험 (NullPointerException)
   * 2. null 체크 -> if문 필수(코드가 지저분해짐)
   *******************************************************************/
  public static void main(String[] args) {

    /*******************************************************************
     * Optional<T> 객체를 생성하는 다양한 방법
     *******************************************************************/
    String str = "abc";
    Optional<String> optVal = Optional.of(str);
    Optional<String> optVal2 = Optional.of("abc");
    // Optional<String> optVal3 = Optional.of(null);         // NullPointerException 발생
    Optional<String> optVal4 = Optional.ofNullable(null); // OK
    Optional<String> optVal5 = Optional.ofNullable("abc"); // OK

    System.out.println("optVal = " + optVal);
    System.out.println("optVal2 = " + optVal2);
    // System.out.println("optVal3 = " + optVal3);
    System.out.println("optVal4 = " + optVal4);
    System.out.println("optVal5 = " + optVal5);

    /*******************************************************************
     * null대신 빈 Optional<T> 객체를 사용하자
     *******************************************************************/
    Optional<String> optVal6 = null;             // 널로 초기화, 바람직하지 않음
    Optional<String> optVal7 = Optional.empty(); // 빈 객체로 초기화

    /*******************************************************************
     * Optional객체의 값 가져오기 - get(), orElse(), orElseGet(), orElseThrow()
     *******************************************************************/
    Optional<String> optVal8 = Optional.of("abc");
    String str1 = optVal8.get();                                  // optVal8에 저장된 값을 반환. null이면 예외발생
    String str2 = optVal8.orElse("");                       // optVal8에 저장된 값이 null일 때는, ""를 반환
    String str3 = optVal8.orElseGet(String::new);                 // 람다식 사용가능 () -> new String()
    String str4 = optVal8.orElseThrow(NullPointerException::new); // 널이면 예외발생 (예외종류 지정가능)

    /*******************************************************************
     * isPresent() - Optional객체의 값이 null이면 false, 아니면 true를 반환
     * 널이 아닐때만 작업 수행, 널이면 아무일도 안함 (값이 있으면 true)
     *******************************************************************/
    if(Optional.ofNullable(str).isPresent()){ // if(str!==null)
      System.out.println(str);
    }

    /*******************************************************************
     * 실습
     *******************************************************************/
    // int[] arr = null;
    int[] arr = new int[0];
    System.out.println("arr.length = " + arr.length);

    // Optional<String> opt = null; // OK, 하지만 바람직X
    Optional<String> opt = Optional.empty(); // 빈 객체로 Optional객체 생성
    System.out.println("opt : " + opt);

    str = opt.orElse("EMPTY"); // Optional에 저장된 값이 null이면 "EMPTY" 반환
    System.out.println("str = " + str);

    str = opt.orElseGet(() -> new String());// Optional에 저장된 값이 null이면 String 객체 반환
    System.out.println("str = " + str);

    /*******************************************************************
     * 기본형 값을 감싸는 래퍼클래스 (성능때문에 사용)
     * OptionalInt, OptionalLong, OptionalDouble
     *
     * Optional의 값 가져오기 - int getAsInt()
     *******************************************************************/
    OptionalInt o1 = OptionalInt.of(1);
    System.out.println("o1.getAsInt() = " + o1.getAsInt());
    OptionalLong o2 = OptionalLong.of(1);
    System.out.println("o2.getAsLong() = " + o2.getAsLong());
    OptionalDouble o3 = OptionalDouble.of(1);
    System.out.println("o3.getAsDouble() = " + o3.getAsDouble());

    /*******************************************************************
     * 빈 Optional객체 와의 비교
     *******************************************************************/
    OptionalInt opt1 = OptionalInt.of(0);    // OptionalInt에 0을 저장
    OptionalInt opt2 = OptionalInt.empty();

    System.out.println("opt1.isPresent() = " + opt1.isPresent()); // true
    System.out.println("opt2.isPresent() = " + opt2.isPresent()); // false
    System.out.println("opt1.equals(opt2) = " + opt1.equals(opt2)); // false
  }
}
