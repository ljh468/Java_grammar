package Object_grammer07;

enum Direction{EAST, SOUTH, WEST, NORTH}

public class ch12_17_열거형enum {
    /*******************************************************************
     * 열거형(enum)
     * 관련된 상수들을 같이 묶어 놓은 것. Java는 타입에 안전한 열거형을 제공 (타입 & 값을 모두체크)
     * 비교연산자 사용 불가 (CompareTo() 사용가능)
     *
     * 열거형을 정의하는 방법
     * Ex : enum 열거형이름 { 상수명1, 상수명2, ...}
     *******************************************************************/
    /*******************************************************************
     * 열거형의 조상 - java.lang.Enum
     * 모든 열거형은 Enum의 자손이며, 아래의 메서드를 상속 받는다.
     * String name() : 열거형 상수의 이름을 문자열로 반환
     * int ordinal() : 열거형 상수가 정의된 순서를 반환(0부터 시작)
     * T valueOf(Class<T> enumType, String name) : 지정된 열거형에서 name과 일치하는 열거형 상수를 반환
     *******************************************************************/
    /*******************************************************************
     *  열거형에 멤버 추가하기
     *  불연속적인 열거형 상수의 경우, 원하는 값을 괄호()안에 적는다.
     *  Ex : enum Direction{EAST(1), SOUTH(5), WEST(-1), NORTH(10)}
     *  
     *  괄호()를 사용하려면, 인스턴스 변수와 생성자를 새로 추가해 줘야 한다.
     *  열거형의 생성자는 묵시적으로 private이므로 ,외부에서 객체생성 불가 (new)
     *******************************************************************/
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        System.out.println("(d1==d2) = " + (d1 == d2));
        System.out.println("(d1==d3) = " + (d1 == d3));
        System.out.println("d1.equals(d3) = " + d1.equals(d3));
//        System.out.println("(d1>d3) = " + (d1 > d3)); // 에러 (열거형은 객체이기 때문)
        System.out.println("d1.compareTo(d2) = " + d1.compareTo(d2));
        System.out.println("d1.compareTo(d3) = " + d1.compareTo(d3));

        switch(d1){
            case EAST: // Direction.EAST라고 쓸수 없다.
                System.out.println("The direction is EAST");
                break;
            case SOUTH:
                System.out.println("The direction is SOUTH");
                break;
            case WEST:
                System.out.println("The direction is WEST");
                break;
            case NORTH:
                System.out.println("The direction is NORTH");
                break;
            default:
        }

        Direction[] dArr = Direction.values(); // 열거형의 모든 상수를 배열로 반환
        for (Direction d : dArr) {
            System.out.printf("%s=%d%n", d.name(), d.ordinal()); // 순서

        }
    }
}
