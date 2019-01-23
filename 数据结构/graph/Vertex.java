package yikai.s.graph;

public class Vertex<Tv> {
    public static final int UNDISCOVERED = 1;
    public static final int DISCOVERED = 2;
    public static final int VISITED = 3;

    Tv data;
    int inDegree; //入度
    int outDegree; //出度
    int status;
    int dTime, fTime; //时间标签
    int parent; //在遍历树中的父节点
    int priority; //优先级

    public Vertex(Tv data) {
        this.data = data;
        inDegree = 0;
        outDegree = 0;
        status = UNDISCOVERED;
        dTime = -1;
        fTime = -1;
        parent = -1;
        priority = Integer.MAX_VALUE;
    }
}
