/**
 * Just a simple hangman game.
 *
 * @author John Chong
 * @version Feb. 16, 2023
 */

public class Main {
/**
 * Prompts User for word, makes a linked list and
 * inserts every letter into a node. Prompts user
 * to guess a letter and tells user if the letter
 * is found in the word or takes one life away if the
 * letter is not found in the linked list. Loops until
 * the game is completed through a victory/defeat. Prompts
 * user to play again. loops until the user says no.
 *
 * @param args command line not used.
*/
    public static void main(String[] args) {

        GameMech game = new GameMech();
        char[] wordArray;
        char target;
        boolean found;
        boolean theEnd = false;
        boolean victory = false;
        boolean again = false;

        do {
            game.rules();
            game.wrong = 0;
            wordArray = game.getWord();

            LinkedList wordList;
            LinkedList fillList;
            wordList = game.createList(wordArray);
            fillList = game.createFillList(wordList.listCount());

            while (true) {
                game.checkStats(wordList, fillList);

                target = game.getGuess();
                found = game.findLetter(wordList, target);

                if (found) {
                    System.out.println("The letter \"" + target + "\" was found.\n");
                }
                else {
                    System.out.println("The letter " + target + " was not found.");
                    game.wrongGuess(game);
                    System.out.println();
                }

                theEnd = game.gameOver();
                victory = game.gameClear(wordList);

                if (theEnd || victory) break;
            }
            again = game.playAgain();
        } while (again);

        game.scan.close();
    }

}