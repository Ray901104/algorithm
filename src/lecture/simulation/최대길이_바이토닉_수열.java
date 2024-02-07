package lecture.simulation;

import java.util.*;

public class 최대길이_바이토닉_수열 {
    public int solution(int[] nums){
        int answer = 0;
        List<Integer> peaks = new ArrayList<>();

        // 봉우리 찾기
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peaks.add(i);
            }
        }

        // 왼쪽, 오른쪽으로 가면서 봉우리를 기준으로 수 비교
        for (int peak : peaks) {
            int left = peak;
            int right = peak;
            int count = 1;

            while (nums[left] > nums[left - 1]) {
                count++;
                left--;
                if(left <= 0) break;
            }

            while (nums[right] > nums[right + 1]) {
                count++;
                right++;
                if(right >= nums.length - 1) break;
            }
            if(count > answer) answer = count;
        }
        return answer;
    }

    public static void main(String[] args){
        최대길이_바이토닉_수열 T = new 최대길이_바이토닉_수열();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
