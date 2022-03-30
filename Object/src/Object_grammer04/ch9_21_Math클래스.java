package Object_grammer04;

public class ch9_21_Math클래스 {
    /*******************************************************************
     * Math클래스
     * 수학관련 static메서드의 집합
     * Math.round() : 일반 반올림
     * Math.rint() : 짝수 반올림
     * Math.abs() : 절대값을 반환
     * Math.ceil() : 주어진 값을 올림하여 반환
     * Math.floor() : 주어진 값을 버림하여 반환
     * Math.random() : 0.0 ~ 1.0범위의 임의의 double값을 반환 (0.0 <= d < 1.0)
     *******************************************************************/
    public static void main(String[] args) {
        double sum = 0;
        double sum1 = 0;
        double sum2 = 0;

        for (double d = 1.5; d <= 10.5; d++) {
            double d1 = Math.round(d);
            // 홀수일때 올림, 짝수일때 버림 (짝수 반올림)
            // 오차가 줄어듬
            double d2 = Math.rint(d);

            System.out.printf("%4.1f %4.1f %4.1f\n" , d, d1, d2);
            sum += d;
            sum1 += d1;
            sum2 += d2;
        }
        System.out.println("---------------");
        System.out.printf("%4.1f %4.1f %4.1f\n" , sum, sum1, sum2);
    }
}
