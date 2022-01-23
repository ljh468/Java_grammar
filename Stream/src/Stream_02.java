import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Stream_02 {
    public static void main(String[] args) {
        /******************************************
         * 스트림 만들기 - 람다식 ( iterate(), generate() )
         * 람다식을 소스로 하는 스트림 생성
         *
         * iterate(초기값, 람다식) : 이전 요소에 종속적 (값이 이어서 진행)
         * generate(람다식) : 이전 요소에 독립적 (seed 초기값 없음)
         ******************************************/
        // iterate(T seed, UnaryOperator f) 단항연산자
        Stream<Integer> iterateStream = Stream.iterate(0, n -> n + 2);
        iterateStream.limit(10).forEach(System.out::print);
        System.out.println();

        // generate(Supplier s) : 주기만 하는것, 입력X, 출력)
        Stream<Integer> generateStream = Stream.generate(() -> 1);
        generateStream.limit(10).forEach(System.out::print);
        System.out.println();

        /******************************************
         * 스트림 만들기 - 파일과 빈 스트림
         * 파일을 소스로 하는 스트림 생성하기
         * 파일내용을 라인단위로 처리함 ( Log파일 분석이나 Text파일 처리할때 유용)
         ******************************************/

        /**
         * 로그 파일 분석이나 텍스트 파일 처리할때 유용한 파일 스트림
         */
//        Stream<Path> files = Files.list(Path dir);
//        Stream<String> files01 = Files.lines(Path dir);
//        Stream<String> files02 = Files.lines(Path dir, Charset cs);
//        Stream<String> files03 = lines(); // BufferedReader 클래스의 메서드

        /**
         * 비어있는 스트림 생성
         */
        Stream emptyStream = Stream.empty();
        long count = emptyStream.count();
        System.out.println("count = " + count);
    }
}
