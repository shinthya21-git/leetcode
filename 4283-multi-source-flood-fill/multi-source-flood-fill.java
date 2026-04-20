class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid=new int[n][m];
        Arrays.sort(sources,(a,b)->b[2]-a[2]);
        Queue<int[]>q=new LinkedList<>();
        for(int[] it:sources)
        {
            int r=it[0],c=it[1],color=it[2];
            q.offer(new int[]{r,c});
            grid[r][c]=color;
        }
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        while(!q.isEmpty())
        {
            int[] cur=q.poll();
            int r=cur[0],c=cur[1];
            int color=grid[r][c];
            for(int i=0;i<4;i++)
            {
                int nr=r+dx[i];
                int nc=c+dy[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==0)
                {
                    grid[nr][nc]=color;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return grid;
    }
}
              