package Object_grammer03;

public class ch8_15_사용자정의예외만들기 {
    /*******************************************************************
     * 예외 되던지기(Exception re-throwing)
     * 예외를 처리한 후에 다시 예외를 발생시키는 것
     * 호출한 메서드와 호출된 메서드 양쪽 모두에서 예외처리 하는것
     *******************************************************************/
    public static void main(String[] args) {
        try{
            method1();
        } catch (MyException e){
            e.printStackTrace();
            System.out.println("e.getMessage() = " + e.getMessage());
            System.out.println("e.getErrCode() = " + e.getErrCode());
            System.out.println("main메서드에서 예외가 처리되었습니다.");
        }
    } // main 끝
    static void method1() throws MyException{
        try{
            throw new MyException("MyException");
        } catch (MyException e){
            System.out.println("method1메서드에서 예외가 처리되었습니다.");
            throw e; // 다시 예외를 발생시킴
        }
    } // 메서드 끝
}
/*******************************************************************
 * 사용자 정의 예외
 * 우리가 직접 예외 클래스를 정의할 수 있다.
 * 조상은 Exception과 RuntimeException중에서 선택
 *******************************************************************/
class MyException extends Exception{
    // 에러코드 값을 저장하기 위한 필드를 추가함
    private final int ERR_CODE; // 생성자를 통해 초기화

    public MyException(String msg, int errCode) { // 생성자
        super(msg);
        this.ERR_CODE = errCode;
    }
    MyException(String msg){ // 생성자
        this(msg, 100);      // ERR_CODE를 100(기본값)으로 초기화
    }
    public int getErrCode(){ // 에러코드를 얻을 수 있는 메서드 추가
        return ERR_CODE;     // 이 메서드는 주로 getMessage()와 함께 사용될 것이다.
    }
}
