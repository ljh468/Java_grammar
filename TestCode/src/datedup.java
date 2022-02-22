import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class datedup {

    /**
     * 신규 계약건
     */
    private static final LocalDate newSDate = LocalDate.parse("2022-11-01", DateTimeFormatter.ISO_DATE);
    private static final LocalDate newEDate = LocalDate.parse("2022-11-11", DateTimeFormatter.ISO_DATE);
    /**
     * 기존 계약건
     */
    private static final LocalDate oldSDate = LocalDate.parse("2022-11-10", DateTimeFormatter.ISO_DATE);
    private static final LocalDate oldEDate = LocalDate.parse("2022-11-20", DateTimeFormatter.ISO_DATE);

    /****************************************************************************************************
     * 보험기간 일부포함 (C2)
     * 기존신청건에 보험기간 전체포함 OR 신규신청건에 기존신청건이 전체포함 (C3)
     * 판별 로직 (포함하지않음 : 0, 전체포함 : 1, 일부포함 : 2)
     ****************************************************************************************************/
    public static void main(String[] args) {
        List<LocalDate> list1s = DateToList(newSDate, newEDate);
        List<LocalDate> list2s = DateToList(oldSDate, oldEDate);
        int valid = 0;
        // 신규가입건이 기존가입건보다 큰경우
        if(list1s.size() > list2s.size()){
            valid = valid(list1s, list2s);
        // 신규가입건이 기존가입건보다 작은경우
        }else{
            valid = valid(list2s, list1s);
        }
        System.out.println("valid = " + valid);
    }

    /****************************************************************************************************
     * 신규가입건의 여행날짜와 기존가입건의 여행날짜를 비교 (포함하지않음 : 0, 전체포함 : 1, 일부포함 : 2)
     ****************************************************************************************************/
    private static Integer valid(List<LocalDate> list1s, List<LocalDate> list2s) {
        // 모두 포함하지 않음
        Integer result = 0;
        if (list1s.containsAll(list2s)) {
            return 1; // 전체 포함
        }
        for (LocalDate list1 : list1s) {
            if (list2s.contains(list1)) {
                return 2; // 일부 포함
            }
        }
        return result;
    }

    /****************************************************************************************************
     * 시작일과 종료일로 해당하는 날짜 리스트를 만듬
     ****************************************************************************************************/
    private static List<LocalDate> DateToList(LocalDate startDate, LocalDate endDate) {
        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        List<LocalDate> DateList = IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(startDate::plusDays)
                .collect(Collectors.toList());

        for (LocalDate localDate : DateList) {
            System.out.println("localDate = " + localDate);
        }
        System.out.println();
        return DateList;
    }
}
