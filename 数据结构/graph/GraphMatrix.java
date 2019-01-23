package yikai.s.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import static yikai.s.graph.Edge.*;
import static yikai.s.graph.Vertex.DISCOVERED;
import static yikai.s.graph.Vertex.UNDISCOVERED;
import static yikai.s.graph.Vertex.VISITED;

public class GraphMatrix<Tv, Te> {

    int n; //顶点数
    int e; //边数


    private Vector<Vertex<Tv>> V = new Vector<>(); //点集
    private Vector<Vector<Edge<Te>>> E = new Vector<>(); //边集

    //顶点基本操作

    //顶点数据
    public Tv vertex(int i) {
        return V.get(i).data;
    }

    //入度
    public int inDegree(int i) {
        return V.get(i).inDegree;
    }

    //出度
    public int outDegree(int i) {
        return V.get(i).outDegree;
    }

    //父节点
    public int parent(int i) {
        return V.get(i).parent;
    }

    //时间标签
    public int dTime(int i) {
        return V.get(i).dTime;
    }

    public int fTime(int i) {
        return V.get(i).fTime;
    }

    //优先级
    public int priority(int i) {
        return V.get(i).priority;
    }

    //状态
    public int status(int i) {
        return V.get(i).status;
    }

    public int firstNbr(int i) {
        return nextNbr(i, n);
    }

    public int nextNbr(int i, int j) {
        //逆向线性试探
        while (j > -1 && !exist(i, --j)) ;
        return j;
    }

    //顶点动态操作

    public void insert(Tv data) {
        //扩充边集
        for (int i = 0; i < n; i++) {
            E.get(i).add(new Edge<Te>());
        }
        E.add(new Vector<>());
        //扩充点集
        n++;    //Construction
        V.add(new Vertex<>(data));  //Operation
    }

    public Tv remove(int i) {
        //移除边集
        E.remove(i);
        for (int j = 0; j < n; j++) {
            E.get(j).remove(i);
        }
        //移除点集
        n--;
        Tv vBack = V.get(i).data;
        V.remove(i);
        return vBack;
    }

    //边的基本操作
    public boolean exist(int i, int j) {
        return E.get(i).get(j) != null;
    }

    public int type(int i, int j) {
        return E.get(i).get(j).status;
    }

    public int weight(int i, int j) {
        return E.get(i).get(j).weight;
    }

    public Te edge(int i, int j) {
        return E.get(i).get(j).data;
    }

    //边的动态操作
    public void insert(Te data, int weight, int i, int j) {
        if (exist(i, j)) return;
        e++;
        E.get(i).set(j, new Edge<Te>(data, weight));
        V.get(i).outDegree++;
        V.get(j).inDegree++;
    }

    public Te remove(int i, int j) {
        Te eBack = edge(i, j);
        e--;
        E.get(i).remove(j);
        V.get(i).outDegree--;
        V.get(j).inDegree--;
        return eBack;
    }

    public void bfs(int s) {
        reset();
        int clock = 0;
        int v = s;
        //逐一对每一个未发现的顶点做广度优先遍历
        //实现了多连通图的同统一遍历
        do {
            if (status(v) == UNDISCOVERED) {
                BFS(v, clock);
            }
        } while (s != (++v % n));
    }

    public void dfs(int s) {
        reset();
        int clock = 0;
        int v = s;
        do {
            if (status(v) == UNDISCOVERED) {
                DFS(v,clock);
            }
        } while (s != (++v % n));
    }

    private void reset() {
        for (int i = 0; i < n; i++) {
            V.get(i).status = UNDISCOVERED;
            V.get(i).dTime = -1;
            V.get(i).fTime = -1;
            V.get(i).parent = -1;
            V.get(i).priority = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (exist(i, j)) {
                    E.get(i).get(j).status = UNDETERMINED;
                }
            }
        }
    }

    private void BFS(int i, int clock) {
        //类似于树这种半线性结构的层次遍历
        Queue<Integer> queue = new LinkedList<>();
        V.get(i).status = UNDISCOVERED;
        queue.add(i);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            V.get(v).dTime = ++clock;
            //逐一考察v顶点的所有邻居
            for (int u = firstNbr(v); u > -1; u = nextNbr(v, u)) {
                if (status(u) == UNDISCOVERED) {
                    V.get(i).status = DISCOVERED;
                    queue.add(u);
                    E.get(v).get(u).status = TREE;  //引入树边
                    V.get(u).parent = v;
                } else E.get(v).get(u).status = CROSS; //归结为跨边
            }
            V.get(v).status = VISITED;  //节点访问完毕，置为已访问状态
        }

    }

    private void DFS(int v, int clock) {
        V.get(v).dTime = ++clock;
        V.get(v).status = DISCOVERED;
        for (int u = firstNbr(v); u > -1; u = nextNbr(v, u)) {
            switch (status(u)) {
                //u尚未发现，意味着支撑树可在此继续拓展
                case UNDISCOVERED:
                    E.get(v).get(u).status = TREE;
                    V.get(u).parent = v;
                    DFS(u, clock); //递归
                    break;
                case DISCOVERED:
                    E.get(v).get(u).status = BACKWARD;
                    break;
                default:
                    //u已经访问完毕（VISITED)，则视承继关系可分为前向边和跨边
                    E.get(v).get(u).status = dTime(v) < dTime(u) ? FORWARD : CROSS;
                    break;

            }
        }
        V.get(v).status = VISITED;
        V.get(v).fTime = ++clock;
    }

}
