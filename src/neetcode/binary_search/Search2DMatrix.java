package neetcode.binary_search;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int left = 0;
        int right = matrix.length - 1;
        int cols = matrix[0].length;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target >= matrix[mid][0] && matrix[mid][cols-1] >= target) {
                int leftColumn = 0;
                int rightColumn = cols - 1;
                while (leftColumn <= rightColumn) {
                    int midColumn = leftColumn + (rightColumn - leftColumn) / 2;
                    if (matrix[mid][midColumn] < target) {
                        leftColumn = midColumn + 1;
                    } else if (matrix[mid][midColumn] > target) {
                        rightColumn = midColumn - 1;
                    } else {
                        return true;
                    }
                }
                return false;
            } else if (matrix[mid][cols-1] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
