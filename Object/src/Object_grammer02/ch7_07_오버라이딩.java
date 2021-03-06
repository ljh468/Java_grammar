package Object_grammer02;

class MyPoint3{
    int x;
    int y;
    public MyPoint3() {
    }
    public MyPoint3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class MyPoint3D extends MyPoint3{
    int z;
    public MyPoint3D() {
    }
    /*******************************************************************
     * super() - 조상의 생성자
     * 모든 생성자는 첫줄에 다른 생성자를 호출
     *******************************************************************/
    public MyPoint3D(int x, int y, int z) {
        super(x, y); // 조상의 생성자 Point(int x, int y)를 호출
        this.z = z;
    }
    // 조상의 getLocation()을 오버라이딩
    @Override
    public String toString() {
        return "MyPoint3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
public class ch7_07_오버라이딩 {
    /*******************************************************************
     * 오버라이딩(overriding)
     * 상속받은 조상의 메서드를 자신에 맞게 변경하는 것
     *******************************************************************/
    /*******************************************************************
     * 오버라이딩의 조건
     * 1. 선언부가 조상 클래스의 메서드와 일치해야 한다. (반환타입, 메서드이름, 매개변수 일치)
     * 2. 접근 제어자가 조삼 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
     * 3. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.
     *******************************************************************/
    /*******************************************************************
     * 오버로딩 vs 오버라이딩
     * 오버로딩(overloading) : 기존에 없는 이름이 같은  새로운 메서드를 정의하는 것(new)
     * 오버라이딩(oberriding) : 상속받은 메서드의 내용을 변경하는 것(change, modify)
     *******************************************************************/
    public static void main(String[] args) {
        MyPoint3D p = new MyPoint3D(3, 5, 7);   // 생성자 호출
//        p.x = 3;
//        p.y = 5;
//        p.z = 7;
        System.out.println(p.toString());
    }
}
