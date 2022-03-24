package Object_grammer01;

public class 클래스 {
    /*******************************************************************
     * 클래스의 정의
     * - 객체를 생성하기 위한 설계도
     * - 데이터 + 함수
     * 1. 변수 : 하나의 데이터를 저장할 수 있는 공간
     * 2. 배열 : 같은 종류의 여러 데이터를 하나로 저장할 수 있는 공간
     * 3. 구조체 : 서로 관련된 여러 데이터(종류 관계 X)를 하나로 저장할 수 있는 공간 (다른 데이터 타입 OK)
     * 4. 클래스 : 데이터와 함수의 결합 (구조체 + 함수)
     *
     * - 사용자 정의타입
     * 1. 원하는 타입을 직접 만들 수 있다.
     * 2. 객체에 변수를 여러개 정의하여 사용
     *******************************************************************/
    public static void main(String[] args) {
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        System.out.println("t1의 channel값은 " + t1.channel + " 입니다.");
        System.out.println("t2의 channel값은 " + t2.channel + " 입니다.");

        t1.channel = 7;
        System.out.println("t1의 channel값을 7로 변경하였습니다.");

        t2 = t1; // 참조변수 t1의 값을 t2에 저장
        System.out.println("t1의 channel값은 " + t1.channel + " 입니다.");
        System.out.println("t2의 channel값은 " + t2.channel + " 입니다.");

    }
}
