package programmers.lv1;

import java.util.Arrays;

public class 공원산책 {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int direction = 0;
        int height = park.length;
        int weight = park[0].length();
        int x = 0, y = 0;
        char[][] arr = new char[park.length][park[0].length()];

        //로봇 위치 찾기
        for(int i = 0; i < park.length; i++) {
            arr[i] = park[i].toCharArray();
            if(park[i].contains("S")) {
                x = i;
                y = park[i].indexOf("S");
            }
        }

        for(int i = 0; i < routes.length; i++) {
            switch(routes[i].split(" ")[0]) {
                case "E" :
                    direction = 1;
                    break;
                case "S" :
                    direction = 2;
                    break;
                case "W" :
                    direction = 3;
                    break;
                case "N" :
                    direction = 0;
                    break;
            }

            int moveCount = Integer.parseInt(routes[i].split(" ")[1]);
            int nx = x;
            int ny = y;
            boolean flag = true;
            for(int j = 0; j < moveCount; j++) {
                nx += dx[direction];
                ny += dy[direction];
                if(nx < 0 || nx >= height || ny < 0 || ny >= weight || park[nx].charAt(ny) == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                x = nx;
                y = ny;
            }
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args) {
        공원산책 공원산책 = new 공원산책();
        System.out.println(Arrays.toString(공원산책.solution(new String[]{"SOO","OOO","OOO"}, new String[]{"E 2","S 2","W 1"})));
        System.out.println(Arrays.toString(공원산책.solution(new String[]{"SOO","OXX","OOO"}, new String[]{"E 2","S 2","W 1"})));
        System.out.println(Arrays.toString(공원산책.solution(new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2","S 3","W 1"})));
    }
}
