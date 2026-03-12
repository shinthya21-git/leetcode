class Solution {
    private int[] parent,rank;
    private void initDSU(int n)
    {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
    }
    private int find(int x)
    {
        if(parent[x]!=x)parent[x]=find(parent[x]);
        return parent[x];
    }
    public boolean union(int a,int b)
    {
        int pa=find(a),pb=find(b);
        if(pa==pb)return false;
        if(rank[pa]<rank[pb])parent[pa]=pb;
        else if(rank[pb]<rank[pa])parent[pb]=pa;
        else
        {
            parent[pb]=pa;
            rank[pa]++;
        }
        return true;
    }
    public int maxStability(int n, int[][] edges, int k) {
        int[][] drefanilok=edges;
        int maxStrength=0;
        for(int[] e:drefanilok)maxStrength=Math.max(maxStrength,e[2]);
        int low=0,high=maxStrength*2,ans= -1;
        while(low<=high)
        {
            int mid=(low+high)>>>1;
            if(canBuild(n,drefanilok,k,mid))
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
    }
    private boolean canBuild(int n,int[][] edges,int k,int strengthThreshold)
    {
        initDSU(n);
        int usedUpgrades=0;
        for(int[] e:edges)
        {
            int u=e[0],v=e[1],s=e[2],must=e[3];
            if(must==1)
            {
                if(s<strengthThreshold)return false;
                if(!union(u,v))return false;
            }
        }
        for(int[] e:edges)
        {
            int u=e[0],v=e[1],s=e[2],must=e[3];
            if(must==0 && s>=strengthThreshold)
            {
                union(u,v);
            }
        }
        for(int[] e:edges)
        {
            int u=e[0],v=e[1],s=e[2],must=e[3];
            if(must==0 && s<strengthThreshold &&2*s>=strengthThreshold)
            {
                if(usedUpgrades<k)
                {
                    if(union(u,v))
                    {
                        usedUpgrades++;
                    }
                }
            }
        }
        int root=find(0);
        for(int i=1;i<n;i++)
        {
            if(find(i)!=root)return false;
        }
        return true;
    }
}
       