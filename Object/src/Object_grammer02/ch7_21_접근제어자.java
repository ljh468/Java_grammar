package Object_grammer02;

class Myparent {
    private     int prv;
                int dft;
    protected   int prt;
    public      int pub;

    public void printMembers(){
        System.out.println("prv = " + prv); // 같은 클래스
        System.out.println("dft = " + dft); // 같은 패키지
        System.out.println("prt = " + prt); // 같은 패키지 + 자손(다른 패키지)
        System.out.println("pub = " + pub); // 접근 제한 없음
    }
}

public class ch7_21_접근제어자 {
    /*******************************************************************
     * 접근 제어자(access modifier)
     * private   : 같은 클래스 내에서만 접근이 가능하다.
     * default   : 같은 패키지 내에서만 접근이 가능하다.
     * protected : 같은 패키지내에서, 그리고 다른 패키지의 자손클래스에서 접근이 가능하다.
     * public    : 접근 제한이 전혀 없다.
     *
     * 클래스 앞에는 default, public만 쓸 수 있다.
     *******************************************************************/
    public static void main(String[] args) {
        Myparent p = new Myparent();
//        System.out.println("prv = " + p.prv); // 에러
        System.out.println("dft = " + p.dft); // OK
        System.out.println("prt = " + p.prt); // OK
        System.out.println("pub = " + p.pub); // OK
    }
}
