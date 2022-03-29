package Objact_grammer03;

class InstallException extends Exception{
    InstallException(String msg){
        super(msg);
    }
    public InstallException(Throwable cause) {
        super(cause);
    }
}
class SpaceException extends Exception{
    SpaceException(String msg){
        super(msg);
    }
}
class MemoryException extends Exception{
    MemoryException(String msg){
        super(msg);
    }
}
public class ch8_18_연결된예외 {
    /*******************************************************************
     * 연결된 예외 (chained exception)
     * 한 예외가 다른 예외를 발생시킬 수 있다.
     * 이유 1 : 여러 예외를 하나로 묶어서 다루기 위해서
     * 이유 2 : checked예외를 unchecked예외로 변경하려 할 때
     *
     * 예외 A가 예외 B를 발생시키면, A는 B의 원인 예외(cause exception)
     * Throwable initCause(Throwable cause) : 지정한 예외를 원인 예외로 등록
     * Throwable getCause() : 원인 예외를 반환
     *******************************************************************/
    public static void main(String[] args) throws InstallException{
        try{
            install();
        } catch (InstallException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    static void install() throws InstallException{
        try{
            int i = -1;
            if(i < 0){
                throw new SpaceException("설치 저장공간 부족");
            }else {
                throw new MemoryException("메모리 저장공간 부족");
            }
        } catch (SpaceException se){
            InstallException ie = new InstallException("설치중 예외발생");
            ie.initCause(se);    // InstallException의 원인 예외를 SpaceException으로 지정
            throw ie;
        } catch (MemoryException me){
            InstallException ie = new InstallException("설치중 예외발생");
            ie.initCause(me);    // InstallException의 원인 예외를 MemoryException 지정
            throw ie;
        }
    }
}
