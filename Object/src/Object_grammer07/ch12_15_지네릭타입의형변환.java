package Object_grammer07;

import java.util.ArrayList;

class Fruit3 implements Eatable{
    public String toString(){
        return "Fruit";}
}
class Apple3 extends Fruit3{public String toString(){
    return "Apple";}}
class Grape3 extends Fruit3{public String toString(){
    return "Grape";}}
class Toy3 {public String toString(){
    return "Toy";}}

public class ch12_15_지네릭타입의형변환 {
    /*******************************************************************
     * 지네릭 타입의 형변환
     * 지네릭 타입과 원시 타입 간의 형변환은 바람직 하지 않다.(경고 발생) (원시타입만 쓰는것은 X)
     * 와일드 카드가 사용된 지네릭 타입으로는 형변환 가능
     * Ex ) Box<Object> objBox = (Box<Object>) new Box<String>(); // 에러 (형변환 불가)
     *      Box<? extends Object> wBox = new Box<String>();       // OK. (와일드카드)
     *******************************************************************/
    /*******************************************************************
     * 지네릭 타입의 제거
     * 컴파일러는 지네릭 타입을 제거하고, 필요한 곳에 형변환을 넣는다.
     * 1. 지네릭 타입의 경계(bound)를 제거 (하위호환성 때문에 T ==> Object로 변경됨)
     * 2. 지네릭 타입 제거 후에 타입이 불일치하면, 형변환을 추가 (컴파일러가 해줌)
     * 3. 와일트 카드가 포함된 경우, 적절한 타입으로 형변환 추가
     *******************************************************************/
    public static void main(String[] args) {
        Box b = null;
//        Box b = new Box<String>();         // OK. but 경고발생 (지네릭타입 써줘야함)
//        Box<Stirng> b = new Box<String>();

//        Box<Object> b = new Box<String>(); // 에러 (지네릭타입이 다르면 에러)

        Box<String> bStr = null;

        b = (Box)bStr;          // Box<String> -> Box (가능하지만 경고)
        bStr = (Box<String>)b;  // Box -> Box<String>

        /*******************************************************************
         * 예제
         *******************************************************************/
        FruitBox3<Fruit3> box = new FruitBox3<Fruit3>();
        // FruitBox3<Apple3> ==> FruitBox3<? extends Fruit3>        // Ok.
        FruitBox3<? extends Fruit3> abox = new FruitBox3<Apple3>(); // 타입불일치 자손 형변환 가능
        // FruitBox3<? extends Fruit3> ==> FruitBox3<Apple>();
        FruitBox3<Apple3> appleBox = (FruitBox3<Apple3>) abox;      // Ok. 경고발생


    }
}
class FruitBox3<T extends Fruit3 & Eatable> extends Box3<T> {
}
class Box3<T>{
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