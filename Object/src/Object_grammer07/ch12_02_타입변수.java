package Object_grammer07;

import java.util.ArrayList;

class Product{
}
class Tv extends Product{
}
class Audio extends Product{
}

public class ch12_02_타입변수 {
    /*******************************************************************
     * 타입변수
     * 클래스를 작성할 때, Object타입 대신 타입 변수(E)를 선언해서 사용.
     * 객체를 생성시, 타입 변수(E) 대신 실제 타입(Tv)을 지정(대입)
     *******************************************************************/
    /*******************************************************************
     * 지네릭 타입과 다형성
     * 1.참조 변수와 생성자의 대입된 타입은 일치해야한다.
     * EX ) ArrayList<Tv> list = new ArrayList<Tv>(); // 타입 일치, 조상 안됨 X
     *
     * 2.지네릭 클래스간의 다형성은 성립.(여전히 대입된 타입은 일치해야함)
     * EX ) List<Tv> list = new ArrayList<Tv>(); // ArrayList가 List를 구현
     *
     * 3.매개변수의 다형성도 성립
     * Ex ) ArrayList<Product> list = new ArrayList<Product>();
     *      list.add(new Product());
     *      list.add(new Tv());     // 자손 객체 OK
     *******************************************************************/
    public static void main(String[] args) {
        /*******************************************************************
         * 예제 1
         *******************************************************************/
        // Tv타입의 객체만 저장가능
        ArrayList<Tv> list = new ArrayList();
        list.add(new Tv());
//        list.add(new Audio()); // 지네릭스가 선언된 타입만 추가 가능
        Tv t = list.get(0); // 형변환 불필요

        /*******************************************************************
         * 예제 2
         *******************************************************************/
        ArrayList<Product> productList = new ArrayList<Product>();
        ArrayList<Tv> tvList = new ArrayList<Tv>();
//        ArrayList<Product> tvList = new ArrayList<Tv>(); // 에러
//        List<Tv> tvList = new ArrayList<Tv>(); // OK. 다형성 (대입된 타입만 같으면 됨)

        productList.add(new Tv());      // 자손 객체 사용가능
        productList.add(new Audio());

        tvList.add(new Tv());
        tvList.add(new Tv());
//        tvList.add(new Audio()); // 에러 (자신또는 자손객체만 가능)

        printAll(productList);
//        printAll(tvList); // 컴파일 에러가 발생 (참조변수 타입과 생성자의 타입이 맞지 않음)
    }

    public static void printAll(ArrayList<Product> list){
        for(Product p : list){
            System.out.println("p = " + p);
        }
    }
}
