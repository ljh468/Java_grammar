package Object_grammer07;

import java.util.ArrayList;

interface Eatable{}
class Fruit implements Eatable{
    public String toString(){
        return "Fruit";}
}
class Apple extends Fruit{public String toString(){
    return "Apple";}}
class Grape extends Fruit{public String toString(){
    return "Grape";}}
class Toy {public String toString(){
    return "Toy";}}

public class ch12_09_제한된지네릭클래스 {
    /*******************************************************************
     * 제한된 지네릭 클래스
     * extends로 대입할 수 있는 타입을 제한 할 수 있음
     * 인터페이스인 경우에도 extends를 사용
     *******************************************************************/
    /*******************************************************************
     * 지네릭스의 제약
     * 타입 변수에 대입은 인스턴스 별로 다르게 가능
     * 1. static 멤버에 타입 변수 사용불가(모든 인스턴스에 공통)
     * 2. 배열 생성할 때 타입변수 사용불가. 타입 변수로 배열 선언은 가능 (new 다음에 T 불가)
     *******************************************************************/
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//        FruitBox<Grape> grapeBox = new FruitBox<Apple>(); // 에러 (타입 불일치)
//        FruitBox<Toy> toyBox = new FruitBox<Toy>(); // 에러 (Toy는 자손이 아님)
        Box<Toy> toyBox = new Box<Toy>();
        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
//        appleBox.add(new Grape()); // 에러, Grape는 Apple의 자손이 아님
        grapeBox.add(new Grape());

        System.out.println("fruitBox = " + fruitBox);
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);
        System.out.println("toyBox = " + toyBox);
    }
}
// Eatable 인터페이스로 구현된 Fruit자신 또는 자손만 타입으로 사용가능
class FruitBox<T extends Fruit & Eatable> extends Box<T> {
}
class Box<T>{
    ArrayList<T> list = new ArrayList<>();
    void add(T item) {
        list.add(item);}
    T get(int i){
        return list.get(i);}
    int size(){
        return list.size();}
    public String toString(){
        return list.toString();}
}
