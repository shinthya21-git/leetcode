class Solution {
    public long sumAndMultiply(int n) {
        long count=0;
        long nozero=0;
        while(n!=0)
        {
            if(n%10!=0)
            {
                nozero=(long)nozero*10+n%10;
                count+=(long)n%10;
            }
            n/=10;
        }
        long nozeroo=0;
        while(nozero!=0)
        {
            nozeroo=nozeroo*10+nozero%10;
            nozero/=10;
        }
        return nozeroo*count;
    }
}
       