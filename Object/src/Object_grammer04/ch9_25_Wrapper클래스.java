package Object_grammer04;

public class ch9_25_Wrapper클래스 {
    /*******************************************************************
     * 래퍼 클래스
     * 기본형 값을 감싸는 클래스 (8개의 기본형을 객체로 다뤄야할때 사용)
     * boolean -> Boolean
     * char -> Character
     * byte -> Byte
     * short -> Short
     * int -> Integer
     * long -> Long
     * float -> Float
     * double -> Double
     *******************************************************************/
    public static void main(String[] args) {
        Integer i = new Integer(100);
        Integer i2 = new Integer(100);

        System.out.println("i==i2 = " + (i == i2));
        System.out.println("i.equals(i2) = " + i.equals(i2));
        System.out.println("i.compareTo(i2) = " + i.compareTo(i2));
        System.out.println("i.toString() = " + i.toString());

        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.SIZE = " + Integer.SIZE);
        System.out.println("Integer.BYTES = " + Integer.BYTES);
        System.out.println("Integer.TYPE = " + Integer.TYPE);

    }
}
