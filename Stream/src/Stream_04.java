import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class Stream_04 {
    public static void main(String[] args) {

        File[] fileArr = {new File("Ex1.java"), new File("Ex1.bak"),
                new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")};

        /*******************************************************************
         * 스트림 요소 변환 - map()
         * Stream<R> map(Function<T, R> mapper)       //스트림의 요소를 변환한다.
         * EX :) Stream<File> -> Stream<String>
         *******************************************************************/

        /**
         * map()으로 Stream<File>을 Stream<String>으로 변환
         */
        Stream<File> fileStream = Stream.of(fileArr);

//        Stream<String> filenameStream = fileStream.map(File::getName);         // 메서드 참조
        Stream<String> filenameStream = fileStream.map((File f) -> f.getName()); // 람다식
        filenameStream.forEach(System.out::println);

        // 스트림 다시 생성
        fileStream = Stream.of(fileArr);

        fileStream.map(File::getName)                       // Stream<File> -> Stream<String>
                .filter(s -> s.indexOf(".") != -1)          // 확장자가 없는 것은 제외
                .map(s -> s.substring(s.indexOf(".") + 1))  // 확장자만 추출
                .map(String::toUpperCase)                   // 모두 대문자로 변화
                .distinct()                                 // 중복 제거
                .forEach(System.out::println);              // JAVABAKTXT

        /*******************************************************************
         * 스트림 요소 출력 - peek()
         * 스트림의 요소를 소비하지 않고 엿보기 (중간연산)
         * 중간 중간 변환이 잘되고있는지 확인할 때 쓰임
         * Stream<T> peek(Consumer<T> action)         // 스트림의 요소에 작업 수행
         *******************************************************************/
        fileStream = Stream.of(fileArr);
        fileStream.map(File::getName)
                .filter(s -> s.indexOf('.') != -1)
                .peek(s -> System.out.printf("filename = %s%n", s))   // 파일명 출력
                .map(s -> s.substring(s.indexOf('.')+1))
                .peek(s -> System.out.printf("extension = %s%n", s))  // 확장자 출력
                .forEach(System.out::println);
        System.out.println();

        /*******************************************************************
         * 스트림의 스트림을 스트림으로 변환 - flatmap
         * Stream<R> flatMap(Function<T, Stream<R>> mapper)
         *******************************************************************/

        /**
         * Stream<String[]> -> Stream<Stream<String>> 으로 변환
         * 배열을 Stream으로 변환
         */
        Stream<String[]> strArrStrm = Stream.of(new String[]{"abc", "def", "ghi"},
                                                new String[]{"ABC", "GHI", "JKLMN"});

        Stream<Stream<String>> strStrStrm = strArrStrm.map(Arrays::stream);
        strStrStrm.forEach(System.out::println);

        /**
         * Stream<String[]> -> Stream<String> 으로 변환
         * 배열을 합침
         */
        Stream<String[]> strArrStrm2 = Stream.of(new String[]{"abc", "def", "ghi"},
                                                 new String[]{"ABC", "GHI", "JKLMN"});

        Stream<String> strStrm = strArrStrm2.flatMap(Arrays::stream);
        strStrm.forEach(System.out::println);


    }
}

