package Object_grammer07;

class Parent{
    void parentMethod(){}
}
class Child extends Parent{
    @Override
    @Deprecated
    void parentMethod(){ } // 조상 메서드의 이름을 잘못 적으면 오류
}
@FunctionalInterface // 함수형 인터페이스는 하나의 추상 메서드만 가능
interface Testable{
    abstract void test(); // 추상 메서드
//    abstract void check();
}
public class ch12_23_애너테이션 {
    /*******************************************************************
     * 애너테이션이란?
     * 주석처럼 프로그래밍 언어에 영향을 미치지 않으며, 유용한 정보를 제공
     *******************************************************************/
    /*******************************************************************
     * 표준 에너테이션
     * Java에서 제공하는 애너테이션
     *
     *  @Override : 오버라이딩을 올바르게 했는지 컴파일러가 체크하게 한다.
     *              오버라이딩할 때 머서드이름을 잘못적는 실수를 하는 경우가 많다.
     *              오버라이딩할 때는 메서드 선언부 앞에 @Override를 붙이자.
     * @Deprecate : 앞으로 사용하지 않을 것을 권장하는 필드나 메서드에 붙인다.
     *              Deprecated의 사용예 -> Date클래스의 getDate()
     *              Deprecated가 붙은 대상이 사용된 코드를 컴파일하면 나타나는 메시지 -> Xlint:deprecation
     * @Functionallnterface : 함수형 인터페이스에 붙이면, 컴파일러가 올바르게 작성했는지 체크
     *                        함수형 인터페이스에는 하나의 추상메서드만 가져야 한다는 제약이 있음
     * @SupperessWarnings : 컴파일러의 경고메시지가 나타나지 않게 억제한다.
     *                      괄호()안에 억제하고자하는 경고의 종류를 문자열로 지정
     *                      둘 이상의 경고를 동시에 억제하려면 "", ""로 나열
     *                      'Xlint'옵션으로 컴파일하면, 경고메시지를 확인할 수 있다.
     *                      괄호[]안이 경고의 종류. 아래의 경우 rawtypes
     *******************************************************************/
    @SuppressWarnings("deprecation") // 경고를 알고있으므로 억제
    public static void main(String[] args) {
        Child child = new Child();
        child.parentMethod();   // deprecated된 메서드 사용
        
    }
}
