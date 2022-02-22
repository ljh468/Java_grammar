import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Objects;

public class TravelDayDTO {
    private static final String C1 = "C1";
    private static final String C2 = "C2";
    private static final String C3 = "C3";

    private LocalDate entry;
    private LocalDate end;

    public TravelDayDTO() {
    }

    public TravelDayDTO(LocalDate entry, LocalDate end) {
        this.entry = entry;
        this.end = end;
    }

    public Long getBetweenDays(){
        return ChronoUnit.DAYS.between(entry, end);
    }

    public LinkedHashMap<String, Objects> createBetweenHash() {
        LinkedHashMap<String, Objects> result = new LinkedHashMap<>();

        LocalDate incEntry = entry;

        // 여행기간 경우의 수 해시생성
        Long betweenDays = getBetweenDays();
        for (int i = 0; i <= betweenDays; i++) {
            for (int j = i; j <= betweenDays; j++) {
                System.out.println(incEntry + "/" + entry.plusDays(j));
                result.put(incEntry + "" + entry.plusDays(j), null);
            }
            incEntry = incEntry.plusDays(1);
        }
        System.out.println("------------- createBetweenHash : " + result.size() + " -------------");
        return result;
    }

    public String getRegisterCaseByPrev(TravelDayDTO prev) {
        System.out.println("prev = " + prev);
        TravelDayDTO cur = this;

        // 여행기간 해시 생성개수를 최소화 하기위한 전처리
        cur.entry = cur.entry.isBefore(prev.entry) ? prev.entry.minusDays(1) : cur.entry;
        System.out.println("cur.entry = " + cur.entry);
        cur.end = cur.end.isAfter(prev.end) ? prev.end.plusDays(1) : cur.end;
        System.out.println("cur.end = " + cur.end);

        LinkedHashMap<String, Objects> prevHash = prev.createBetweenHash();
        LinkedHashMap<String, Objects> curHash = cur.createBetweenHash();

        // 이전 여행기간에서 현재 여행기간이 겹치는게 있는지랑 카운트 조회
        int eqCount = 0;
        for (String k : curHash.keySet()) {
            if (prevHash.containsKey(k)) {
                eqCount++;
            }
        }
        System.out.println("eqCount = " + eqCount);

        return eqCount > 0 ? eqCount == curHash.size() || eqCount == prevHash.size() ? this.C3 : this.C2 : this.C1;
    }

    @Override
    public String toString() {
        return "TravelDayDTO{" +
                "entry=" + entry +
                ", end=" + end +
                '}';
    }
}
