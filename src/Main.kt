import java.util.*

var deck:Deck=Deck(8)
var thisNumber=0
var dealer:Player=Player()
var user:Player=Player()
var scanner: Scanner = Scanner(System.`in`)
var userInput:String=""
var flag:Int=0 // 1:user win, 2:dealer win, 3:draw, 0:need to decide(both under 22)

fun main() {
    //초기 각각 두장씩 받음
    init()
    printUserAndDealer()//초기 상태 보여줌

    while(user.score<22) {//user input 받아서 결정.
        userInput = scanner.nextLine()
        if(userInput == "s"){
            break
        }

        if (userInput == "h") {
            user.hit(drawCard())
            printUserAndDealer()
            if(user.score>=22) {
                flag = 2//22 넘어가므로 유저 무조건 패
            }
        }

    }
    while(dealer.score<=15 && flag!=2)//dealer의 score가 15이하이고 user가 패배한 상황이 아니라면 dealer는 무조건 받음
    {
        dealer.hit(drawCard())
        printUserAndDealer()
        if(dealer.score>=22)
            flag=1//user가 무조건 승리한 상황
    }
    if(flag==0)//dealer와 user 모두 22미만이므로 값의 비교를 통해 결정.
    {
        if(user.score<dealer.score)//dealer승리
            flag=2
        else if(user.score==dealer.score)//비김
            flag=3
        else//user 승리
            flag=1

    }
    showResult(flag)
    scanner.close()

}
fun init(){
    user.hit(drawCard())
    dealer.hit(drawCard())
    user.hit(drawCard())
    dealer.hit(drawCard())
}
fun drawCard():Card{
    return deck.cards[thisNumber++]
}
fun printUserAndDealer():Unit{
    println("user: $user")
    println("dealer: $dealer")
    println()
}
fun showResult(flag:Int)
{
    when(flag)
    {
        1->println("User Win")
        2->println("Dealer Win")
        3->println("Draw")
    }
}