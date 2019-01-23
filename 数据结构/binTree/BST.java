package yikai.s.binTree;

public class BST<T extends Comparable> extends BinTree<T> {

    private BinNode<T> _hot;

    public BST(T data) {
        super(data);
    }

    public BinNode<T> search(T data) {
        return searchIn(root(), data);
    }

    private BinNode<T> searchIn(BinNode<T> node, T data) {
        //查找成功时返回指定结点，
        if (node == null) return null;
        if (node.data.equals(data)) return node;
        _hot = node;
        return searchIn(node.data.compareTo(data) > 0 ? node.lChild : node.rChild, data);
    }

    public BinNode<T> insert(T data) {
        BinNode<T> node = search(data);
        if (node != null) return node;
        if (_hot.data.compareTo(data) > 0) {
            node = _hot.lChild = new BinNode<>(data,_hot);
        } else {
            node = _hot.rChild = new BinNode<>(data,_hot);
        }
        updateHeightAbove(node);
        return node;
    }

    public boolean remove(T data) {
        BinNode<T> node = search(data);
        if (node == null) return false;
        removeAt(node);
        _size--;
        updateHeightAbove(node);
        return false;
    }

    private void removeAt(BinNode<T> target) {
        boolean isLeftChild = _hot.data.compareTo(target.data) > 0;

        if (target.lChild == null) {
            if (isLeftChild) _hot.lChild = target.rChild;
             else _hot.rChild = target.rChild;
        } else if (target.rChild == null) {
            if (isLeftChild) _hot.lChild = target.lChild;
            else _hot.rChild = target.lChild;
        } else {
            BinNode<T> w = target.succ();
            T tmep = w.data; w.data = target.data; target.data = tmep;
            //将原问题转化为，摘除非二度的结点w
            if(isLeftChild) _hot.lChild = target.rChild;
            else _hot.rChild = target.rChild;
        }
    }

//    @Override
//    public void print() {
//        root().travIn();
//    }
}
