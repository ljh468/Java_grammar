import java.util.*;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

class Student3 {
    String name;
    boolean isMale; // 성별
    int hak;        // 학년
    int ban;        // 반
    int score;      // 총점

    public Student3(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
    }

    /**
     * groupingBy()에서 사용
     */
    enum Level {HIGH, MID, LOW} // 성적을 상, 중, 하 3단계로 분류

}

public class Stream_08 {
    public static void main(String[] args) {

        Student3[] stuArr = {
                new Student3("나자바", true, 1, 1, 300),
                new Student3("김지미", false, 1, 1, 250),
                new Student3("김자바", true, 1, 1, 200),
                new Student3("이지미", false, 1, 2, 150),
                new Student3("남자바", true, 1, 2, 100),
                new Student3("안지미", false, 1, 2, 50),
                new Student3("황지미", false, 1, 3, 100),
                new Student3("강지미", false, 1, 3, 150),
                new Student3("이자바", true, 1, 3, 200),
                new Student3("나자바", true, 2, 1, 300),
                new Student3("김지미", false, 2, 1, 250),
                new Student3("김자바", true, 2, 1, 200),
                new Student3("이지미", false, 2, 2, 150),
                new Student3("남자바", true, 2, 2, 100),
                new Student3("안지미", false, 2, 2, 50),
                new Student3("황지미", false, 2, 3, 100),
                new Student3("강지미", false, 2, 3, 150),
                new Student3("이자바", true, 2, 3, 200),
        };

        /*******************************************************************
         * 스트림의 그룹화 (n분할) - groupingBy()
         *******************************************************************/
        System.out.println();
        System.out.println("******************************************************");
        System.out.println("1. 단순 그룹화(반별로 그룹화)");
        Map<Integer, List<Student3>> stuByBan = Stream.of(stuArr) // 그룹화
                .collect(groupingBy(Student3::getBan, toList())); //학생을 반별로 그룹화

        for (List<Student3> ban : stuByBan.values()) {
            System.out.println("ban = " + ban);
        }
        System.out.println();

        System.out.println("******************************************************");
        System.out.println("2. 단순 그룹화(성적별로 그룹화)");
        Map<Student3.Level, List<Student3>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) return Student3.Level.HIGH;
                    else if (s.getScore() >= 100) return Student3.Level.MID;
                    else return Student3.Level.LOW;
                }));

        TreeSet<Student3.Level> keySet = new TreeSet<>(stuByLevel.keySet());
        for (Student3.Level key : keySet) {
            System.out.println("[" + key + "]");
            for (Student3 s : stuByLevel.get(key)) {
                System.out.println(s);
            }
            System.out.println();
        }

        System.out.println("******************************************************");
        System.out.println("3. 단순 그룹화 + 통계(성적별 학생수)");
        Map<Student3.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) return Student3.Level.HIGH;
                    else if (s.getScore() >= 100) return Student3.Level.MID;
                    else return Student3.Level.LOW;
                }, counting()));

        for (Student3.Level key : stuCntByLevel.keySet()) {
            System.out.printf("[%s] - %d명, %n", key, stuCntByLevel.get(key));
        }
        System.out.println();


        System.out.println("******************************************************");
        System.out.println("4. 다중 그룹화(학년별, 반별로 그룹화)");
        Map<Integer, Map<Integer, List<Student3>>> stuByHakAndBan = Stream.of(stuArr) // 다중 그룹화
                .collect(groupingBy(Student3::getHak, // 1. 학년별로 그룹화
                        groupingBy(Student3::getBan) // 2. 반별로 그룹화
                ));

        for (Map<Integer, List<Student3>> hak : stuByHakAndBan.values()) {
            for (List<Student3> ban : hak.values()) {
                System.out.println();
                for (Student3 s : ban) {
                    System.out.println(s);
                }
            }
        }
        System.out.println();

        System.out.println("******************************************************");
        System.out.println("5. 다중 그룹화 + 통계(학년별, 반별1등)");
        Map<Integer, Map<Integer, Student3>> topStuByHakAndBan =
                Stream.of(stuArr)
                        .collect(groupingBy(Student3::getHak,
                                groupingBy(Student3::getBan,
                                        collectingAndThen(
                                                maxBy(comparingInt(Student3::getScore)), Optional::get
                                        )
                                )
                        ));

        for (Map<Integer, Student3> ban : topStuByHakAndBan.values()) {
            for (Student3 s : ban.values()) {
                System.out.println(s);
            }
        }
        System.out.println();

        System.out.println("******************************************************");
        System.out.println("6. 다중 그룹화 + 통계(학년별, 반별 성적그룹)");
        Map<String, Set<Student3.Level>> stuByScoreGroup =
                Stream.of(stuArr)
                        .collect(groupingBy(s -> s.getHak() + "-" + s.getBan(), // 학년 반을 문자열 통째로 그훕화
                                mapping(s -> {
                                    if (s.getScore() >= 200) return Student3.Level.HIGH;
                                    else if (s.getScore() >= 100) return Student3.Level.MID;
                                    else return Student3.Level.LOW;
                                }, toSet())
                        ));

        Set<String> keyset2 = stuByScoreGroup.keySet();

        for (String key : keyset2) {
                System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
        }
    } // main 끝
}


