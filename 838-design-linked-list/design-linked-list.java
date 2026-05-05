class MyLinkedList {

    // Node definition
    class Node {
        int val;
        Node next;

        Node(int v) {
            val = v;
            next = null;
        }
    }

    Node head;

    // Constructor
    public MyLinkedList() {
        head = null;
    }

    // Get value at index
    public int get(int index) {
        if (index < 0)
            return -1;

        Node curr = head;
        int i = 0;

        while (curr != null) {
            if (i == index) {
                return curr.val;
            }
            curr = curr.next;
            i++;
        }
        return -1;
    }

    // Add at head
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    // Add at tail
    public void addAtTail(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
    }

    // Add at index
    public void addAtIndex(int index, int val) {
        if (index < 0)
            return;

        // Insert at head
        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node prev = head;
        int i = 0;

        // Traverse to (index - 1)
        while (prev != null && i < index - 1) {
            prev = prev.next;
            i++;
        }

        // If index is valid
        if (prev != null) {
            Node newNode = new Node(val);
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    // Delete at index
    public void deleteAtIndex(int index) {
        if (index < 0 || head == null)
            return;

        // Delete head
        if (index == 0) {
            head = head.next;
            return;
        }

        Node prev = head;
        int i = 0;

        // Traverse to (index - 1)
        while (prev.next != null && i < index - 1) {
            prev = prev.next;
            i++;
        }

        // If node exists
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
}