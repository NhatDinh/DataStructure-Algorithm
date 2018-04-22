public class LinkedList {
    node head = null;

    // node a, b;
    class node {
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }

    node sortedMerge(node a, node b) {
        node result = null;
        // Base cases
        if (a == null)
            return b;
        if (b == null)
            return a;

        // Pick either a or b, and recursively merge two sorted halves
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;

    }
    //0(logN) run time
    node mergeSort(node h) {
        // Base case : if head is null then list is empty
        if (h == null || h.next == null) {
            return h;
        }

        // get the middle of the list
        node middle = getMiddle(h);
        node nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        node left = mergeSort(h);

        // Apply mergeSort on right list
        node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // Utility function to get the middle of the linked list
    node getMiddle(node h) {
        //Base case
        if (h == null)
            return h;
        node tmpptr = h.next;
        node midptr = h;

        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node
        while (tmpptr != null) {
            tmpptr = tmpptr.next;
            if (tmpptr != null) {
                midptr = midptr.next;
                tmpptr = tmpptr.next;
            }
        }
        return midptr;
    }

    //
    void push(int new_data) {
        /* allocate node */
        node new_node = new node(new_data);

        /* link the old list off the new node */
        new_node.next = head;

        /* move the head to point to the new node */
        head = new_node;
    }

    // Utility function to print the linked list
    void printList(node head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.push(1);
        list.push(6);
        list.push(2);
        list.push(3);
        list.push(8);
        list.push(5);
        list.push(4);
        list.push(7);
        //original linked list: 1 -> 6 -> 2 -> 3 -> 8 -> 5 -> 4 -> 7
        System.out.println("Original:");
        list.printList(list.head);

        // Apply merge Sort
        list.head = list.mergeSort(list.head);
        System.out.print("\nSorted Linked List is: \n");
        list.printList(list.head);
    }
}



