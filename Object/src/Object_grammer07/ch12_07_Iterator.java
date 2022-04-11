package Object_grammer07;

import java.util.ArrayList;
import java.util.Iterator;

class Student{
    String name = ""; // 이름
    int ban;          // 반
    int no;           // 번호

    Student(String name, int ban, int no) {
        this.name = name;
        this.ban = ban;
        this.no = no;
    }
}
public class ch12_07_Iterator {
    /*******************************************************************
     * Interator<E>
     * 클래스를 작성할 때, Object타입 대신 T와 같은 타입 변수를 사용
     *******************************************************************/
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("자바왕", 1, 1));
        list.add(new Student("자바짱", 1, 2));
        list.add(new Student("홍길동", 2, 1));

        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
//            Student s = (Student) it.next(); // 지네릭스를 사용하지 않으면 형변환 필요
//            Student s = it.next();
//            System.out.println(s.name);
            System.out.println(it.next().name);
        }
    }
}
