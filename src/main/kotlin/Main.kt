import kotlin.random.Random
import com.jogodaforca.gameart.*

val words = arrayListOf("acnes","adubo","bobos","brota","camas","chuca","datas","durex","eixos","ermos","fadas","falta","gagos","galha","ileal","imite","jeque","julga","laica","laser","magda","mambo","nafta","nadei","odiei","ogros","pague","panca","queto","quote","rabos","raiou","sacou","salve","tacos","talos","uivar","ungir","varre","vasco","xerox","zarpe",)
var word = ""
val guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0

fun main(args: Array<String>) {
    setup()
}
fun setup() {
    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].uppercase()

    for (i in word.indices)
        guesses.add('_')

    var gameOver = false

    do {
        printGameStatus()
        println("Tente uma letra:")
        var input = readLine()?:""
        input = input.uppercase()

        if (input.isBlank()){
            println("Essa não é uma entrada valida, tente novamente com uma letra!")
        } else{
            val letter: Char = input[0]

            if (word.contains(letter)){
                for (i in word.indices){
                    if (word[i] == letter)
                        guesses[i] = letter
                    }
                if (!guesses.contains('_'))
                    gameOver = true
            } else {
                println("Letra errada!")
                remainingGuesses--
                mistakes++
                if (mistakes == 6)
                    gameOver = true
            }
        }
    } while (!gameOver)

    if (mistakes == 6){
        printGameStatus()
        println("Você perdeu! A palavra era: $word")
    }else {
        println("Parebén, você venceu!!")
        println("A palavra era: $word")

    }
}
fun printGameStatus(){
    when (mistakes){
        0-> printNoMistakes()
        1-> printOneMistake()
        2-> printTwoMistakes()
        3-> printThreeMistakes()
        4-> printFourMistakes()
        5-> printFiveMistakes()
        else-> printSixMistakes()
    }

    print("Palavra:")
    for (element in guesses)
        print(" $element")
    println("\nVocê tem $remainingGuesses tentativa(s) restantes!!")
}

