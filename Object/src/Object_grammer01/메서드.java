package Object_grammer01;

public class 메서드 {
    /*******************************************************************
     * 메서드의 장점
     * - 코드의 중복을 줄일 수 있다.
     * - 코드의 관리가 쉽다.
     * - 코드를 재사용할 수 있다.
     * - 코드가 간결해서 이해하기 쉬워진다.
     *******************************************************************/

    /*******************************************************************
     * 메서드의 작성
     * - 반복적으로 수행되는 여러 문장을 메서드로 작성
     * - 하나의 메서드는 한 가지 기능만 수행하도록 작성
     * 
     * 메서드 = 선언부 + 구현부
     * 반환타입 메서드이름(타입변수명, 타입변수명, ...) // 선언부
     * { 메서드 호출시 수행될 코드 } // 구현부
     *******************************************************************/

    /*******************************************************************
     * 메서드의 호출
     * 메서드이름(값1, 값2, ...); // 메서드를 호출하는 방법
     *******************************************************************/
    public static void main(String[] args) {
        MyMath mm = new MyMath();
        long result1 = mm.add(5L, 3L); // add 메서드 호출
        long result2 = mm.subtract(5L, 3L);
        long result3 = mm.multiply(5L, 3L);
        double result4 = mm.divide(5L, 3L);
        long result5 = mm.max(5, 3); // 둘 중에 큰 값을 반환하는 메서드
        long result6 = mm.min(5, 3); // 둘 중에 작은 값을 반환하는 메서드
        mm.printGugudan(12); // 12단 출력

        System.out.println("add = " + result1);
        System.out.println("subtract = " + result2);
        System.out.println("multiply = " + result3);
        System.out.println("divide = " + result4);
        System.out.println("max = " + result5);
        System.out.println("min = " + result6);

    }
}
class MyMath{
    void printGugudan(int dan){
        if(!(2 <= dan && dan <= 9)){ // 입력받은 단(dan)이 2~9가 아니면, 메서드 종료하고 돌아가기
            return;
        }
        for(int i = 1; i <= 9; i++){
            System.out.printf("%d + %d = %d\n", dan, i, dan * i);
        }
    }
    long add(long a, long b){
        return a + b;
    }
    long subtract(long a, long b) {
        return a - b;
    }
    long multiply(long a, long b) {
        return a * b;
    }
    double divide(double a, double b) {
        return a / b;
    }
    // 두 값을 받아서 둘중 큰 값을 반환하는 메서드를 작성
    long max(long a, long b){
        long result = 0;
//        if(a > b){
//            result = a;
//        }else{
//            result = b;
//        }
//        return result;
        return a > b ? a : b;
    }
    long min(long a, long b){
        long result = 0;
        if(a < b){
            return a;
        } else {
            return b;
        }
    }
}
