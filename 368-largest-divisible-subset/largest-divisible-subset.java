class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        int lastIndx=0;
        int maxLen=0;
        int dp[]=new int[nums.length];
        Arrays.fill(dp,1);
        int parent[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            parent[i]=i;
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0&&dp[i]<dp[j]+1)
                {
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
            }
            if(dp[i]>maxLen)
            {
                lastIndx=i;
                maxLen=dp[i];
            }
        }
        int i=lastIndx;
        while(parent[i]!=i)
        {
            list.add(nums[i]);
            i=parent[i];
        }
        list.add(nums[i]);
        return list;
    }
}
            