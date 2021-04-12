package com.random.problem;

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