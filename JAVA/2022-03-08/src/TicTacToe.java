import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class TicTacToe {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.ticTacToeGame();
    }

    private void ticTacToeGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char[][] board = new char[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        for (int i = 0; i < board.length; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---|---|---");
            }
        }

        int flag = 0;
        do {
            userTic(board);
            flag = checkBingo(board);
            comTic(board);
            flag = checkBingo(board);
            printTic(board);

        } while (flag != 1);

    }

    private void userTic(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.println("사용자 턴(x y) : ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (board[x][y] == ' ') {
                board[x][y] = 'O';
                break;
            } else {
                count += 1;
                if (count > 8) {
                    break;
                }
                continue;
            }
        }
    }

    private void comTic(char[][] board) {
        Random random = new Random();
        System.out.println("컴퓨터 턴");
        int count = 0;
        while (true) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);

            if (board[x][y] == ' ') {
                board[x][y] = 'X';
                break;
            } else {
                count += 1;
                if (count > 8) {
                    break;
                }
                continue;

            }

        }
    }

    private void printTic(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---|---|---");
            }
        }
    }

    private int checkBingo(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {

            // 대각선
            if (board[1][1] != ' ') {
                if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                    winner(board[i][i]);
                    return 1;

                } else if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
                    winner(board[i][i]);
                    return 1;
                }
            }

            if (board[i][i] != ' ') {
                // 가로
                for (int j = 0; j < board.length; j++) {
                    if (board[i][i] == board[i][j]) {
                        count += 1;

                        if (count >= 3) {
                            winner(board[i][i]);
                            return 1;
                        }
                    }
                }
                count = 0;

                // 세로
                for (int j = 0; j < board.length; j++) {
                    if (board[i][i] == board[j][i]) {
                        count += 1;

                        if (count >= 3) {
                            winner(board[i][i]);
                            return 1;
                        }
                    }
                }
                count = 0;
            }
        }
        return 0;
    }

    private void winner(char c) {
        if (c == 'O') {
            System.out.println("사용자가 승리하였습니다 !");
        } else {
            System.out.println("컴퓨터가 승리하였습니다 !");
        }
    }
}
