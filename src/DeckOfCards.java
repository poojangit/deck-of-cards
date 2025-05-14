import java.util.Random;

public class DeckOfCards {
    public static void main(String[] args) {
        //suits and ranks of the cards
        String[] suits = { "Clubs","Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "Jack", "Queen", "King", "Ace"};
        //total number of cards
        int totalNumber = suits.length * ranks.length;
        String[] deck = new String[totalNumber];

        //initialize the deck
        int index = 0;
        for(String suit : suits){
            for(String rank : ranks){
                deck[index] = rank + " of " + suit;
                index++;
            }
        }
        //shuffle the deck
        shuffleDeck(deck);

        //Distribute 9 cards to 4 players
        String[][] players = new String[4][9];
        int cardIndex = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<9; j++){
                players[i][j] = deck[cardIndex++];
            }
        }
        // Print the cards received by each player
        for (int i = 0; i < 4; i++) {
            System.out.println("Player " + (i + 1) + "'s cards:");
            for (int j = 0; j < 9; j++) {
                System.out.println(players[i][j]);
            }
            System.out.println();
        }

    }
    //Method to shuffle the deck
    private static void shuffleDeck(String[] deck){
        Random random = new Random();
        for(int i=0; i< deck.length; i++){
            int randomIndex = random.nextInt(deck.length);
            //swap the cards
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }

    }
}
