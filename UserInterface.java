/* (C) Copyright 2017 Vincent Pace (https://github.com/vincentpace2395)

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

import java.util.Scanner;

public class UserInterface {

    /* Main method which provides basic user interface */
    public static void main(String[] args) {
        System.out.println("Welcome to the n-queens problem!\n");
        System.out.println("You can enter '0' at any time to quit.");
        Scanner scan = new Scanner(System.in);
        int N;

        do {
            do {
                System.out.print("Enter width of board (Must be 1 or a number greater than 3): ");
                N = scan.nextInt();
            } while (!((N == 1) || (N > 3) || (N == 0)));
            int board_arr[][] = new int[N][N];
            Solution solution = new Solution();
            if (solution.solveProblem(N, board_arr, 0) == false) {
                System.out.println("Solution not found");
                break;
            }
            displayBoard(N, board_arr);
            System.out.println();
        } while (N != 0);
        System.out.println("Shutting down...");
    }

    /* Method to display the contents of the board */
    public static void displayBoard(final int N, int board_arr[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board_arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}