package Object_grammer05;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ch10_09_형식화클래스 {
    /*******************************************************************
     * 형식화 클래스
     * java.text패키지의 DecimalFormat, SimpleDateFormat
     * 숫자와 날짜를 원하는 형식으로 쉽게 출력가능 (숫자, 날짜 -> 형식문자열)
     * 형식 문자열에서 숫자와 날짜를 뽑아내는 기능 (형식문자열 -> 숫자, 날짜)
     *******************************************************************/
    public static void main(String[] args) throws ParseException {
        /*******************************************************************
         * DecimalFormat
         * 숫자를 형식화할 때 사용(숫자 -> 형식문자열)
         * 특정 형식의 문자열을 숫자로 변환할 때도 사용(형식문자열 -> 숫자)
         *******************************************************************/
        DecimalFormat df = new DecimalFormat("#,###.##");
        DecimalFormat df2 = new DecimalFormat("#,##E0");
        
        // 문자열을 숫자로 변경
        Number num = df.parse("1,234,567.89");
        System.out.println("num = " + num);

        double d = num.doubleValue();
        System.out.println("d = " + d);
        
        // 숫자를 지수 형식으로 변경
        System.out.println("df2 = " + df2.format(num));
        System.out.println("###########################################");

        /*******************************************************************
         * SimpleDateFormat
         * 날짜와 시간을 다양한 형식으로 출력할 수 있게 해준다.
         * 특정 형식으로 되어있는 문자열에서 날짜와 시간을 뽑아낼 수도 있다.
         * 1. 문자열 -> 날짜 - parse();
         * 2. 날짜 -> 문자열 - format();
         *******************************************************************/
        Date today = new Date();
        SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
        SimpleDateFormat sdf5, sdf6, sdf7, sdf8, sdf9;

        sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        sdf2 = new SimpleDateFormat("yy년 MMM dd일 E요일");
        sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
        sdf5 = new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");
        sdf6 = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
        sdf7 = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
        sdf8 = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");
        sdf9 = new SimpleDateFormat("오늘은 이달의 F번째 E요일입니다.");

        System.out.println(sdf1.format(today));
        System.out.println(sdf2.format(today));
        System.out.println(sdf3.format(today));
        System.out.println(sdf4.format(today));
        System.out.println(sdf5.format(today));
        System.out.println(sdf6.format(today));
        System.out.println(sdf7.format(today));
        System.out.println(sdf8.format(today));
        System.out.println(sdf9.format(today));
        System.out.println("###########################################");

        DateFormat df3 = new SimpleDateFormat("yyyy년 MM월 dd일");
        DateFormat df4 = new SimpleDateFormat("yyyy/MM/dd");
        try{
            Date dd = df3.parse("2022년 03월 11일");
            System.out.println(df4.format(dd));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
