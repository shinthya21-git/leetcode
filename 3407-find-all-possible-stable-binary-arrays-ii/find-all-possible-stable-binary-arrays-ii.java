class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        
        int M=(int)1e9+7;
        int[][][] dp=new int[zero+1][one+1][2];
        int maxConsecutiveZeros =Math.min(limit,zero);
        int maxConsecutiveOnes =Math.min(limit,one);
        for(int i=0;i<=maxConsecutiveZeros;i++)
        dp[i][0][0]=1;
        for(int j=0;j<=maxConsecutiveOnes;j++)
        dp[0][j][1]=1;
        for(int i=1;i<=zero;i++
        )
        {
            for(int j=1;j<=one;j++)
            {
                dp[i][j][0]=(dp[i-1][j][0]+dp[i-1][j][1])%M;
                dp[i][j][1]=(dp[i][j-1][0]+dp[i][j-1][1])%M;
                if(i>=limit+1)
                dp[i][j][0]=(dp[i][j][0]-dp[i-limit-1][j][1]+M)%M;
                if(j>=limit+1)
                dp[i][j][1]=(dp[i][j][1]-dp[i][j-limit-1][0]+M)%M;
            }
        }
        return(dp[zero][one][0]+dp[zero][one][1])%M;
    }
}
           