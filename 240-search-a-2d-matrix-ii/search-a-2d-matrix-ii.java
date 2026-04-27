class Solution {
    // time:O(log (n*m)),  n,m = number of rows and cols 
    //space:O(1)

    public boolean searchMatrix(int[][] matrix, int target) {
      // mid element - largest and smallest at the same time either row wise and col wise or vice versa

        //[1, 4, 7]         target = 5
        //[2, 5, 8]         3 and 7 are mid candidates, pick one
        //[3, 6, 9]
      
        int rows = matrix.length;
        int cols = matrix[0].length;

        //mid element - starting point to begin tarversal in Matrix
        int r = 0;
        int c = cols - 1;

        while(r < rows && c >= 0) {
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target) c--;
            else r++;
        }

        return false;
    }
}