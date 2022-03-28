package Object_grammer02;

public interface ch7_35_인터페이스 {
    /*******************************************************************
     * 인터페이스(interface)
     * 추상 메서드의 집합 (프로그래밍 관점)
     * 구현된 것이 전혀 없는 설계도. 껍데기(모든 멤버가 public)
     * 
     * 인터페이스와 추상클래스의 차이점
     * 인터페이스는 구현된것이 없는 추상메서드의 집합 (변수, iv, cv 들어갈 수 없음)
     * 추상클래스는 일반 클래스에 추상메서드가 들어있는 클래스
     *******************************************************************/
    /*******************************************************************
     * 인터페이스의 조상은 인터페이스만 가능(Object가 최고 조상 아님
     * 다중 상속이 가능. (추상메서드는 구현부가 없기 때문에 충돌해도 문제없음)
     *******************************************************************/
    public static final int SPADE = 4; // 상수
    final int DIAMOND = 3; // public static final 생략가능
    static int HEART = 2;
    int CLOVER = 1;
    
    public abstract String getCardNumber(); // 추상 메서드
    String getCardKind(); // public abstract 생략가능
}
/*******************************************************************
 * 인터페이스의 구현
 * 인터페이스에 정의된 추상 메서드를 완성하는 것
 * 일부만 구현하는 경우, 클래스 앞에 abstract를 붙여야 함.
 *
 * class 클래스이름 implements 인터페이스이름 {
 *     // 인터페이스에 정의된 추상메서드를 모두 구현해야 한다.
 * }
 *******************************************************************/
class Fighter implements ch7_35_인터페이스{

    @Override
    public String getCardNumber() {
        return "getCardNumber";
    }

    @Override
    public String getCardKind() {
        return "getCardNumber";
    }
}
