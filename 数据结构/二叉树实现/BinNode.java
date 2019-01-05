package yikai.s.binTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinNode<T> {

    private static final int BinNode = 0;
    BinNode parent;
    BinNode lChild;
    BinNode rChild;

    private T data;

    boolean isEmpty;

    int height;

    //增加了不安全性
    public BinNode() {
        isEmpty = true;
    }

    public void updateHeiht() {
//		if (lChild == null && rChild == null) {
//			height = 1;
//		} else if (lChild == null && rChild != null) {
//			height = 1 + rChild.height;
//		} else if (lChild != null && rChild == null) {
//			height = 1 + lChild.height;
//		} else {
//			height = 1 + Math.max(lChild.height, rChild.height);
//		}

        height = 1 + Math.max(lChild == null ? 0 : lChild.height, rChild == null ? 0 : rChild.height);
    }

    int getHeight() {

        if (lChild == null && rChild == null) {
            height = 1;
        } else {

        }
        return height;
    }

    public BinNode(T data, BinNode<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    int size() {
        int sum = 1;
        if (lChild != null) {
            sum += lChild.size();
        }
        if (rChild != null) {
            sum += rChild.size();
        }
        return sum;
    }

    BinNode<T> insertAsLc(T data) {
        return lChild = new BinNode<T>(data, this);
    }

    BinNode<T> insertAsRc(T data) {
        return rChild = new BinNode<T>(data, this);
    }

    BinNode<T> succ() {

        return null;
    }


    //子树层次遍历
    void travLevel() {
        Queue<BinNode<T>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            BinNode<T> x = queue.remove();
            visit(x);
            if (x.lChild != null) {
                queue.add(x.lChild);
            }
            if (x.rChild != null) {
                queue.add(x.rChild);
            }
        }
    }

    //子树先序遍历
    void travPre() {
        //迭代思路一
//		Stack<BinNode<T>> stack = new Stack<>();
//		stack.push(this);
//
//		BinNode<T> temp;
//		while( !stack.isEmpty() ) {
//			temp = stack.pop();
//			visit(temp);
//			if (temp.rChild != null) {
//				stack.push(temp.rChild);
//			}
//			if (temp.lChild != null) {
//				stack.push(temp.lChild);
//			}
//		}

        //迭代思路二
        Stack<BinNode<T>> stack = new Stack<>();
        BinNode<T> x = this;
        while (true) {

            visitAlongLeftBranch(x, stack);
            if (stack.empty()) {
                break;
            }
            x = stack.pop();
        }


    }

    void visitAlongLeftBranch(BinNode<T> x, Stack<BinNode<T>> stack) {

        while (x != null) {
            visit(x);
            stack.push(x.rChild);
            x = x.lChild;    //沿左侧链下行
        }
    }

    void goAlongLeftBranch(BinNode<T> x, Stack<BinNode<T>> stack) {
        while (x != null) {
            stack.push(x);
            x = x.lChild;
        }
    }

    //子树中序遍历
    void travIn() {
        Stack<BinNode<T>> stack = new Stack<>();
        BinNode<T> x = this;
        while (true) {
            goAlongLeftBranch(x, stack);
            if (stack.empty()) {
                break;
            }
            x = stack.pop();
            visit(x);
            x = x.rChild;
        }
    }

    void gotoHLVFL(Stack<BinNode<T>> stack) {
        BinNode<T> x;
        while ((x = stack.peek()) != null) {
            if (x.lChild != null) {
                if (x.rChild != null) {
                    stack.push(x.rChild);
                }
                stack.push(x.lChild);
            } else {
                stack.push(x.rChild);
            }
        }
        stack.pop();
    }

    //子树后序遍历
    void travPost() {
        Stack<BinNode<T>> stack = new Stack<>();
        BinNode<T> x = this;
        stack.push(this);
        while (!stack.empty()) {
            //若站点非当前结点之父（则必为其右兄）
            if (stack.peek() != x.parent) {
                gotoHLVFL(stack);
            }
            x = stack.pop();
            visit(x);
        }
    }


    void visit(BinNode<T> x) {
        System.out.print(x.data + "  ");
    }

    void drawTree() {

        //描述： 直观的打印出二叉树，但暂时无法忽略不存在的结点

        Queue<BinNode<T>> queue1 = new LinkedList<>();
        Queue<BinNode<T>> queue2 = new LinkedList<>();
        //将所有结点逐层装入queue2中
        queue1.add(this);
        for (int i = 0; i < Math.pow(2, height) - 1; i++) {
            BinNode<T> x = queue1.remove();

            queue2.add(x);
            if (x.lChild != null) {
                queue1.add(x.lChild);
            } else {
                queue1.add(new BinNode<>());
            }
            if (x.rChild != null) {
                queue1.add(x.rChild);
            } else {
                queue1.add(new BinNode<>());
            }
        }

        //先不考虑变成字符串的问题
        StringBuffer sbf = new StringBuffer();

        //逐层两层点间隔，且非兄弟结点间隔等于兄弟结点间隔
        Stack<Integer> interval = new Stack<>();
        //初始化每层结点间隔
        int init = 5;
        int bottomNode = getLevelNodeNum(height);
        //底层宽度 = 间隔长度 * 间隔数 + 节点数
        int maxWidth = init * (bottomNode - 1) + bottomNode;
        for (int i = 0; i < height; i++) {
            interval.push(init);
            //上层结点间隔 = 下层结点间隔 * 2 + 1
            init = 2 * init + 1;
        }

        //逐层首结点距离左侧距离
        int space;

        for (int i = 1; i <= height; i++) {
            //空白 = (底层宽度 - 该层结点间隔） / 2
            space = (maxWidth - (interval.peek() * (getLevelNodeNum(i) - 1) + getLevelNodeNum(i))) / 2;

            //装饰边
            if (i != 1) {
                printSpace(space);
                for (int j = 1; j <= Math.pow(2, i - 1); j++) {
                    if (j % 2 != 0) {
                        System.out.print("╔");
                        printSymbol(interval.peek(),"═");
                    } else {
                        System.out.print("╗");
                        printSymbol(interval.peek()," ");
                    }

                }
                System.out.println();
            }

            //打印结点
            printSpace(space);
            for (int j = 1; j <= Math.pow(2, i - 1); j++) {
                BinNode<T> temp = queue2.remove();
                if (temp.isEmpty) {
                    System.out.print("*");
                } else {
                    System.out.print(temp.data);
                }
                printSpace(interval.peek());
            }

            System.out.println();
            interval.pop();
        }


    }

    private void printSymbol(int n, String s) {
        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
    }

    private int getLevelNodeNum(int level) {
        return (int) Math.pow(2, level - 1);
    }

    private void printSpace(int n) {
       printSymbol(n," ");
    }


    public static void main(String[] args) {

    }


}
