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

        /*******************************************************************
         * 문자열을 숫자로 변환하는 다양한 방법
         *
         *******************************************************************/
        int i1 = new Integer("100").intValue(); // flatValue(), longValue(), ...
        int i2 = Integer.parseInt("100");
        Integer i3 = Integer.valueOf("100");
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
    }
}
