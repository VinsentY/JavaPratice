package yikai.s.Sort;


import yikai.s.Link.Link;
import yikai.s.Link.Node;

import java.util.Calendar;
import java.util.Random;

public class InsertSort {

    // 代码可读性不够高,而且逻辑还是有些混乱为了在效率上稍微提高
    public static <T extends Comparable>Link<T> insetSort(Link<T> list, boolean descending) {
        long startTime = System.currentTimeMillis();

        Node n = list.first().getSucc().getSucc(); //有序结点序列的边界哨兵
        Node q = n;
        Node p;
        for(int r = 0; r < list.size() - 1; r++) { //r为已经有序的节点数
            n = n.getSucc();
            for(p = list.first().getSucc(); p != q; p = p.getSucc()) {
                //同或逻辑
                if (descending && q.data().compareTo(p.data()) > 0 || !descending && q.data().compareTo(p.data()) < 0) {
                    list.remove(q);
                    list.insertBefore(p,q);
                    break;
                }
            }
            q = n;
        }
        System.out.println(System.currentTimeMillis() - startTime);
        return list;
    }



}
