import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_05 {
    public static void main(String[] args) {

        /*******************************************************************
         * 스트림(Stream)의 최종연산 - forEach()
         *
         * 스트림의 모든 요소에 지정된 작업을 수행
         * forEach() : 병렬스트림인 경우 순서가 보장되지 않음
         * forEachOrdered() : 병렬스트림인 경우에도 순서가 보장됨
         * *******************************************************************/
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

//        Stream.of(strArr).forEach(System.out::println);
        Stream.of(strArr)
                .parallel()
                .forEachOrdered(System.out::println); // 병렬처리를 하면 순서가 달라지기때문에 forEachOrdered 사용

        /*******************************************************************
         * 조건검사
         * allMatch() : 모든 요소가 조건을 만족시키면 true
         * anyMatch() : 한 요소라도 조건을 만족시키면 true
         * noneMatch() : 모든 요소가 조건을 만족시키지 않으면 true
         * 
         * 조건에 일치하는 요소 찾기
         * findFirst() : 첫 번째 요소를 반환, 순차 스트림에 사용
         * findAny() : 아무거나 하나를 반환, 병렬 스트림에 사용
         *******************************************************************/
        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0); // 문자열 길이가 0인 요소가 하나도 없는지 확인
        Optional<String> sWord = Stream.of(strArr)
                                    .filter(s -> s.charAt(0) == 's').findFirst();
        System.out.println("noEmptyStr = " + noEmptyStr);
        System.out.println("sWord.get() = " + sWord.get());

        /*******************************************************************
         * 스트림(Stream)의 최종연산 - reduce()
         *
         * 스트림의 요소를 하나씩 줄여가며 누적연산(accumulate) 수행
         * identity : 초기값 (null이 초기값일 수 있음)
         * accumulator : 이전 연산결과와 스트림의 요소에 수행할 연산
         * combiner : 병렬처리된 결과를 합치는데 사용할 연산(병렬 스트림)
         * *******************************************************************/

        /**
         * Stream<String>을 Stream<Integer>로 변환
         */
        Stream<Integer> intSream = Stream.of(strArr).map(String::length);

        /**
         * Stream<String>을 IntStream으로 변환
         * (String s) -> (s.length())
         */
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a, b) -> a + 1);
        int sum = intStream2.reduce(0, (a, b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);
        OptionalInt empty = IntStream.empty().reduce(Integer::max);
        OptionalInt empty2 = IntStream.empty().reduce(Integer::max);

        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
        System.out.println("max = " + max.getAsInt());
        System.out.println("min = " + min.getAsInt());
        System.out.println("empty.orElse(0) = " + empty.orElse(0));
        System.out.println("empty2.orElseGet(() -> 0) = " + empty2.orElseGet(() -> 0));

    }
}

