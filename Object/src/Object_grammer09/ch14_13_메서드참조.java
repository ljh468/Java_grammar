package Object_grammer09;

import java.util.function.Function;
import java.util.function.Supplier;

public class ch14_13_메서드참조 {
    /*******************************************************************
     * 메서드 참조(method reference)
     * 하나의 메서드만 호출하는 람다식은 '메서드 참조'로 간단히 할 수 있다.
     * 1. static메서드 참조 : (x) -> ClassName.method(x) -> ClassName::method
     * 2. 인스턴스메서드 참조 : (obj, x) -> obj.method(x)  -> ClassName::method
     ******************************************************************/
    /*******************************************************************
     * 생성자의 메서드 참조
     * 공급자 : 입력은없고 출력만 있음
     *         Supplier<MyClass> s = () -> new MyClass();
     *         Supplier<MyClass> s = MyClass::new;
     * Function : 입력도있고 출력도 있음
     *            Function<Integer, MyClass> s = (i) -> new MyClass(i);
     *            Function<Integer, MyClass> s = MyClass::new;
     ******************************************************************/
    /*******************************************************************
     * 배열과 메서드 참조
     * Function<Integer, int[]> f = x -> new int[x]; // 람다식
     * Function<Integer, int[]> f = int[]::new;      // 메서드참조
     ******************************************************************/
    public static void main(String[] args) {
        // 람다식
        Function<String, Integer> f = (String s) -> Integer.parseInt(s);
        System.out.println(f.apply("100"));
        // 메서드 참조 (클래스이름::메서드이름)
        Function<String, Integer> f2 = Integer::parseInt;
        System.out.println(f2.apply("200"));

        // Supplier는 입력 X, 출력 O
        Supplier<MyClass> s = () -> new MyClass();
        Supplier<MyClass> s2 = MyClass::new;
        MyClass mc = s.get();
        System.out.println(mc);
        System.out.println(s.get()); // 서로 다른 객체

        // Function은 입력 O, 출력 O (생성자 추가)
        Function<Integer, MyClass2> s3 = (i) -> new MyClass2(i);
        Function<Integer, MyClass2> s4 = MyClass2::new;
        MyClass2 mc2 = s3.apply(100);
        System.out.println(mc2);
        System.out.println("mc2.iv = " + mc2.iv);
        System.out.println(s4.apply(200)); // 서로 다른 객체
        System.out.println("s3.apply(200).iv = " + s4.apply(200).iv);

        // 배열 생성
        Function<Integer, int[]> s5 = i -> new int[i];
        Function<Integer, int[]> s6 = int[]::new;
        int[] arr = s5.apply(100);
        System.out.println("arr.length = " + arr.length);
        System.out.println(s6.apply(100).length);
    }
}
class MyClass{}
class MyClass2{
    int iv;
    MyClass2(int iv){
        this.iv = iv;
    }
}