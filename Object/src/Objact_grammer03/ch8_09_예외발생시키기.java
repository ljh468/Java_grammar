package Objact_grammer03;

public class ch8_09_예외발생시키기 {
    /*******************************************************************
     * 1. 연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만든 다음
     *    Exception e = new Exception("고의로 발생시켰음");
     * 2. 키워드 throw를 이용해서 예외를 발생시킨다.
     *    throw e;
     *******************************************************************/
    /*******************************************************************
     * checked 예외 : 컴파일러가 예외 처리 여부를 체크 (예외 처리 필수) (Exception과 자손)
     * unchecked 예외 : 컴파일러가 예외 처리 여부를 체크 안함 (예외 처리 선택) (RuntimeException과 자손)
     *******************************************************************/
    public static void main(String[] args) {
        try{
            // Exception과 그 자손은 반드시 예외처리를 해줘야 한다.(필수)
            throw new Exception("고의로 발생시켰음");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("e.getMessage() = " + e.getMessage());

            // RuntimeException과 그자손은 예외처리를 해주지 않아도 컴파일이 된다.(선택)
            throw new RuntimeException();
        }
    }
}
