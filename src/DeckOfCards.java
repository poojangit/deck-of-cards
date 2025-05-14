import java.util.Random;

public class DeckOfCards {
    public static void main(String[] args) {
        //Define suits and ranks of the cards
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
       PlayerQueue playerQueue = new PlayerQueue();
        for(int i=0; i<4; i++){
            Player player = new Player("Player " + (i+1));
            for(int j=0; j<9; j++){
                player.addCard(deck[i*9+j]);
            }
            player.sortCards(ranks); //sort cards by rank
            playerQueue.enqueue(player);
        }
        // Print players and their cards
        while(!playerQueue.isEmpty()){
            Player player = playerQueue.dequeue();
            System.out.println(player.getName() + "'s cards:");
            player.printCards();
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
