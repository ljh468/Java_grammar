package Object_grammer04;

import java.util.ArrayList;

public class ch9_30_오토박싱언박싱 {
    /*******************************************************************
     * 오토박싱 & 언박싱
     * 기본형을 래퍼클래스로 변환해주는 것을 오토박싱
     * 래퍼클래스를 기본형으로 변환해주는 것을 언박싱
     * JDK(1.5)이전에는 기본형과 참조형간의 연산이 불가능
     *******************************************************************/
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        /**
         * 오토박싱 : 기본형 -> 래퍼클래스
         */
//        list.add(new Integer(100));   // list에는 객체만 추가가능
        list.add(100);                      // JDK 1.5이전에는 에러
        System.out.println("list = " + list);
        System.out.println("################################################");

        /**
         * 언박싱 : 래퍼클래스 -> 기본형
         */
//        int i = list.get(0).intValue();     // intValue()로 Integer를 기본형으로 변환
        Integer i = list.get(0);            // list에 저장된 첫번째 객체를 꺼냄
        System.out.println("i = " + i);
        System.out.println("################################################");

        /**
         * 기본형을 참조형으로 형변환(형변환 생략가능)
         */
        int num = 10;
        Integer intg = (Integer) num; // Integer intg = Integer.valueOf(num);
        Object obj = (Object) num;    // Object obj = (Object)Integer.valueOf(num);
        System.out.println("intg = " + intg);
        System.out.println("obj = " + obj);

        Long lng = 100L; // Long lng = new Long(100L);
        System.out.println("lng = " + lng);

        int num2 = num + 10; // 참조형과 기본형간의 연산가능
        System.out.println("num2 = " + num2);
        long l = intg + lng; // 참조형 간의 덧셈도 가능
        System.out.println("l = " + l);

        Integer intg2 = new Integer(20);
        System.out.println("intg2 = " + intg2);
        int num3 = (int) intg2; // 참조ㅜ형을 기본형으로 형변환 가능(형변환 생략가능)
        System.out.println("num3 = " + num3);
    }
}
