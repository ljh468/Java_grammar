package Object_grammer02;

class Time{
    private int hour; // 0 ~ 23사이의 값을 가져야함
    private int minute;
    private int second;

    public void setHour(int hour) {
        if(isValidHour(hour)) return;
        this.hour = hour;
    }
    public int getHour(){
        return hour;
    }
    // 매개변수로 넘겨진 hour가 유효한지 확인해서 알려주는 메서드
    private boolean isValidHour(int hour) {
        return hour < 0 || hour > 23;
    }
}

public class ch7_22_캡슐화 {
    /*******************************************************************
     * 캡슐화와 접근 제어자
     * 접근 제어자를 사용하는 이유 :
     * 외부로 부터 데이터를 보호하기 위해서
     * 외부에는 불필요한, 내부적으로만 사용되는, 부분을 감추기 위해서
     *******************************************************************/
    public static void main(String[] args) {
        Time t = new Time();
//        t.hour = 100; // 보호되어야한다.
        t.setHour(23);  // 23시로 변경
        System.out.println(t.getHour());

        t.setHour(100);  // 100은 유효하지 않음
        System.out.println(t.getHour());
    }
}
