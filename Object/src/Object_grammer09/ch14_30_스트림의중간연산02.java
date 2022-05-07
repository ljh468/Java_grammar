package Object_grammer09;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class ch14_30_스트림의중간연산02 {
    public static void main(String[] args) {
        /*******************************************************************
         * 스트림의 요소 변환하기 - map()
         * Stream<R> map (Function<? super T, ? extends R> mapper)  // Stream<T> -> Stream<R>
         ******************************************************************/
        File[] fileArr = {new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"),
                          new File("Ex1"), new File("Ex1.txt")};

        Stream<File> fileStream = Stream.of(fileArr);

        // map()으로 Stream<File>을 Stream<String>으로 변환
        Stream<String> filenameStream = fileStream.map((File f) -> f.getName());
        filenameStream.forEach(System.out::println);

        fileStream = Stream.of(fileArr); // 스트림을 다시 생성
        
        fileStream.map(File::getName)                       // Stream<File> -> Steram<String>
                .filter(s -> s.indexOf('.')!= -1)           // 확장자가 없는 것은 제외
                .map(s -> s.substring(s.indexOf('.')+1))    // 확장자만 추출
                .map(String::toUpperCase)                   // 모두 대문자로 변환
                .distinct()                                 // 중복제거
                .forEach(System.out::println);                // JAVABAKTXT

        System.out.println();

        /*******************************************************************
         * 스트림의 요소를 소비하지 않고 엿보기 - peek()
         * Stream<T> peek(Consumer<? super T> action>   // 중간연산 (스트림을 소비 X)
         * void      forEach(Consumer<? super T> action // 최종연산 (스트림을 소비 O)
         * ******************************************************************/
        fileStream = Stream.of(fileArr); // 스트림을 다시 생성

        fileStream.map(File::getName)
                .filter(s -> s.indexOf('.')!= -1)
                .peek(s -> System.out.printf("filename=%s%n", s)) // 내용이 잘나오는지 중간 확인 용도로 쓰임
                .map(s -> s.substring(s.indexOf('.')+1))
                .peek(s -> System.out.printf("extension=%s%n", s))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        /*******************************************************************
         * 스트림의 스트림을 스트림으로 변환 - flatMap()
         * Stream<Stream<String>> strStrStrm = strArrStrm.map(Arrays::stream);   // map을 이용하면 쪼개지기만함
         * Stream<String> strStrStrm = strArrStrm.flatMap(Arrays::Stream);       // Arrays.stream(T[])
         * ******************************************************************/
        Stream<String[]> strArrStrm = Stream.of(new String[]{"abc", "def", "jkl"},
                                                new String[] {"ABC", "GHI", "JKL"}
        );
        // map으로 변환
        // Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);

        // flatMap으로 변환 (완전히 평평하게 펴짐)
        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);    // 스트림의 요소를 모두 소문자로 변경
        strStrm.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not there is no try",
        };
        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +"))) // 정규식 ( + 하나이상의 공백 )
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }
}