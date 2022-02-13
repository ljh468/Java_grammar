import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class test {
//     ############# 생년월일, 수신인번호 예외처리 ############
//     생년월일 유효성체크 : 6자리, 숫자(정규식 처리)
//     수신인 번호 : 시작 2자리가 01로 시작하는지 확인(정규식처리) and 총 자리수 9자리 or 10자리
    public static boolean isDateOfBirth(String str){
        return Pattern.matches("^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])", str);
    }

    private static boolean isPhone(String str){
        return Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
    }

//    public static void main(String[] args) {
//
//        // 생년월일 체크
//        String ssn = "901209";
//        boolean s = isDateOfBirth(ssn);
//        System.out.println("s : " + s);
//
//
//        // 휴대폰번호 체크
//        String mobile = "01058502269";
//        boolean m = isPhone(mobile);
//        System.out.println("m = " + m);
//    }


    public static void main(String[] args) {
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime regdt = now.minusSeconds(5);
//        long between = ChronoUnit.SECONDS.between(regdt, now);
//
//        System.out.println("now = " + now);
//        System.out.println("regdt = " + regdt);
//        System.out.println("between = " + between);
//        // 포맷 정의
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
//        String formatedNow = now.format(formatter);
//        System.out.println("formatedNow = " + formatedNow);

        String c = String.valueOf(34);
        System.out.println("c = " + c);
        System.out.println(c.charAt(0));
    }



}
