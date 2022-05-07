package Object_grammer09;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ch14_23_스트림의중간연산01 {
    public static void main(String[] args) {
        /*******************************************************************
         * 스트림 자르기 - skip(), limit()
         * Stream<T> skip (long n)  // 앞에서부터 n개 건너뛰기
         * Stream<T> limit(long maxSize)    // maxSize 이후의 요소는 잘라냄
         ******************************************************************/
        IntStream intStream = IntStream.rangeClosed(1, 10); // 12345678910
        intStream.skip(3).limit(5).forEach(System.out::print); // 45678
        System.out.println();

        /*******************************************************************
         * 스트림 요소 걸러내기 - filter(), distinct()
         * Stream<T> filter (Predicate<? super T> predicate // 조건에 맞지 않는 요소 제거
         * Stream<T> distinct()    // 중복제거
         ******************************************************************/
        IntStream intStream1 = IntStream.of(1, 2, 2, 3, 3, 4, 5, 5, 6);
        intStream1.distinct().forEach(System.out::print); // 123456
        System.out.println();

        IntStream intStream2 = IntStream.rangeClosed(1, 10); // 12345678910
        intStream2.filter(n -> n % 2 ==0).forEach(System.out::print); // 246810 (짝수)
        System.out.println();

        IntStream intStream3 = IntStream.rangeClosed(1, 10); // 12345678910
        intStream3.filter(i -> i % 2 != 0 && i % 3 != 0).forEach(System.out::print); // 157 (2,3의 배수가 아닌수)
        System.out.println();

        /*******************************************************************
         * 스트림 정렬하기 - sorted()
         * - 정렬대상, 정렬기준이 필요
         * Stream<T> sorted()   // 스트림 요소의 기본 정렬(Comparable)로 정렬
         * Stream<T> sorted(Comparator<? super T> comparator) // 지정된 Comparator로 정렬
         *
         * Comparator의 comparing()으로 정렬 기준을 제공
         * cmparing(Function<T, U> keyExtractor)
         * cmparing(Function<T, U> keyExtractor, Comparator<U> keyComparator)
         ******************************************************************/
        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        );
        studentStream.sorted(Comparator.comparing(Student::getBan) // 반별 정렬
                .thenComparing(Comparator.naturalOrder())) // 추가로 기본정렬
                .forEach(System.out::print);
    }
}
class Student implements Comparable<Student>{
    String name;
    int ban;
    int totalScore;

    Student(String name, int ban, int totalScore){
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }
    public int getBan() {
        return ban;
    }
    public int getTotalScore() {
        return totalScore;
    }

    @Override
    // 총점 내림차순을 기본 정렬로 한다.
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
