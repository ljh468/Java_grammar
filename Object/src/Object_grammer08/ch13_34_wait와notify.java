package Object_grammer08;

import java.util.ArrayList;

public class ch13_34_wait와notify {
    /*******************************************************************
     * wait()과 notify()
     * 동기화의 효율을 높이기 위해 wait(), notify()를 사용
     * Object클래스에 정의되어 있으며, 동기화 블록 내에서만 사용할 수 있다.
     * wait() : 객체의 lock을 풀고 쓰레드를 해당 객체의 waiting pool에 넣는다.
     * notify() : waiting pool에서 대기중인 쓰레드 중의 하나를 깨운다.
     * notifyAll() : waiting pool에서 대기중인 모든 쓰레드를 깨운다.
     *******************************************************************/
    public static void main(String[] args) throws InterruptedException {
        /*******************************************************************
         * 예제 1
         * 요리사는 Table에 음식을 추가. 손님은 Table의 음식을 소비
         * 요리사와 손님이 같은 객체(Table)을 공유하므로 동기화가 필요
         * 
         * 동기화 X ==> 예외발생
         * - 요리사가 Table에 요리를 추가하는 과정에 손님이 요리를 먹음
         * - 하나 남은 요리를 손님2가 먹으려하는데, 손님1이 먹음
         * [문제점] Table을 여러 쓰레드가 공유하기 때문에 작업 중에 끼어들기 발생
         * [해결책] Table의 add()와 remove()를 syncronized로 동기화
         * 
         * 동기화 O ==> 비효율적
         * [문제점] 예외는 발생하지 않지만, 손님이 Table에 lock건 상태를 지속 할 수 있음
         *         요리사 Table의 lock을 얻을 수 없어서 음식을 추가 하지 못함
         * [해결책] 음식이 없을때, wait()으로 손님이 lock를 풀고 기다리게 하자
         *         요리사가 음식을 추가하면, notify()로 손님에게 알리자(손님이 lock을 재확인)
         ******************************************************************/
        /*******************************************************************
         * wait()와 notify()를 사용시
         * 전과 달리 한 쓰레드가 lock을 오래 쥐는 일이 없어짐. 효율적이 됨
         ******************************************************************/
        Table2 table = new Table2();

        new Thread(new Cook2(table), "COOK").start();
        new Thread(new Customer2(table, "donut"),  "CUST1").start();
        new Thread(new Customer2(table, "burger"), "CUST2").start();
        Thread.sleep(2000);
        System.exit(0);
    }
}

class Table2 {
    String[] dishNames = { "donut","donut","burger" }; // donut의 확률을 높인다.
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        while(dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name+" is waiting.");
            try {
                wait(); // COOK쓰레드를 기다리게 한다.
                Thread.sleep(500);
            } catch(InterruptedException e) {}
        }
        dishes.add(dish);
        notify();  // 기다리고 있는 CUST를 깨우기 위함.
        System.out.println("Dishes:" + dishes.toString());
    }

    public void remove(String dishName) {
        synchronized(this) {
            String name = Thread.currentThread().getName();

            while(dishes.size()==0) {
                System.out.println(name+" is waiting.");
                try {
                    wait(); // CUST쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            }

            while(true) {
                for(int i=0; i<dishes.size();i++) {
                    if(dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify(); // 잠자고 있는 COOK을 깨우기 위함
                        return;
                    }
                } // for문의 끝

                try {
                    System.out.println(name+" is waiting.");
                    wait(); // 원하는 음식이 없는 CUST쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            } // while(true)
        } // synchronized
    }
    public int dishNum() { return dishNames.length; }
}
class Customer2 implements Runnable {
    private Table2  table;
    private String food;

    Customer2(Table2 table, String food) {
        this.table = table;
        this.food  = food;
    }

    public void run() {
        while(true) {
            try { Thread.sleep(100);} catch(InterruptedException e) {}
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);
        } // while
    }
}

class Cook2 implements Runnable {
    private Table2 table;

    Cook2(Table2 table) { this.table = table; }

    public void run() {
        while(true) {
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try { Thread.sleep(10);} catch(InterruptedException e) {}
        } // while
    }
}