package Object_grammer04;

public class ch9_12_Join {
    /*******************************************************************
     * join()과 StringJoiner
     * join()은 여러 문자열 사이에 구분자를 넣어서 결합한다.
     * ex : String str = String.join("_", arr);
     *******************************************************************/
    /*******************************************************************
     * 문자열과 기본형 간의 변환
     * 숫자를 문자열로 바꾸는 방법
     * int i = 100;
     * String str1 = i + "";
     * String str2 = String.valueOf(i);
     * 문자열을 숫자로 바꾸는 방법
     * int i = Integer.parseInt("100");
     * int i = Integer.valueOf("100");
     * Integer i = Integer.valueOf("100"); // valueOf는 참조형으로 반환
     *******************************************************************/
    public static void main(String[] args) {
        int iVal = 100;
//        String strVal = iVal + "";
        String strVal = String.valueOf(iVal); // int를 String으로 변환
        double dVal = 200.0;
        String strVal2 = String.valueOf(dVal); // double을 String으로 변환

        double sum = Integer.parseInt("+" + strVal) + Double.parseDouble(strVal2);
        double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);
        
        // 구분자 없이 문자열이 하나로 합쳐짐
        System.out.println(String.join("", strVal, "+", strVal2, "=") + sum);
        System.out.println(strVal + "+" + strVal2 + "=" + sum2);
    }
}
