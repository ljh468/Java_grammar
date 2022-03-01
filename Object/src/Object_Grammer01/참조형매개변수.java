package Object_Grammer01;

class Data2{ int x; }
class Data3{ int x; }
public class 참조형매개변수 {
    public static void main(String[] args) {
        System.out.println("참조형 매개변수");
        Data2 d = new Data2();
        d.x = 10;
        System.out.println("main() : x = " + d.x);

        change(d);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x);

        /*******************************************************************
         * 참조형 반환 타입
         *******************************************************************/
        System.out.println("참조형 반환타입");
        Data3 d2 = new Data3();
        d2.x = 10;

        Data3 d3 = copy(d2);
        System.out.println("d2.x = " + d2.x);
        System.out.println("d3.x = " + d3.x);

    }
    // static 메서드는 객체 생성없이 호출 가능
    static void change(Data2 d){ // 참조형 매개변수
        d.x = 1000;
        System.out.println("change() : x = " + d.x);
    }

    static Data3 copy(Data3 d){
        Data3 tmp = new Data3(); // 새로운 객체 tmp를 생성
        tmp.x = d.x;             // d.x의 값을 tmp.x에 복사
        return tmp;              // 복사한 객체의 주소를 반환
    }
}
