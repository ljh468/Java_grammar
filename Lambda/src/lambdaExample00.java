@FunctionalInterface
interface Print {
    void print(int a, int b);
}

class Test {
    public void testMethod(Print print) {
        print.print(1, 2);
        System.out.println("콘솔 출력 실행문");
    }
}
public class lambdaExample00 {
    public static void main(String[] args) {
        Test noLambda = new Test();

        // print 메서드를 오버라이딩
        noLambda.testMethod(new Print() {
            @Override
            public void print(int a, int b) {
                System.out.println("a와 b의 합은 : " + (a + b));
                System.out.println("a와 b의 차는 : " + (a - b));
            }
        });

        Test lambdaTest = new Test();
        lambdaTest.testMethod((a, b) -> {
            System.out.println("a와 b의 합은 : " + (a + b));
            System.out.println("a와 b의 차는 : " + (a - b));
        });

    }
}
