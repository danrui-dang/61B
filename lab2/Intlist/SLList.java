public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList() {

        sentinel = new IntNode(-1, null);
        size = 0;
    }

    public SLList(int x) {
        IntNode first = new IntNode(x, null);
        sentinel = new IntNode(-1, first);
        size = 1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        IntNode newFirst = new IntNode(x, sentinel.next);
        sentinel.next = newFirst;
        size += 1;
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public void addLastSquare(int x) {
        IntNode ptr = sentinel.next;
        IntNode pre = sentinel;
        while(ptr != null) {
            IntNode temp = new IntNode(ptr.item * ptr.item, ptr.next);
            ptr.next = temp;
            pre = temp;
            ptr = ptr.next.next;
        }
        IntNode newNode = new IntNode(x,null);
        pre.next = newNode;
    }

    public void deleteFirst() {
        IntNode newNext = sentinel.next.next;
        sentinel.next = newNext;
    }

    /**We want to add a method to IntList so that if 2 numbers in a row are the same, we add them together and
     make one large node. For example:
     1 → 1 → 2 → 3 becomes 2 → 2 → 3 which becomes 4 → 3
     */
    public void addAdjacent () {
        IntNode ptr = sentinel.next;
        while(ptr != null && ptr.next != null) {
            if(ptr.item == ptr.next.item) {
                ptr.next = ptr.next.next;
                ptr.item += ptr.item;
            }
            else ptr = ptr.next;
        }
    }

    /** Crashes when you call addLast on an empty SLList. Fix it. */
    public static void main(String[] args) {
        SLList x = new SLList();
        x.addLast(1);
        x.addLast(1);
        x.addLast(2);
        x.addLast(3);
        //x.addAdjacent();
        x.addLastSquare(5);
        IntNode ptr = x.sentinel.next;
        while(ptr != null) {
            System.out.print(ptr.item + "->");
            ptr = ptr.next;
        }
    }
}
