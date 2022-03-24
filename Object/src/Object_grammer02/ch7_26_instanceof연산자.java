package Object_grammer02;


public class ch7_26_instanceof연산자 {
    /*******************************************************************
     * instanceof 연산자
     * 참조변수의 형변환 가능여부 확인에 사용. 가능하면 true 반환 (조상 <-> 자손)
     * 형변환 전에 반드시 instanceof로 확인해야 함
     *******************************************************************/
    /*******************************************************************
     * 참조변수의 형변환은 왜 하는가?
     * 참조변수(리모컨)을 변경함으로써 사용할 수 있는 멤버의 갯수를 조절하기 위해서
     * 
     * instanceof연산자는 언제 사용하나요?
     * 참조변수를 형변환하기 전에 형변환 가능여부를 확인할 때
     *******************************************************************/
    public static void main(String[] args) {
        FireEngine fe = new FireEngine();
        System.out.println(fe instanceof Object);       // 조상 true
        System.out.println(fe instanceof Car);          // 조상 true
        System.out.println(fe instanceof FireEngine);   // 자신 true
    }
}
