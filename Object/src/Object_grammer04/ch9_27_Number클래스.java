package Object_grammer04;

public class ch9_27_Number클래스 {
    /*******************************************************************
     * Number클래스
     * 모든 숫자 래퍼 클래스의 조상
     * 각 숫자객체를 기본형 클래스로 반환하는 메서드를 가지고 있음
     *******************************************************************/
    public static void main(String[] args) {
        Integer i = new Integer(100);
        int number = i.intValue();
        System.out.println("number = " + number);

        /**
         * 문자열을 숫자로 변환하는 다양한 방법
         */
        int i1 = new Integer("100").intValue(); // flatValue(), longValue(), ...
        int i2 = Integer.parseInt("100");
        Integer i3 = Integer.valueOf("100");
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);

        /**
         * n진법의 문자열을 숫자로 변환하는 방법
         */
        int i4 = Integer.parseInt("100", 2);    // 2진수
        int i5 = Integer.parseInt("100", 8);    // 8진수
        int i6 = Integer.parseInt("100", 16);   // 16진수
        int i7 = Integer.parseInt("FF", 16);    // 16진수
        System.out.println("i4 = " + i4);
        System.out.println("i5 = " + i5);
        System.out.println("i6 = " + i6);
        System.out.println("i7 = " + i7);
    }
}
