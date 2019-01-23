public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode n = head.next; //有序序列的边界哨兵
        ListNode m =  head; //n的小跟班


        while (n != null) {
            ListNode q = dummyHead.next;
            ListNode p = dummyHead;
            while (q != n) {

                if (q.val > n.val) {
                    //把边界哨兵移动
                    m.next = n.next; //移出边界哨兵
                    n.next = p.next;
                    p.next = n;
                    n = m;
                    break;
                }

                p = q;
                q = q.next;
            }
            m = n;
            n = n.next;
        }
        return dummyHead.next;
    }