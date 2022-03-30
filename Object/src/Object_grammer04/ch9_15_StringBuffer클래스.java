package Object_grammer04;

public class ch9_15_StringBuffer클래스 {
    /*******************************************************************
     * StringBuffer클래스
     * String처럼 문자형 배열(char[])을 내부적으로 가지고 있다.
     * 그러나, String과 달리 내용을 변경할 수 있다. (mutable)
     * append()는 지정된 내용을 StringBuffer에 추가 후, StringBuffer의 참조를 반환
     *******************************************************************/
    /*******************************************************************
     * StringBuffer의 생성자
     * 배열은 길이 변경불가. 공간이 부족하면 새로운 배열을 생성해야함
     * StringBuffer는 저장할 문자열의 길이를 고려해서 적절한 크기로 생성해야함 
     *******************************************************************/
    /*******************************************************************
     * StringBuffer의 비교
     * StringBuffer는 equals()가 오버라이딩되어있지 않다.(주소비교)
     * StringBuffer을 String으로 변환 후에 equals()로 비교해야 한다.
     * String s = sb.toString(); // StringBuffer를 String으로 변환
     *******************************************************************/
    /*******************************************************************
     * StringBuilder
     * StringBuffer는 동기화되어 있다. 멀티 쓰레드에 안전(thread-safe)
     * 멀티 쓰레드 프로그램이 아닌 경우, 동기화는 불필요한 성능저하
     * 싱글 쓰레드일 경우 StringBuilder를 사용하면 성능향상
     *******************************************************************/
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("01");
        StringBuffer sb2 = sb.append(23);
        sb.append('4').append(56);

        StringBuffer sb3 = sb.append(78);
        sb3.append(9.0);

        System.out.println("sb = " + sb);
        System.out.println("sb2 = " + sb2);
        System.out.println("sb3 = " + sb3);

        System.out.println("sb = " + sb.deleteCharAt(10));
        System.out.println("sb = " + sb.delete(3, 6));
        System.out.println("sb) = " + sb.insert(3, "abc"));
        System.out.println("sb = " + sb.replace(6, sb.length(), "END"));

        System.out.println("sb.capacity = " + sb.capacity());
        System.out.println("sb.length() = " + sb.length());
    }
}
