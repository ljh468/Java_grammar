package Object_Grammer01;
/*******************************************************************
 * 생성자 this()
 * - 생성자에서 다른 생성자 호출할 때 사용
 * - 다른 생성자 호출시 첫 줄에서만 사용가능
 *******************************************************************/

/*******************************************************************
 * 참조변수 this
 * - 인스턴스 자신을 가리키는 참조변수
 * - 인스턴스 메서드(생성자 포함)에서 사용가능
 * - 지역변수(lv)와 인스턴스 변수(iv)를 구별할 때 사용
 *******************************************************************/

/*******************************************************************
 * 참보변수 this와 생성자 this()
 * this : 인스턴스 자신을 가리키는 참조변수, 인스턴스의 주소가 저장되어 있다.
 *        모든 인스턴스 메서드에 지역변수로 숨겨진 채로 존재한다.
 * this(), this(매개변수) : 생성자, 같은 클래스의 다른 생성자를 호출할 때 사용한다.
 *******************************************************************/

class Car{
    String color;    // 색상
    String gearType; // 변속기 종류 - auto, manual
    int door;        // 문의 개수\

    public Car() { // 기본 생성자
        this("white", "auto", 4); // 다른 생성자 호출 this()
    }
    public Car(String color) {
        this.color = color;
    }
    public Car(String color, String gearType, int door) {
        this.color = color;       // 참조변수(iv)를 가리킴
        this.gearType = gearType; // 참조변수(iv)와 지역변수(lv)를 구별하기 위함
        this.door = door;
    }

    public String addString() {         // 인스턴스 메서드
        return color + gearType + door; // 원래는 this.color + this.gearType + this.door를 써줘야함
    }

    static String addString2(String color, String gearType, int door){ // 클래스 메서드(static)
        return color + gearType + door;
    }
}
public class 생성자this {
    public static void main(String[] args) {
    }
}
