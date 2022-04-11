package Object_grammer07;

import java.util.ArrayList;

class Fruit2 extends Fruit {
    public String toString(){
        return "Fruit";}
}
class Apple2 extends Fruit2{public String toString(){
    return "Apple";}}
class Grape2 extends Fruit2{public String toString(){
    return "Grape";}}

class Juice{
    String name;
    Juice(String name){
        this.name = name + "Juice";}
    public String toString(){
        return name;}
}

class Juicer{
    static Juice makeJuice(FruitBox2<? extends Fruit2> box){
        String tmp = "";
        for (Fruit2 f : box.getList()) {
            tmp += f + " ";
        }
        return new Juice(tmp);
    }
}
public class ch12_12_와일드카드 {
    /*******************************************************************
     * 와일드 카드 <?>
     * 하나의 참조 변수로 대입된 타입이 다른 객체를 참조 가능
     * <? extends T> : 와일드 카드의 상한 제한. T와 그 자손들만 가능
     * <? super T> : 와일드 카드의 하한 제한. T와 그 조상들만 가능
     * <?> : 제한 없음. 모든 타입이 가능. <? extends Object>와 동일
     * 
     * 메서드의 매개변수에 와일드 카드 사용 가능
     *******************************************************************/
    /*******************************************************************
     * 지네릭 메서드
     * 지네릭타입이 선언된 메서드(타입 변수는 메서드 내에서만 유효)
     * 클래스의 타입 매개변수<T>와 메서드의 타입 매개변수 <T>는 별개 (메서드 타입변수가 우선)
     * 메서드를 호출할 때마다 타입을 대입해야 함 (대부분 생략가능)
     * 메서드를 호출할 대 타입을 생략하지 않을 때는 클래스 이름 생략 불가
     *******************************************************************/
    public static void main(String[] args) {
        // 타입 변수는 일치 하여야함
        FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
        // Fruit2와 그 자손들을 가질 수 있음 (Apple, Grape)
//        FruitBox2<? extends Fruit2> appleBox = new FruitBox2<Apple2>();
        FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();

//        appleBox = new FruitBox2<Fruit2>();
//        appleBox = new FruitBox2<Apple2>();
//        appleBox = new FruitBox2<Grape2>();

        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());
        appleBox.add(new Apple2());
        appleBox.add(new Apple2());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));
    }
}
class FruitBox2<T extends Fruit> extends Box2<T> {
}
class Box2<T>{
    ArrayList<T> list = new ArrayList<>();
    void add(T item) {
        list.add(item);}
    T get(int i){
        return list.get(i);}
    ArrayList<T> getList(){return list;}
    int size(){
        return list.size();}
    public String toString(){
        return list.toString();}
}