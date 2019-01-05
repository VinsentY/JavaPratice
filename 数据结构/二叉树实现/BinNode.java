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

    //�����˲���ȫ��
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


    //������α���
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

    //�����������
    void travPre() {
        //����˼·һ
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

        //����˼·��
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
            x = x.lChild;    //�����������
        }
    }

    void goAlongLeftBranch(BinNode<T> x, Stack<BinNode<T>> stack) {
        while (x != null) {
            stack.push(x);
            x = x.lChild;
        }
    }

    //�����������
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

    //�����������
    void travPost() {
        Stack<BinNode<T>> stack = new Stack<>();
        BinNode<T> x = this;
        stack.push(this);
        while (!stack.empty()) {
            //��վ��ǵ�ǰ���֮�������Ϊ�����֣�
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

        //������ ֱ�۵Ĵ�ӡ��������������ʱ�޷����Բ����ڵĽ��

        Queue<BinNode<T>> queue1 = new LinkedList<>();
        Queue<BinNode<T>> queue2 = new LinkedList<>();
        //�����н�����װ��queue2��
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

        //�Ȳ����Ǳ���ַ���������
        StringBuffer sbf = new StringBuffer();

        //�������������ҷ��ֵܽ���������ֵܽ����
        Stack<Integer> interval = new Stack<>();
        //��ʼ��ÿ������
        int init = 5;
        int bottomNode = getLevelNodeNum(height);
        //�ײ��� = ������� * ����� + �ڵ���
        int maxWidth = init * (bottomNode - 1) + bottomNode;
        for (int i = 0; i < height; i++) {
            interval.push(init);
            //�ϲ����� = �²����� * 2 + 1
            init = 2 * init + 1;
        }

        //����׽�����������
        int space;

        for (int i = 1; i <= height; i++) {
            //�հ� = (�ײ��� - �ò������� / 2
            space = (maxWidth - (interval.peek() * (getLevelNodeNum(i) - 1) + getLevelNodeNum(i))) / 2;

            //װ�α�
            if (i != 1) {
                printSpace(space);
                for (int j = 1; j <= Math.pow(2, i - 1); j++) {
                    if (j % 2 != 0) {
                        System.out.print("�X");
                        printSymbol(interval.peek(),"�T");
                    } else {
                        System.out.print("�[");
                        printSymbol(interval.peek()," ");
                    }

                }
                System.out.println();
            }

            //��ӡ���
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
