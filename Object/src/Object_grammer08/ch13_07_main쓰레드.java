package Object_grammer08;

public class ch13_07_main쓰레드 {
    /*******************************************************************
     * main 쓰레드
     * main 메서드의 코드를 수행하는 쓰레드
     * 쓰레드는 '사용자 쓰레드'와 '데몬 쓰레드' 두 종류가 있다.
     * (실행 중인 사용자 쓰레드가 하나도 없을때 프로그램은 종료된다.)
     *******************************************************************/

    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx1_1 th1 = new ThreadEx1_1();
        Thread th2 = new Thread(new ThreadEx1_2());
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        /**
         * main메서드가 종료되도 쓰레드가 남아있으면 프로그램은 종료 되지 않는다.
         */
        try{
            th1.join(); // main쓰레드가 th1의 작업이 끝날때까지 기다림
            th2.join(); // main쓰레드가 th2의 작업이 끝날때까지 기다림
        }catch (InterruptedException e){
        }
        // 쓰레드가 모두 종료되고 소요시간이 나옴
        System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
    }
}
