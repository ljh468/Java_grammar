import javax.swing.text.html.Option;
import java.io.File;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Stream_05 {
    public static void main(String[] args) {

        /*******************************************************************
         * Optional<T>
         * T타입 객체의 래퍼클래스 (모든 종류의 객체 or null을 저장할 수 있음)
         * 1. null을 직접 다루는것은 위험 (간접적으로 null을 다루기 위함)
         * 2. null값을 직접 다루면 if 문을 이용한 null 체크 필수
         *******************************************************************/

        /*******************************************************************
         * Optional<T> 객체 생성하기
         *******************************************************************/
        String str = "abc";
        Optional<String> optVal = Optional.of(str);
        Optional<String> optVal1 = Optional.of("abc");
        // Optional<String> optVal2 = Optional.of(null); // NullPointerExcetion발생
        Optional<String> optVal3 = Optional.ofNullable(null); // OK

        /**
         * Null 대신 빈 Optional<T> 객체를 사용해야 함
         */
        Optional<String> optVal4 = null; // null 초기화, 바람직하지않음
        Optional<String> optVal5 = Optional.empty(); // 빈 객체로 초기화

        /*******************************************************************
         * Optional<T> 객체의 값 가져오기
         * get(), orElse(), orElseGet(), orElseThrow()
         *******************************************************************/
        Optional<String> optVal6 = Optional.of("abc");
        String str1 = optVal6.get(); // optVal에 저장된 값을 반환, null이면 예외발생
        String str2 = optVal6.orElse(""); // optVal에 저장된 값이 null 일때는, ""를 반환
        String str3 = optVal6.orElseGet(String::new); // 람다식 사용가능 () -> new String()
        String str4 = optVal6.orElseThrow(NullPointerException::new); // 널이면 예외 발생 ( 예외종류 지정자가능 )


        /**
         * isPresent() - Optional객체의 값이 null 이면 false, 아니면 true를 반환
         * if(str !=null)
         */
        str = "abc";
        if(Optional.ofNullable(str).isPresent()){
            System.out.println(str);
        }

        /**
         * ifPresent() - Optional 객체의 값이 null이 아닐때만 작업 수행, 널이면 아무일도 안함
         */
        str2 = null;
//        Optional.ofNullable(str2).ifPresent(System.out::println); // 람다식
        Optional.ofNullable(str2).ifPresent((v) -> System.out.println(v));

        /*******************************************************************
         * 실습
         *******************************************************************/
//        int[] arr = null;
        int[] arr = new int[0]; // null 이 아니게때문에 에러가 나지 않음
        System.out.println("arr.length = " + arr.length);

//        Optional<String> opt = null; // Ok, 하지만 바람직하지 않음
        Optional<String> opt = Optional.empty();
//        Optional<String> opt = Optional.of("abc");
        System.out.println("opt = " + opt); // Optional.empty 값 반환
//        System.out.println("opt.get() = " + opt.get()); // no value present 예외발생

        /**
         * try catch 문 사용
         */
//        str = "";
//        try {
//            str = opt.get();
//        } catch (Exception e) {
//            str  = ""; // 예외가 발생하면 빈문자열("")로 초기화
//        }

        /**
         * orElse(), orElseGet() 사용
         */
//        str = opt.orElse(""); // Optional에 저장된 값이 null이면 ""반환
//        str = opt.orElseGet(() -> new String());
        str = opt.orElseGet(String::new);
        System.out.println("str = " + str);
        
        /*******************************************************************
         * OptionalInt, OptionalLong, OptionalDouble
         * 기본형 값을 감싸는 래퍼 클래스 (성능을 위해 사용)
         *******************************************************************/
        OptionalInt optInt1 = OptionalInt.of(0);
        OptionalInt optInt2 = OptionalInt.empty();

        int su = optInt1.getAsInt();
        System.out.println("su = " + su);

        /**
         * 빈 Optional객체와의 비교
         * 0과 empty의 value는 같지만 isPresent()메서드를 통해 비교할 수 있는
         */
        System.out.println("optInt1.isPresent() = " + optInt1.isPresent());   // true
        System.out.println("optInt2.isPresent() = " + optInt2.isPresent()); // false
        System.out.println("equals = " + optInt1.equals(optInt2));           // false

        /*******************************************************************
         * 실습
         *******************************************************************/
        Optional<String> optStr = Optional.of("abcde");
//        Optional<Integer> optInt = optStr.map(String::length);
        Optional<Integer> optInt = optStr.map(s -> s.length());
        System.out.println("optStr = " + optStr.get());
        System.out.println("optInt = " + optInt.get());

        int result1 = Optional.of("123")
                            .filter(x -> x.length() > 0)
                            .map(Integer::parseInt).get();

        int result2 = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).orElse(-1);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);

        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x -> System.out.printf("result3 = %d%n", x));

        optInt1 = OptionalInt.of(0);
        optInt2 = OptionalInt.empty();
        System.out.println("optInt1.isPresent() = " + optInt1.isPresent()); // true
        System.out.println("optInt2.isPresent() = " + optInt2.isPresent()); // false

        System.out.println("optInt1.getAsInt() = " + optInt1.getAsInt()); // 0
//        System.out.println("optInt2.getAsInt() = " + optInt2.getAsInt()); // no suchElementException
        System.out.println("optInt1 = " + optInt1);
        System.out.println("optInt2 = " + optInt2);
        System.out.println("optInt1.equals(optInt2) = " + optInt1.equals(optInt2));
    }
}

