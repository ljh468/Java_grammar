package Object_grammer08;

import javax.swing.*;

class ThreadEx5_1 implements Runnable{
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}
public class ch13_11_IO블락킹 {
    /*******************************************************************
     * 쓰레드의 I/O블락킹(blocking)
     * I/O블락킹 : 입출력시 작업 중단
     * 싱글쓰레드는 사용자의 입력을 받을때 기다려야 하는데
     * 멀티쓰레드는 그동안 다른쓰레드로 작업을 수행할 수 있음 (효율적)
     *******************************************************************/
    public static void main(String[] args) {
        /**
         * 멀티쓰레드로 구현된 시간제한 입력받기
         */
        Thread th1 = new Thread(new ThreadEx5_1());
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + "입니다.");
    }
}
