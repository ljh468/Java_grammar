package Object_Grammer01;

class Data{int x;}
public class 기본형매개변수 {
    public static void main(String[] args) {
        /*******************************************************************
         * 기본형 매개변수 : 변수의 값을 읽기만 할 수 있다.(read only)
         * 참조형 매개변수 : 변수의 값을 읽고 변경할 수 있다.(read & write)
         *******************************************************************/
        Data d = new Data();
        d.x = 10;
        System.out.println("main() : x = " + d.x);

        change(d.x);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x);
    }
    static void change(int x){
        x = 1000;
        System.out.println("change() : x = " + x);
    }
}

