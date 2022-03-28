package Object_grammer02;

public class ch7_45_내부클래스의제어자와접근성 {
    /*******************************************************************
     * 내부 클래스의 제어자와 접근성
     * 내부 클래스의 제어자는 변수에 사용 가능한 제어자와 동일
     * 클래스는 default, public만 그러나, 내부클래스는 default, public, private, protected 모두 사용가능
     *
     * 내부 스태틱클래스는 외부클래스의 인스턴스 멤버에 접근할 수 없다.
     * 내부 인스턴스클래스는 외부 클래스의 private멤버도 접근이 가능하다.
     * 내부 지역클래스는 감싸고 있는 final이 붙은 변수(상수)만 접근이 가능하다.
     *******************************************************************/

    /**
     * 인스턴스 내부클래스
     */
    class InstanceInner{
        int iv = 100;
//        static int cv = 100;        // 에러! static변수를 선언할 수 없다.
        final static int CONST = 100; // final static은 상수이므로 허용
    }

    /**
     * static 내부클래스
     */
    static class StaticInner{
        int iv = 100;
        static int cv = 200;         // static클래스만 static멤버를 정의할 수 있다.
    }

    /**
     * 지역 내부클래스
     */
    void myMethod(){
        class LocalInner{
            int iv = 300;
//            static int cv = 300;          // 에러! static변수를 선언할 수 없다.
            final static int CONST = 300;   // final static은 상수이므로 허용
        }
    }

    public static void main(String[] args) {
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);
//        System.out.println(LocalInner.CONST); // 에러. 지역 내부 클래스는 메서드내에서만 가능
    }
}
