package Object_grammer03;

public class ch8_04_예외처리하기 {
    /*******************************************************************
     * try - catch 문
     *
     * try블럭 내에서 예외가 발생한 경우
     * 1. 발생한 예외와 일치하는 catch블럭이 있는지 확인한다.
     * 2. 일치하는 catch블럭을 찾게 되면, 그 catch블럭내의 문장들을 수행하고 전체 try-catch문을 빠져나가서
     *    그 다음 문장을 계속해서 수행한다. 만일 일치하는 catch블럭을 찾지 못하면, 예외는 처리되지 못한다. (비정상 종료)
     *
     * try블럭 내에서 예외가 발생하지 않은 경우
     * 1. catch블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.
     *******************************************************************/
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);
        } catch (ArithmeticException ae){
            /*******************************************************************
             * printStackTrace() : 예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 화면에 출력
             * getMessage() : 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.
             *******************************************************************/
            ae.printStackTrace();
            System.out.println("ae.getMessage() = " + ae.getMessage());
        } catch (Exception e){
            // 모든 예외의 최고 조상 Exception
            System.out.println("Excption");
        }
        // Try-catch의 끝
        System.out.println(6);
    }
}
