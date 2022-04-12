package Object_grammer08;

public class ch13_22_sleep {
    /*******************************************************************
     * sleep()
     * 현재 쓰레드를 지정된 시간동안 멈추게 한다.
     * 필수로 예외처리를 해야 한다. (InterruptedException이 발생하면 깨어남)
     * 특정 쓰레드를 지정해서 멈추게 하는 것은 불가능하다.
     *
     * ======= 메서드는 자기자신에게만 동작 =======
     * static void sleep(long millis)
     * static void sleep(long millis, int nanos)
     *******************************************************************/
    public static void main(String[] args) {
        ThreadEx8_1 th1 = new ThreadEx8_1();
        ThreadEx8_2 th2 = new ThreadEx8_2();
        th1.start();
        th2.start();

        delay(2 * 1000);
        System.out.println("<< main 종료 >>");
    }

    /**
     * Thread.sleep을 메서드로 변경 (예외처리 필수)
     */
    static void delay(long millis){
        try {
            Thread.sleep(2000); // main 쓰레드 2초동안 sleep (자기자신만 호출)
        } catch (InterruptedException e) {} // 예외처리 필수
    }
}

class ThreadEx8_1 extends Thread{
    public void run(){
        for(int i = 0; i < 300; i++){
            System.out.print("-");
        }
        System.out.println("<< th1 종료 >>");
    }
}
class ThreadEx8_2 extends Thread{
    public void run(){
        for(int i = 0; i < 300; i++){
            System.out.print("|");
        }
        System.out.println("<< th2 종료 >>");
    }
}