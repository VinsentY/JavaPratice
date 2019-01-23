package yikai.s.Link;

import java.util.Random;

// 链表接口封装
public class Link<T extends Comparable> {

    private int size = 0;
    private Node<T> header;
    private Node<T> trailer;

    public Link() {
        header = new Node<T>();
        trailer = new Node<T>();
        header.succ = trailer;
        trailer.pre = header;
    }

    public Link(T[] arr) {
        header = new Node<T>();
        trailer = new Node<T>();
        header.succ = trailer;
        trailer.pre = header;

        for (T t : arr) {
            insertAsLast(t);
        }
    }

    public int size() {
        return size;
    }

    public Node<T> first() {
        return header;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<T> last() {
        return trailer;
    }

    public void insertAsFirst(T data) {
        header.insertAsSucc(data);
        size++;
    }

    public void insertAsFirst(Node<T> data) {
        header.insertAsSucc(data);
        size++;
    }

    public void insertAsLast(T data) {
        trailer.insertAsPre(data);
        size++;
    }

    public void insertAsLast(Node<T> data) {
        trailer.insertAsPre(data);
        size++;
    }

    public void insertBefore(Node<T> location, T data) {
        location.insertAsPre(data);
        size++;
    }

    public void insertAfter(Node<T> location, T data) {
        location.insertAsSucc(data);
        size++;
    }

    public void insertBefore(Node<T> location, Node<T> node) {
        location.insertAsPre(node);
        size++;
    }

    public void insertAfter(Node<T> location, Node<T> node) {
        location.insertAsSucc(node);
        size++;
    }

    // 不建议开放这些接口
    private void insertBefore(int index, Node<T> node) {
        get(index).insertAsPre(node);
        size++;
    }

    private void insertAfter(int index, Node<T> node) {
        get(index).insertAsSucc(node);
        size++;
    }

    private void insertBefore(int index, T data) {
        get(index).insertAsPre(data);
        size++;
    }

    private void insertAfter(int index, T data) {
        get(index).insertAsSucc(data);
        size++;
    }

    private Node<T> remove(int index, boolean indexFlag) {
        return remove(get(index));
    }

    private Link<T> copyNode(int index, int n) {
        return copyNode(get(index), n);
    }

    private Node<T> get(int index) {
        Node<T> node = header.succ;
        for (int i = 0; i < index; i++) {
            node = node.succ;
        }
        return node;
    }

    public Node<T> remove(Node<T> node) {
        if (node != trailer) {
            node.pre.succ = node.succ;
            node.succ.pre = node.pre;
            size--;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer();
        sbf.append("{ ");
        Node<T> node = first().succ;
        int i = 0;
        while (node != last()) {
            sbf.append(node.data + " ");
            node = node.succ;
        }
        sbf.append(" }");

        return sbf.toString();
    }

    public Node<T> remove(T data) {
        Node<T> node = find(data);
        return remove(node);
    }

    public boolean isSortUp() {
        Boolean descending = false;
        Boolean ascending = false;
        Node<T> node = header.succ;
        while (node != trailer.pre) {
            if (node.data.compareTo(node.succ.data) > 0) {
                descending = true;
            } else if (node.data.compareTo(node.succ.data) < 0) {
                ascending = true;
            }
            if (descending && ascending) {
                return false;
            }
            node = node.succ;
        }
        return true;
    }

    public Link<T> copyNode(Node<T> node, int n) {
        Link<T> newList = new Link<T>();

        for (int i = 0; i < n; i++) {
            newList.insertAsLast(node.data);
            node = node.succ;
        }

        return newList;
    }

    Link<T> copyNode() {
        return copyNode(header.succ, size);
    }

    public void sort() {
        int totalSize = size;

        //可读性
        Node<T> node = header.succ;
        Node<T> inPlace = header.succ;
        Node<T> recordMax;

        while (inPlace != trailer) {
            recordMax = inPlace;
            while (node != trailer) {
                if (node.data.compareTo(recordMax.data) > 0) {
                    recordMax = node;
                }
                node = node.succ;
            }
            T swap = inPlace.data;
            inPlace.data = recordMax.data;
            recordMax.data = swap;

            node = inPlace.succ;
            inPlace = node;
        }
    }

    public Node<T> find(T data) {
        Node<T> node = header.succ;
        while (node != trailer) {
            if (node.data.equals(data)) {
                return node;
            }
            node = node.succ;
        }
        return trailer;
    }

    public Node<T> search(T data) {
        //列表的二分查找并不会提高其算法的时间效率
        return find(data);
    }

    public int deduplicate() {
        int oldSize = size;
        Node<T> node;
        for (Node<T> n = first().succ; n != last().succ; n = n.succ) {
            node = find(n.data);
            //导致效率降低的原因来自于此
            //其实i之后的元素已经可以确保是唯一化的了
            if (node != n && node != trailer) {
                remove(node);
            }
        }
        return oldSize - size;
    }

    public int uniquify() {
        if (size < 2) {
            return 0;
        }
        if (!isSortUp()) {
            return -1;
        }
        Node<T> p = header.succ;
        Node<T> q = p.succ;
        int cnt = 0;
        while (p.succ != trailer) {
            if (p.data.equals(q.data)) {
                q = q.succ;
                remove(q.pre);
                cnt++;
            } else {
                p = q;
                q = q.succ;
            }
        }

        return cnt;
    }

    public void clear() {
        int oldSize = size;
        for (int i = 0; i < oldSize; i++) {
            remove(header.succ);
        }
    }

    public static void main(String[] args) {
        Link<Integer> link = new Link<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
//            link.insertAsLast(random.nextInt(100) + 1);
            link.insertAsLast(i * 2);

        }
        Link<Integer> link1 = link.copyNode();
//        long startTime = System.currentTimeMillis();
//        link.sort();
//        System.out.println(System.currentTimeMillis() - startTime);
//
//        startTime = System.currentTimeMillis();
//
//        link.uniquify();
//        System.out.println(System.currentTimeMillis() - startTime);
//        startTime = System.currentTimeMillis();
//        System.out.println(link);
//        link1.deduplicate();
//        System.out.println(System.currentTimeMillis() - startTime);
//        System.out.println(link1);
//        link1.clear();
//        System.out.println(link1);

        System.out.println(link);
//        link.remove(2);
        link.insertAsFirst(link.remove(3, true));
//        link.remove(link.first());
        System.out.println(link);

    }
}
