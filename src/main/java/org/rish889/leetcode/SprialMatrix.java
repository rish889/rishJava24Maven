package org.rish889.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {
    public static void main(String args[]) {
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int firstRow = 0;
        int lastRow = matrix.length - 1;
        int firstColumn = 0;
        int lastColumn = matrix[0].length - 1;

        while (isLeft(firstRow, lastRow, firstColumn, lastColumn)) {
            int i = firstRow;
            int j = firstColumn;

            while (j <= lastColumn) {
                result.add(matrix[i][j]);
                j++;
            }
            j = lastColumn;
            firstRow++;
            i = firstRow;
            if (!isLeft(firstRow, lastRow, firstColumn, lastColumn)) {
                break;
            }

            while (i <= lastRow) {
                result.add(matrix[i][j]);
                i++;
            }
            i = lastRow;
            lastColumn--;
            j = lastColumn;
            if (!isLeft(firstRow, lastRow, firstColumn, lastColumn)) {
                break;
            }

            while (j >= firstColumn) {
                result.add(matrix[i][j]);
                j--;
            }
            j = firstColumn;
            lastRow--;
            i = lastRow;
            if (!isLeft(firstRow, lastRow, firstColumn, lastColumn)) {
                break;
            }

            while (i >= firstRow) {
                result.add(matrix[i][j]);
                i--;
            }
            i = firstRow;
            firstColumn++;
            j = firstColumn;
        }

        return result;
    }

    private boolean isLeft(int firstRow, int lastRow, int firstColumn, int lastColumn) {
        return firstRow <= lastRow && firstColumn <= lastColumn;
    }
}
