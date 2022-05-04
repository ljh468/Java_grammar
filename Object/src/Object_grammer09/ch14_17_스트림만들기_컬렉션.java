package Object_grammer09;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ch14_17_스트림만들기_컬렉션 {
    public static void main(String[] args) {
        /*******************************************************************
         * 스트림 만들기 - 컬렉션
         * - Collection인터페이스의 stream() 메서드로 컬렉션을 스트림으로 반환
         * - list.stream();
         ******************************************************************/
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStr = list.stream(); // list를 Stream으로 변환
        intStr.forEach(System.out::print); // forEach() 최종연산

        // Stream은 1회용, Stream에 대해 최종연산을 수행하면 stream이 닫힌다.
        intStr = list.stream();
        intStr.forEach(System.out::print);
        System.out.println();

        /*******************************************************************
         * 스트림 만들기 - 배열
         * - Stream.of(T ... value) // 가변인자
         * - Stream.of(T[])
         * - Arrays.stream(T[])
         * - Arrays.stream(T[], start, end)
         ******************************************************************/
//        Stream<String> strStream = Stream.of("a", "b", "c");
//        Stream<String> strStream = Stream.of(new String[] {"a", "b", "c"});
        Stream<String> strStream = Arrays.stream(new String[]{"a", "b", "c"});
        strStream.forEach(System.out::println);
        
        /**
         * Integer객체 스트림
         */
        Integer[] intArr2 = {1, 2, 3, 4, 5}; // 자동으로 오토박싱
        Stream<Integer> intStream2 = Arrays.stream(intArr2);
        System.out.println("count : " + intStream2.count());
        
        /**
         * 기본형 int스트림
         */
        int[] intArr = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(intArr);
        System.out.println("sum : " + intStream.sum()); // 추가기능이 있음
//        System.out.println("average : " + intStream.average());

        /*******************************************************************
         * 스트림 만들기 - 임의의 수 (난수)
         * IntStream intStream = new Random().ints();       // 무한 스트림
         * intStream.limit(5).forEach(System.out::println); // 5개의 요소만 출력
         * IntStream intStream = new Random().ints(5);      // 크기가 5인 난수 스트림을 반환
         ******************************************************************/
        IntStream intStream3 = new Random().ints();       // 무한스트림
        intStream3.limit(5).forEach(System.out::println); // 5개의 요소만
        System.out.println();

        // 요소의 개수 설정
        IntStream intStream4 = new Random().ints(5); // 유한스트림
        intStream4.forEach(System.out::println);
        System.out.println();

        // 난수의 범위 설정
        IntStream intStream5 = new Random().ints(5, 5, 10);
        intStream5.forEach(System.out::print);
        System.out.println();

        /*******************************************************************
         * 스트림 만들기 - 특정 범위의 정수
         * 특정범위의 정수를 요소로 갖는 스트림 생성하기
         * IntStream intStream = IntStream.range(1, 5); // 1, 2, 3, 4
         ******************************************************************/
        IntStream intStream6 = IntStream.range(1, 5); // 1, 2, 3, 4
        intStream6.forEach(System.out::print);
        System.out.println();

        /*******************************************************************
         * 스트림 만들기 - 람다식 iterate(), generate()
         * 람다식을 소스로 하는 스트림 생성하기 (무한 스트림)
         * iterate()는 이전 요소를 seed로 해서 다음요소를 계산한다.
         * Stream<Integer> evenStream = Stream.iterate(초기값, 람다식) : 이전요소에 종속적
         *
         * generate()는 seed를 사용하지 않는다.
         * Stream<Integer> evenStream = Stream.generate(람다식) : 이전요소에 독립적
         ******************************************************************/
        // iterate(T seed, UnaryOperator f) : 단항연산자
        Stream<Integer> iterStream = Stream.iterate(0, n -> n + 2);
        iterStream.limit(10).forEach(System.out::print);
        System.out.println();

        // generate(Supplier s) : 입력이 없고 출력만 있음
        Stream<Integer> geneStream = Stream.generate(() -> 1);
        geneStream.limit(10).forEach(System.out::print);

        /*******************************************************************
         * 스트림 만들기 - 파일과 빈 스트림
         * 파일을 소스로 하는 스트림 생성하기
         * Stream<Path> fileStream = Files.list(Path dir) // path는 파일 또는 디렉토리
         * fileStream.lines(Path path) // 파일내용을 라인단위로
         * 
         * 비어있는 스트림 생성하기
         * Stream emptyStream = Stream.empty(); // empty()는 빈 스트림을 생성해서 반환
         ******************************************************************/
    }
}
