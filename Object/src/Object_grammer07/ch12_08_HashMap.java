package Object_grammer07;

import java.util.HashMap;

public class ch12_08_HashMap {
    /*******************************************************************
     * HashMap<K,V>
     * 여러개의 타입변수가 필요한 경우, 콤마(,) 를 구분자로 선언
     * Ex ) HashMap<String, Student> map = new HashMap<String, Student>(); // 생성
     *      map.put("자바왕", new Student("자바왕", 1, 1, 100, 100, 100));   // 데이터 저장
     *******************************************************************/
    public static void main(String[] args) {
        HashMap<String, Student2> map = new HashMap<>();
        map.put("자바왕", new Student2("자바왕", 1, 1, 100, 100, 100));
        System.out.println("map = " + map);

        // public V get(Object key)
        Student2 s = map.get("자바왕"); // 형변환 불필요
        System.out.println("s.name = " + s.name);
    }
}
class Student2{
    String name = "";
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    public Student2(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}
