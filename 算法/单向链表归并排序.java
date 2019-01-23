public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = null;
        ListNode middle = getMid(head);
        second = middle.next;
        middle.next = null; //将链表分成两段!

        first = sortList(first);
        second = sortList(second);
        return merge(first,second);

    }

    private ListNode merge(ListNode first, ListNode second) {
        if (first == null)
            return second;
        if (second == null)
            return first;

        ListNode res = new ListNode(0);
        ListNode curr = res;//控制新链表顺序的point

        while (first != null && second != null) {
            if (first.val < second.val) {
                curr.next = first;
                curr = curr.next;
                first = first.next;
            } else {
                curr.next = second;
                curr = curr.next;
                second = second.next;
            }
        }

        if (first != null)
            curr.next = first;
        if (second != null)
            curr.next = second;

        return res.next;
//        if (first == null) return second;
//        if (second == null) return first;
//
//        ListNode dummyHead = new ListNode(0);
//        ListNode node = dummyHead;
//        while (first != null && second != null) {
//            if (first.val > second.val) {
//                node.next = second;
//                node = node.next;
//                second = second.next;
//            } else {
//                node.next = first;
//                node  = node.next;
//                first = first.next;
//            }
//        }
//        if (first == null) {
//            node.next = second;
//        } else {
//            node.next = first;
//        }
//        return dummyHead.next;
    }

    public ListNode getMid(ListNode head) {

        ListNode slow = head, fast = head.next;

        while (fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;


//        boolean flag = false;
//       ListNode m = head;
//       ListNode n = head;
//       while (m.next != null) {
//           m = m.next;
//           if (flag) n = n.next;
//           flag = !flag;
//       }
//       return n;
    }