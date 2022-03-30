package Object_grammer04;

public class ch9_01_object클래스 {
    /*******************************************************************
     * Objecdt클래스
     * 모든 클래스의 최고 조상, 오직 11개의 메서드만을 가지고 있다.
     * notify(), wait()등은 쓰레드와 관련된 메서드이다.
     *******************************************************************/
    /*******************************************************************
     * equals(Object obj)
     * 객체 자신(this)과 주어진 객체(obj)를 비교한다. 같으면 true, 다르면 false
     * Obejct클래스의 equals()는 객체의 주소를 비교(참조변수 값 비교)
     * 인스턴스 변수(iv)의 값을 비교하도록 equals()를 오버라이딩해야 한다.
     *******************************************************************/
    public static void main(String[] args) {
        Person p1 = new Person(801108111222L);
        Person p2 = new Person(801108111222L);
        if(p1.equals(p2)){
            System.out.println("p1과 p2는 같은사람입니다.");
        } else{
            System.out.println("p1과 p2는 다른사람입니다.");
        }
    }
}
class Person {
    long id;

    Person(long id) {
        this.id = id;
    }
    @Override
    // Object의 equals()를 오버라이딩해서 주소가 아닌 value를 비교
    public boolean equals(Object obj) {
        // 참조변수의 형변환 전에는 반드시 instanceof로 확인해야함
        if(!(obj instanceof Person)) return false;
        Person p = (Person)obj; // obj를 Person으로 형변환
        return this.id == p.id;
        // return this.id == (Person)obj.id;
    }
}
