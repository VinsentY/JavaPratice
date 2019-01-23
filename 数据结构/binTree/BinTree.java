package yikai.s.binTree;

public class BinTree<T> {

    protected int _size;

    private BinNode<T> _root;

    public BinTree(T data) {
        _root = new BinNode<T>(data, null);
        _root.updateHeiht();
    }


    public void updateHeightAbove(BinNode<T> x) {
        while(x != null) {
            x.updateHeiht();
            x = x.parent;
        }
    }

    public int size() {
        return _size;
    }

    boolean isEmpty() {
        return _root == null;
    }

    BinNode<T> root() {
        return _root;
    }

    BinNode<T> insertAsLc(BinNode<T> x, T data) {
        _size++;
        x.insertAsLc(data);
        updateHeightAbove(x.lChild);
        return x.lChild;
    }

    BinNode<T> insertAsRc(BinNode<T> x, T data) {
        _size++;
        x.insertAsRc(data);
        updateHeightAbove(x.rChild);
        return x.rChild;
    }

    int getHeight() { return root().height;}

    public void print() {
        root().drawTree();
    }

    //...子数接入、删除和分离接口...
    //...遍历接口...
    public static void main(String[] args) {
        BinTree<Character> tree = new BinTree<>('K');
        tree.insertAsLc(tree.root(), 'I');
        tree.insertAsRc(tree.root(), 'J');
        BinNode<Character> s = tree.root().lChild;
        BinNode<Character> ss = tree.insertAsRc(s, 'H');
        BinNode<Character> sss1 = tree.insertAsLc(ss, 'B');
        BinNode<Character> sss2 =tree.insertAsRc(ss, 'G');

//        tree.root().travIn();
//        System.out.println();
//
//
//        tree.root().travPre();
//        System.out.println();
//
//
//        tree.root().travPost();
//        System.out.println();

//        tree.root().travLevel();
//        System.out.println();
        tree.print();
        System.out.println("树的高度为: " + tree.getHeight());
    }

}
