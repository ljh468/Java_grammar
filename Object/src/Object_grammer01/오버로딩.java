package Object_grammer01;

public class 오버로딩 {
    /*******************************************************************
     * 오버로딩 (overloading)
     * - 한 클래스 안에 같은 이름의 메서드 여러 개 정의 하는것 (매개변수만 다름)
     *
     * 오버로딩이 성립하기 위한 조건
     * 1. 메서드 이름이 같아야 한다.
     * 2. 매개변수의 개수 또는 타입이 달라야 한다.
     * 3. 반환 타입은 영향 없다.
     *******************************************************************/
    public static void main(String[] args) {
        MyMath3 myMath3 = new MyMath3();
        int add = myMath3.add(1, 2);
        System.out.println("add = " + add);
        long add2 = myMath3.add(3L, 4L);
        System.out.println("add2 = " + add2);
        int add3 = myMath3.add(new int[]{1,2,3,4,5});
        System.out.println("add3 = " + add3);
    }
}
class MyMath3{
    int add(int a, int b){
        System.out.println("int add(int a, int b) - ");
        return a + b;
    }
    long add(long a, long b){
        System.out.println("long add(long a, long b) - ");
        return a + b;
    }
    int add(int[] a){
        System.out.println("int add(int[] a) - ");
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }
}
