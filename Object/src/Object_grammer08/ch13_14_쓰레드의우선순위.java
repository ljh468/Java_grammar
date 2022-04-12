package Object_grammer08;

public class ch13_14_쓰레드의우선순위 {
    /*******************************************************************
     * 쓰레드의 우선순위(priority of thread)
     * 작업의 중요도에 따라 쓰레드의 우선순위를 다르게 하여 특정 쓰레드가 더 많은 작업 시간을 갖게 할 수 있다.
     *******************************************************************/
    /*******************************************************************
     * 쓰레드그룹
     * - 서로 관련된 쓰레디를 그룹으로 묶어서 다루기 위한것.
     * - 모든 쓰레드는 반드시 하나의 쓰레드 그룹에 포함되어 있어야 한다.
     * - 쓰레드 그룹을 지정하지 않고 생성한 쓰레드는 'main쓰레드 그룹'에 속한다.
     * - 자신을 생성한 쓰레드(부모 쓰레드)의 그룹과 우선순위를 상속받는다.
     *******************************************************************/
    public static void main(String[] args) {
        ThreadEx6_1 th1 = new ThreadEx6_1();
        ThreadEx6_2 th2 = new ThreadEx6_2();

        // 우선순위는 1~10까지 (높을수록 우선순위가 높음) but 희망사항일뿐이다.
        // 기본값은 5
        th2.setPriority(9);
        System.out.println("th1.getPriority(-) = " + th1.getPriority());
        System.out.println("th2.getPriority(|) = " + th2.getPriority());
        th1.start();
        th2.start();
    }
}
class ThreadEx6_1 extends Thread{
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for(int x = 0; x < 10000000; x++); // 시간지연용 for문
        }
    }
}
class ThreadEx6_2 extends Thread{
    public void run(){
        for(int i = 0; i < 300; i++){
            System.out.print("|");
            for(int x = 0; x < 1000000; x++); // 시간지연용 for문
        }
    }
}
