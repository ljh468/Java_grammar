package Object_grammer08;

public class ch13_28_join {
    /*******************************************************************
     * join()
     * 지정된 시간동안 특정 쓰레드가 작업하는 것을 기다린다.
     * void join(long millis) // 1000 / 1초 동안
     *******************************************************************/
    /*******************************************************************
     * yield() - static 메서드 (자기자신한테만 사용)
     * 남은 시간을 다음 쓰레드에게 양보하고, 자신(현재 쓰레드)은 실행대기한다.
     * yield()와 interrupt()를 적절히 사용하면, 응답성과 효율을 높일 수 있다.
     * yield가 적용될지 안될지는 OS가 판단
     *******************************************************************/
    static long startTime = 0;
    public static void main(String[] args) {
        ThreadEx11_1 th1 = new ThreadEx11_1();
        ThreadEx11_2 th2 = new ThreadEx11_2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();
        try{
            th1.join(); // main 쓰레드가 th1의 작업이 끝날때 까지 기다린다.
            th2.join();
        } catch (InterruptedException e){}

        System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
    }
}
class ThreadEx11_1 extends Thread{
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
    }
}
class ThreadEx11_2 extends Thread{
    public void run(){
        for(int i = 0; i < 300; i++){
            System.out.print("|");
        }
    }
}
