package Object_grammer05;

import java.util.Calendar;

public class ch10_01_날짜와시간 {
    /*******************************************************************
     * java.util.Date
     * 날짜와 시간을 다룰 목적으로 만들어진 클래스(JDK 1.0)
     * Date의 메서드는 거의 deprecated되었지만, 여전히 쓰이고있다\
     *
     * java.util.Calendar
     * Date클래스를 개선한 새로운 클래스(JDK 1.1), 그러나 여전히 단점이 존재
     *
     * java.time
     * Date와 Calendar의 단점을 개선한 새로운 클래스들을 제공(JDK 1.8)
     *******************************************************************/
    /*******************************************************************
     * Clendar클래스
     * 추상클래스이므로 getInstance()를 통해 구현된 객체를 얻어야한다.
     * Calendar cal = Calendar.getInstance();
     * get()으로 말짜와 시간 필드 가져오기 - int get(int field)
     *******************************************************************/
    public static void main(String[] args) {
        /**
         * 기본적으로 현재날짜와 시간으로 설정된다.
         */
        Calendar today = Calendar.getInstance();
        System.out.println("이해의 년도 = " + today.get(Calendar.YEAR));
        System.out.println("월(0~11), 0:1월) =  " + today.get(Calendar.MONTH));
        System.out.println("이해의 몇째주 = " + today.get(Calendar.WEEK_OF_YEAR));
        System.out.println("이달의 몇째주 = " + today.get(Calendar.WEEK_OF_MONTH));

        /**
         * DATE와 DAY_OF_MONTH는 같다.
         */
        System.out.println("이달의 몇일 = " + today.get(Calendar.DATE));
        System.out.println("이달의 몇일 = " + today.get(Calendar.DAY_OF_MONTH));
        System.out.println("이해의 몇일 = " + today.get(Calendar.DAY_OF_YEAR));
        // 1: 일요일, 2: 월요일, ... 7: 토요일
        System.out.println("이달의 몇 째 요일 = " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("오전_오후(0:오전, 1:오후) = " + today.get(Calendar.AM_PM));
        System.out.println("시간(0~11) = " + today.get(Calendar.HOUR));
        System.out.println("시간(0~23) = " + today.get(Calendar.HOUR_OF_DAY));
        System.out.println("분(0~59) = " + today.get(Calendar.MINUTE));
        System.out.println("초(0~59) = " + today.get(Calendar.SECOND));
        System.out.println("1000분의 1초(0~999) = " + today.get(Calendar.MILLISECOND));
        // 1000분의 1초를 시간으로 표시하기 위해 3600000으로 나누었다. (1시간 = 60 * 60초)
        System.out.println("TimeZone(-12~+12) = " + today.get(Calendar.ZONE_OFFSET)/(60*60*1000));
        System.out.println("이달의 마지막날 = " + today.getActualMaximum(Calendar.DATE));
        System.out.println("######################################################");

        /*******************************************************************
         * set()으로 날짜와 시간지정하기
         * 날짜 지정하는 방법. 월(MONTH)이 0부터 시작한다는 점에 주의
         *******************************************************************/
        Calendar date = Calendar.getInstance();
        date.set(2022, 11, 9); // 2022년 12월 9일 (month는 0부터 시작)

        final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        date1.set(2022, 0, 1);
        System.out.println("date1은 " + toString(date1) + " " + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일입니다.");
        System.out.println("date2은 " + toString(date2) + " " + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일입니다.");

        /**
         * 두 날짜간의 차이를 얻으려면, getTimeInMillis() 천분의 일초단위로 변환해야함
         */
        long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
        System.out.println("date1부터 date2까지 " + difference + "초가 지났습니다.");
        System.out.println("일(day)로 계산하면 " + difference/(24*60*60) + "일 입니다.");
        System.out.println("######################################################");

        /*******************************************************************
         * 시간 지정하는 방법
         *******************************************************************/
        final int[] TIME_UNIT = {3600, 60, 1}; // 큰 단위를 앞에 놓는다.
        final String[] TIME_UNIT_NAME = {"시간 ", "분 ", "초 "};

        Calendar time1 = Calendar.getInstance();
        time1.set(Calendar.HOUR_OF_DAY, 1);
        time1.set(Calendar.MINUTE, 10);
        time1.set(Calendar.SECOND, 20);
        Calendar time2 = Calendar.getInstance();
        System.out.println("time1 : " + time1.get(Calendar.HOUR_OF_DAY) + "시 " + time1.get(Calendar.MINUTE) + "분 " + time1.get(Calendar.SECOND) + "초");
        System.out.println("time2 : " + time2.get(Calendar.HOUR_OF_DAY) + "시 " + time2.get(Calendar.MINUTE) + "분 " + time2.get(Calendar.SECOND) + "초");

        long difference2 = Math.abs(time1.getTimeInMillis() - time2.getTimeInMillis()) / 1000;
        System.out.println("time1과 time2의 차이는 " + difference2 + "초 입니다.");

        String tmp = "";
        for (int i = 0; i < TIME_UNIT.length; i++) {
            tmp += difference2 / TIME_UNIT[i] + TIME_UNIT_NAME[i];
            difference2 %= TIME_UNIT[i];
        }
        System.out.println("시분초로 변환하면 = " + tmp + "입니다.");
        System.out.println("######################################################");

        /*******************************************************************
         * clear()는 Calendar객체의 모든 필드를 초기화
         * clear(int field)는 Calendar객체의 특정 필드를 초기화
         *******************************************************************/
        /*******************************************************************
         * add()는 특정필드의 값을 중가 또는 감소(다른 필드에 영향 O)
         * roll()은 특정필드의 값을 증가 또는 감소(다른 필드에 영향 X)
         *******************************************************************/
        /*******************************************************************
         * 1. Calendar를 Date로 변환
         * Calendar cal = Calendar.getInstance();
         * Date d = new Date(cal.getTimeInMillis());
         *
         * 2. Date를 Calendar로 변환
         * Date d = new Date();
         * Calendar cal = Calendar.getInstance();
         * cal.setTime(d);
         *******************************************************************/
    }

    public static String toString(Calendar date) {
        return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일";
    }
}
