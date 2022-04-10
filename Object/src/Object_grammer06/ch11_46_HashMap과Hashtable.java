package Object_grammer06;

import java.util.*;

public class ch11_46_HashMap과Hashtable {
    /*******************************************************************
     * HashMap과 Hashtable - 순서 X, 중복(키 X, 값 O)
     * Map인터페이스를 구현. 데이터를 key와 value의 쌍으로 저장
     * 해싱(hashing)기법으로 데이터를 저장. 데이터가 많아도 검색이 빠르다.
     *
     * HashMap
     * - Map인터페이스를 구현한 대표적인 컬렉션 클래스
     * - 순서를 유지하려면, LinkedHashMap클래스를 사용하면 된다.
     * TreeMap
     * - 범위 검색과 정렬에 유리한 컬렉션 클래스
     * - HashMap보다 데이터 추가, 삭제에 시간이 더 걸림림
     *******************************************************************/
    /*******************************************************************
     * 해싱(hashing)
     * 해시함수를 이용해서  해시테이블에 데이터를 저장 및 검색
     * (key값을 넣으면 배열의 저장위치(배열의 index)를 알려줌)
     * 해시테이블은 배열과 링크드리스트가 조합된 형태 (2차원배열 형태)
     * 1. Key로 해시함수를 호출해서 해시코드를 얻는다.(배열의 index)
     * 2. 해시코드(해시함수의 반환값)에 대응하는 링크드리스트를 배열에서 찾는다.
     * 3. 링크드리스트에서 키와 일치하는 데이터를 찾는다.
     * ( 해시함수는 값은 키에 대해 항상 같은 해시코드를 반환해야함, 서로다른 키일지라도 같은 해시코드를 반환할 수 있음)
     *******************************************************************/
    /*******************************************************************
     * HashMap 메서드
     * Object put(Object key, Object value) : 데이터 추가
     * Object remove(Object key) : 데이터 삭제
     * Object replace(Object key, Object value) : 데이터 변경
     * Set entrySet() : 키 와 값으로 이루어진 set반환
     * Set keySet() : 키만 반환
     * Collection values() : 값만 반환
     * Object get(Object key) : key값을 넣으면 값 반환
     * Object getOrDefault(Object key, Object defaultValue) : 키값이 없으면 지정한 default 반환
     * boolean containsKey(Object key) : key 중에 있는지 여부 확인
     * boolean containsValue(Object value) : value 중에 있는지 여부 확인
     *******************************************************************/
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("myId", "1234");
        map.put("asdf", "1111");
        // 키 값이 같은경우 마지막 값으로 변경
        map.put("asdf", "1234");

        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("id와 password를 입력해주세요");
            System.out.println("id : ");
            String id = s.nextLine().trim();

            System.out.println("password : ");
            String password = s.nextLine().trim();
            System.out.println();

            if (!map.containsKey(id)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요");
                continue;
            }
            if(!(map.get(id).equals(password))){
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
            }else{
                System.out.println("id와 비밀번호가 일치합니다.");
                break;
            }
        }
        /*******************************************************************
         * 예제 2 : HashMap 명단 가져오기
         *******************************************************************/
        HashMap map2 = new HashMap();
        map2.put("김자바", new Integer(90));
        map2.put("김자바", new Integer(100));
        map2.put("이자바", new Integer(100));
        map2.put("강자바", new Integer(80));
        map2.put("안자바", new Integer(90));

        Set set2 = map2.entrySet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            // Map 내부의 인터페이스 Entry<key, value>
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
        }
        set2 = map2.keySet();
        System.out.println("참가자 명단 : " + set2);

        Collection values = map2.values();
        it = values.iterator();

        int total = 0;
        while (it.hasNext()) {
            Integer i = (Integer) it.next();
            total += i.intValue();
        }
        System.out.println("총점 : " + total);
        System.out.println("평균 : " + (float) total / set2.size());
        System.out.println("최고점수 : " + Collections.max(values));
        System.out.println("최저점수 : " + Collections.min(values));

        /*******************************************************************
         * 예제 3 :
         *******************************************************************/
        String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};

        HashMap map3 = new HashMap();

        for(int i = 0; i < data.length; i++){
            if(map3.containsKey(data[i])){
                int value = (int) map3.get(data[i]);
                map3.put(data[i], value + 1);
            }else{
                map3.put(data[i], 1);
            }
        }

        Iterator it2 = map3.entrySet().iterator();
        while(it2.hasNext()){
            Map.Entry entry = (Map.Entry)it2.next();
            int value = (int) entry.getValue();
            System.out.println(entry.getKey() + " : " + "#".repeat(value) + " " + value);
            System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
        }
    }
    public static String printBar(char ch, int value){
        char[] bar = new char[value];
        for (int i = 0; i < bar.length; i++) {
            bar[i] = ch;
        }
        return new String(bar);
    }
}
