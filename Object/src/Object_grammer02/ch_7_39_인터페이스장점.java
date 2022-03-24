package Object_grammer02;

class A {
    // 인터페이스 I를 구현한 객체만 들어올 수 있음
    public void method(I i){
        i.method();
    }
}
/**
 * B클래스의 선언과 구현을 분리
 */
interface I {
    public void method();
}
class B implements I {
    public void method(){
        System.out.println("B클래스의 메서드");
    }
}
class C implements I{
    public void method(){
        System.out.println("C클래스의 메서드");
    }
}
public class ch_7_39_인터페이스장점 {
    /*******************************************************************
     * 인터페이스의 장점
     * 두 대상(객체)간의 "연결, 대화, 소통"을 돕는 "중간 역할"을 한다.
     * 선언(설계)와 구현을 분리시킬 수 있게 한다. (느슨한 결합)
     * 변경에 용이, 유연한 코드
     *******************************************************************/
    public static void main(String[] args) {
        A a = new A();
        a.method(new B());
        a.method(new C());
    }
}
