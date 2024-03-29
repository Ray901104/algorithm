package lecture.simulation;

import java.util.*;

public class 사다리타기 {

    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        //answer 배열 초기화
        for (int i = 0; i < n; i++) {
            answer[i] = (char) (65 + i);
        }

        //가로줄 탐색
        for (int[] line : ladder) {
            for (int x : line) {
                char temp = answer[x - 1];
                answer[x - 1] = answer[x];
                answer[x] = temp;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        사다리타기 T = new 사다리타기();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}

