public class Deck {
    private  Card[] cards;

    public Deck(int n) {
        this.cards = new Card[n];
    }

    public Card[] getCards() {
        return this.cards;
    }


    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    public void printDeck() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }


    private static int randomInt(int low, int high) {
        // return a random number between low and high,
        int randint = (int) (Math.random() * (high - low + 1)) + low;
        return randint;


    }

    private void swapCards(int i, int j) {
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }


    public void shuffle() {


        for (int i = 0; i < cards.length; i++) {

            int randomnum = randomInt(0, cards.length - 1);

            // random number between 0 -53
            swapCards(i, randomnum);

            // choose a random number between i and length - 1
            // swap the ith card and the randomly-chosen card
        }

    }


    private int indexLowest(int low, int high) {
        int minindex =  low;
        for (int i = low; i <= high; i++) {
            // compares with the lowest index each time
            if (cards[i].compareTo(cards[minindex]) < 0){
                minindex = i;
            }


        } return minindex;


    }






    public void  selectionSort() {
            Card[] sorted = new Card[this.cards.length];
            // iterate through the list
            for (int i = 0; i < cards.length-1; i ++ ){
                //find the lowest index in the list each time
                int lowestIndex = indexLowest(i, cards.length - 1);
                //swap the current first item with the lowest
                swapCards(i, lowestIndex);


            }

        }





//   public Deck subdeck(int low, int high) {
//        Deck sub = new Deck(high - low);
//       for (int i = 0; i < sub.cards.length; i++) {
//           sub.cards[i] = this.cards[low + i];
//        }
//        return sub;
//    }


    public Deck subdeck(int low, int high) {
        if (low < 0 || high > this.cards.length || low >= high) {
            throw new IllegalArgumentException("Invalid subdeck range");
        }
        Deck sub = new Deck(high - low);  // no need for +1
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }








    public  static Deck merge(Deck d1, Deck d2) {

        Deck d3 = new Deck(d1.cards.length + d2.cards.length);
        // create a new deck, d3, big enough for all the cards

        // use the index i to keep track of where we are at in
        // the first deck, and the index j for the second deck
        int i = 0;
        int j = 0;



        for (int k = 0; k < d3.cards.length; k++) {
            // If d1 is exhausted, take from d2
            if (i >= d1.cards.length) {
                d3.cards[k] = d2.cards[j];
                j++;
            }
            // If d2 is exhausted, take from d1
            else if (j >= d2.cards.length) {
                d3.cards[k] = d1.cards[i];
                i++;
            }
            // Compare top cards from both decks
            else if (d1.cards[i].compareTo(d2.cards[j]) < 0) {
                d3.cards[k] = d1.cards[i];
                i++;
            }
            else {
                d3.cards[k] = d2.cards[j];
                j++;
            }
        }
        return d3;
    }



    public Deck mergeSort() {
        // if the deck has 0 or 1 cards, return it
        if (cards.length <= 1){
            return this;
        }

        // find the middle
        int mid = cards.length / 2;


        Deck left = subdeck(0, mid ).mergeSort();
        Deck right = subdeck(mid, cards.length ).mergeSort();



        return merge(left, right);

        // otherwise, divide the deck into two subdecks


        // return the result
    }








//

    }


