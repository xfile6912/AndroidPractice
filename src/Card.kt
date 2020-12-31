data class Card(
    var score:Int=0,
    var suit:String="",
    var name:String=""
) {
    constructor(i:Int):this(i%13,((i-1)/13).toString(), (i%13).toString())
    {
        if(score==11 || score==12||score==0)
            score=10
        suit=when(suit){
            "0" -> "♠"
            "1" -> "◆"
            "2" -> "♥"
            "3" -> "♣"
            else ->""
        }
        name=when(name){
            "11"-> "J"
            "12"-> "Q"
            "0" -> "K"
            "1" -> "A"
            else -> name
        }
    }
}