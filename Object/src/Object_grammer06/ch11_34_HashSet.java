package Object_grammer06;

import java.util.*;

public class ch11_34_HashSet {
    /*******************************************************************
     * HashSet - 순서 X, 중복 X
     * - Set인터페이스를 구현한 대표적인 컬렉션 클래스
     * - 순서를 유지하려면, LinkedHashSet클래스를 사용하면 된다.
     *******************************************************************/
    /*******************************************************************
     * TreeSet - 순서 X, 중복 X
     * - 범위 검색과 정렬에 유리한 컬렉션 클래스
     * - HashSet보다 데이터 추가, 삭제에 시간이 더 걸림
     *******************************************************************/
    public static void main(String[] args) {
        /*******************************************************************
         * boolean add(Object o) : 추가
         * boolean addAll(Collection c) : 합집합
         * boolean remove(Object o) : 삭제
         * boolean removeAll(Collection c) : 교집합
         * boolean retainAll(Collection c) : 차집합(조건부 삭제)
         * void clear() : 모두삭제
         * boolean contains(Object o) : 객체가 포함하는지 확인
         * boolean containsAll(Collection c) : 여러객체가 모두 포함하는지 확인
         * Iterator iterator() : iterator 객체 반환
         * boolean isEmpty() : 비어있는지 확인
         *******************************************************************/
        /*******************************************************************
         * 예제 1 : set객체를 활용하여 중복제거
         *******************************************************************/
        Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
        Set set = new HashSet();
        for(int i = 0; i < objArr.length; i++){
            // HashSet에 objArr의 요소들을 저장한다. (중복 X)
            System.out.println(objArr[i] + "=" + set.add(objArr[i]));

        }
        // HashSet에 저장된 요소들을 출력한다.
        System.out.println(set);

        // HashSet에 저장된 요소들을 출력한다.(Iterator 이용)
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        /*******************************************************************
         * 예제 2 : set의 크기가 6보다 작은 동안 1~45사이의 난수를 저장
         *******************************************************************/
        Set set2 = new HashSet();
        for(int i = 0; set2.size() < 6; i++){
            int num = (int)(Math.random()*45) + 1; // 1~45사이의 random값
//            set.add(new Integer(num));
            set2.add(num);
        }
        // set은 정렬이 안됨
        System.out.println(set2);
        
        // set을 List로 옮기고 정렬
        List list = new LinkedList(set2); // LinkedList(Collection c)
        Collections.sort(list);          // Collections.sort(List list)
        System.out.println(list);
        
        /*******************************************************************
         * 예제3 : 
         * HashSet은 객체를 저장하기전에 기존에 같은 객체가 있는지 확인
         * 같은 객체가 없으면 저장하고, 있으면 저장하지 않는다.
         * boolean add(Object o)는 저장할 객체의 equals()와 hashCode()를 호출 (중복확인)
         * equals()와 hashCode()가 오버라이딩 되어 있어야함
         *******************************************************************/
        HashSet set3 = new HashSet();

        set3.add("abc");
        set3.add("abc");
        set3.add(new Person2("Devid", 10));
        set3.add(new Person2("Devid", 10));
        System.out.println(set3);

        /*******************************************************************
         * 예제4 :
         *******************************************************************/
        HashSet setA = new HashSet();
        HashSet setB = new HashSet();
        HashSet setHab = new HashSet();
        HashSet setKyo = new HashSet();
        HashSet Cha = new HashSet();

        setA.add("1");
        setA.add("2");
        setA.add("3");
        setA.add("4");
        setA.add("5");
        System.out.println("A = " + setA);

        setB.add("4");
        setB.add("5");
        setB.add("6");
        setB.add("7");
        setB.add("8");
        System.out.println("B = " + setB);

        // 교집합 (공통된 요소만 남기고 삭제)(공통된 요소만 남기고 삭제)
//        setA.retainAll(setB);
//        System.out.println("교집합 : " + setA);

       // 합집합 : setB의 모든 요소를 추가(중복 제외)
//        setA.addAll(setB);
//        System.out.println("합집합 : " + setA);

        // 차집합 : setB의 공통 요소를 제거
        setA.removeAll(setB);
        System.out.println("차집합 : " + setA);

        System.out.println("A ∩ B= " + setKyo);
        System.out.println("A ∪ B = " + setHab); // 한글 ㄷ을 누르고
        System.out.println("A - B = " + Cha);
        /*******************************************************************
         * 예제4 :
         ******************************************************************/
    }
}
// equals()와 hashCode()를 오버라이딩해야 HashSet이 바르게 동작
class Person2{
    String name;
    int age;

    Person2(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return name + ":" + age;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Person2)) return false;
        Person2 p = (Person2) obj;
        // 나 자신(this)의 이름과 나이를 p와 비교
        return this.name.equals(p.name) && this.age == p.age;
    }

    @Override
    public int hashCode() {
        // int hash(Object... values); 가변인자
        return Objects.hash(name, age);
    }
}