package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 자바의 정석 p223, 빙고 문제 응용
 */
public class Bingo_01 {
    static final int BOARD_SIZE = 5;
    static final int BINGO_MARK_NUMBER = 0;
    static ArrayList<Integer> cache;
    static int[] bingoBoard;

    public static void main(String[] args) {
        bingoBoard = initBoard();
        prepareGame();

        boolean isBingo = false;
        while (!isBingo) {
            int input = processInput();
            if (validateInput(input)) {
                mark(input);
                isBingo = checkBingo(input);
                clearCache(input);

                displayBoard(bingoBoard);
            }
        }
    }

    static void prepareGame() {
        displayInfo();
        shuffle(bingoBoard);
        updateCacheArr(bingoBoard);
        displayBoard(bingoBoard);
    }

    static void displayInfo() {
        System.out.println("빙고 게임을 시작합니다.");
    }

    static int[] initBoard() {
        int[] arr = new int[BOARD_SIZE * BOARD_SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    static void shuffle(int[] bingoBoard) {
        for (int i = 0; i < bingoBoard.length; i++) {
            int randIdx = (int) (Math.random() * bingoBoard.length);
            int temp = bingoBoard[randIdx];
            bingoBoard[randIdx] = bingoBoard[i];
            bingoBoard[i] = temp;
        }
    }

    static void updateCacheArr(int[] bingoBoard) {
        cache = (ArrayList<Integer>) Arrays.stream(bingoBoard).boxed().collect(Collectors.toList());
    }

    static void displayBoard(int[] bingoBoard) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bingoBoard.length; i++) {
            sb.append(String.format("%2d", bingoBoard[i])).append(" ");
            if (i % BOARD_SIZE == 4) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static int processInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    static boolean validateInput(int input) {
        if (input <= BINGO_MARK_NUMBER || input > BOARD_SIZE * BOARD_SIZE) {
            System.out.println("다시 입력해주세요. 지정된 범위 외의 숫자를 입력 받았습니다; 정상적인 범위 [1, 25]");
            return false;
        }
        return true;
    }

    static void mark(int input) {
        if (cache.contains(input)) {
            int curIdx = cache.indexOf(input);
            bingoBoard[curIdx] = BINGO_MARK_NUMBER;
        }
    }

    static void clearCache(int input) {
        if (cache.contains(input)) {
            int curIdx = cache.indexOf(input);
            cache.set(curIdx, BINGO_MARK_NUMBER);
        }
    }

    static boolean checkBingo(int input) {
        // [TODO] short circuit 계산 땜에 이후가 계산 안됨
        // return checkWidthBingo(input) && checkHeightBingo(input) && checkCrossBingo(input);
        boolean isWidthBingo = checkWidthBingo(input);
        boolean isHeightBingo = checkHeightBingo(input);
        boolean isCrossBingo = checkCrossBingo(input);
        return isWidthBingo || isHeightBingo || isCrossBingo;
    }

    static boolean checkWidthBingo(int input) {
        int curIdx = cache.indexOf(input);
        int row = curIdx / BOARD_SIZE;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (bingoBoard[row + i] != BINGO_MARK_NUMBER) {
                return false;
            }
        }
        System.out.println("가로 빙고");
        return true;
    }

    static boolean checkHeightBingo(int input) {
        int curIdx = cache.indexOf(input);
        int col = curIdx % BOARD_SIZE;
        for (int i = 0; i < bingoBoard.length; i += BOARD_SIZE) {
            if (bingoBoard[i + col] != BINGO_MARK_NUMBER) {
                return false;
            }
        }
        System.out.println("세로 빙고");
        return true;
    }

    /* 통상 5x5 빙고게임에서 중앙은 모든 사람이 대각선 빙고를 할 수 있는 자유 공간으로서 간주된다. */
    static boolean checkCrossBingo(int input) {
        boolean isLeftToRightCross = checkLeftToRightCross(input);
        boolean isRightToLeftCross = checkRightToLeftCross(input);
        return isLeftToRightCross || isRightToLeftCross;
    }

    static boolean checkLeftToRightCross(int input) {
        int curIdx = cache.indexOf(input);
        int inc = BOARD_SIZE + 1;

        return loopToFindCurIdxExist(curIdx, 0, inc);
    }

    static boolean checkRightToLeftCross(int input) {
        int curIdx = cache.indexOf(input);
        int inc = BOARD_SIZE - 1;

        return loopToFindCurIdxExist(curIdx, 4, inc);
    }

    private static boolean loopToFindCurIdxExist(int curIdx, int startIdx, int inc) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (curIdx % inc != 0) {
                return false;
            }
            if (bingoBoard[startIdx + i * inc] != 0) {
                return false;
            }
        }
        System.out.println("대각선 빙고");
        return true;
    }
}
