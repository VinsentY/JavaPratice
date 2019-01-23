package yikai.s.Link;

// TODO 封装访问属性问题
public class Node<T extends Comparable> {
    T data;
    Node<T> pre;
    Node<T> succ;

    public Node() {
    }

    public Node(T data, Node<T> pre, Node<T> succ) {
        this.data = data;
        this.pre = pre;
        this.succ = succ;
    }

    void insertAsPre(T data) {
        Node<T> node = new Node<T>(data, pre, this);
        pre.succ = node;
        pre = node;
    }

    void insertAsPre(Node<T> node) {
        node.pre = pre;
        node.succ = this;
        pre.succ = node;
        pre = node;
    }

    void insertAsSucc(Node<T> node) {
        node.pre = this;
        node.succ = succ;
        succ.pre = node;
        succ = node;

    }

    void insertAsSucc(T data) {
        Node<T> node = new Node<T>(data, this, succ);
        succ.pre = node;
        succ = node;
    }

    public Node<T> getPre() {
        return pre;
    }

    public Node<T> getSucc() {
        return succ;
    }

    public T data() {
        return data;
    }

    public static void main(String[] args) {
       
    }
}
