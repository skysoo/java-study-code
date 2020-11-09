package org.example.codingtest.oneLevel;

/**
 * 스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀 있습니다.
 * 이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
 * 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
 * <p>
 * 1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
 * 2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
 * 3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
 * 4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
 * 4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
 * <p>
 * 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
 * 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 **/
public class PressDownKeyPad {
    public static void main(String[] args) {
//        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        String hand = "right";
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        solution(numbers, hand);
    }

    public static String solution(int[] numbers, String hand) {
        var answer = "";
        // 목표값과 왼손, 오른손의 거리 계산, 거리가 같으면 hand 따라
        var leftHand = -1;
        var rightHand = -1;
        var sb = new StringBuilder();

        for (var target : numbers) {
            System.out.println("target : "+target);
            if (target == 1 || target == 4 || target == 7) {
                sb.append("L");
                leftHand = target;
            } else if (target == 3 || target == 6 || target == 9) {
                sb.append("R");
                rightHand = target;
                // 가운데 키패드 일 때
            } else {
                // 왼손, 오른손 거리가 같다면
                int leftDistance = distance(leftHand, target);
                int rightDistance = distance(rightHand, target);
                if (leftDistance == rightDistance) {
                    if (hand.equals("left")) {
                        sb.append("L");
                        leftHand = target;
                    } else {
                        sb.append("R");
                        rightHand = target;
                    }

                    // 왼손이 더 가깝다면
                } else if (leftDistance < rightDistance) {
                    sb.append("L");
                    leftHand = target;
                    // 오른손이 더 가깝다면
                } else {
                    sb.append("R");
                    rightHand = target;
                }
            }
        }
        answer = sb.toString();
        System.out.println(answer);
        return answer;
    }

    public static int distance(int location, int target) {
        int[][] current = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        int locationX = 0;
        int locationY = 0;
        int targetX = 0;
        int targetY = 0;

        for (int i = 0; i < current.length; i++) {
            for (int j = 0; j < current[0].length; j++) {
                if (location==current[i][j]){
                    locationX = i;
                    locationY = j;
                }
                if (target==current[i][j]){
                    targetX = i;
                    targetY = j;
                }
            }
        }

        /**
         * location(x,y) 과 target(x,y) 사이의 거리를 구해라.
         *
         * Math.sqrt(x) - x 의 루트 값
         * Math.pow(x,y) - y 제곱근
         * Math.abs(x-y) - 음수 부호까지 계산
         **/
        int value = (int) Math.ceil(Math.sqrt(Math.pow(Math.abs(targetX - locationX), 2)
                + Math.pow(Math.abs(targetY - locationY), 2)));
        System.out.println("Distance location "+location +" to target "
                +target +" = " + value);
        return value;
    }
}
