class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;

        int low = 0;
        int high = M * N - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int i = mid / N;
            int j = mid % N;

            int curr = matrix[i][j];

            if (curr == target) {
                return true;
            } else if (curr < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
