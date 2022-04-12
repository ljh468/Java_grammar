package Object_grammer08;

import javax.swing.*;

public class ch13_24_interrupt {
    /*******************************************************************
     * interrupt()
     * 대기상태(WAITING)인 쓰레드를 실행대기상태(RUNNABLE)로 만든다.
     *
     * void interrupt() : 쓰레드의 interrupted상태를 false에서 true로 변경
     * boolean isaInterrupted() : 쓰레드의 interrupted상태를 반환
     * static boolean interrupted() : 현재 쓰레드의 interrupted상태를 알려주고, false로 초기화
     *******************************************************************/
    public static void main(String[] args) {
        ThreadEx9_1 th1 = new ThreadEx9_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt(); // interrupt()를 호출하면 interrupted상태가 true가 됨
        System.out.println("isInterrupted() : " + th1.isInterrupted()); // true
        // main쓰레드가 interrupt 되었는지 확인
        System.out.println("interrupted() : " + Thread.interrupted()); // (메인 쓰레드)false
    }
}

class ThreadEx9_1 extends Thread{
    public void run(){
        int i = 10;

        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);
            // 시간지연
            for (long x = 0; x < 2500000000L; x++) {}
            System.out.println("카운트가 종료되었습니다.");
        }
        System.out.println("isInterrupted() : " + this.isInterrupted()); // true
        System.out.println("isInterrupted() : " + this.isInterrupted()); // true

        // isInterrupted()와 달리 interrupted()는 interrupted라는 상태변수를 false로 초기화한다.
        System.out.println("interrupted() : " + Thread.interrupted());  // true (초기화)
        System.out.println("interrupted() : " + Thread.interrupted());  // false
    }
}