class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp=new int[m][n];
       for(int i=0;i<m;i++)
       {
        Arrays.fill(dp[i],-1);
       }
        return maze(m,n,1,1,dp);
    }
    public int maze(int m,int n,int rows,int columns,int [][]dp)
    {
        if(rows==m || columns ==n)return 1;
        if(dp[rows][columns]!=-1)return dp[rows][columns];
        return dp[rows][columns]=maze(m,n,rows+1,columns,dp)+maze(m,n,rows,columns+1,dp);
    }
}