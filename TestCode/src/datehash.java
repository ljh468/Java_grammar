import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Objects;

public class datehash {
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


    public static void main(String[] args) {
        TravelDayDTO newDay = new TravelDayDTO(newSDate, newEDate);
        TravelDayDTO oldDay = new TravelDayDTO(oldSDate, oldEDate);

        String registerCase = newDay.getRegisterCaseByPrev(oldDay);
        System.out.println("registerCase = " + registerCase);
    }
}
