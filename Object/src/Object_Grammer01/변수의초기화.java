package Object_Grammer01;

/*******************************************************************
 * 변수의 초기화
 * - 지역변수(lv)는 수동 초기화 해야함(사용전 꼭!!!)
 * - 멤버변수(iv, cv)는 자동 초기화된다.
 *******************************************************************/

/*******************************************************************
 * 멤버변수의 초기화 (iv, cv)
 * 1. 명시적 초기화(대입연산자 =)
 * 2. 초기화 블럭
 *   -   클래스 변수(cv) 초기화 : static {}
 * 3. 생성자
 *   - 인스턴스 변수(iv) 초기화
 *******************************************************************/
class Engine{
}
class Car2{
    int door = 4;            // 기본형 변수의 초기화
    Engine e = new Engine(); // 참조형 변수의 초기화 (객체를 넣어 주어야 한다. null값 X)
}

/*******************************************************************
 *  => 클래스변수(cv) 초기화 시점 : 클래스가 처음 메모리에 올라갈 때 단 한번
 *  => 인스턴스변수(iv) 초기화 시점 : 인스턴스가 생성될 때 마다
 *******************************************************************/

/*******************************************************************
 *  초기화 순서
 *  1. cv -> iv
 *  2. 자동(0) -> 간단(=) -> 복잡(static{}, 생성자)
 *******************************************************************/
class InitTest{
    static int cv = 1; // cv 명시적 초기화
    int iv = 1;        // iv 명시적 초기화
    
    static { cv = 2; } // 클래스 초기화 블럭
    { iv = 2; }        // 인스턴스 초기화 블럭

    InitTest(){        // 생성자 (iv초기화)
        iv = 3;
    }
}
public class 변수의초기화 {

}
