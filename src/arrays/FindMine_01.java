package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * 0204 - 지뢰찾기 구현
 * 자바의 정석 p222, 2차원 배열에 X표하기 참고
 */
public class FindMine_01 {
    static final int SIZE = 10;

    public static void main(String[] args) {
        int randCnt = initRandCnt();
        char[][] guessingBoard = initGuessingBoard();
        int[][] randBoard = initRandBoard(randCnt);

        displayInfo(randCnt);
        do {
            displayBoard(guessingBoard);
            int[] inputs = processInput();
            char curSymbol = 'X';
            if (isCorrectAnswer(inputs, randBoard)) {
                displayItsCorrect();
                curSymbol = 'O';
                randCnt--;
            }
            markGuessingBoard(guessingBoard, inputs, curSymbol);
        } while (randCnt > 0);
    }

    static int[] processInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rowAndCol = new int[2];

        try {
            String[] inputs = br.readLine().split(" ");
            rowAndCol[0] = Integer.parseInt(inputs[0]);
            rowAndCol[1] = Integer.parseInt(inputs[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowAndCol;
    }

    static boolean isCorrectAnswer(int[] rowAndCol, int[][] randBoard) {
        int x = rowAndCol[0], y = rowAndCol[1];
        return randBoard[x][y] == 1;
    }

    static void displayItsCorrect() {
        System.out.println("맞췄습니다.");
    }

    static void markGuessingBoard(char[][] guessingBoard, int[] inputs, char curSymbol) {
        int row = inputs[0];
        int col = inputs[1];

        guessingBoard[row][col] = curSymbol;
    }

    static void displayInfo(int randCnt) {
        System.out.println("랜덤 지뢰찾기 게임 초기 버전;");
        System.out.printf("%d 개의 랜덤한 위치에 폭탄이 숨어 있습니다. 폭탄을 찾아주세요\n", randCnt);
    }

    static void displayBoard(char[][] guessingBoard) {
        for (int i = 0; i <= guessingBoard.length; i++) {
            if (i == 0) {
                StringBuilder sb = new StringBuilder().append(" ");
                for (int j = 0; j < SIZE; j++) {
                    sb.append(j);
                }
                System.out.println(sb);
            } else {
                for (int k = 0; k <= guessingBoard[i - 1].length; k++) {
                    if (k == 0) {
                        System.out.print(i - 1);
                        continue;
                    }
                    System.out.print(guessingBoard[i - 1][k - 1]);
                }
                System.out.println();
            }
        }
    }

    static int initRandCnt(){
        Random rand = new Random();
        int maxSize = SIZE * SIZE;
        return rand.nextInt(maxSize) + 1;
    }

    static char[][] initGuessingBoard() {
        char[][] guessingBoard = new char[SIZE][SIZE];
        for (char[] chars : guessingBoard) {
            Arrays.fill(chars, ' ');
        }
        return guessingBoard;
    }

    static int[][] initRandBoard(int randCnt) {
        int[] randPos = new int[SIZE * SIZE];
        int[][] randBoard = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE * SIZE; i++) {
            randPos[i] = i;
        }

        shuffle(randPos);
        pickAndMark(randBoard, randPos, randCnt);

        return randBoard;
    }

    static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int randIdx = (int) (Math.random() * arr.length);
            int temp = arr[0];
            arr[0] = arr[randIdx];
            arr[randIdx] = temp;
        }

        // System.out.println("result of shuffle ");
        // System.out.println(Arrays.toString(arr));
    }

    static void pickAndMark(int[][] board, int[] arr, int cnt) {
        for (int i = 0; i < cnt; i++) {
            int row = arr[i] / SIZE;
            int col = arr[i] % SIZE;
            board[row][col] = 1;
        }
    }
}
