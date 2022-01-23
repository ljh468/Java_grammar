import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class Stream_03 {
    public static void main(String[] args) {
        /******************************************
         * 스트림의 연산
         * 스트림이 제공하는 기능 - 중간 연산과 최종연산
         * 중간 연산 : 연산결과가 스트림인 연산, 반복적으로 적용가능
         * 최종 연산 : 연산결과가 스트림이 아닌 연산, 단 한번만 적용가능(스트림의 요소를 소모)
         ******************************************/

        /******************************************
         * 중간 연산의 종류
         * 1. Stream<T> distinct()                       // 중복을 제거
         * 2. Stream<T> filter(Predicate<T> predicate)   // 조건에 안 맞는 요소 제외
         * 3. Stream<T> limit(long maxSzie)              // 스트림의 일부를 잘라낸다.
         * 4. Stream<T> skip(long n)                     // 스트림의 일부를 건너뛴다.
         * 5. Stream<T> peek(Consumer<T> action)         // 스트림의 요소에 작업 수행
         * 6. Stream<T> sorted()                         // 스트림의 요소를 정렬한다.
         *    Stream<T> sorted(Comparator<T> comparator) // 정렬기준으로 정렬
         * 7. Stream<R> map(Function<T, R> mapper)       //스트림의 요소를 변환한다.
         *              mapToDouble
         *              mapToInt
         *              mapToLong
         * 8. Stream<R> flatMap(Function<T, Stream<R>> mapper)
         *              flatMapToDouble
         *              flatMapToInt
         *              flatMapToLong
         ******************************************/

        /*******************************************************************
         * 스트림 자르기 - skip(), limit()
         *******************************************************************/
        IntStream intStream = IntStream.rangeClosed(1, 10); // 1 2 3 4 5 6 7 8 9 10
        System.out.print("스트림 자르기 : ");
        intStream.skip(3).limit(5).forEach(System.out::print); // 4 5 6 7 8
        System.out.println();

        /*******************************************************************
         * 스트림 요소 걸러내기 - filter(), distinct()
         *******************************************************************/

        /**
         * Stream<T> distinct()                       // 중복을 제거
         */
        IntStream intStream1 = IntStream.of(1, 2, 3, 3, 3, 4, 5, 5, 6);
        System.out.print("스트림 distinct : ");
        intStream1.distinct().forEach(System.out::print); // 1 2 3 4 5 6
        System.out.println();

        /**
         * Stream<T> filter(Predicate<T> predicate)   // 조건에 안 맞는 요소 제외
         */
        IntStream intStream2 = IntStream.rangeClosed(1, 10); // 1 2 3 4 5 6 7 8 9 10
        System.out.print("스트림 filter : ");
        intStream2.filter(i -> i%2==0).forEach(System.out::print); // 2 4 6 8 10
        System.out.println();

        // filter를 여러번 사용( 중간연산은 여러번 사용 가능)
        IntStream intStream3 = IntStream.rangeClosed(1, 10); // 1 2 3 4 5 6 7 8 9 10
        System.out.print("스트림 다중 filter : ");
//        intStream3.filter(i -> i%2!=0 && i%3!=0).forEach(System.out::print);
        intStream3.filter(i -> i%2 != 0).filter(i -> i%3 !=0).forEach(System.out::print); // 1 5 7
        System.out.println();

        /*******************************************************************
         * 스트림 정렬하기 - sorted()
         * Stream<T> sorted()                        // 스트림 요소의 기본정렬(Comparable)로 정렬
         * Stream<T> sorted(Comparator<> comparator) // 스트림 요소의 기본정렬(Comparable)로 정렬
         *******************************************************************/
        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)

        );

        /**
         * Comparator의 comparing()으로 정렬 기준을 제공
         * 추가 정렬 기준을 제공할 대는 thenComparing()을 사용
         */
//        studentStream.sorted(Comparator.comparing(Student::getBan).reversed() // 1. 반별 정렬
        studentStream.sorted(Comparator.comparing((Student s) -> s.getBan()) // 메서드 참조를 람다식으로 변환
                .thenComparing(Comparator.naturalOrder())) // 2. 기본 정렬
                .forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    Student(String name, int ban, int totalScore){
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String toString(){
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    String getName(){ return name;}
    int getBan(){ return ban;}
    int getTotalScore(){ return totalScore;}

    // 총점 내림차순을 기본정렬로 한다.
    public int compareTo(Student s){
        return s.totalScore - this.totalScore;
    }
}

