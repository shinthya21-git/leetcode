class Solution {
    List<List<String>> res=new ArrayList<>();
    Map<String,List<String>> adj=new HashMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict=new HashSet<>(wordList);
        if(!dict.contains(endWord))
        {
            return res;
        }
        Queue<String> q=new LinkedList<>();
        Map<String,Integer> ladder=new HashMap<>();
        for(String word:dict)
        {
            ladder.put(word,Integer.MAX_VALUE);
        }
        q.offer(beginWord);
        
        ladder.put(beginWord, 0);
        int steps=1;
        int minSteps=Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                String w=q.poll();
                if(steps>minSteps)
                {
                    break;
                }
                for(int j=0;j<w.length();j++)
                {
                    for(int k= 'a';k<='z';k++)
                    {
                        char arr[]=w.toCharArray();
                        arr[j]=(char)k;
                        String newWord=new String(arr);
                        if(ladder.containsKey(newWord))
                        {
                            if(steps>ladder.get(newWord))
                            {
                                continue;
                            }
                            else if(steps<ladder.get(newWord))
                            {
                                q.offer(newWord);
                                ladder.put(newWord,steps);
                            }
                            else
                            {

                            }
                            adj.putIfAbsent(newWord,new ArrayList<>());
                            adj.get(newWord).add(w);
                            if(newWord.equals(endWord))
                            {
                                minSteps=steps;
                            }
                        }
                    }
                }
            }
            steps++;
        }
        backTrace(beginWord,endWord,new ArrayList<>());
        return res;
    }
    public void backTrace(String beginWord,String currWord,List<String> pathList)
    {
        if(currWord.equals(beginWord))
        {
            pathList.add(0,beginWord);
            res.add(new ArrayList<>(pathList));
            pathList.remove(0);
            return;
        }
        pathList.add(0,currWord);
        if(adj.get(currWord)!=null)
        {
            for(String w:adj.get(currWord))
            {
                backTrace(beginWord,w,pathList);
            }
        }
        pathList.remove(0);
    }
}
            
        