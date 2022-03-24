package Object_grammer02;

class Car{
    String color;
    int door;
    void drive(){ // 운전하는 기능
        System.out.println("drive, Brrr~");
    }
    void stop(){  // 멈추는 기능
        System.out.println("stop!!!");
    }
}
class FireEngine extends Car{
    void water(){
        System.out.println("water!!!");
    }
}
public class ch7_24_참조변수의형변환 {
    /*******************************************************************
     * 참조변수의 형변환
     * 사용할 수 있는 멤버의 갯수를 조절하는 것 (리모컨을 변경)
     * 조상, 자손 관계의 참조변수는 서로 형변환 가능
     *******************************************************************/
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine(); // 실제 인스턴스가 무엇인지가 중요.
        FireEngine fe2 = null;

        fe.water();
        car = fe; // car = (Car)fe; 에서 형변환이 생략됨
//        car.warter; // 컴파일 에러!! Car타입의 참조변수로는 water()를 호출할 수 없다.
        fe2 = (FireEngine) car; // 자손타입 <== 조상타입, 형변환 생략 불가
        fe2.water();

        Car c = new Car();
//        FireEngine ff = (FireEngine)c; // 형변환 실행 에러 java.lang.ClassCastException
//        ff.water(); // 컴파일은 되나, 실제가르키는 객체 Car는 .water가 없다.
    }
}
