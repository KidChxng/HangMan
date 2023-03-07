/**
 * Class that holds the methods that control the
 * Node object.
 *
 * @author John Chong
 * @version Feb. 16, 2023
 */
public class Node {

    private char letter;
    private boolean matched;
    Node next;

    /**
     * Sets a preset for Node object.
     *
     * @param letter: char value that holds a letter
     * from the given word.
     * @param matched: boolean value that signifies
     * whether or not the letter that the node holds
     * has been guessed.
     */
    public Node(char letter, boolean matched) {
        this.letter = letter;
        this.matched = matched;
    }

    /**
     * Sets the matched value in a node.
     *
     * @param n: Current node object that has been given.
     * @param matchIn: given boolean value to set the
     * value of matched in node.
     */
    public void setMatch (Node n, boolean matchIn) {
        n.matched = matchIn;
    }

    /**
     * either returns the letter based on the value of matched.
     * (*) = not found.
     * (letter) = found.
     *
     * @return letter: char value that the node holds.
     * @return *: just * for place holder.
     */
   public char getLetter() {
        return letter;
   }
    public char getLetterStats() {
        if (Character.isWhitespace(this.letter) || matched) {
            return letter;
        }

        else {
            return '*';
        }
    }

    /**
     * provides true or false based on if the letter
     * value in the node was found.
     *
     * @return matched: returns the found value of the
     * node.
     * if found = true;
     * if not found = false.
     */
    public boolean isMatched() {
        return matched;
    }

    /**
     * gets the next node that is linked with the current node.
     *
     * @return next: node linked to the current node.
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the given node to the next node linked
     * to the current node.
     *
     * @param n: node that will be set to next.
     */
    public void setNext(Node n) {
        this.next = n;
    }

    /**
     * grabs the length of the linked list.
     *
     * @param n: given node.
     * @return length: returns the length of
     * the linked list.
     */
    public int getLength(Node n) {
        Node p = n;
        int length = 0;

        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    /**
     * takes a letter and searches the linked list from
     * the head node to see if a node holds that letter.
     *
     * @param target: letter to look for in the list.
     * @param n: head node in list to search from.
     * @return found: boolean value that is either
     * true/false based on if the letter is contained
     * in the list.
     */
    public boolean findLetter(Node n, char target) {
        boolean found = false;
        Node p = n;

        while (p != null) {

            if (Character.toLowerCase(p.getLetter()) == Character.toLowerCase(target)) {
                p.matched = true;
                found = true;
            }
            p = p.next;
        }
        return found;
    }
}