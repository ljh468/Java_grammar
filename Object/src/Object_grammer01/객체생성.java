package Object_grammer01;

public class 객체생성 {
    public static void main(String[] args) {
        Tv t;               // TV 인스턴스를 참조하기 위한 변수 t를 선언
        t = new Tv();       // TV 인스턴스를 생성

        t.channel = 7;      // TV 인스턴스의 멤버변수 channel의 값을 7로 지정
        t.channelDown();    // TV 인스턴스의 메서드 chanelDown()을 호출
        System.out.println("현재 채널은 " + t.channel + " 입니다.");
    }
}

class Tv{
    /*******************************************************************
     * 클래스변수 (Cv) : static 으로 정의된 전역변수 (클래스파일이 메모리에 올라가면 생성)
     * 멤버변수 (Iv) : 클래스 내에 선언된 변수 (객체 생성시 생성)
     * 지역변수 (lv) : 메서드 내에 선언된 변수 (메서드 호출시 생성)
     *******************************************************************/

    // Tv의 속성 (멤버변수)
    static String color;   // 색상
    boolean power;  // 전원상태(on/off)
    int channel;    // 채널

    // Tv의 기능 (메서드)
    void power(){power = !power;}   // TV를 켜거나 끄는 기능을 하는 메서드
    void channelUp(){ ++channel;}   // TV의 채널을 높이는 기능을 하는 메서드
    void channelDown(){ --channel;} // TV의 채널을 낮추는 기능을 하는 메서드
}
