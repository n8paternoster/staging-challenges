package October;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class cc1012 {

    // util method to insert a node
    public static Node addNode(Node head, int val) {
        Node n = new Node(val);
        if (head != null) {
            while (head.next != null) {
                head = head.next;
            }
            head.next = n;
        }
        return n;
    }

    /**
     * 1. (Intersection) Find the intersecting node of two singly linked list or null if none exist
     * @param n Size of l1
     * @param m Size of l2
     */
    public static Node intersectingNode(int n, int m, Node l1, Node l2) {
        int offset = n-m;
        if (offset < 0) {
            while (l2 != null && offset++ < 0)
                l2 = l2.next;
        } else if (offset > 0) {
            while (l1 != null && offset-- > 0)
                l1 = l1.next;
        }
        while (l1 != null && l2 != null) {
            if (l1 == l2) return l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

    /**
     * 2. (Loop Detection) - Find the node in a singly linked list that begins a cycle
     */
    public static Node loopStart(Node head) {
        // Floyd's cycle detection algorithm
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return slow;
        }
        return null;
    }
    
    public static void main(String[] args) {
        /* example taken from leetcode problem #160
            a = 4 -> 1 -> 8 -> 4 -> 5
            b = 5 -> 6 -> 1 -> 8 -> 4 -> 5 (joined at 8) */
        Node a = new Node(4);
        addNode(a, 1);
        Node join = addNode(a, 8);
        addNode(a, 4);
        addNode(a, 5);
        Node b = new Node(5);
        addNode(b, 6);
        Node last = addNode(b, 1);
        last.next = join;

        Node intersection = intersectingNode(5, 6, a, b);
        System.out.println(intersection.data);  // 8

        /* c = 3 -> 4 -> 8 -> 7 -> 1 -> 13 -> back to 7 */
        Node c = new Node(3);
        addNode(c, 4);
        addNode(c, 8);
        join = addNode(c, 7);
        addNode(c, 1);
        last = addNode(c, 13);
        last.next = join;

        Node loop = loopStart(c);
        System.out.println(loop.data);  // 7
    }

}