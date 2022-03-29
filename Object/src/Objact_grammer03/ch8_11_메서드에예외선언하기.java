package Objact_grammer03;

import java.io.File;

/*******************************************************************
 * 오버라이딩 : 1. 선언부일치, 2. 접근제어자 좁게, 3. 조상보다 많은 예외선언 X
 *******************************************************************/
public class ch8_11_메서드에예외선언하기 {
    /*******************************************************************
     * 예외를 처리하는 방법 : 1. try-catch문(직접처리), 2. 예외 선언하기(예외 알리기), 3. 감추기(빈 catch)
     * 예외선언 : 메서드가 호출시 발생가능한 예외를 호출하는 쪽에 알리는 것
     *******************************************************************/

    /**
     * 직접처리
     */
    public static void main(String[] args) {
        try{
            File f = createFile("test.txt");
            System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다.");
        } catch(Exception e){
            System.out.println("다시 입력해주세요." + e.getMessage());
        } finally {
            // 예외의 발생여부에 관계없이 항상 수행되어야하는 문장을 넣는다. ex: 임시파일삭제
            // finally블럭은 try-catch문의 맨 마지막에 위치해야한다.
        }
    }
    /**
     * 예외 선언하기 (떠넘기기)
     */
    static File createFile(String fileName) throws Exception{
        if(fileName == null || fileName.equals("")){
            throw new Exception("파일이름이 유효하지 않습니다.");
        }
        File f = new File(fileName);
        // File객체의 createNewFile메서드를 이용해서 실제 파일을 생성
        f.createNewFile();
        return f;   // 생성된 객체의 참조를 반환
    }
}
