class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;

        int startRow = 0;
        int endRow = M - 1;
        int midRow = 0;

        // binary search for finding the correct row
        while(startRow <= endRow){
            midRow = startRow + (endRow - startRow)/2;

            if(target > matrix[midRow][N-1]){
                startRow = midRow + 1;
            }else if(target < matrix[midRow][0]){
                endRow = midRow - 1;
            }else{
                break;
            }
        }

        if(!(startRow <= endRow)){
            return false;
        }

        int startCol = 0;
        int endCol = N - 1;
        while(startCol <= endCol){
            int midCol = startCol + (endCol - startCol)/2;
            int curr = matrix[midRow][midCol];

            if(target == curr){
                return true;
            }else if(target < curr){
                endCol = midCol - 1;
            }else{
                startCol = midCol + 1;
            }
        }

        return false;
    }
}
