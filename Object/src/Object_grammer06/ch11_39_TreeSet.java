package Object_grammer06;

import java.util.*;

public class ch11_39_TreeSet {
    /*******************************************************************
     * TreeSet - 범위 탐색, 정렬
     * 이진 탐색 트리(binary search tree)로 구현. 범위 탐색과 정렬에 유리
     * 이진 트리는 모든 노드가 최대 2개의 하위 노드를 갖음
     * 각 요소(node)가 나무(tree)형태로 연결(LinkedList의 변형)
     ******************************************************************/
    /*******************************************************************
     * 이진 탐색 트리(binary search tree)
     * 부모보다 작은 값은 왼쪽, 큰 값은 오르쪽에 저장
     * 데이터가 많아질 수록 축, 삭제에 시간이 더 걸림(비교 횟수 증가)
     * 루트부터 트리를 따라 내려가며 값을 비교. 작으면 왼쪽, 크면 오른쪽에 저장
     ******************************************************************/
    /*******************************************************************
     * add(Object obj) : 비교후 데이터 저장
     * TreeSet(Comparator comp) : 주어진 정렬기준으로 정렬하는 TreeSet을 생성
     ******************************************************************/
    /*******************************************************************
     * 트리 순회
     * 이진 트리의 모든 노드를 한번씩 읽는 것을 트리 순회라고 한다. (전위 순회, 후위 순회, 레벨 순회)
     * 중위 순회하면 오름차순으로 정렬된다.
     ******************************************************************/
    public static void main(String[] args) {
        /*******************************************************************
         * 범위검색, 정렬 (정렬 필요없음)
         * TreeSet은 비교하며 저장하기 때문에 비교기준이 필요하다.
         * 저장하는 객체가 Comparable을 가지고 있던가, TreeSet이 Comparator 정렬 기준을 가지고 있어야함
         ******************************************************************/
//        Set set = new TreeSet(new TestComp()); // 정렬기준 설정
        Set set = new TreeSet();

        for(int i = 0; set.size() < 6; i++){
            int num = (int)(Math.random() * 45) + 1;
            set.add(num); // set.add(new Integer(num));
//            set.add(new Test());
        }
        System.out.println("set : " + set);

        /*******************************************************************
         * 예제 2 :
         ******************************************************************/
        TreeSet set2 = new TreeSet();

        String from = "b";
        String to = "d";

        set2.add("abc");
        set2.add("alien");
        set2.add("bat");
        set2.add("car");
        set2.add("Car");
        set2.add("disc");

        System.out.println("set2 = " + set2);
        System.out.println("range search : from " + from + " to " + to);
        System.out.println("result1 : " + set2.subSet(from, to));
        System.out.println("result2 : " + set2.subSet(from, to + "zzz"));

        /*******************************************************************
         * 예제 3 :
         ******************************************************************/
        TreeSet set3 = new TreeSet();
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

        for(int i = 0; i < score.length; i++){
            set3.add(new Integer(score[i]));
        }
        System.out.println("50보다 작은값 : " + set3.headSet(50));
        System.out.println("50보다 큰 값 : " + set3.tailSet(new Integer(50)));
        System.out.println("40~80 사이값 : " + set3.subSet(40, 80));
    }
}
// 저장하는 객체에 정렬기준 오버라이딩
class Test implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
// 또는 정렬기준을 설정
class TestComp implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        return 1;
    }
}
