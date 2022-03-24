package Object_grammer02;

class Tv{
    boolean power; // 전원상태 (on/off)
    int channel;   // 채널

    void power(){power = !power;}
    void channelUp() { ++channel;}
    void channelDown() { --channel;}
}
class SmartTv extends Tv{
    boolean caption;    // 캡션상태(on/off)
    void displayCaption(String text){
        if(caption){    // 캡션 상태가 on(true)일 때만 text를 보여준다.
            System.out.println(text);
        }
    }
}
public class ch7_01_상속 {
    /*******************************************************************
     * 상속 (Inheritance)
     * 기존의 클래스로 새로운 클래스를 작성하는것. (코드의 재사용)
     * 두 클래스를 부모와 자식으로 관계를 맺어주는것.
     * 자손은 조상의 모든 멤버를 상속받는다. (생성자, 초기화블럭 제외)
     * 자손의 멤버 개수는 조상보다 적을 수 없다. (같거나 많다.)
     * 자손의 변경은 조상에 영향을 미치지 않는다.
     *******************************************************************/
    public static void main(String[] args) {
        SmartTv stv = new SmartTv();
        stv.channel = 10;               // 조상클래스로 부터 상속받은 멤버
        stv.channelUp();                // 조상클래스로 부터 상속받은 멤버
        System.out.println(stv.channel);
        stv.displayCaption("Hello, World");
        stv.caption = true;
        stv.displayCaption("Hello, World");
    }
}
