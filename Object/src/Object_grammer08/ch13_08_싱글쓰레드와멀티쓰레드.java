package Object_grammer08;
class MyThead1 extends Thread{
    public void run(){
        for (int i = 0; i < 300; i++ ) {
            System.out.println("-");
        }
    }
}
class MyThread2 implements Runnable {
    @Override
    public void run(){
        for (int i = 0; i < 300; i++ ) {
            System.out.println("|");
        }
    }
}
public class ch13_08_싱글쓰레드와멀티쓰레드 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        /*******************************************************************
         * 싱글쓰레드
         * 싱글쓰레드는 순차적으로 실행
         *******************************************************************/
        for(int i = 0; i < 300; i++){
            System.out.printf("%s", new String("-"));
        }
        System.out.print("소요시간 1 : " + (System.currentTimeMillis() - startTime));

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.println("소요시간 2 : " + (System.currentTimeMillis() - startTime));

        /*******************************************************************
         * 멀티쓰레드
         * 멀티쓰레드는 시간과 순서는 OS의 스케쥴러가 결정
         * 싱글쓰레드보다 시간이 더 걸리지만, 두 가지 작업을 동시에 할 수 있음
         *******************************************************************/
        Thread th1 = new ThreadEx1_1();
        Thread th2 = new Thread(new ThreadEx1_2());
        th1.start();
        th2.start();
        try{
            th1.join(); // main쓰레드가 th1의 작업이 끝날때까지 기다림
            th2.join(); // main쓰레드가 th2의 작업이 끝날때까지 기다림
        }catch (InterruptedException e){
        }
        System.out.println("소유시간 : 3" + (System.currentTimeMillis() - startTime));
    }

}
