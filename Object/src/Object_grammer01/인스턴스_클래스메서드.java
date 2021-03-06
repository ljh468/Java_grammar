package Object_grammer01;

public class 인스턴스_클래스메서드 {
    /*******************************************************************
     * 인스턴스 메서드
     * - 인스턴스 생성 후, '참조변수.메서드이름()'으로 호출
     * - 인스턴스 멤버(iv, im)와 관련된 작업을 하는 메서드
     * - 메서드 내에서 인스턴스 변수(iv) 사용가능
     *
     * static 메서드(클래스메서드)
     * - 객체 생성없이 '클래스이름.메서드이름()'으로 호출
     * - 인스턴스 멤버(iv, im)와 관련없는 작업을 하는 메서드
     * - 메서드 내에서 인스턴스 변수(iv) 사용불가
     *******************************************************************/

    /*******************************************************************
     * static은 언제 붙여야 할까 ?
     * - 속성(멤버 변수) 중에서 공통 속성에 static을 붙인다.
     * - 인스턴스 멤버(iv, im)을 사용하지 않는 메서드에 static을 붙인다.
     * - static 메서드는 인스턴스 변수(iv)를 사용할 수 없다. (iv는 객체 생성후 사용가능)
     * - static 메서드는 인스턴스 메서드(im)를 호출할 수 없다. (인스턴스 메서드는 객체 생성후 사용가능)
     *******************************************************************/
    public static void main(String[] args) {

    }
}
