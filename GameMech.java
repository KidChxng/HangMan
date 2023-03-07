import java.util.Scanner;

/**
 * Class that holds methods that control the
 * mechanics of the hangman game.
 *
 * @author John Chong
 * @version Feb. 16, 2023
 */
public class GameMech {

    int wrong;
    char[] lives;

    Scanner scan = new Scanner(System.in);

    /**
     * Constructor that sets the base values
     * everytime a GameMech object is made.
     *
     * wrong: counter that holds the number of
     * wrong guesses that have been made.
     *
     * lives: char[] array that holds the word
     * hang. game is over when hang is completed.
     */
    public GameMech() {
        this.wrong = 0;
        this.lives = new char[] {'H', 'A', 'N', 'G'};
    }

    /**
     * Prints a welcome message and the rules to
     * hangman game.
     */
    public void rules() {
        System.out.println("\nWelcome to Chong's Hangman game!");
        System.out.println("A word is given and the players must complete the given word ");
        System.out.println("by providing letters. The Game is lose when 4 incorrect tries ");
        System.out.println("have been made or the word \"HANG\" has been completed.");
        System.out.println("DONT COMPLETE \"HANG\" AND GOOD LUCK!!\n");
    }

    /**
     * Prompts user for their word and transfer the word into
     * a char[] array called wordArray. Loops until the input
     * is not null;
     *
     * @return wordArray: a char[] array that holds the
     * user's inputed word.
     */
    public char[] getWord() {
        // Initalizing variables
        String word;
        boolean proceed = true;
        char[] wordArray = new char[0];

        // Prompts User for their word and repeats until word != null.
        do {
            System.out.println("Please input your desired word.");
            System.out.print("Word: ");
            word = scan.nextLine();

            if (word.isEmpty()) {
                proceed = false;
                System.out.print("\n");
            }

            // If word != null, add word into a char[] array.
            else {
                proceed = true;
                for (int i = 0; i < 5; i++) {
                    System.out.println("The game will now begin!");
                }
                wordArray = word.toCharArray();
            }
        } while (!proceed);
        return wordArray;
    }

    /**
     * Prompts user for their guess and converts the string
     * into a char value.
     *
     * @return target: a char that holds the user's guess.
     */
    public char getGuess(){
        char target;
        String guess;

        do {
            System.out.println("\nPlease input your guess.");
            System.out.print("Letter: ");

            guess = scan.nextLine();
            target = guess.charAt(0);
            target = guess.charAt(0);

        } while(guess.isEmpty());
        return target;
    }

    /**
     * Takes the given linked list and searches if the list
     * contains a node that holds the same value of the user's
     * guess.
     *
     * @param listIn: linked List where each node holds a
     * char of the user's word.
     * @param targetIn: char value of the user's guess.
     * @return front.findLetter(front, targetIn): boolean that
     * returns true if the linkedlist holds the user's guess.
     * other wise returns false.
     */
    public boolean findLetter(LinkedList listIn, char targetIn) {
        Node front = listIn.head;
        return front.findLetter(front, targetIn);
    }

    /**
     * If the user's guess is not in the linked list, increments the
     * counter that holds the amount of wrong guesses made and prints
     * out how many letters in "HANG" has been made.
     *
     * @param mechIn: The current version of hangman that is
     * being played.
     * @return mechIn: current version of hangman that is
     * being played.
     */
    public GameMech wrongGuess(GameMech mechIn) {
        mechIn.wrong++;
        for (int i = 0; i < mechIn.wrong; i++) {
            System.out.print(lives[i]);
        }
        return mechIn;
    }

    /**
     * creates a linkedList from the given char[] array.
     *
     * @param arrayIn: char[] array of the user's word.
     * @return wordList: a linkedList that was made from
     * the given array.
     */
    public LinkedList createList(char[] arrayIn) {
        LinkedList wordList = new LinkedList();

        for(char c: arrayIn) {
            wordList.insert(c, false);
        }
    return wordList;
    }

    /**
     * Creates a linked list of '-' for decoration purposes.
     *
     * @param countIn: an int value that holds the number
     * of chars in the user's word.
     * @return fillList: a list that is filled with '-' based
     * on the number of chars in the user's word.
     */
    public LinkedList createFillList(int countIn) {
        LinkedList fillList = new LinkedList();

        for (int i = 0; i < countIn; i++) {
            fillList.insert('-', true);
        }
        return fillList;
    }

    /**
     * Prints out the user's word and shows what letters they
     * correctly guessed.
     *
     * @param wordListIn: Linked list that contains the user's word.
     * @param fillListIn: Linked list that contains '-'.
     */
    public void checkStats(LinkedList wordListIn, LinkedList fillListIn) {
        System.out.println("\nThe Chosen Word is ");
        fillListIn.printList();
        System.out.println();
        wordListIn.printList();
        System.out.println();
        fillListIn.printList();
        System.out.println();
    }

    /**
     * Checks the number of wrong guesses the user has made. If
     * the user has made 4 wrong guess, the game is over and
     * a game over script is printed out.
     *
     * @return true/false: returns true if game is over.
     */
    public boolean gameOver() {
        if (this.wrong == 4) {
            System.out.println("\nYou completed HANG...");
            System.out.println("You are out of tries... ");
            System.out.println("GAME OVER");
            return true;
        }

        else return false;
    }

    /**
     * Checks the given node list to see if all the nodes that
     * holds the user's word. If all nodes have a boolean value
     * of true, that means all the letters have been guessed and
     * the game is cleared.
     *
     * @param listIn: Linked list that contains the user's word
     * and boolean values that show which words were correctly '
     * guessed.
     * @return true / false: returns true if the game is cleared.
     */
    public boolean gameClear(LinkedList listIn) {
        GameMech game = new GameMech();
        Node current;
        current = listIn.head;
        boolean found;

        while(current != null) {
            found = current.isMatched();

            if(found) {
                current = current.next;
            }
            else {
                return false;
            }
        }
        System.out.println("--!!Congratulations!!--");
        System.out.println("You have cleared the game!!");
        return true;
    }

    /**
     * Prompts user to see if they wish to play again.
     *
     * @return true / false: return true if the user enters 'y'
     * to play again.
     */
    public boolean playAgain() {
        String input;
        char choice;
        boolean proceed = false;

        do {
            System.out.println("\nPlay again?");
            System.out.println("Yes (Y) / No (N)");
            input = scan.nextLine();
            choice = Character.toLowerCase(input.charAt(0));

            if (choice == 'y') {
                return true;
            }
            else if (choice != 'n'){
                proceed = false;
            }
            else {
                proceed = true;
            }
        } while (!proceed);
        return false;
    }

}
