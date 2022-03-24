package Object_grammer02;

abstract class Unit2{
    int x, y;
    abstract void move(int x, int y);
    void stop(){
        System.out.println("멈춥니다.");
    }
}
interface Fightable{    // 인터페이스의 모든 메서드는 public abstract. (예외없이)
    void move(int x, int y);    // public abstract가 생략됨
    void attack(Fightable f);   // public abstract가 생략됨
}
class Fighter2 extends Unit2 implements Fightable{
    // 오바라이딩 규칙 : 조상보다 접근제어자가 좁으면 안된다.
    public void move(int x, int y) {
        System.out.println("[" + x + ", " + y + "]로 이동");
    }
    public void attack(Fightable f) {
        System.out.println("[" + f + "]로 공격");
    }
    // 싸울 수 있는 상대를 불러온다.
    Fightable getFightable(){
        return (Fightable) new Fighter2(); // Fightable을 구현한 Fighter를 생성해서 반환
    }
}
public class ch_7_38_인터페이스_다형성 {
    /*******************************************************************
     * 인터페이스를 이용한 다형성
     * 인터페이스도 구현 클래스의 부모?
     * 부모는 아니지만 부모역할을 함
     * !! - 인터페이스 타입 매개변수는 인터페이스를 구현한 클래스의 객체만 가능
     * 인터페이스를 메서드의 리턴타입으로 지정할 수 있다.
     * !! - 인터페이스를 구현한 클래스의 인스턴스를 반환
     *******************************************************************/
    public static void main(String[] args) {
//        Fighter2 f = new Fighter2();
        Unit2 u = new Fighter2();
        u.move(100, 200);
//        u.attack(new Fighter2()); // Unit2에는 attack()이 없어서 호출불가
        u.stop();
        System.out.println("########################################");

        Fightable f = new Fighter2();
        f.move(100, 200);
        f.attack(new Fighter2());
//        f.stop(); // Fightable에는 stop()이 없어서 호출불가
        System.out.println("########################################");

        Fighter2 f2 = new Fighter2();
        Fightable f3 = f2.getFightable(); // getFightable의 반환타입과 일치해야함

    }
}
