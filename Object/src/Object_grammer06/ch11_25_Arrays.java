package Object_grammer06;

import java.util.Arrays;

public class ch11_25_Arrays {
    /*******************************************************************
     * Arrays - 배열을 다루기 편리한 메서드(static) 제공
     * 1. 배열의 출력 - toString()
     * 2. 배열의 복사 - copyOf(), copyOfRange()
     * 3. 배열 채우기 - fill(), setAll()
     * 4. 배열의 정렬과 검색 - sort(), binarySearch()
     * 5. 다차원 배열의 출력 - deepToString()
     * 6. 다차원 배열의 비교 - deepEquals()
     * 7. 배열을 List로 변환 - asList(Object... a) (읽기 전용)
     * 8. 람다와 스트림 관련 - parallelXXX(), spliterator(), stream()
     *******************************************************************/
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[][] arr2D = {{11, 12, 13}, {21, 22, 23}};

        System.out.println("arr = " + Arrays.toString(arr));
        // 2차원 배열은 deepToString()으로 출력
        System.out.println("arr2D = " + Arrays.deepToString(arr2D));

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, 3);
        int[] arr4 = Arrays.copyOf(arr, 7);
        int[] arr5 = Arrays.copyOfRange(arr, 2, 4);
        int[] arr6 = Arrays.copyOfRange(arr, 0, 7);

        System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));
        System.out.println("Arrays.toString(arr3) = " + Arrays.toString(arr3));
        System.out.println("Arrays.toString(arr4) = " + Arrays.toString(arr4));
        System.out.println("Arrays.toString(arr5) = " + Arrays.toString(arr5));
        System.out.println("Arrays.toString(arr6) = " + Arrays.toString(arr6));

        int[] arr7 = new int[5];
        Arrays.fill(arr7, 9); // arr = [9,9,9,9,9]
        System.out.println("arr7 = " + Arrays.toString(arr7));

        Arrays.setAll(arr7, i -> (int)(Math.random()*6) + 1);
        System.out.println("arr7 = " + Arrays.toString(arr7));

        for (int i : arr7) {
            char[] graph = new char[i];
            Arrays.fill(graph, '*');
            System.out.println(new String(graph) + i);
        }

        String[][] str2D = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}};
        String[][] str2D2 = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}};

        System.out.println(Arrays.equals(str2D, str2D2));
        System.out.println(Arrays.deepEquals(str2D, str2D2));

        char[] chArr = {'A', 'D', 'C', 'B', 'E'};

        System.out.println("chArr = " + Arrays.toString(chArr));
        // binarySearch는 사전에 정렬이 되어있어야 함
        System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B'));
        System.out.println("= After sorting =");

        // 배열을 정렬
        Arrays.sort(chArr);
        System.out.println("chArr = " + Arrays.toString(chArr));
        System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B'));
    }
}
