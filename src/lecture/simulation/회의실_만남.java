package lecture.simulation;

import java.util.Arrays;

public class 회의실_만남 {

    public int[] solution(int[] enter, int[] exit){
        int n = enter.length;
        int[] answer = new int[n];

        //사람번호를 -1씩 하기
        for (int i = 0; i < n; i++) {
            enter[i]--;
            exit[i]--;
        }

        //enterIdx
        int[] enterIdx = new int[n];
        for (int i = 0; i < enterIdx.length; i++) {
            enterIdx[enter[i]] = i;
        }

        //출입 시간 기록
        int[] enterT = new int[n];
        int[] exitT = new int[n];
        int time = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && j <= enterIdx[exit[i]]) {
                enterT[enter[j]] = time++;
                j++;
            }
            exitT[exit[i]] = time++;
        }

        for (int i = 0; i < enterT.length; i++) {
            for (int j = i + 1; j < exitT.length; j++) {
                if (!(exitT[i] < enterT[j] || exitT[j] < enterT[i])) {
                    answer[i]++;
                    answer[j]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        회의실_만남 T = new 회의실_만남();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
