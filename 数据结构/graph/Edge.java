package yikai.s.graph;

public class Edge<Te> {

    public static final int UNDETERMINED = 1;
    public static final int TREE = 2;
    public static final int CROSS = 3;
    public static final int FORWARD = 4;
    public static final int BACKWARD = 5;

    Te data;    //数据
    int weight; //权重
    int status; //状态

    public Edge(Te data, int weight) {
        this.data = data;
        this.weight = weight;
        status = UNDETERMINED;
    }

    public Edge() {
    }
}
