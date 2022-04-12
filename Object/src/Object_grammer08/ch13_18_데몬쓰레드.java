package Object_grammer08;

public class ch13_18_데몬쓰레드 implements Runnable{
    /*******************************************************************
     * 데몬 쓰레드(daemon thread)
     * - 일반 쓰레드의 작업을 돕는 보조적인 역할을 수행
     * - 일반 쓰레드가 모두 종료되면 자동적으로 종료된다.
     * - 가비지 컬렉터, 자동저장, 화면 자동갱신 등에 사용된다.
     * - 무한루프와 조건문을 이용해서 실행 후 대기하다가 특정조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.
     * - setDaemon(boolean on)은 반드시 start()호출전에 실행되어햐한다.
     *
     * boolean isDaemon() : 쓰레드가 데몬쓰레드인지 확인
     * void setDaemon(boolean on) : 쓰레드를 데몬쓰레드 또는 사용자쓰레드로 변경, true면 데몬쓰레드
     *******************************************************************/

    static boolean autoSave = false;

    public static void main(String[] args) {
        /**
         * main 쓰레드
         */
        Thread t = new Thread(new ch13_18_데몬쓰레드());
        t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다. (데몬쓰레드로 지정)
        t.start();

        for (int i = 1; i <= 17; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(i);
            if (i == 5) {
                autoSave = true;
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    @Override
    public void run(){
        /**
         * daemon 쓰레드
         */
        while(true){
            try {
                Thread.sleep(3 * 1000); // 3초마다
            } catch (InterruptedException e) {}
            if(autoSave) autoSave();
        }
    }
    public void autoSave(){
        System.out.println("작업파일이 자동저장되었습니다.");
    }
}
