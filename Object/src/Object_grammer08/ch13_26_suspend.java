package Object_grammer08;

public class ch13_26_suspend {
    /*******************************************************************
     * suspend(), resume(), stop()
     * 쓰레드의 실행을 일시정지, 재개, 완전정지 시킨다.
     * void suspend() : 쓰레드를 일시정지 시킨다.
     * void resume() : suspend()에 의해 일시정지된 쓰레드를 실행대기상태로 만든다.
     * void stop() : 쓰레드를 즉시 종료시킨다.
     *
     * 교착상태가 빠지기 쉬워서 deprecated가 됨 (dead-lock을 일으킬 우려가 있음)
     *******************************************************************/
    public static void main(String[] args) {
        MyThread th1 = new MyThread("*");
        MyThread th2 = new MyThread("**");
        MyThread th3 = new MyThread("***");
        th1.start();
        th2.start();
        th3.start();

        try{
            Thread.sleep(2000);
            th1.suspend(); // 쓰레드 th1를 잠시 중단시킨다.
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume(); // 쓰레드 th1이 다시 동작하도록 한다.
            Thread.sleep(3000);
            th1.stop();   // 쓰레드 th1을 강제종료시킨다.
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        }catch (InterruptedException e){}

    }
}

// 직접 구현
class MyThread implements Runnable{
    // volatile은 cpu가 Ram의 복사본을 사용하지 못하게 함 (원본을 사용)
    //쉽게 바뀌는 변수 때문에 원본에서 가져다가 쓰라는 의미
    volatile boolean suspend = false; // 쉽게 바뀌는 변수
    volatile boolean stoped = false;
    Thread th;

    // 생성자
    MyThread(String name){
        // Thread(Runnable r, String name)
        th = new Thread(this, name);
    }
    void start(){
        th.start();
    }
    void stop(){
        stoped = true;
    }
    void suspend(){
        suspend = true;
    }
    void resume(){
        suspend = false;
    }

    public void run(){
        while(!stoped){
            if (!suspend) {
                System.out.println(Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){}
            }
        }
    }
}