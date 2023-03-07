public class LinkedList {

    Node head;

    /**
     * Sets a preset for the linked list object.
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * inserts a node at the end of a linked list.
     *
     * @param letter: char value that holds a letter of the
     * word.
     * @param matched: boolean value that holds the value
     * that shows whether the letter was guessed or not.
     */
    public void insert(char letter, boolean matched) {
        Node n = new Node(letter, matched);

        if (this.head == null) {
            this.head = n;
        }

        else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;

            }

            current.next = n;
            if (Character.isWhitespace(n.getLetter())) {
                n.setMatch(n, true);
            }
        }
    }

    /**
     * returns the head/front of the linked list.
     *
     * @return head: head of the linked list.
     */
    public Node getHead() {
        return head;
    }

    /**
     * Sets label to a trimmed labeIn.
     *
     * @return count: Current node object that has been
     */
    public int listCount() {
        int count = 0;
        Node current = this.head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * prints the word but fills in '*' if a
     * letter in the word has not yet been found.
     */
    public void printList() {
        Node current = this.head;

        while (current != null) {
            System.out.print(current.getLetterStats() + " ");
            current = current.next;
        }
    }

}