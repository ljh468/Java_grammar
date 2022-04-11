package Object_grammer07;

import java.util.ArrayList;

public class ch12_01_지네릭스 {
    /*******************************************************************
     * 컴파일시 타입을 체크해 주는 기능(COMPILE-TIME TYPE CHECK)
     * 객체의 타입 안정성을 높이고 형변환의 번거로움을 줄여줌
     *******************************************************************/
    /*******************************************************************
     * 지네릭스 용어
     * Box<T> : 지네릭 클랙스 . T의 Box 또는 T Box라고 읽음 (타입변수는 T)
     * T      : 타입변수 또는 타입 매개변수(T는 타입문자)
     * Box    : 원시 타입(raw type) (일반클래스 -> 지네릭클래스)
     * Box<String> b = new Box<String>(); ==> 대입된 타입
     *******************************************************************/
    public static void main(String[] args) {
//        ArrayList<Object> list = ArrayList<Object>(); // JDK1.5부터는 지네릭스 사용
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30); // 지네릭스 덕분에 타입 체크가 강화됨.
//        list.add("40"); // 컴파일은 되지만 ClassCastException 오류
//        Integer i = (Integer) list.get(2);

        Integer i = list.get(2); // 지네릭스를 설성 하였기때문에 형변환 불필요
        System.out.println("list = " + list);
    }
}
