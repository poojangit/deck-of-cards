public class Player {
    private String name;
    private CardQueue cardQueue;

    public Player(String name){
        this.name = name;
        this.cardQueue = new CardQueue();
    }
    public String getName(){
        return name;
    }
    public void addCard(String card){
        cardQueue.enqueue(card);
    }
    public void sortCards(String[] rankOrder){
        String[] cards = cardQueue.toArray();
        for(int i=0; i<cards.length-1; i++){
            for(int j=0; j<cards.length-i-1; j++){
                if(getRankIndex(cards[j], rankOrder)>getRankIndex(cards[j+1], rankOrder)){
                    String temp = cards[j];
                    cards[j] = cards[j+1];
                    cards[j+1] = temp;
                }
            }
        }
    }
    private int getRankIndex(String card, String[] rankOrder){
        String rank = card.split(" ")[0];
        for(int i=0; i<rankOrder.length; i++){
            if(rank.equals(rankOrder[i])){
                return i;
            }
        }
        return -1;
    }
    public void printCards() {
        while(!cardQueue.isEmpty()){
             System.out.println(cardQueue.dequeue());
         }
    }
}
