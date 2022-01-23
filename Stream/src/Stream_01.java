import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_01 {
    public static void main(String[] args) {
        /******************************************
         * 스트림(Stream) 만들기
         ******************************************/
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // List를 Stream으로 변환
        Stream<Integer> intStream = list.stream();
        intStream.forEach(System.out::print); // forEach() 최종연산
        System.out.println();
        // 스트림은 1회용, 한번 더 스트림을 출력하려면 다시 생성해서 사용해야함
        intStream = list.stream();
        intStream.forEach(System.out::print);
        System.out.println();

        /******************************************
         * 스트림 만들기 - 배열
         ******************************************/
        Stream<String> strStream = Stream.of("a", "b", "c");
        strStream.forEach(System.out::print);
        System.out.println();

        Stream<String> strStream2 = Stream.of(new String[]{"d", "e", "f", "g"});
        strStream2.forEach(System.out::print);
        System.out.println();

        // 배열, 시작인덱스, 끝인덱스(마지막은 포함 X)
        Stream<String> strStream3 = Arrays.stream(new String[]{"h", "i", "j", "k"}, 0, 3);
        strStream3.forEach(System.out::print);
        System.out.println();

        /**
         * 기본형 스트림 정의
         * 기본형 스트림은 숫자연산 count(), sum(), average() 등을 제공함
         */
        int[] intArr = {1, 2, 3, 4, 5};
        IntStream intStream2 = Arrays.stream(intArr);
//        intStream2.forEach(System.out::print);
//        System.out.println("count() : " + intStream2.count());
//        System.out.println("sum() = " + intStream2.sum());
        System.out.println("average() : " + intStream2.average());

        /**
         * 객체형 스트림 정의
         * 객체 스트림으로 정의하여 사용하려면 참조형타입으로 변경해야함
         * 객체형 스트림은 count()만 사용할 수 있음
         */
        Integer[] intArr2 = {6, 7, 8, 9, 10};
        Stream<Integer> intStream3 = Arrays.stream(intArr2);
//        intStream3.forEach(System.out::print);
        System.out.println("count() : " + intStream3.count());
        System.out.println();

        /******************************************
         * 스트림 만들기 - 임의의 수
         ******************************************/
        IntStream randomStream = new Random().ints();
        randomStream
                .limit(5) // 5개만 자르기
                .forEach(System.out::print);
        System.out.println();

        /**
         * 범위 지정
         */
        // 10개, 5~10까지의 난수
        IntStream randomStream2 = new Random().ints(10, 5, 10);
        randomStream2
//                .limit(5) // 5개만 자르기
                .forEach(System.out::print);
        System.out.println();

        // 끝을 포함하지 않는 범위 지정
        IntStream randomStream3 = IntStream.range(1, 5);
        randomStream3.forEach(System.out::print);
        System.out.println();
        // 끝을 포함하는 범위 지정
        IntStream randomStream4 = IntStream.rangeClosed(1, 5);
        randomStream4.forEach(System.out::print);
        System.out.println();

    }
}
