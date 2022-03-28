package Object_grammer02;

public class ch7_34_추상클래스의작성 {
    /*******************************************************************
     * 추상메서드의 작성
     * 여러 클래스에 공통적으로 사용될 수 있는 추상클래스를 바로 작성하거나
     * 기존클래스의 공통 부분을 뽑아서 추상클래스를 만든다.
     *******************************************************************/
    /*******************************************************************
     * 추상화 (불명확) <==> 구체화 (명확)
     * 추상화된 코드는 구체화된 코드보다 유연하다. 변경에 유리
     *******************************************************************/
    public static void main(String[] args) {
        /**
         * 객체배열 : 참조변수 묶은 것
         */
        Unit[] group = {new Marine(), new Tank(), new Dropship()};
        for(int i = 0; i < group.length; i++){
            group[i].move(100, 200);
        }
    }
}
abstract class Unit{
    int x, y;
    abstract void move(int x, int y);
    void stop(){/* 현재 위치에 정지 */}
}
class Marine extends Unit{ // 보병
    void move(int x, int y){
        System.out.println("Marine[x=" + x + ", y=" + y + "]");
    }
    void StimPack(){/* 스팀팩을 사용한다. */}
}

class Tank extends Unit{ // 탱크
    void move(int x, int y){
        System.out.println("Tank[x=" + x + ", y=" + y + "]");
    }
    void changeMode(){/* 공격모드를 변환한다. */}
}
class Dropship extends Unit{ // 수송선
    void move(int x, int y){
        System.out.println("Dropship[x=" + x + ", y=" + y + "]");
    }
    void load(){/* 선택된 대상을 태운다. */}
    void unload(){/* 선택된 대상을 내린다.. */}
}
