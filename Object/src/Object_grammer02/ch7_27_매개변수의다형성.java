package Object_grammer02;

class Product{
    int price;      // 제품의 가격
    int bonusPoint; // 제품 구매시 제공하는 보너스

    Product(int price){
        this.price = price;
        bonusPoint = (int) (price / 10.0);
    }
}
class Tv1 extends Product{
    Tv1(){
        // 조상클래스의 생성자 Product (int price)를 호출한다.
        super(100);
    }

    @Override
    public String toString() {
        return "Tv1";
    }
}
class Computer extends Product{
    Computer(){
        super(200);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}
class Audio extends Product{
    Audio(){
        super(50);
    }
    @Override
    public String toString() {
        return "Audio";
    }
}
class Buyer{ // 고객, 물건을 사는사람
    int money = 1000;
    int bonusPoint = 0;
    Product[] cart = new Product[10];   // 구입한 제품을 저장하기 위한 배열
    int i = 0;

    void buy(Product p){
        if(money < p.price){
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }
        money -= p.price;           // 가진 돈에서 구입한 제품의 가격을 뺀다.
        bonusPoint += p.bonusPoint; // 제품의 보너스 점수를 추가한다.
        cart[i++] = p;              // 제품을 Product[] cart에 저장한다.
        System.out.println(p + " 을/를 구입하셨습니다.");
    }
}
public class ch7_27_매개변수의다형성 {
    /*******************************************************************
     * 매개변수의 다형성
     * 참조형 매개변수는 메서드 호출시, 자신과 같은 타입 또는 자손타입의 인스턴스를 넘겨줄 수 있다.
     * 장점 : 
     * 1. 다형적 매개변수
     * 2. 하나의 배열로 여러종류 객체 다루기
     *******************************************************************/
    public static void main(String[] args) {
        Buyer b = new Buyer();
        /**
         * 1. 다형적 매개변수
         */
        b.buy(new Tv1());       // buy(Product p)
        b.buy(new Computer());  // buy(Product p)
        b.buy(new Audio());  // buy(Product p)
        System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
        System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다.");

        /**
         * 2. 하나의 배열로 여러종류 객체 다루기
         * - 조상타입의 배열에 자손들의 객체를 담을 수 있다.
         */
        int sum = 0;
        String itemList = "";
        for (int i = 0; i < b.cart.length; i++) {
            if(b.cart[i] == null) break;
            sum += b.cart[i].price;
            itemList += b.cart[i] +", ";
        }
        System.out.println("구입하신 물품의 총금액은 : " + sum);
        System.out.println("구입하신 물품은 : " + itemList);
    }
}
