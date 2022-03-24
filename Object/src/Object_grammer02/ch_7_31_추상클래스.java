package Object_grammer02;

abstract  class Player{ // 추상클래스
    abstract void play(int pos); // 추상메서드
    abstract void stop();        // 추상메서드 (선언부만 있고 구현부{}가 없는 메서드)
}
class AudioPlayer extends Player{
    void play(int pos){
        System.out.println(pos + "위치 부터 play합니다.");
    };
    void stop() {
        System.out.println("재생을 멈춥니다.");
    };
}
public class ch_7_31_추상클래스 {
    /*******************************************************************
     * 추상클래스(abstract class)
     * 미완성 설계도. 추상(미완성) 메서드를 갖고 있는 클래스
     * 다른 클래스 작성에 도움을 주기 위한 것. 인스턴스 생성 불가
     * 상속을 통해 추상 메서드를 완성해야 인스턴스 생성 가능
     *******************************************************************/
    /*******************************************************************
     * 추상메서드(abstract method)
     * 미완성 메서드. 구현부(몸통, {})가 없는 메서드
     * abstract 리턴타입 메서드이름(); (주석을 통해 어떤 기능을 수행할 목적으로 작성하였는지 설명한다.)
     * 꼭 필요하지만 자손마다 다르게 구현될 것으로 예상되는 경우 사용
     * (일부만 구현한 경우 abstract를 붙여야 함)
     *******************************************************************/
    public static void main(String[] args) {
        /**
         * 추상 클래스는 상속을 통해 완성해야 객체 생성가능
         */
//        Player p = new Player();
//        AudioPlayer ap = new AudioPlayer();
        Player ap = new AudioPlayer();
        ap.play(100);
        ap.stop();
    }
}
