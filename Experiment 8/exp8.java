class Solution {
    class Pair{
        int f ;
        int s;
        Pair(int a ,int b){
            this.f=a;
            this.s=b;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for(int i =0;i<V;i++)adj.add(new ArrayList<>());
        for(int[] edge:edges){
            int u=edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(w,v));
            adj.get(v).add(new Pair(w,u));
        }
        int[] dis = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.f-b.f);
        q.add(new Pair(0,src));
        
        while(!q.isEmpty()){
            Pair p= q.remove();
            int w=p.f;
            int curr=p.s;
            
            for(Pair node : adj.get(curr)){
               int currDist=dis[curr]+node.f;
                if(currDist<dis[node.s]){
                    dis[node.s]=currDist;
                    q.add(node);
                }
                
            }
        }
        return dis;
        
    }
}