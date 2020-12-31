data class Deck(
    var deckCount:Int=0,
    var cards:ArrayList<Card> = ArrayList()
){
 constructor(i:Int):this(i, ArrayList()){
     for(i in 0..deckCount) {
         for (j in 1..52) {
             cards.add(Card(j))
         }
         cards.shuffle()
     }
 }
}