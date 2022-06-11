package Object_grammer09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ch14_40_스트림의최종연산 {
    /*******************************************************************
     * 스트림의 최종연산
     * 중간연산 : n번, 최종연산 : 1번(스트림 요소 소모)
     *******************************************************************/
    public static void main(String[] args) {

        /********************************************************************
         * 스트림의 모든 요소에 지정된 작업을 수행
         * void forEach(Consumer<? super T> action)        // 병렬스트림인 경우 순서가 보장되지 않음
         * void forEachOrdered(Consumer<? super T> action  // 병렬스트림인 경우에도 순서가 보장
         ********************************************************************/
        IntStream.range(1, 10).sequential().forEach(System.out::print);      //  직렬처리 123456789
        System.out.println();
        IntStream.range(1, 10).parallel().forEach(System.out::print);        //  병렬처리 589671432
        System.out.println();
        IntStream.range(1, 10).parallel().forEachOrdered((s) -> System.out.print(s)); //  병렬처리 589671432
        System.out.println();

        /*******************************************************************
         * 조건검사 - allMatch(), anyMatch(), noneMatch()
         * boolean allMath (Predicate<? super T> predicate) (조건식)    // 모든 요소가 조건을 만족시키면 true
         * boolean anyMath (Predicate<? super T> predicate)           // 한 요소가 조건을 만족시키면 true
         * boolean nonMath (Predicate<? super T> predicate)           // 모든 요소가 조건을 만족시키면 true
         *******************************************************************/
        Student[] stu = new Student[]{
                new Object_grammer09.Student("이자바", 3, 100),
                new Object_grammer09.Student("김자바", 1, 89),
                new Object_grammer09.Student("안자바", 2, 58),
                new Object_grammer09.Student("박자바", 2, 92),
                new Object_grammer09.Student("소자바", 1, 77),
                new Object_grammer09.Student("나자바", 3, 25)
        };
        Stream<Object_grammer09.Student>stuStream = Arrays.stream(stu);
        boolean hasFailedStu = stuStream.anyMatch(s -> s.getTotalScore() <= 60); // 낙제자가 있는지?
        System.out.println("hasFailedStu = " + hasFailedStu);

        /********************************************************************
         * 조건에 일치하는 요소 찾기 - findFirst(), findAny()
         * Optional<T> findFirst    // 첫번째 요소를 반환, 순차 스트림에 사용
         * Optional<T> findAny()    // 아무거나 하나를 반환, 병렬 스트림에 사용
         ********************************************************************/
        Stream<Object_grammer09.Student>stuStream2 = Arrays.stream(stu);
        Optional<Student> result = stuStream2.filter(s -> s.getTotalScore() <= 60).findFirst();
        System.out.println(result.get().toString());

        /*********************************************************************
         * 스트림의 최종연산 - reduce()
         * 스트림의 요소를 하나씩 줄여가며 누적연산 수행
         * Optional<T> reduce(BinaryOperator<T> accumulator)
         * T           reduce(T identity, BinaryOperator<T> accumulator)
         * U           reduce(U identity, BiFunction<U, T, T> accumulator, BinaryOperator<U> combiner)
         * identity : 초기값
         * accumulator : 이전 연산결과와 스트림의 요소에 수행할 연상
         * combiner : 병렬처리된 결과를 합치는데 사용할 연산(병렬 스트림)
         *********************************************************************/
        System.out.println();
        String[] strArr = {
                "Ingeritance", "Java", "Lambda", "stream", "OptionalDouble", "IntStream", "count", "sum"
        };
        Stream.of(strArr)
                .parallel() // 병렬로 처리
                .forEach(System.out::println); // 순서유지 : forEachOrdered()

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0); // 0인 값이 하나라도 있으면 false
        Optional<String> sword = Stream.of(strArr).filter(s -> s.charAt(0) == 's').findFirst();

        System.out.println("noEmptyStr = " + noEmptyStr);
        System.out.println("sword.get() = " + sword.get());

        // Stream<String>을 Stream<Integer>으로 변환
        Stream<Integer> intStream0 = Stream.of(strArr).map(String::length);

        // Stream<String>을 IntStream으로 변환 (IntStream 기본형 스트림)
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a, b) -> a + 1);
        int sum = intStream2.reduce(0, (a, b) -> a + b);
        OptionalInt max = intStream3.reduce((iStr1, iStr2) -> Integer.max(iStr1, iStr2));
        OptionalInt min = intStream4.reduce(Integer::min);
        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
        System.out.println("max.orElse = " + max.orElse(0));
        System.out.println("max.orElseGet = " + max.orElseGet(() -> 0)); // supplier (공급자)
        System.out.println("min = " + min);
        System.out.println("min.getAsInt() = " + min.getAsInt());

    }
}
