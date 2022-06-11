package Object_grammer09;

public class ch14_45_Collect객체 {
    /********************************************************************
     * collect(), Collectors
     * collect()는 Collector 인터페이스를 매개변수로 하는 스트림의 최종연산
     * Object collect(Collector collector)  // Collector를 구현한 클래스의 객체를 매개변수로
     * Object collect(Supplier supplier, Biconsumer accumulator, BiConsumer combiner) // 잘 안쓰임
     * 
     * reduce() : 리듀싱
     * collect() : 그룹별 리듀싱
     ********************************************************************/
    /*******************************************************************
     * Collector는 수집(collect)에 필요한 메서드를 정의해 놓은 인터페이스
     *
     * T(요소)를 A에 누적한 다음, 결과를 R로 변환해서 반환
     * public interface Collector<T, A, R> {...}
     *******************************************************************/
    /*******************************************************************
     * Collectors 클래스는 다양한 기능의 컬렉터(Collector를 구현한 클래스)를 제공
     * 변환 - mapping(), toList(), toSet(), toMap(), toCollection()
     * 통계 - counting(), summingInt(), averagingInt(), maxBy(), minBy(), summarizingInt(), ...
     * 문자열 결합 - joining()
     * 리듀싱 - reducing()
     * 그룹화와 분할 - groupingBy(), partitioningBy(), collectingAndThen()
     *******************************************************************/
    public static void main(String[] args) {
        /*******************************************************************
         * 스트림을 컬렉션, 배열로 변환
         *
         * 스트림을 컬렉션으로 변환 - toList(), toSet(), toMap(), toCollection()
         * ex : studentStream.map(Student::getName).collect(Collectors.toCollection(ArrayList::new))
         *
         * 스트림을 배열로 변환 - toArray()
         * ex : Student[] stuNames = studentStream.toArray(Student[]::new);
         *******************************************************************/

        /*******************************************************************
         * 스트림의 통계 - counting(), summingInt()
         * 스트림의 통계정보를 제공 - counting(), summingInt(), maxBy(), minBy()
         *
         * .collect()는 그룹별 계산 가능
         * long count = stuStream.collect(counting());
         * long totalScore = stuStream.collect(summingInt(Student::getTotalScore));
         * Optional<Student> topStudent = stuStream.collect(maxBy(Comparator.comparingInt(Student::getTotalScore)));
         *******************************************************************/

        /*******************************************************************
         * 스트림을 리듀싱 - Collectors.reducing() (그룹별 리듀싱 가능)
         * Collector reducing(BinaryOperator<T> op)
         * Collector reducing(T identity, BinaryOperator<T> op)
         * Collector reducing(U identity, Function<T, U> maaper, BinaryOperator<U> op) // map+reduce
         *
         * Optional<Integer> max = intStream.boxed().collect(reducing(Integer::max));
         * long sum = intStream.boxed().collect(reducing(0, (a, b) -> a + b));
         * int grandTotal = stuStream.collect(reducing(0, Student::getTotalScore, Integer::sum));
         *******************************************************************/

        /*******************************************************************
         * 문자열 스트림의 요소를 모두 연결 - joining()
         *
         * String studentInfo = stuStream.collect(joining(",", "[", "]")); // Student의 toString()으로 결합
         *******************************************************************/
    }
}
