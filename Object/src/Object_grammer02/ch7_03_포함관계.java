package Object_grammer02;

class Mypoint{
    int x;
    int y;
}
//class Circle extends Mypoint{     // 상속
//    int r;
//}

class Circle{                       // 포함
    Mypoint p = new Mypoint(); // 참조변수의 초기화
    int r;
}
public class ch7_03_포함관계 {
    /*******************************************************************
     * 포함(composite)이란?
     * 클래스의 멤버로 참조변수를 선언하는것
     *******************************************************************/
    /*******************************************************************
     * 포함(composite)이란
     * 클래스의 멤버로 참조변수를 선언하는것
     * 상속관계 : " ~은 ~이다. (is-a)"
     * 포함관계 : " ~은 ~을 가지고 있다. (has-a)"
     ******************************************************************/
    public static void main(String[] args) {
        Circle c = new Circle();
        c.p.x = 1;
        c.p.y = 2;
        c.r = 3;
        System.out.println("c.p.x = " + c.p.x);
        System.out.println("c.p.y = " + c.p.y);
        System.out.println("c.r = " + c.r);
    }
}
