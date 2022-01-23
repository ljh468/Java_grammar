@FunctionalInterface
interface MyFunction2 {
    void run(); // public abstract void run();
}

public class lambda_01 {
    /**
     * 매개변수의 타입이 MyFunction2인 메서드
     * @param f (MyFunction2)
     */
    static void execute(MyFunction2 f){
        f.run();
    }
    /**
     * 반환타입이 MyFunction2 인 메서드
     * @return f (MyFunction2)
     */
    static MyFunction2 getMyFunction(){
//        MyFunction2 f = () -> System.out.println("f3.run()");
//        return f;
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args) {
        /**
         * 람다식으로 MyFunction2의 run()을 구현
         */
        MyFunction2 f1 = () -> System.out.println("f1.run()");

        /**
         * 익명클래스로  run()구현
         */
        MyFunction2 f2 = new MyFunction2() {
            public void run() {
                System.out.println("f2.run()");
            }
        };

        /**
         * 반환타입이 람다식
         */
        MyFunction2 f3 = getMyFunction();

        /**
         * 출력
         */
        f1.run(); // 람다식으로 구현
        f2.run(); // 익명클래스로 구현
        f3.run(); // 반환타입이 람다식

        // 매개변수가 람다식을 받아 run() 호출
        execute(f1);
        execute(() -> System.out.println("run()"));
    }
}
