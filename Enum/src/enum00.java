//               0      1      2     3
// 열거형 상수는 객체임
enum Direction{ EAST, SOUTH, WEST, NORTH}

public class enum00 {
    public static void main(String[] args) {
        /*****************************************************
         * 열거형 (enum)
         * 관련된 상수들을 같이 묶어 놓은것. Java는 타입에 안전한 열거형을 제공
         *
         * 열거형의 정의
         * enum 열거형이름 { 상수명1, 상수명2, ...}
         * 열거형 상수의 비교에 ==과 compareTo() 사용가능
         *
         * 열거형의 조상 - java.lang.Enum
         * 모든 열거형은 Enum의 자손이며, 아래의 메서드를 상속받는다.
         * values(), valueOf()는 컴파일러가 자동으로 추가
         * values() : 열거형 상수 모든 값 반환
         * valueOf() : 지정된 열거형에서 name과 일치하는 열거형 상수를 반환
         *****************************************************/

        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        System.out.println("(d1==d2) = " + (d1 == d2));
        System.out.println("(d1==d3) = " + (d1 == d3));
        System.out.println("d1.equals(d3) = " + d1.equals(d3));
//        System.out.println("(d1 > d3) = " + (d1 > d3)); // 에러
        System.out.println("d1.compareTo(d3) = " + d1.compareTo(d3));
        System.out.println("d1.compareTo(d2) = " + d1.compareTo(d2));

        switch (d1){
            case EAST: // Direction.EAST라고 쓸 수 없다.
                System.out.println("The direction is EAST."); break;
            case SOUTH:
                System.out.println("The direction is SOUTH."); break;
            case WEST:
                System.out.println("The direction is WEST."); break;
            case NORTH:
                System.out.println("The direction is NORTH."); break;
            default:
                System.out.println("Invalid direction."); break;
        }

        Direction[] dArr = Direction.values(); // 열거형의 모든 상수를 배열로 반환

        for (Direction d : dArr) {
            // 이름(name)하고 상수가 정의된 순서(ordinal) 반환
            System.out.printf("%s = %d%n", d.name(), d.ordinal());
        }
    }
}
