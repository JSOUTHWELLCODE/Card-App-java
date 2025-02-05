import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.SubmissionPublisher;


public class Card {
    private final int rank;
    private final int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }





        public static final String[] RANKS = {
                null, "Ace", "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "Jack", "Queen", "King"};

        public static final String[] SUITS = {
                "Clubs", "Diamonds", "Hearts", "Spades"};   //0 is club //1 diamonds // 2 hearts // spades




       public boolean equals(Card that) {
        return this.rank == that.rank
                && this.suit == that.suit;
        }


        // instance variables and constructors go here

        public String toString() {
            return RANKS[this.rank] + " of " + SUITS[this.suit];
        }


    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }








//print deck


    public static int binarySearch(Card[] cards, Card target) {
        int low = 0;
        int high = cards.length - 1;
        while (low <= high) {

            System.out.println(low + ", " + high);
            int mid = (low + high) / 2;                 // step 1
            int comp = cards[mid].compareTo(target);

            if (comp == 0) {                            // step 2
                return mid;
            } else if (comp < 0) {                      // step 3
                low = mid + 1;
            } else {                                    // step 4
                high = mid - 1;
            }
        }
        return -1;
    }






    public static Card[] createDeck() {
           Card[] cards = new Card[52];
           int i = 0;
           for (int suit = 0; suit <= 3; suit++) {
               for (int rank = 1; rank <=  13; rank++) {
                   cards[i] = new Card(rank, suit);    //cards[i]  == the array of objects
                   i ++;
               }

           }
           return cards;
    }



    public static Card[] hand(Card[] cards) {
          Random rand = new Random();
          Card[] hand = new Card[5];
          for(int i = 0; i <= 4; i++) {
              int randomcard = rand.nextInt(cards.length);
              hand[i] = cards[randomcard];




          }
          return hand;

    }


    public static int[] hist(Card[] cards){
// iterates through hand and each time there is suit it increments the array
        int[] counts = new int[4];
        for (int i = 0; i < cards.length; i++) {
            Card card = cards[i];


                switch (getsuit(card)) {
                    case 0:
                        counts[0]++;
                        break;
                    case 1:
                        counts[1]++;
                        break;
                    case 2:
                        counts[2]++;
                        break;
                    case 3:
                        counts[3]++;
                        break;
                }

            }



         String flush = (counts[0] == 5 || counts[1] == 5 || counts[2] == 5 || counts[3] == 5) ? "Wow you got a flush" : "Not a flush";
         System.out.println(flush);







        return counts;
    }











   public static int getsuit(Card card) {
           return card.suit;

   }




    public static void main(String[] args) {
      Deck deck = new Deck();
      deck.shuffle();


      deck.mergeSort();
      Deck sorted = deck.mergeSort();
      sorted.printDeck();


     //   deck.mergeSort();
      //  deck.printDeck();
    // Deck sub2 = deck.subdeck(deck.getCards().length/2, deck.getCards().length);


     //  Deck d3 = deck.merge(sub1, sub2);











    }
}

