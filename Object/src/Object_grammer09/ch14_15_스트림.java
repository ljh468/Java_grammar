package Object_grammer09;

public class ch14_15_스트림 {
    /*******************************************************************
     * 스트림(Stream)
     * 다양한 데이터 소스를 표준화된 방법으로 다루기 위한것
     * 1. 스트림만들기
     * 2. 중간연산 (여러번 가능)
     * 3. 최종연산 (1번만 가능)
     ******************************************************************/
    /*******************************************************************
     * 스트림이 제공하는 기능
     * stream.filter();   // 걸러내기 (중간)
     * stream.distinct(); // 중복제거 (중간)
     * stream.sort();     // 정렬 (중간)
     * stream.limit(5);   // 스트림 자르기 (중간)
     * stream.count();    // 요소 개수 세기 (최종)
     * stream.forEach();  // 스트림 요소 출력 (최종)
     ******************************************************************/
    /*******************************************************************
     * 스트림의 특징
     * - 스트림은 데이터 소스로부터 데이터를 읽기만할 뿐 변경하지 않는다.
     * - 스트림은 Iterator처럼 1회용이다. (필요하면 다시 스트림을 생성해야 함)
     * - 최종 연산 전까지 중간연산이 수행되지 않는다. (지연된 연산)
     * - 스트림은 작업을 내부 반복으로 처리한다. (forEach();)
     * - 스트림의 작업을 병렬로 처리 (병렬 스트림) (.parallel())
     ******************************************************************/
    /*******************************************************************
     * 기본형 스트림 - IntStream, LongStream, DoubleStream
     * - 스트림으로 변환되면 기본형데이터가 참조형으로 변환된다. ( 1 -> new Integer(1) ) (오토박싱)
     * - 오토박싱 & 언박싱의 비효율이 제거됨 (Stream<Integer> 대신 IntStream 사용) (성능 개선)
     * - 숫자와 관련된 유용한 메서드를 Stream<T>보다 더 많이 제공
     ******************************************************************/
    public static void main(String[] args) {

    }
}
