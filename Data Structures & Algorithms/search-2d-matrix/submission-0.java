class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;

        int startRow = 0;
        int endRow = M - 1;
        int startCol = 0;
        int endCol = N - 1;

        while(startRow <= endRow){
            int midRow = (startRow + endRow)/2;

            // target found
            if(target == matrix[midRow][0]){
                return true;
            }// target not found but less than first element in mid row
            else if(target < matrix[midRow][0]){
                endRow = midRow - 1;    
            }// target not less than first element in mid row, 
            //  could be in this row, search
            else{
                while(startCol <= endCol){
                    int midCol = (startCol + endCol )/2;
                    if(target == matrix[midRow][midCol]){
                        return true;
                    }else if(target < matrix[midRow][midCol]){
                        endCol = midCol - 1;
                    }else {
                        startCol = midCol + 1;
                    }
                }

                // loop stops, that means element not found, 
                // change search space
                startRow = midRow + 1;
            }
        }

        return false;
        
    }
}
