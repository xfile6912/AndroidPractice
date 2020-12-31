data class Player(
    var score:Int=0,
    var hands:ArrayList<Card> =ArrayList()
) {
    fun hit(c:Card){
        hands.add(c)
        calculator()
    }
    fun calculator(){
        score=0
        for(c in hands) {
            score += c.score
        }
        if(isInA() && score<=11)
        {
            score+=10
        }
    }

    private fun isInA(): Boolean {
        for(c in hands)
        {
            if(c.name=="A")
                return true
        }
        return false
    }
}