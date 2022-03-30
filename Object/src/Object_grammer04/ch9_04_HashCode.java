package Object_grammer04;

import java.util.Objects;

class Card{
    String kind;
    int number;

    Card(){
        this("SPADE", 1);
    }

    Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }
    
    // object클래스의 toString()을 오버라이딩
    @Override
    public String toString() {
        return "Card{" +
                "kind='" + kind + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Card)) return false;
        Card c = (Card)o;
        return this.kind.equals(c.kind) && this.number == c.number;
    }

    // equals()를 오버라이딩하면 hashCode()도 오버라이딩 해야한다.
    @Override
    public int hashCode() {
        return Objects.hash(kind, number);
    }
}

public class ch9_04_HashCode {
    /*******************************************************************
     * hashCode()
     * 객체의 해시코드(hash code)를 반환하는 클래스
     * Object클래스의 hashCode()는 객체의 주소를 int로 변환해서 반환 (객체마다 다른값을 반환)
     * 
     * equals()를 오버라이딩하면, hashCode()도 오버라이딩해야 한다.
     * - equals()의 결과가 true인 두 객체의 해시코드는 같아야 하기 때문 (iv 비교)
     * 
     * System.identityHashCode(Object obj)는 Object클래스의 hashCode()와 동일
     *******************************************************************/
    /*******************************************************************
     * toString()의 오버라이딩
     * toString() : 객체를 문자열(String)으로 변환하기 위한 메서드
     *******************************************************************/
    public static void main(String[] args) {
        /**
         * toString으로 오버라이팅 하지 않으면 서로 다른 주소값이 나옴
         * 오버라이딩하게 되면 iv를 반환 (클래스는 iv의 집합)
         */
        Card c1 = new Card();
        Card c2 = new Card();
        System.out.println("c1.toString() = " + c1.toString());
        System.out.println("c2.toString() = " + c2.toString());
        System.out.println("################################################\n");

        /**
         * equals(), hashCode()를 오버라이딩하지 않으면 각 객체마다 다른 hash값이 나옴
         */
        System.out.println("c1.equals(c2) = " + c1.equals(c2));
        System.out.println("c1.hashCode() = " + c1.hashCode());
        System.out.println("c2.hashCode() = " + c2.hashCode());
    }
}
