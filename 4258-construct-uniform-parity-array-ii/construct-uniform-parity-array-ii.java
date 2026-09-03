class Solution {
    public boolean uniformArray(int[] nums1) {
        int even=0,odd=0;
        for(int num:nums1)
            {
                if(num%2==0)even++;
                else odd++;
            }
        if(even==0||odd==0)return true;
        int minOdd=Integer.MAX_VALUE;
        for(int num:nums1)
            {
                if(num%2!=0)
                {
                    minOdd=Math.min(minOdd,num);
                        }
            }
        for(int num:nums1)
            {
                if(num%2==0)
                {
                    if(num-minOdd<=0)return false;
                }
            }
        return true;
    }
}
              