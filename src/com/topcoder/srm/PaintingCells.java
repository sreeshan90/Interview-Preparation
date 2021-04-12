package com.topcoder.srm;

/**
 * 	Rookie SRM 4
 * 	You're given the number of rows and columns of a board.
 *  You want to paint it black and white like a chess board. You know that the first cell of the first row is white.
 * 	Calculate and return the number of white cells in the board after you paint it.
 */
public class PaintingCells {

    public int paint(int rows, int columns) {

        if (rows == 1 && columns == 1) {
            return 1;
        }

        int result = 0;

        for (int i=0; i< rows; i++) {
            if (i%2 == 0) {
                result += Math.ceil((float)columns/2);
            }
            else {
                result += Math.floor((float)columns/2);
            }
        }
        return result;
    }

}