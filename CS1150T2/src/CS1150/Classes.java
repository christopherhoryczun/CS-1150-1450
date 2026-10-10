package CS1150;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Classes {

	public static void main(String[] args) {
		Game game = new Game();
        game.start();
	}

}
class Board {
    private int[] board;

    public Board() {
        board = new int[9]; // All initialized to 0
    }

    public boolean isFull() {
        for (int cell : board) {
            if (cell == 0) return false;
        }
        return true;
    }

    public boolean placeMove(int pos, int player) {
        if (pos >= 0 && pos < 9 && board[pos] == 0) {
            board[pos] = player;
            return true;
        }
        return false;
    }

    public int[] getBoard() {
        return board;
    }

    public void printBoard() {
        char[] symbols = new char[]{' ', 'X', 'O'};
        System.out.println("-------------");
        for (int i = 0; i < 9; i++) {
            System.out.print("| " + symbols[board[i]] + " ");
            if (i % 3 == 2) {
                System.out.println("|");
                System.out.println("-------------");
            }
        }
    }

    public boolean checkWin(int player) {
        return (
            (board[0] == player && board[1] == player && board[2] == player) ||
            (board[3] == player && board[4] == player && board[5] == player) ||
            (board[6] == player && board[7] == player && board[8] == player) ||
            (board[0] == player && board[3] == player && board[6] == player) ||
            (board[1] == player && board[4] == player && board[7] == player) ||
            (board[2] == player && board[5] == player && board[8] == player) ||
            (board[0] == player && board[4] == player && board[8] == player) ||
            (board[2] == player && board[4] == player && board[6] == player)
        );
    }
}



class Game {
    private Board board;
    private Scanner scanner;
    private Random random;
    private int counter;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
        random = new Random();
        counter = 0;
    }

    public void start() {
        System.out.println("Welcome to 1D Tic-Tac-Toe!");
        while (true) {
            board.printBoard();
            playerTurn();
            counter++;

            if (board.checkWin(1)) {
                board.printBoard();
                System.out.println("You win!");
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("Draw! No more moves.");
                break;
            }

            computerTurn();
            counter++;

            if (board.checkWin(2)) {
                board.printBoard();
                System.out.println("Computer wins!");
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("Draw! No more moves.");
                break;
            }
        }
    }

    private void playerTurn() {
        int choice;
        while (true) {
            System.out.print("Player turn: Enter an integer between 0 and 8: ");
            choice = scanner.nextInt();
            if (board.placeMove(choice, 1)) {
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private void computerTurn() {
        System.out.println("Computer's turn...");
        int choice;
        while (true) {
            choice = random.nextInt(9);
            if (board.placeMove(choice, 2)) {
                System.out.println("Computer chose position " + choice);
                break;
            }
        }
    }
}
